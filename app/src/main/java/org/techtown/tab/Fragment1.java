package org.techtown.tab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    ImageView pic1,pic2,pic3,pic4,pic5,pic6,pic7,pic8,pic9,pic10;
    ImageView pic11,pic12,pic13,pic14,pic15,pic16,pic17,pic18,pic19,pic20;
    ImageView pic21,pic22,pic23,pic24;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        pic1 = rootView.findViewById(R.id.imageView);
        pic1.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap1.class);
            startActivity(intent);
        });
        pic2 = rootView.findViewById(R.id.imageView4);
        pic2.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap2.class);
            startActivity(intent);
        });
        pic3 = rootView.findViewById(R.id.imageView3);
        pic3.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap3.class);
            startActivity(intent);
        });
        pic4 = rootView.findViewById(R.id.imageView5);
        pic4.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap4.class);
            startActivity(intent);
        });
        pic5 = rootView.findViewById(R.id.imageView6);
        pic5.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap5.class);
            startActivity(intent);
        });
        pic6 = rootView.findViewById(R.id.imageView7);
        pic6.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap1.class);
            startActivity(intent);
        });
        pic7 = rootView.findViewById(R.id.imageView12);
        pic7.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap2.class);
            startActivity(intent);
        });
        pic8 = rootView.findViewById(R.id.imageView11);
        pic8.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap3.class);
            startActivity(intent);
        });
        pic9 = rootView.findViewById(R.id.imageView8);
        pic9.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap4.class);
            startActivity(intent);
        });
        pic10 = rootView.findViewById(R.id.imageView9);
        pic10.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap5.class);
            startActivity(intent);
        });
        pic11 = rootView.findViewById(R.id.imageView10);
        pic11.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap1.class);
            startActivity(intent);
        });
        pic12 = rootView.findViewById(R.id.imageView13);
        pic12.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap2.class);
            startActivity(intent);
        });
        pic13 = rootView.findViewById(R.id.imageView14);
        pic13.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap3.class);
            startActivity(intent);
        });
        pic14 = rootView.findViewById(R.id.imageView15);
        pic14.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap4.class);
            startActivity(intent);
        });
        pic15 = rootView.findViewById(R.id.imageView16);
        pic15.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap5.class);
            startActivity(intent);
        });
        pic16 = rootView.findViewById(R.id.imageView17);
        pic16.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap1.class);
            startActivity(intent);
        });
        pic17 = rootView.findViewById(R.id.imageView18);
        pic17.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap2.class);
            startActivity(intent);
        });
        pic18 = rootView.findViewById(R.id.imageView19);
        pic18.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap3.class);
            startActivity(intent);
        });
        pic19 = rootView.findViewById(R.id.imageView20);
        pic19.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap4.class);
            startActivity(intent);
        });
        pic20 = rootView.findViewById(R.id.imageView21);
        pic20.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap5.class);
            startActivity(intent);
        });
        pic21 = rootView.findViewById(R.id.imageView22);
        pic21.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap1.class);
            startActivity(intent);
        });
        pic22 = rootView.findViewById(R.id.imageView23);
        pic22.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap2.class);
            startActivity(intent);
        });
        pic23 = rootView.findViewById(R.id.imageView26);
        pic23.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap3.class);
            startActivity(intent);
        });
        pic24 = rootView.findViewById(R.id.imageView27);
        pic24.setOnClickListener((v)->{
            Intent intent = new Intent(getActivity().getApplicationContext(), googlemap4.class);
            startActivity(intent);
        });


        return rootView;
    }

}
