package org.techtown.tab;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import org.json.JSONObject;

import java.lang.reflect.Field;

public class Fragment2 extends Fragment {

    private TextView id,name,age,num,major;
    private ImageView pic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);

        id = rootView.findViewById(R.id.editTextTextPersonName4);
        name = rootView.findViewById(R.id.editTextTextPersonName5);
        age = rootView.findViewById(R.id.editTextTextPersonName6);
        num = rootView.findViewById(R.id.editTextTextPersonName7);
        major = rootView.findViewById(R.id.editTextTextPersonName8);

        Bundle bundle = getArguments();

        String id_ = bundle.getString("id");
        String name_ = bundle.getString("name");
        String age_ = bundle.getString("age");
        String hak_ = bundle.getString("hak");
        String major_ = bundle.getString("major");

        pic = rootView.findViewById(R.id.imageView2);

        int lid = getResources().getIdentifier(name_,"drawable", getActivity().getPackageName());

        pic.setImageResource(lid);

        id.setText(id_);
        name.setText(name_);
        age.setText(age_);
        num.setText(hak_);
        major.setText(major_);

        return rootView;
    }
}
