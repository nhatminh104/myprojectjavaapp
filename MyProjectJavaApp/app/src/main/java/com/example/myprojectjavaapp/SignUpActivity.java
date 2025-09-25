package com.example.myprojectjavaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText edtFullName121, edtEmail121, edtPhone121, edtPassword121, edtConfirmPassword121;
    private Button btnSignUp121, facebookButton_121, googleButton_121;
    private TextView txtSignIn121;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edtFullName121 = findViewById(R.id.edtFullName121);
        edtEmail121 = findViewById(R.id.edtEmail121);
        edtPhone121 = findViewById(R.id.edtPhone121);
        edtPassword121 = findViewById(R.id.edtPassword121);
        edtConfirmPassword121 = findViewById(R.id.edtConfirmPassword121);
        btnSignUp121 = findViewById(R.id.btnSignUp121);
        txtSignIn121 = findViewById(R.id.txtSignIn121);
        facebookButton_121 = findViewById(R.id.facebookButton_121);
        googleButton_121 = findViewById(R.id.googleButton_121);

        btnSignUp121.setOnClickListener(v -> {
            String fullName = edtFullName121.getText().toString().trim();
            String email = edtEmail121.getText().toString().trim();
            String phone = edtPhone121.getText().toString().trim();
            String password = edtPassword121.getText().toString().trim();
            String confirmPassword = edtConfirmPassword121.getText().toString().trim();

            if (fullName.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(SignUpActivity.this, "Mật khẩu xác nhận không khớp!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SignUpActivity.this, "Đăng ký thành công cho: " + fullName, Toast.LENGTH_SHORT).show();
            }
        });

        txtSignIn121.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        facebookButton_121.setOnClickListener(v ->
                Toast.makeText(SignUpActivity.this, "Đăng ký bằng Facebook!", Toast.LENGTH_SHORT).show()
        );

        googleButton_121.setOnClickListener(v ->
                Toast.makeText(SignUpActivity.this, "Đăng ký bằng Google!", Toast.LENGTH_SHORT).show()
        );
    }
}
