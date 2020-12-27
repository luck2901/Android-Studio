package org.techtown.tab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddActivity extends AppCompatActivity {


    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //아이디 정의
        Button add_savebtn = (Button) findViewById(R.id.add_apply);
        final EditText title1 = (EditText) findViewById(R.id.title1);
        final EditText context1 = (EditText) findViewById(R.id.context1);

        //온클릭리스너
        add_savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //edittext에 저장된 텍스트 Strig에 저장
                String get_title = title1.getText().toString();
                String get_context = context1.getText().toString();

                //hashmap 만들기
                HashMap result = new HashMap<>();
                result.put("title1", get_title);
                result.put("context1", get_context);

                //firebase 정의
                mDatabase = FirebaseDatabase.getInstance().getReference();
                //firebase에 저장
                mDatabase.child("Article").push().setValue(result);





                Intent intent = new Intent(AddActivity.this, QnA.class);
                startActivity(intent);

            }
        });
    }
}