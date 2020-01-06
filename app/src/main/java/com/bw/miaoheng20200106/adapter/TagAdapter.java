package com.bw.miaoheng20200106.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.miaoheng20200106.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 时间 :2020/1/6  9:13
 * 作者 :苗恒
 * 功能 :展示左侧分离的适配器
 */
public class TagAdapter extends RecyclerView.Adapter<TagAdapter.MyViewHolder> {
    Context context;
    List<String> category;


    public TagAdapter(Context context, List<String> category) {
        this.category = category;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //渲染布局
        View view = View.inflate(context, R.layout.tag_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvTag.setText(category.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //回调当前选中的名字
                  tagCallBack.getName(category.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_tag)
        TextView tvTag;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //绑定
            ButterKnife.bind(this,itemView);
        }
    }
    private TagCallBack tagCallBack;

    public void setTagCallBack(TagCallBack tagCallBack) {
        this.tagCallBack = tagCallBack;
    }

    //自动以接口回调
    public interface TagCallBack{
        void getName(String s);
    }
}
