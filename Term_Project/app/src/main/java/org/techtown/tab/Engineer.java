package org.techtown.tab;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Engineer extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.engineer_introduction);

        Intent receivedIntent = getIntent();

        Button menu01Button = (Button) findViewById(R.id.button);
        menu01Button.setOnClickListener((v)->{
            Intent resultIntent = new Intent();
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        });

        EditText hannumber = (EditText) findViewById(R.id.editTextTextPersonName3);
        hannumber.setOnClickListener((v) -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-2819-2901"));
            startActivity(intent);
        });
        EditText nanumber = (EditText) findViewById(R.id.editTextTextPersonName15);
        nanumber.setOnClickListener((v) -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-4064-3297"));
            startActivity(intent);
        });
        EditText ithomepage = (EditText) findViewById(R.id.editTextTextPersonName10);
        ithomepage.setOnClickListener((v) -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://it.jbnu.ac.kr/"));
            startActivity(intent);
        });
        EditText ithomepage1 = (EditText) findViewById(R.id.editTextTextPersonName17);
        ithomepage1.setOnClickListener((v) -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://it.jbnu.ac.kr/"));
            startActivity(intent);
        });

        Toast toast = Toast.makeText(this, "개발자 소개칸입니다.", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 20);
        toast.show();
    }
}