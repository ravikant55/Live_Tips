package com.example.affwlcom.live_tips;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.BreakIterator;
import java.util.HashMap;

public class Register_Live_Tips extends AppCompatActivity {


    Button btn_Confirm, btn_Cancel;
    EditText edit_Name, edit_Email, edit_Phone, edit_Password, edit_Re_Password;
    ProgressDialog progressDialog;
    String namestr, emailstr, phonestr, passwordstr, repasswordstr, emailPattern;
    String finalResult ;


    String HttpURL = "http://boudhi.com/Livetips/UserRegistration.php";
    Boolean CheckEditText = true;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__live__tips);

        edit_Name = (EditText) findViewById(R.id.etName);
        edit_Email = (EditText) findViewById(R.id.etEmailid);
        edit_Phone = (EditText) findViewById(R.id.etphone);
        edit_Password = (EditText) findViewById(R.id.etcpsswd);
        edit_Re_Password = (EditText) findViewById(R.id.edrpassword);

        //Initialization of Register Button
        btn_Confirm = (Button) findViewById(R.id.cfrmbtn);
        btn_Cancel = (Button) findViewById(R.id.cnclbtn);

        btn_Confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                CheckEditTextIsEmptyOrNot();

            }


        });

        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Register_Live_Tips.this, Login_Live_Tips.class);
                startActivity(intent);
            }
        });
    }

    public void CheckEditTextIsEmptyOrNot() {
        CheckEditText = true;
        namestr = edit_Name.getText().toString();
        emailstr = edit_Email.getText().toString();
        phonestr = edit_Phone.getText().toString();
        passwordstr = edit_Password.getText().toString();
        repasswordstr = edit_Re_Password.getText().toString();

        emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (TextUtils.isEmpty(namestr) || TextUtils.isEmpty(emailstr) || TextUtils.isEmpty(phonestr) || TextUtils.isEmpty(passwordstr) || TextUtils.isEmpty(repasswordstr)) {

            Toast.makeText(this, "Enter All Field", Toast.LENGTH_SHORT).show();

            CheckEditText = false;
        }
        else if (!emailstr.matches(emailPattern)) {
            Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
            edit_Email.setError("Invalid email address");
            CheckEditText = false;

        }else if (!phonestr.matches("\\d{10}")) {
            Toast.makeText(getApplicationContext(), "Invalid Contact number", Toast.LENGTH_SHORT).show();
            edit_Phone.setError("Invalid Contact number");
            CheckEditText = false;

        }else if(!passwordstr.equals(repasswordstr)){
            Toast.makeText(Register_Live_Tips.this,"Password Not matching",Toast.LENGTH_SHORT).show();
            edit_Re_Password.setError("Password Not matching");
            CheckEditText = false;

        }

        if (CheckEditText) {
            UserRegisterFunction(namestr, emailstr, phonestr, passwordstr, repasswordstr);
        }
    }

    public void UserRegisterFunction(final String Name, final String Email, final String Phone, final String Password, String Repassword) {

        class UserRegisterFunctionClass extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(Register_Live_Tips.this, "Loading Data", null, true, true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                Toast.makeText(Register_Live_Tips.this, httpResponseMsg.toString(), Toast.LENGTH_LONG).show();

                if (httpResponseMsg.toString().equalsIgnoreCase("Registration Successfully")) {

                    Intent intent = new Intent(Register_Live_Tips.this, Login_Live_Tips.class);

                    startActivity(intent);
                }
            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("username", params[0]);

                hashMap.put("email", params[1]);

                hashMap.put("phone", params[2]);

                hashMap.put("password", params[3]);

                hashMap.put("repassword", params[4]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        UserRegisterFunctionClass userRegisterFunctionClass = new UserRegisterFunctionClass();

        userRegisterFunctionClass.execute(Name, Email, Phone, Password, Repassword);
    }
}
