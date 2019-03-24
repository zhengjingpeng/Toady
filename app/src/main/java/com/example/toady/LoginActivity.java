package com.example.toady;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.toady.Utils.LoginUtils;

import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText mEdLoginNumber;
    private EditText mEdLoginPassword;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        Map<String, String> userInfo = LoginUtils.getUserInfo(this);
        if(userInfo != null) {
           // 显示在界面上
            mEdLoginNumber.setText(userInfo.get("account"));
            mEdLoginPassword.setText(userInfo.get("psw"));
        }
        findViewById(R.id.tv_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        mBtnLogin.setOnClickListener(this);
    }

    private void initView() {
        mEdLoginNumber = (EditText) findViewById(R.id.ed_login_number);
        mEdLoginPassword = (EditText) findViewById(R.id.ed_login_password);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_login:
               /* SharedPreferences sp=getSharedPreferences("data",MODE_PRIVATE);
                String mynumber = sp.getString("phone", null);
                String mypassword=sp.getString("password",null);
                String number = mEdLoginNumber.getText().toString();
                String password = mEdLoginPassword.getText().toString();

                if(number==mynumber&&password==mypassword){
                    Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
                }
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                break;*/
                Map<String, String> userInfo = LoginUtils.getUserInfo(getApplicationContext());
                String account = mEdLoginNumber.getText().toString().trim();
                String psw = mEdLoginPassword.toString();
// 校验号码和密码是否正确
                if (TextUtils.isEmpty(account)) {
                    Toast.makeText(getApplicationContext(), "请输入 QQ 号码", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(psw)) {
                    Toast.makeText(getApplicationContext(), "请输入密码", Toast.LENGTH_SHORT).show();
                }
                if(mEdLoginNumber.getText().toString().equals(userInfo.get("account"))&&
                        mEdLoginPassword.getText().toString().equals(userInfo.get("psw"))){
                    Toast.makeText(getApplicationContext(),"登陆成功",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"登陆失败",Toast.LENGTH_SHORT).show();
                }

        }

        }

    }

