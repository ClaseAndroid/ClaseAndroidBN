package myapplication.project.com.appclase3.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import myapplication.project.com.appclase3.R;


/**
 * Created by OSP on 1/06/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> stringList;
    private Context context;


    public RecyclerViewAdapter(List<String> stringList, Context context){
        this.stringList = stringList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tviName;

        public ViewHolder(View itemView) {
            super(itemView);
            tviName = (TextView) itemView.findViewById(R.id.tviName);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder;

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_alumno, parent, false);

        holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof ViewHolder){
            ViewHolder viewHolder = (ViewHolder) holder;

            viewHolder.tviName.setText(stringList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }
}
