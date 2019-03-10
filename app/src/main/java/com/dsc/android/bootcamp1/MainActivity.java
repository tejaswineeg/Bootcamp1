package com.dsc.android.bootcamp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etName, etPassword, etEmail, etConfirmPassword;
    private Button btnRegister;
    private String name,email,password,confirmPassword;
    private TinyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new TinyDB(this);
        initView();
        btnRegister.setOnClickListener(this);
    }

    //Initialising the UI Components here
    private void initView() {
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        btnRegister = (Button)findViewById(R.id.btnRegister);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegister:
                getInfo();
                register();
                break;
        }
    }

    private void getInfo() {
        name = etName.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        confirmPassword = etConfirmPassword.getText().toString().trim();

    }

    private void register(){
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
           Toast.makeText(this,"One or more field is empty",Toast.LENGTH_SHORT).show();
        }
        else{
            if (password.equals(confirmPassword)){
                db.putString("name",name);
                db.putString("email",email);
                db.putString("password",password);
                Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);
                finish();
            }

            else{
                Toast.makeText(this,"Password did not match",Toast.LENGTH_SHORT).show();
            }
        }
    }
}

