package myapplication.project.com.claseandroidbn3;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by OSP on 5/06/17.
 */

public class ListViewAdapter extends ArrayAdapter<Alumno> {

    private Context context;
    private List<Alumno> stringList;

    public ListViewAdapter(@NonNull Context context, @LayoutRes int resource, List<Alumno> stringList) {
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
            holder.tviLastName = (TextView) row.findViewById(R.id.tviLastName);
            holder.tviDNI = (TextView) row.findViewById(R.id.tviDNI);
            holder.iviAlumno = (ImageView) row.findViewById(R.id.iviAlumno);

            row.setTag(holder);

        }else {

            holder = (AdapterPruebaLsitHolder) row.getTag();
        }

        //holder.tviName.setText(getItem(position));
        holder.tviName.setText(stringList.get(position).getName());
        holder.tviLastName.setText(getItem(position).getLastName());
        holder.iviAlumno.setImageResource(getItem(position).getImage());

        return row;
    }

    static class AdapterPruebaLsitHolder {

        TextView tviName;
        TextView tviLastName;
        TextView tviDNI;
        ImageView iviAlumno;
    }

}
