package com.bw.miaoheng20200106.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bw.miaoheng20200106.R;
import com.bw.miaoheng20200106.entity.DataEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.http.GET;

/**
 * 时间 :2020/1/6  9:13
 * 作者 :苗恒
 * 功能 :展示商品信息的适配器
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
    Context context;

    List<DataEntity.DataBean> data1;


    public DataAdapter(Context context, List<DataEntity.DataBean> data1) {
        this.context = context;
        this.data1 = data1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //渲染布局
        View view = View.inflate(context, R.layout.data_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //设置值
          holder.tvName.setText(data1.get(position).getGoods_name());
          holder.tvPrice.setText(data1.get(position).getCurrency_price());
        Glide.with(context).load(data1.get(position).getGoods_thumb())
                .placeholder(R.mipmap.ic_launcher_round)//占位图
                .error(R.mipmap.ic_launcher)//错误图
                .transforms(new RoundedCorners(20))//圆角图
                .into(holder.ivImage);

    }

    @Override
    public int getItemCount() {
        return data1.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_image)
        ImageView ivImage;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //绑定butterknife
            ButterKnife.bind(this, itemView);
        }
    }

}
