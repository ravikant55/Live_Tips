package com.example.affwlcom.live_tips;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Login_Live_Tips extends AppCompatActivity implements View.OnClickListener{

    Button btn_Login, btn_Register;
    EditText edit_Name_Login, edit_Password_Login;
    String PasswordHolder, EmailHolder;
    String finalResult ;
    String HttpURL = "http://boudhi.com/Livetips/UserLogin.php";
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    public static final String UserEmail = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__live__tips);

        edit_Name_Login = (EditText) findViewById(R.id.editTextUsername);
        edit_Password_Login = (EditText) findViewById(R.id.editTextPassword);
        btn_Login = (Button) findViewById(R.id.btnLiveLogin);
        btn_Register = (Button) findViewById(R.id.btnLiveRegister);

        btn_Login.setOnClickListener(this);
        btn_Register.setOnClickListener(this);

    }

//    private void validate(String userName, String userPassword) {
//        if (userName.equals("Admin") && userPassword.equals("1234")) {
//            Intent intent = new Intent(Login_Live_Tips.this, Live_Tips.class);
//            startActivity(intent);
//        }
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLiveLogin:

                CheckEditTextIsEmptyOrNot();

                if(CheckEditText){


                    UserLoginFunction(EmailHolder, PasswordHolder);

                }
                else {

                    Toast.makeText(Login_Live_Tips.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                }

//                if (edit_Name_Login.getText().toString().length() == 0) {
//                    edit_Name_Login.setError("Enter Your UserName");
//                    edit_Name_Login.requestFocus();
//                }
//                if (edit_Password_Login.getText().toString().length() == 0) {
//                    edit_Password_Login.setError("Password not entered");
//                    edit_Password_Login.requestFocus();
//                } else {
//                    Toast.makeText(getApplicationContext(), " Login Success", Toast.LENGTH_LONG).show();
//                }

//                validate(edit_Name_Login.getText().toString(), edit_Password_Login.getText().toString());
                break;

            case R.id.btnLiveRegister:
                Intent registerIntent = new Intent(Login_Live_Tips.this, Register_Live_Tips.class);
                com.example.affwlcom.live_tips.Login_Live_Tips.this.startActivity(registerIntent);
                break;
        }
    }

    private void CheckEditTextIsEmptyOrNot() {
        EmailHolder = edit_Name_Login.getText().toString();
        PasswordHolder = edit_Password_Login.getText().toString();

        if(TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder))
        {
            CheckEditText = false;
        }
        else {

            CheckEditText = true ;
        }

    }

    private void UserLoginFunction(final String email, final String password) {

        class UserLoginClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(Login_Live_Tips.this,"Loading Data",null,true,true);

            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {
                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                if(httpResponseMsg.equalsIgnoreCase("Data Matched")){

                    finish();

                    Intent intent = new Intent(Login_Live_Tips.this, Live_Tips.class);

                    intent.putExtra(UserEmail,email);

                    startActivity(intent);

                }
                else{

                    Toast.makeText(Login_Live_Tips.this,httpResponseMsg,Toast.LENGTH_LONG).show();
                }


            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("email",params[0]);

                hashMap.put("password",params[1]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        UserLoginClass userLoginClass = new UserLoginClass();

        userLoginClass.execute(email,password);
    }

}