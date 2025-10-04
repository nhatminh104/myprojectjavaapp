package com.example.loginprofile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername121;
    private EditText editTextPassword121;
    private Button buttonLogin121;

    public static final String EXTRA_USERNAME = "com.example.USERNAME";
    public static final String EXTRA_PASSWORD = "com.example.PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername121 = findViewById(R.id.editTextUsername121);
        editTextPassword121 = findViewById(R.id.editTextPassword121);
        buttonLogin121 = findViewById(R.id.buttonLogin121);

        editTextUsername121.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                Toast.makeText(MainActivity.this, "Xóa ký tự trong Username", Toast.LENGTH_SHORT).show();
            }
            return false;
        });

        editTextPassword121.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                Toast.makeText(MainActivity.this, "Xóa ký tự trong Password", Toast.LENGTH_SHORT).show();
            }
            return false;
        });

        buttonLogin121.setOnClickListener(v -> performLogin());
    }

    private void performLogin() {
        String usernameValue121 = editTextUsername121.getText().toString();
        String passwordValue121 = editTextPassword121.getText().toString();

        if (usernameValue121.isEmpty() || passwordValue121.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ Tên người dùng và Mật khẩu.", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent121 = new Intent(MainActivity.this, ProfileActivity.class);
        intent121.putExtra(EXTRA_USERNAME, usernameValue121);
        intent121.putExtra(EXTRA_PASSWORD, passwordValue121);
        startActivity(intent121);
        editTextPassword121.setText("");
    }
}
