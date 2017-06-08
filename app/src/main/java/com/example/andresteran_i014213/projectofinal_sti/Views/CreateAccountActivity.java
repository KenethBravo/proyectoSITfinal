package com.example.andresteran_i014213.projectofinal_sti.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.andresteran_i014213.projectofinal_sti.Adapters.UserAdapter;
import com.example.andresteran_i014213.projectofinal_sti.Data.DataUser;
import com.example.andresteran_i014213.projectofinal_sti.LoginActivity;
import com.example.andresteran_i014213.projectofinal_sti.Models.User;
import com.example.andresteran_i014213.projectofinal_sti.R;

import java.util.List;

public class CreateAccountActivity extends AppCompatActivity {

    Button createAccount;
    EditText name,username,email,password, passwordConfirm;
    DataUser dataUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        showTolbar(getResources().getString(R.string.txt_title_toolbar),true);

        createAccount = (Button) findViewById(R.id.btn_account);
        name = (EditText) findViewById(R.id.id_account_name);
        username = (EditText) findViewById(R.id.id_account_user);
        email = (EditText) findViewById(R.id.id_account_email);
        password = (EditText) findViewById(R.id.id_account_paswordAcount);
        passwordConfirm  = (EditText) findViewById(R.id.id_account_paswordConfirm);


        dataUser = new DataUser(this);
        dataUser.open();

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(username.getText().toString().equals("")||password.getText().toString().equals("")
                        ||passwordConfirm.getText().toString().equals("")
                        ||name.getText().toString().equals("")||email.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), getString(R.string.txt_field_vaccant), Toast.LENGTH_SHORT).show();
                }
                // check if both password matches
                else if(!password.getText().toString().equals(passwordConfirm.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), getString(R.string.txt_password_validation), Toast.LENGTH_SHORT).show();

                }
                else
                {
                    createData();
                    Toast.makeText(getApplicationContext(),getString(R.string.txt_succesfully_account), Toast.LENGTH_SHORT).show();
                    goLogginActivity();
                }
            }
        });

    }

    private void showTolbar(String title, boolean upButton) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    private void createData(){
        User user = new User();
        user.setName(name.getText().toString());
        user.setEmail(email.getText().toString());
        user.setUsername(username.getText().toString());
        user.setPassword(password.getText().toString());
        user.setStatus("false");

        dataUser.create(user);
    }

    public void goLogginActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}