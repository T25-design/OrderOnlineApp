package com.example.OrderOnline;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edUsername;
    private EditText edPassword;
    private Button  btnLogin;
    private Button btnSign;
    private final String CREDENTIAL_SHARED_PREF= "our_shared_pref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edUsername = findViewById(R.id.ed_username);
        edPassword = findViewById(R.id.ed_password);
        btnSign = findViewById(R.id.btn_sign);
        btnLogin = findViewById(R.id.btn_login);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignIn.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
                String strUser = credentials.getString("Username",null);
                String strPass = credentials.getString("Password",null);
                String username_from_ed = edUsername.getText().toString();
                String password_from_ed = edPassword.getText().toString();
                if(strUser!=null && username_from_ed!=null && strUser.equals(username_from_ed))
                {
                    if(password_from_ed!=null && strPass!=null && password_from_ed.equals(strPass))
                    {Toast.makeText(MainActivity.this,"Login Successful" , Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(MainActivity.this,OrderActivity.class);
                    startActivity(intent3);
                    }
                    else
                        Toast.makeText(MainActivity.this,"Login Failed" , Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this,"Login Failed" , Toast.LENGTH_SHORT).show();
            }
        });



    }


        /*ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.roll_no));
        listView.setAdapter(adapter);*/




}