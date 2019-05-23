package com.example.withm.ui.smywanfragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.withm.R;

/**
 * Created by Dell on 2019/5/23.
 */

public class WanAdapter extends RecyclerView.Adapter {


    private OnItemClickLisener mlisener;

    @Override
    public int getItemViewType(int position) {
        if (position == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.wanxlc_text, null);
            return new TextViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.wanxlc_item, null);
            return new ListViewHolder(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == 1) {
            TextViewHolder holder1 = (TextViewHolder) holder;

        } else {
            ListViewHolder holder1 = (ListViewHolder) holder;

        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }
  //接口回调

     public interface OnItemClickLisener{
             void OnItemClickLisener(int position);
          }

          public void SetOnItemClickLisener(OnItemClickLisener lisener){
              mlisener = lisener;
          }
    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView mJapan;
        TextView mDao;
        TextView mZhidao;
        Button mPrice;
        TextView mIntrestring;

        public ListViewHolder(View itemView) {
            super(itemView);
            this.mJapan = (TextView) itemView.findViewById(R.id.japan);
            this.mDao = (TextView) itemView.findViewById(R.id.dao);
            this.mZhidao = (TextView) itemView.findViewById(R.id.zhidao);
            this.mPrice = (Button) itemView.findViewById(R.id.price);
            this.mIntrestring = (TextView) itemView.findViewById(R.id.intrestring);
        }
    }

    class TextViewHolder extends RecyclerView.ViewHolder {

        TextView mJapan;
        TextView mDao;
        TextView mZhidao;
        public TextViewHolder(View itemView) {
            super(itemView);
            this.mJapan = (TextView) itemView.findViewById(R.id.japan);
            this.mDao = (TextView) itemView.findViewById(R.id.dao);
            this.mZhidao = (TextView) itemView.findViewById(R.id.zhidao);
        }
    }


}
