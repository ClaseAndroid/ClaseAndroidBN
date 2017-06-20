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
import com.capacitacion.project.appclase7.domain.Operaciones;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by OSP on 1/06/17.
 */

public class RecyclerViewOperacionesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Operaciones> friendList;
    private Context context;


    public RecyclerViewOperacionesAdapter(List<Operaciones> friendList, Context context){
        this.friendList = friendList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tviId;
        TextView tviCod;
        TextView tviNombre;
        TextView tviCodigo;

        public ViewHolder(View itemView) {
            super(itemView);
            tviId = (TextView) itemView.findViewById(R.id.tviId);
            tviCod = (TextView) itemView.findViewById(R.id.tviCod);
            tviNombre = (TextView) itemView.findViewById(R.id.tviNombre);
            tviCodigo = (TextView) itemView.findViewById(R.id.tviCodigo);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder;

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_operacion, parent, false);

        holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof ViewHolder){
            ViewHolder viewHolder = (ViewHolder) holder;

            Operaciones friend = friendList.get(position);

            viewHolder.tviId.setText(friend.getId() + "");
            viewHolder.tviNombre.setText(friend.getNombre());
            viewHolder.tviCod.setText(friend.getCod_IOE());
            viewHolder.tviCodigo.setText(friend.getCodigo());
        }
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }
}
