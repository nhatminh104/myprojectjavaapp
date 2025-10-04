package com.example.loginprofile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private TextView textViewUsername121;
    private TextView textViewPassword121;
    private ImageButton imageButtonBack121;
    private ImageButton imageButtonSettings121;
    private TextView textViewDisplayName121;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textViewUsername121 = findViewById(R.id.textViewUsername121);
        textViewPassword121 = findViewById(R.id.textViewPassword121);
        imageButtonBack121 = findViewById(R.id.imageButtonBack121);
        imageButtonSettings121 = findViewById(R.id.imageButtonSettings121);
        textViewDisplayName121 = findViewById(R.id.textViewDisplayName121);

        String usernameValue121 = getIntent().getStringExtra(MainActivity.EXTRA_USERNAME);
        String passwordValue121 = getIntent().getStringExtra(MainActivity.EXTRA_PASSWORD);

        if (usernameValue121 != null && passwordValue121 != null) {
            textViewUsername121.setText(usernameValue121);
            textViewDisplayName121.setText(usernameValue121);

            String maskedPassword = maskPassword(passwordValue121);
            textViewPassword121.setText(maskedPassword);
        } else {
            Toast.makeText(this, "Lỗi: Không nhận được thông tin tài khoản.", Toast.LENGTH_LONG).show();
            textViewUsername121.setText("Không có dữ liệu");
            textViewDisplayName121.setText("Không có dữ liệu");
            textViewPassword121.setText(maskPassword("default"));
        }

        imageButtonBack121.setOnClickListener(v -> {
            finish();
        });

        imageButtonSettings121.setOnClickListener(v -> {
            Toast.makeText(this, "Quay về màn hình Đăng nhập...", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private String maskPassword(String rawPassword) {
        if (rawPassword == null || rawPassword.isEmpty()) {
            return "";
        }
        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < rawPassword.length(); i++) {
            masked.append('\u2022');
        }
        return masked.toString();
    }
}
