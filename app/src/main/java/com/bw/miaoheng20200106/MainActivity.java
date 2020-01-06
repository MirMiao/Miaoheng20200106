package com.bw.miaoheng20200106;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.miaoheng20200106.adapter.DataAdapter;
import com.bw.miaoheng20200106.adapter.TagAdapter;
import com.bw.miaoheng20200106.base.BaseActivity;
import com.bw.miaoheng20200106.contract.IShopContract;
import com.bw.miaoheng20200106.entity.DataEntity;
import com.bw.miaoheng20200106.entity.TagEntity;
import com.bw.miaoheng20200106.presenter.ShopPresenter;
import com.bw.miaoheng20200106.utils.NetUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<ShopPresenter> implements IShopContract.IView {


    @BindView(R.id.rv_tag)
    RecyclerView rvTag;
    @BindView(R.id.rv_data)
    RecyclerView rvData;

    @Override
    protected void initData() {
        if(NetUtils.getInstance().hasNet(this)){
            presenter.getTagData();
        }else{
            Toast.makeText(this, "当前网络丢失,请重新检查网络后重试!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void initView() {
        //设置布局管理器
         rvTag.setLayoutManager(new LinearLayoutManager(this));
         rvData.setLayoutManager(new GridLayoutManager(this,2));
         //EventBus注册
         EventBus.getDefault().register(this);
    }

    @Override
    protected ShopPresenter initPresenter() {
        return new ShopPresenter();
    }

    @Override
    protected int bindLayoutid() {
        return R.layout.activity_main;
    }

    /**
     * 成功的回调
     * @param data
     */
    @Override
    public void seccess(Object data) {
        if (data instanceof TagEntity) {
            //展示左侧分类信息
            List<String> category = ((TagEntity) data).getCategory();
            TagAdapter tagAdapter = new TagAdapter(MainActivity.this, category);
            rvTag.setAdapter(tagAdapter);
            //左侧分类的点击事件
            tagAdapter.setTagCallBack(new TagAdapter.TagCallBack() {
                @Override
                public void getName(String s) {
                    //使用EcentBus传值
                    EventBus.getDefault().post(s);
                }
            });
        }else if(data instanceof DataEntity){
            //展示右侧商品信息
            List<DataEntity.DataBean> data1 = ((DataEntity) data).getData();
            DataAdapter dataAdapter = new DataAdapter(MainActivity.this, data1);
            rvData.setAdapter(dataAdapter);
        }

    }

    /**
     * 使用eventbus接收值
     * @param s
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getName(String s){
        HashMap<String, String> params = new HashMap<>();
        params.put("category",s);
        //请求右侧商品信息
        presenter.getShopData(params);
    }

    /**
     * 失败的回调
     * @param throwable
     */
    @Override
    public void failure(Throwable throwable) {
        Toast.makeText(this, "当前网络不佳,请重试!", Toast.LENGTH_SHORT).show();
    }

    /**
     * 在销毁的生命周期中,取消注册EventBus
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
