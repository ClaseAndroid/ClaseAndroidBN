package myapplication.project.com.appclase2.activity.clase2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import myapplication.project.com.appclase2.R;
import myapplication.project.com.appclase2.entity.User;

public class DataActivity extends AppCompatActivity {

    private TextView tviName;
    private TextView tviLastName;
    private TextView tviEmail;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase2);

        tviName = (TextView) findViewById(R.id.tviName);
        tviLastName = (TextView) findViewById(R.id.tviLastName);
        tviEmail = (TextView) findViewById(R.id.tviEmail);

        if(getIntent().getExtras() != null){
            user = (User) getIntent().getExtras().getSerializable("DATA");

            tviName.setText(user.getName());
            tviLastName.setText(user.getLastName());
            tviEmail.setText(user.getEmail());
        }

    }
}
