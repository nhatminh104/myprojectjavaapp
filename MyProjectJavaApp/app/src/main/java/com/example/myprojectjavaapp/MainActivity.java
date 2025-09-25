package com.example.myprojectjavaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText phoneEditText_121;
    private EditText passwordEditText_121;
    private TextView forgotPasswordTextView_121;
    private Button signInButton_121;
    private TextView signUpTextView_121;
    private Button facebookButton_121;
    private Button googleButton_121;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXaVaThietLapSuKien_121();
    }

    private void anhXaVaThietLapSuKien_121() {
        phoneEditText_121 = findViewById(R.id.phoneEditText_121);
        passwordEditText_121 = findViewById(R.id.passwordEditText_121);
        forgotPasswordTextView_121 = findViewById(R.id.forgotPasswordTextView_121);
        signInButton_121 = findViewById(R.id.signInButton_121);
        signUpTextView_121 = findViewById(R.id.signUpTextView_121);
        facebookButton_121 = findViewById(R.id.facebookButton_121);
        googleButton_121 = findViewById(R.id.googleButton_121);

        signInButton_121.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone_121 = phoneEditText_121.getText().toString().trim();
                String password_121 = passwordEditText_121.getText().toString().trim();

                if (phone_121.isEmpty() || password_121.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Đăng nhập với SĐT: " + phone_121, Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgotPasswordTextView_121.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Chức năng Quên mật khẩu!", Toast.LENGTH_SHORT).show());
        signUpTextView_121.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Chuyển đến màn hình Đăng ký!", Toast.LENGTH_SHORT).show());
        facebookButton_121.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Đăng nhập bằng Facebook!", Toast.LENGTH_SHORT).show());
        googleButton_121.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Đăng nhập bằng Google!", Toast.LENGTH_SHORT).show());
    }
}