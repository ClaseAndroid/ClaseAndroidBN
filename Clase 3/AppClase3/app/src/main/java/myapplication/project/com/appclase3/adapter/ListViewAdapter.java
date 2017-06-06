package myapplication.project.com.appclase3.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import myapplication.project.com.appclase3.R;

/**
 * Created by OSP on 5/06/17.
 */

public class ListViewAdapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> stringList;

    public ListViewAdapter(@NonNull Context context, @LayoutRes int resource, List<String> stringList) {
        super(context, resource, stringList);

        this.context = context;
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;
        AdapterPruebaLsitHolder holder;

        if(row == null){
            holder = new AdapterPruebaLsitHolder();
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();

            row = inflater.inflate(R.layout.row_alumno, parent, false);

            holder.tviName = (TextView) row.findViewById(R.id.tviName);

            row.setTag(holder);

        }else {

            holder = (AdapterPruebaLsitHolder) row.getTag();
        }

        holder.tviName.setText(getItem(position));


        return row;
    }

    static class AdapterPruebaLsitHolder {

        TextView tviName;
    }

}
