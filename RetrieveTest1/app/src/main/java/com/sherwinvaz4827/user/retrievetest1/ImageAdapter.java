package com.sherwinvaz4827.user.retrievetest1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Images> imagesArrayList;


    public ImageAdapter(Context mContext, ArrayList<Images> imagesArrayList) {
        this.mContext = mContext;
        this.imagesArrayList = imagesArrayList;
    }

    @NonNull
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rows,parent,false);

        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ViewHolder holder, int position) {
        Picasso.get().load(imagesArrayList.get(position).getUrl1()).placeholder(R.mipmap.ic_launcher).fit().centerInside().into(holder.enemyimg1);
        Picasso.get().load(imagesArrayList.get(position).getUrl2()).placeholder(R.mipmap.ic_launcher).fit().centerInside().into(holder.enemyimg2);
        Picasso.get().load(imagesArrayList.get(position).getUrl3()).placeholder(R.mipmap.ic_launcher).fit().centerInside().into(holder.enemyimg3);
        Picasso.get().load(imagesArrayList.get(position).getUrl4()).placeholder(R.mipmap.ic_launcher).fit().centerInside().into(holder.enemyimg4);
        Picasso.get().load(imagesArrayList.get(position).getUrl5()).placeholder(R.mipmap.ic_launcher).fit().centerInside().into(holder.enemyimg5);
        Picasso.get().load(imagesArrayList.get(position).getUrl6()).placeholder(R.mipmap.ic_launcher).fit().centerInside().into(holder.myheroimg1);
        Picasso.get().load(imagesArrayList.get(position).getUrl7()).placeholder(R.mipmap.ic_launcher).fit().centerInside().into(holder.myheroimg2);
        Picasso.get().load(imagesArrayList.get(position).getUrl8()).placeholder(R.mipmap.ic_launcher).fit().centerInside().into(holder.myheroimg3);
        Picasso.get().load(imagesArrayList.get(position).getUrl9()).placeholder(R.mipmap.ic_launcher).fit().centerInside().into(holder.myheroimg4);
        Picasso.get().load(imagesArrayList.get(position).getUrl10()).placeholder(R.mipmap.ic_launcher).fit().centerInside().into(holder.myheroimg5);
    }

    @Override
    public int getItemCount() {
        return imagesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView enemyimg1,enemyimg2,enemyimg3,enemyimg4,enemyimg5;
        ImageView myheroimg2,myheroimg3,myheroimg4,myheroimg5,myheroimg1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            enemyimg1=itemView.findViewById(R.id.imageView1);
            enemyimg2=itemView.findViewById(R.id.imageView2);
            enemyimg3=itemView.findViewById(R.id.imageView3);
            enemyimg4=itemView.findViewById(R.id.imageView4);
            enemyimg5=itemView.findViewById(R.id.imageView5);

            myheroimg1=itemView.findViewById(R.id.imageView6);
            myheroimg2=itemView.findViewById(R.id.imageView7);
            myheroimg3=itemView.findViewById(R.id.imageView8);
            myheroimg4=itemView.findViewById(R.id.imageView9);
            myheroimg5=itemView.findViewById(R.id.imageView10);
        }
    }

}
