package com.example.affwlcom.live_tips.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.affwlcom.live_tips.R;

/**
 * Created by Affwl.com on 2/9/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecylerVH> {


    Context c;
//    ImageView buttonImage;
    String[] StockName;
//    String TextViews
//    TextView ViewData1,ViewData1,ViewData1;
//    Double price;


    public RecyclerViewAdapter(Context c,String[] StockName) {

        this.c = c;
//        this.buttonImage = buttonImage;
        this.StockName = StockName;
//        this.price =  price;


    }

    @Override
    public RecylerVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.list_view_model,parent,false);
        return new RecylerVH(v);
    }

    @Override
    public void onBindViewHolder(RecylerVH holder, int position) {
//        holder.imageViewButton.setImageDrawable(buttonImage);
        holder.nameTxt.setText(StockName[position]);
    }

    @Override
    public int getItemCount() {
        return StockName.length;
    }

    public class RecylerVH extends RecyclerView.ViewHolder{

//        ImageView imageViewButton;
        TextView nameTxt;

        public RecylerVH(View itemView) {
            super(itemView);
//            imageViewButton = itemView.findViewById(R.id.imageButton);
            nameTxt = itemView.findViewById(R.id.nameTxt);


        }
    }
}

