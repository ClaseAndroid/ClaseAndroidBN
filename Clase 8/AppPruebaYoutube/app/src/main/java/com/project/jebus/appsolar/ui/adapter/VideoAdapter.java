package com.project.jebus.appsolar.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.project.jebus.appsolar.R;
import com.project.jebus.appsolar.model.VideoEntity;
import com.project.jebus.appsolar.ui.activity.VideoYoutubeActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private List<VideoEntity> list;
    private Context context;
    public ShareDialog shareDialog;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tviNameVideo;
        public TextView tviAuthor;
        private ImageView iviAuthor;
        private ImageView iviVideo;
        private ImageView iviShare;
        private RelativeLayout rlaContentVideo;


        public ViewHolder(View v) {
            super(v);
            tviAuthor = (TextView) v.findViewById(R.id.tviAuthor);
            tviNameVideo = (TextView) v.findViewById(R.id.tviNameVideo);
            iviAuthor = (ImageView) v.findViewById(R.id.iviAuthor);
            iviVideo = (ImageView) v.findViewById(R.id.iviVideo);
            iviShare = (ImageView) v.findViewById(R.id.iviShare);
            rlaContentVideo = (RelativeLayout) v.findViewById(R.id.rlaContentVideo);
        }
    }

    public VideoAdapter(Context context, List<VideoEntity> list) {
        this.list = list;
        this.context = context;
        shareDialog = new ShareDialog((Activity)context);
    }

    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_video, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final VideoEntity videoEntity = list.get(position);

        if(videoEntity != null) {
            String nameVideo = TextUtils.isEmpty(videoEntity.getSnippet().getTitle())?(""):(videoEntity.getSnippet().getTitle());
            String author = TextUtils.isEmpty(videoEntity.getSnippet().getChannelTitle())?(""):(videoEntity.getSnippet().getChannelTitle());

            holder.tviNameVideo.setText(nameVideo);
            holder.tviAuthor.setText(author);

            String imageVideo = videoEntity.getSnippet().getThumbnails().getHigh().getUrl();
            if(imageVideo == null) imageVideo = "";

            Picasso.with(context).load(imageVideo).into(holder.iviVideo);

            holder.iviShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = videoEntity.getSnippet().getThumbnails().getHigh().getUrl();

                    ShareLinkContent content = new ShareLinkContent.Builder()
                            .setContentUrl(Uri.parse(url))
                            .build();
                    shareDialog.show(content);
                }
            });
            holder.rlaContentVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    String idVideo = videoEntity.getId().getVideoId();
                    bundle.putString("idVideo", idVideo);
                    Intent intent = new Intent(context, VideoYoutubeActivity.class);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setNotifyDataSetChanged(List<VideoEntity> list){
        this.list = list;
        notifyDataSetChanged();
    }

}