package com.capacitacion.project.appclase7.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.capacitacion.project.appclase7.R;
import com.capacitacion.project.appclase7.domain.Friend;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by OSP on 1/06/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Friend> friendList;
    private Context context;


    public RecyclerViewAdapter(List<Friend> friendList, Context context){
        this.friendList = friendList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tviName;
        TextView tviLastName;
        ImageView iviFriend;

        public ViewHolder(View itemView) {
            super(itemView);
            tviName = (TextView) itemView.findViewById(R.id.tviName);
            tviLastName = (TextView) itemView.findViewById(R.id.tviLastName);
            iviFriend = (ImageView) itemView.findViewById(R.id.iviFriend);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder;

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_friend, parent, false);

        holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof ViewHolder){
            ViewHolder viewHolder = (ViewHolder) holder;

            Friend friend = friendList.get(position);

            if(friend.getName() != null)viewHolder.tviName.setText(friend.getName());
            if(friend.getLastname() != null)viewHolder.tviLastName.setText(friend.getLastname());

            if(friend.getImage() != null)Picasso.with(context).load(friend.getImage()).into(viewHolder.iviFriend);


        }
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }
}
