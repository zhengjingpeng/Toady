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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEdtPhone;
    private EditText mEdtPassword;
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();


    }

    private void initView() {
        mEdtPhone = (EditText) findViewById(R.id.edt_phone);
        mEdtPassword = (EditText) findViewById(R.id.edt_password);
        mBtnRegister = (Button) findViewById(R.id.btn_register);
        /*toolbar_back=findViewById(R.id.toolbar_back);*/
        mBtnRegister.setOnClickListener(this);
/*
        toolbar_back.setOnClickListener(this);
*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_register:
               /* String phone= mEdtPhone.getText().toString();
                String password = mEdtPassword.getText().toString();
                SharedPreferences sp=getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                if(phone.isEmpty()){
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }
                if(password.isEmpty()){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    editor.putString("phone", phone);
                    editor.putString("password", password);
                    editor.commit();
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                }
                break;*/
           /* case R.id.toolbar_back:
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                break;*/
                String account = mEdtPhone.getText().toString().trim();
                String psw = mEdtPassword.getText().toString();
                if(TextUtils.isEmpty(account)) {
                    Toast.makeText(this, "请输入 QQ 号码",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(psw)) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 登录成功
                //Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                //Log.i("MainActivity", "记住密码: " + account + ", " + psw);
// 保存用户信息
                boolean isSaveSuccess = LoginUtils.saveUserInfo(this, account,
                        psw);
                if(isSaveSuccess) {
                    Toast.makeText(this, "保存成功",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "保存失败",
                            Toast.LENGTH_SHORT).show();
                }
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
        }
    }
}
