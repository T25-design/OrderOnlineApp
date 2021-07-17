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

public class SignIn extends AppCompatActivity {

    private EditText edusername;
    private EditText edpassword;
    private EditText edconfirmpassword;
    private Button btnCreateAccount;
    private final String  CREDENTIAL_SHARED_PREF= "our_shared_pref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
          edusername= findViewById(R.id.ed_username);
          edpassword= findViewById(R.id.ed_password);
          edconfirmpassword= findViewById(R.id.ed_confirmPassword);
           btnCreateAccount = findViewById(R.id.btn_Create);

           btnCreateAccount.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String strPassword = edpassword.getText().toString();
                   String strConfirmPassword = edconfirmpassword.getText().toString();
                   String strUsername = edusername.getText().toString();

                   if(strPassword!=null && strConfirmPassword!=null && strConfirmPassword.equals(strPassword))
                   {
                       SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
                       SharedPreferences.Editor editor = credentials.edit();
                       editor.putString("Password",strPassword);
                       editor.putString("Username",strUsername);
                       editor.commit();
                   }
                   else
                       Toast.makeText(SignIn.this,"Error" , Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(SignIn.this, MainActivity.class);
                   startActivity(intent);
               }
           });

    }
}