package com.example.jongtest2;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class Frag4  extends Fragment {
    private View view;
    private Button button;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag4, container, false);

        Button button1 = (Button) view.findViewById(R.id.button1);
        Spannable span1 = (Spannable) button1.getText();
        span1.setSpan(new ForegroundColorSpan(Color.BLACK),0,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span1.setSpan(new RelativeSizeSpan(1.3f), 0, 6, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        Button button2 = (Button) view.findViewById(R.id.button2);
        Spannable span2 = (Spannable) button2.getText();
        span2.setSpan(new ForegroundColorSpan(Color.BLACK),0,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span2.setSpan(new RelativeSizeSpan(1.3f), 0, 6, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        Button button3 = (Button) view.findViewById(R.id.button3);
        Spannable span3 = (Spannable) button3.getText();
        span3.setSpan(new ForegroundColorSpan(Color.BLACK),0,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span3.setSpan(new RelativeSizeSpan(1.3f), 0, 6, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        Button button4 = (Button) view.findViewById(R.id.button4);
        Spannable span4 = (Spannable) button4.getText();
        span4.setSpan(new ForegroundColorSpan(Color.BLACK),0,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span4.setSpan(new RelativeSizeSpan(1.3f), 0, 10, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        Button button5 = (Button) view.findViewById(R.id.button5);
        Spannable span5 = (Spannable) button5.getText();
        span5.setSpan(new ForegroundColorSpan(Color.BLACK),0,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span5.setSpan(new RelativeSizeSpan(1.3f), 0, 6, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        Button button6 = (Button) view.findViewById(R.id.button6);
        Spannable span6 = (Spannable) button6.getText();
        span6.setSpan(new ForegroundColorSpan(Color.BLACK),0,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span6.setSpan(new RelativeSizeSpan(1.3f), 0, 10, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        Button button7 = (Button) view.findViewById(R.id.button7);
        Spannable span7 = (Spannable) button7.getText();
        span7.setSpan(new ForegroundColorSpan(Color.BLACK),0,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span7.setSpan(new RelativeSizeSpan(1.3f), 0, 9, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        Button button8 = (Button) view.findViewById(R.id.button8);
        Spannable span8 = (Spannable) button8.getText();
        span8.setSpan(new ForegroundColorSpan(Color.BLACK),0,3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span8.setSpan(new RelativeSizeSpan(1.3f), 0, 3, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        Button button9 = (Button) view.findViewById(R.id.button9);
        Spannable span9 = (Spannable) button9.getText();
        span9.setSpan(new ForegroundColorSpan(Color.BLACK),0,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span9.setSpan(new RelativeSizeSpan(1.3f), 0, 10, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        Button button10 = (Button) view.findViewById(R.id.button10);
        Spannable span10 = (Spannable) button10.getText();
        span10.setSpan(new ForegroundColorSpan(Color.BLACK),0,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span10.setSpan(new RelativeSizeSpan(1.3f), 0, 6, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        button = (Button)view.findViewById(R.id.hospital_info);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), hospital.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("http://www.khmc.or.kr/index.php")));
                startActivity(i);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("http://www.samsunghospital.com/home/main/index.do")));
                startActivity(i);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("http://www.amc.seoul.kr/asan/main.do")));
                startActivity(i);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("https://yuhs.severance.healthcare/yuhs/index.do")));
                startActivity(i);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("http://www.e-hyemin.co.kr/html/")));
                startActivity(i);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("http://www.paik.ac.kr/pmc/main.asp")));
                startActivity(i);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("https://www.cnuh.co.kr/")));
                startActivity(i);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("http://www.chamc.co.kr/")));
                startActivity(i);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("http://www.kumc.or.kr/main/index.do")));
                startActivity(i);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("https://www.inha.com/page/main")));
                startActivity(i);
            }
        });




        return view;
    }

}
