package myapplication.project.com.appclase3.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import myapplication.project.com.appclase3.R;
import myapplication.project.com.appclase3.db.AdminSQLiteOpenHelper;

public class DBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);


    }

    private void loadDataDB(){

        AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(this, "User", null, 1);
        SQLiteDatabase bd = adminSQLiteOpenHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "Pedro");
        contentValues.put("lastName", "Picapiedra");
        contentValues.put("dni", "123");
        contentValues.put("email", "pp@piedra.pe");

        bd.insert("User", null, contentValues);
        bd.close();

    }

    private void loadDataDB(int dni){

        AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(this, "User", null, 1);
        SQLiteDatabase bd = adminSQLiteOpenHelper.getWritableDatabase();

        Cursor cursor = bd.rawQuery("select name, lastName from user where dni = " + dni, null);


        bd.close();

    }
}
