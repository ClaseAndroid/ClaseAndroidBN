package myapplication.project.com.claseandroidbn3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spnAlumno;
    private ListView lviAlumno;
    private GridView gviAlumno;
    private RecyclerView rviAlumno;
    private List<String> arrayAlumno = new ArrayList<>();
    private List<Alumno> alumnoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayAlumno.add("Seleccionar Almuno");
        arrayAlumno.add("MARIA");
        arrayAlumno.add("MARIA-2");
        arrayAlumno.add("MARIA-3");
        arrayAlumno.add("MARIA-4");
        arrayAlumno.add("MARIA-5");
        arrayAlumno.add("MARIA-5");

        alumnoList.add(new Alumno("JESUS", "CASTRO", "4545454", R.mipmap.ic_launcher_round));
        alumnoList.add(new Alumno("JESUS-1", "CASTRO", "4545454", R.mipmap.ic_icon_2));
        alumnoList.add(new Alumno("JESUS-2", "CASTRO", "4545454", R.mipmap.ic_prueba));
        alumnoList.add(new Alumno("JESUS-3", "CASTRO", "4545454", R.mipmap.ic_launcher_round));
        alumnoList.add(new Alumno("JESUS-4", "CASTRO", "4545454", R.mipmap.ic_icon_2));


        spnAlumno = (Spinner) findViewById(R.id.spnAlumno);
        lviAlumno = (ListView) findViewById(R.id.lviAlumno);
        gviAlumno = (GridView) findViewById(R.id.gviAlumno);
        rviAlumno = (RecyclerView) findViewById(R.id.rviAlumno);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        rviAlumno.setLayoutManager(linearLayoutManager);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(arrayAlumno, this);
        rviAlumno.setAdapter(recyclerViewAdapter);


        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayAlumno);
        spnAlumno.setAdapter(stringArrayAdapter);

        ListViewAdapter listViewAdapter = new ListViewAdapter(this, R.layout.row_alumno, alumnoList);
        lviAlumno.setAdapter(listViewAdapter);

        gviAlumno.setAdapter(listViewAdapter);

        spnAlumno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               // if(i > 0)Toast.makeText(MainActivity.this, arrayAlumno.get(i), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        gviAlumno.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrayAlumno.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
