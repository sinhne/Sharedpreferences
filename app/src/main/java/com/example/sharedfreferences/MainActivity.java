package com.example.sharedfreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtuser,edtpass;
    Button btndn;
    CheckBox cb;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        sharedPreferences=getSharedPreferences("datalogin",MODE_PRIVATE);
        edtuser.setText(sharedPreferences.getString("tai khoan",""));
        edtpass.setText(sharedPreferences.getString("mat khau",""));
        cb.setChecked((sharedPreferences.getBoolean("checked", false)));
        btndn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edtuser.getText().toString().trim();
                String password=edtpass.getText().toString().trim();

                if(username.equals("sinh123")&&password.equals("sinh2210")){
                    Toast.makeText(MainActivity.this, "thanh cong", Toast.LENGTH_SHORT).show();
                    if(cb.isChecked()){
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("taikhoan",username);
                        editor.putString("matkhau",password);
                        editor.putBoolean("checked",true);
                        editor.commit();
                    }else {
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void AnhXa(){
        btndn=(Button) findViewById(R.id.button);
        edtuser=(EditText) findViewById(R.id.TextPersonName);
        edtpass=(EditText) findViewById(R.id.TextPassword);
        cb=(CheckBox) findViewById(R.id.checkBox);
    }

}