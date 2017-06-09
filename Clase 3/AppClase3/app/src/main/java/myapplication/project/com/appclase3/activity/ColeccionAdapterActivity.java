package myapplication.project.com.appclase3.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import myapplication.project.com.appclase3.R;
import myapplication.project.com.appclase3.adapter.ListViewAdapter;
import myapplication.project.com.appclase3.adapter.RecyclerViewAdapter;
import myapplication.project.com.appclase3.entity.User;

public class ColeccionAdapterActivity extends AppCompatActivity {

    private Spinner spnPersona;
    private ListView lviPersona;
    private GridView gviPersona;
    private RecyclerView rviPersona;
    private Button butEnter;
    private String [] alumnos = {"Pedro", "Luis", "Maria"};
    private List<User> userList = new ArrayList<>();
    private List<String> stringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coleccion_adapter);

        initUI();

        /**
         * CARGAR DATOS
         */

        userList.add(new User("PEDRO"));
        userList.add(new User("MARIA"));
        userList.add(new User("JUAN"));
        userList.add(new User("GOKU"));

        stringList.add("MARTIN");
        stringList.add("MARIA");
        stringList.add("MARIO");
        stringList.add("MARIBEL");
        stringList.add("MARI LUZ");


        /**
         * Spinner
         */

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, alumnos);
        spnPersona.setAdapter(stringArrayAdapter);

        /**
         * ListView
         */

        ListViewAdapter listViewAdapter = new ListViewAdapter(this, R.layout.row_alumno, stringList);
        lviPersona.setAdapter(listViewAdapter);


        /**
         * GridView
         */

        ListViewAdapter gridViewAdapter = new ListViewAdapter(this, R.layout.row_alumno, stringList);
        gviPersona.setAdapter(gridViewAdapter);

        /**
         * RecyclerView
         */

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setReverseLayout(true);

        rviPersona.setLayoutManager(linearLayoutManager);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(stringList, this);
        rviPersona.setAdapter(recyclerViewAdapter);

        /**
         * ActionBar
         */
        getSupportActionBar().setDisplayShowHomeEnabled(true);// Para poder ver el icono del menu
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("PRUEBA ANDROID");

    }

    private void initUI(){

        spnPersona = (Spinner) findViewById(R.id.spnPersona);
        lviPersona = (ListView) findViewById(R.id.lviPersona);
        gviPersona = (GridView) findViewById(R.id.gviPersona);
        rviPersona = (RecyclerView) findViewById(R.id.rviPersona);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.item1:

                Toast.makeText(this, "MENU ITEM 1", Toast.LENGTH_SHORT).show();

                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
