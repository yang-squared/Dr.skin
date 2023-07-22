package com.example.jongtest2;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class Frag5  extends Fragment {
    private View view;
    Button button1, button2;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag5,container,false);
        button1 = (Button) view.findViewById(R.id.button1);
        button2 = (Button) view.findViewById(R.id.button2);

        int images[]={
                R.drawable.banner1,
                R.drawable.banner2,
                R.drawable.banner3
        };
        ViewFlipper banner = (ViewFlipper) view.findViewById(R.id.banner);
        for(int image : images) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(image);

            banner.addView(imageView);
            banner.setFlipInterval(3000);
            banner.setAutoStart(true);

            banner.setInAnimation(getActivity(),android.R.anim.slide_in_left);
            banner.setOutAnimation(getActivity(),android.R.anim.slide_out_right);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), info.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), By.class);
                startActivity(intent);
            }
        });
        return view;

    }
}
