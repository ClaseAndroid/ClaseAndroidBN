package myapplication.project.com.appclase3.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import myapplication.project.com.appclase3.R;
import myapplication.project.com.appclase3.db.AdminSQLiteOpenHelper;

public class DBActivity extends AppCompatActivity {

    private EditText eteName;
    private EditText eteLastName;
    private EditText eteDNI;
    private EditText eteEmail;
    private Button butAddUser;
    private Button butSearch;
    private TextView tviName;
    private TextView tviLastName;
    private TextView tviEmail;
    private EditText eteSearch;
    private RadioGroup rgrOption;

    private String name;
    private String lastName;
    private String dni;
    private String email;

    private int optionSelect = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        eteName = (EditText) findViewById(R.id.eteName);
        eteLastName = (EditText) findViewById(R.id.eteLastName);
        eteDNI = (EditText) findViewById(R.id.eteDNI);
        eteEmail = (EditText) findViewById(R.id.eteEmail);
        butAddUser = (Button) findViewById(R.id.butAddUser);
        tviName = (TextView) findViewById(R.id.tviName);
        tviLastName = (TextView) findViewById(R.id.tviLastName);
        tviEmail = (TextView) findViewById(R.id.tviEmail);
        eteSearch = (EditText) findViewById(R.id.eteSearch);
        butSearch = (Button) findViewById(R.id.butSearch);
        rgrOption = (RadioGroup) findViewById(R.id.rgrOption);


        butAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = eteName.getText().toString();
                lastName = eteLastName.getText().toString();
                dni = eteDNI.getText().toString();
                email = eteEmail.getText().toString();

                loadDataDB(name, lastName, dni, email);
            }
        });

        butSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dniSearch = eteSearch.getText().toString();

                switch (optionSelect){
                    case 1: getDataUserForDNI(dniSearch);break;
                    case 2: deleteUserForDNI(dniSearch);break;
                }

            }
        });

        rgrOption.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                switch (i){
                    case R.id.rbuSearch:
                        optionSelect = 1;
                        butSearch.setText(getString(R.string.buscar));
                        break;
                    case R.id.rbuDelete:
                        optionSelect = 2;
                        butSearch.setText(getString(R.string.eliminar));
                        break;
                }
            }
        });


    }

    private void loadDataDB(String name, String lastName, String dni, String email){

        AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(this, "user", null, 1);
        SQLiteDatabase bd = adminSQLiteOpenHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("lastName", lastName);
        contentValues.put("dni", dni);
        contentValues.put("email", email);

        bd.insert("user", null, contentValues);
        bd.close();

        eteName.setText("");
        eteLastName.setText("");
        eteDNI.setText("");
        eteEmail.setText("");

        Toast.makeText(this, getString(R.string.usuario_guardado), Toast.LENGTH_SHORT).show();
    }

    private void getDataUserForDNI(String dni){

        AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(this, "user", null, 1);
        SQLiteDatabase bd = adminSQLiteOpenHelper.getWritableDatabase();

        Cursor cursor = bd.rawQuery("select name, lastName, email from user where dni = " + dni, null);

        if(cursor.moveToFirst()){
            tviName.setText("Nombre : " + cursor.getString(0));
            tviLastName.setText("Apellido : " + cursor.getString(1));
            tviEmail.setText("Email : " + cursor.getString(2));
        }else{
            Toast.makeText(this, getString(R.string.no_exinten_coincidencias), Toast.LENGTH_SHORT).show();
            eteName.setText("");
            eteLastName.setText("");
            eteEmail.setText("");
        }

        bd.close();

    }

    private void deleteUserForDNI(String dni){

        AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(this, "user", null, 1);
        SQLiteDatabase bd = adminSQLiteOpenHelper.getWritableDatabase();

        int cant = bd.delete("user", "dni = " + dni, null);

        if(cant >= 1){
            Toast.makeText(this, getString(R.string.usuario_borrado), Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, getString(R.string.no_exinten_coincidencias), Toast.LENGTH_SHORT).show();
        }

        bd.close();

    }
}
