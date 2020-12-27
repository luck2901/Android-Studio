package org.techtown.tab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {

    private Button notice, engineer, QnA, logout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);

        notice = rootView.findViewById(R.id.button3);
        engineer = rootView.findViewById(R.id.button5);
        QnA = rootView.findViewById(R.id.button4);
        logout = rootView.findViewById(R.id.button6);

        QnA.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), QnA.class);
            startActivity(intent);
        });

            notice.setOnClickListener((v)->{
                Intent intent = new Intent(getActivity().getApplicationContext(), Notice.class);
                startActivity(intent);
            });

            engineer.setOnClickListener((v)->{
                Intent intent = new Intent(getActivity().getApplicationContext(), Engineer.class);
                startActivity(intent);
        });

        logout.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });
        return rootView;
    }
}
