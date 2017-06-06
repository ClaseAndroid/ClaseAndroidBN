package myapplication.project.com.appclase2.activity.clase2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import myapplication.project.com.appclase2.R;
import myapplication.project.com.appclase2.entity.User;

public class MainActivity extends AppCompatActivity {

    private Button butGo;
    private EditText eteEmail;
    private EditText etePassword;

    private User user;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        loadData();

    }

    private void initUI(){

        butGo = (Button) findViewById(R.id.butGo);
        eteEmail = (EditText) findViewById(R.id.eteEmail);
        etePassword = (EditText) findViewById(R.id.etePassword);


        butGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = eteEmail.getText().toString();
                password = etePassword.getText().toString();

                if(email.equals("")){
                    Toast.makeText(MainActivity.this, getString(R.string.message_enter_email), Toast.LENGTH_SHORT).show();
                    return;
                }

                if(password.equals("")){
                    Toast.makeText(MainActivity.this, getString(R.string.message_enter_password), Toast.LENGTH_SHORT).show();
                    return;
                }

                user = new User(email, password, "PEDRO", "CASTRO");

                /**
                 * Pasar informacion mediante un Intent
                 */

                Intent intent = new Intent(MainActivity.this, DataActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("DATA", user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void loadData(){

    }
}
