package org.techtown.tab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Notice extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        Button menu01Button = (Button) findViewById(R.id.button2);
        menu01Button.setOnClickListener((v)->{
            Intent resultIntent = new Intent();
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        });

        Toast toast = Toast.makeText(this, "공지사항입니다.", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,20);
        toast.show();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        NoticeAdapter adapter = new NoticeAdapter();

        adapter.addItem(new NoticeList("1. ★블랙프라이데이 세일★", "12월 25일부터 블랙프라이데이 진행합니다. \n크리스마스 시즌 옷들도 많이 판매하고 있습니다. \n많은 관심 부탁드립니다."));
        adapter.addItem(new NoticeList("2. ★앱 오류 관련 쿠폰 지급★", "12월 20일에 발생했던 오류에 대해서 사과의 의미로 쿠폰을 지급하고 있습니다. \n쿠폰은 랜덤으로 5%~10% 지급됩니다. \n오류에 대해서는 다시한번 사죄의 말씀 드립니다."));
        adapter.addItem(new NoticeList("3. ★배송 지연 관련 문의★", "\n배송 지연에 관하여 많은 문의들이 들어왔습니다. \n연말 시즌이라 배송이 늦어지는 점 양해 부탁드립니다."));

        recyclerView.setAdapter(adapter);

    }
}
