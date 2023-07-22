package com.example.jongtest2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
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

public class Frag1 extends Fragment {
    private View view;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1, container, false);

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

        Button button1 = (Button) view.findViewById(R.id.button1);
        Spannable span1 = (Spannable) button1.getText();
        span1.setSpan(new ForegroundColorSpan(Color.GRAY),0,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        Button button2 = (Button) view.findViewById(R.id.button2);
        Spannable span2 = (Spannable) button2.getText();
        span2.setSpan(new ForegroundColorSpan(Color.GRAY),0,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        Button button3 = (Button) view.findViewById(R.id.button3);
        Spannable span3 = (Spannable) button3.getText();
        span3.setSpan(new ForegroundColorSpan(Color.GRAY),0,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        Button button4 = (Button) view.findViewById(R.id.button4);
        Spannable span4 = (Spannable) button4.getText();
        span4.setSpan(new ForegroundColorSpan(Color.GRAY),0,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        Button button5 = (Button) view.findViewById(R.id.button5);
        Spannable span5 = (Spannable) button5.getText();
        span5.setSpan(new ForegroundColorSpan(Color.GRAY),0,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        Button button6 = (Button) view.findViewById(R.id.button6);
        Spannable span6 = (Spannable) button6.getText();
        span6.setSpan(new ForegroundColorSpan(Color.GRAY),0,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial();
                /*
                AlertDialog alertDialog = new AlertDialog.Builder(Frag1.this).create();
                AlertDialog.Builder dialog = new AlertDialog.Builder(Frag1.this);
                dialog.setTitle("제목").setMessage("메시지");
                dialog.show();*/
                }
            });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial2();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial3();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial4();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial5();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial6();
            }
        });

        return view;
    }


    void dial()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(" 피부암 막으려면 ‘이렇게’ 하세요").setMessage("피부과 전문의에게 ‘전신 피부 검진’을 받으면 피부암을 조기 발견할 수 있을 확률이 2배 올라간다는 연구 결과가 나왔다.\n" +
                "\n"+" 연구팀은 가족력이 있거나 자외선에 노출이 많은 고위험군이라면 정기적인 전신 피부 검사를 받아야 한다고 본다. 편평세포암, 기저세포암의 주요 원인은 자외선이며, 흑색종은 확실히 규명되진 않았지만, 자외선 노출, 유전적 요인이 원인일 것으로 추정된다. 가족 내 흑색종 환자가 있는 경우 없는 사람보다 발병률이 8배 높은 것으로 알려졌다.");
        builder.setPositiveButton("더 보기",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"페이지로 이동합니다.",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("https://m.health.chosun.com/svc/news_view.html?contid=2021081301477")));
                startActivity(i);
            }
        });
        builder.setNegativeButton("닫기",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
               // Toast.makeText(getActivity(),"닫기.",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }


    void dial2()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(" 피부병 환자 타깃 신약개발 열기 후끈").setMessage("CRO 전문기관 아이큐비아는 지난 22일 식약처로부터 #키닉사 파마슈티컬즈의 '빅사렐리맙'(Vixarelimab, KPL-716)에 대한 2상 임상시험을 승인받았다. 결절성 가려움 발진(결절성 양진) 환자 24명을 대상으로 소양증 감소에 대한 'KPL-716'의 유효성, 안전성, 내약성, 약동학 등을 알아보기 위한 시험이다\n" +
                "\n"+"유한양행도 이달 16일 ‘YH35324’의 1상 임상시험을 승인 받았다. 유한양행은 이번 승인에 따라 앞으로 아토피가 있는 건강인 또는 경증의 알레르기질환을 가진 피험자 68명을 대상으로 ‘YH35324’ 피하 주사 시의 안전성, 내약성, 약동학 및 약력학적 특성을 평가하기 위한 임상을 진행할 예정이다. 임상기관은 유항양행은 분당서울대병원, 아주대병원, 신촌세브란스병원 등이다.\n" +
                "\n" +"앞으로 어떤 신약이 개발되어 환자의 삶의 질 개선에 도움을 줄 수 있을지 주목된다.");
        builder.setPositiveButton("더 보기",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"페이지로 이동합니다.",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("https://www.hkn24.com/news/articleView.html?idxno=320261")));
                startActivity(i);
            }
        });
        builder.setNegativeButton("닫기",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getActivity(),"확인.",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }

    void dial3()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(" 땀이 줄줄 흐르는 여름철…요주의 피부병").setMessage("1. 완선" +
                "\n" +
                "앉아 있는 시간이 많은 사람들 중에는 사타구니 부분이 가렵고 벌겋게 붓는 증상을 경험한 일이 종종 있을 것이다. 사타구니에 홍반과 가려움증이 생기는 증상은 습진이 아닌 곰팡이 균에 감염돼 생기는 완선이라는 질환이다\n\n" +
                "\n"+"2. 어루러기" +
                "\n" +
                "갑자기 피부가 겹치는 곳이나 땀이 잘 흐르는 곳에 갑자기 얼룩덜룩한 반점이 생기는 경우가 있다. 어루러기(전풍)라는 질환으로 말라세지아라는 효모균에 의해 발생한다. 주로 겨드랑이, 가슴, 등, 목 등에 황토색, 황갈색, 붉은 빛을 띠는 다양한 크기의 반점과 하양 버짐 같은 반점이 섞여 있는 것이 특징이다.\n\n"
        +"3. 농가진" +
                "\n" +
                "벌레에 물렸거나 아토피성 피부염이 있는 아이가 환부를 긁어 생긴 상처에 포도상구균이나 연쇄상구균이 침투해 노란 고름이 차오르는 경우 대부분이 농가진이다. 물집 농가진은 신생아에서 주로 발생하며 무력증, 발열, 설사 등이 동반되기도 한다.");
        builder.setPositiveButton("더 보기",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"페이지로 이동합니다.",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("http://kormedi.com/1345936/%EB%95%80%EC%9D%B4-%EC%A4%84%EC%A4%84-%ED%9D%90%EB%A5%B4%EB%8A%94-%EC%97%AC%EB%A6%84%EC%B2%A0%EC%9A%94%EC%A3%BC%EC%9D%98-%ED%94%BC%EB%B6%80%EB%B3%91-3/")));
                startActivity(i);
            }
        });
        builder.setNegativeButton("확인",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"확인.",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }

    void dial4()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(" 혈압 조절 돕는 음식 7가지.. 또 다른 몸의 변화는?").setMessage("◆ 방울토마토" +
                "\n" +
                "몸속의 나트륨을 배출하는 칼륨이 풍부해 혈압 조절을 돕고 궁극적으로 심장병, 뇌졸중 예방에 효과를 낸다.\n\n" +
                "\n"+"◆ 시금치" +
                "\n" +
                "시금치는 100g당 502mg의 칼륨을 갖고 있다. 고혈압을 예방-조절하고 몸속의 노폐물 배출을 원활하게 한다.\n\n"
                +"◆ 표고버섯" +
                "\n" +
                "표고버섯에는 에르고스테롤 성분이 풍부해 혈중 콜레스테롤 농도를 낮추고 혈압을 조절하는데 도움을 준다.\n\n"+
                "◆ 상추" +
                "\n" +
                "일반 채소에 비해 수분(약 90%)이 많고 칼슘, 비타민 등이 풍부하다. 칼륨, 철분이 많아 혈액의 양을 늘리고 맑게 해주는 효과를 낸다.\n\n" +
                "\n"+"◆ 고구마" +
                "\n" +
                "칼륨을 비롯해 비타민 A, B, C가 풍부하고, 비타민 C는 조리할 때 열을 가해도  70~80%나 남아 있다.\n\n"
                +"◆ 감자" +
                "\n" +
                "감자에 많이 든 칼륨은 나트륨의 배출을 도와 고혈압 환자의 혈압 조절에 도움을 준다. 감자의 비타민 C는 스트레스로 인한 피로를 더는 데 좋다.\n\n"+
                "◆ 브로콜리\n"+"브로콜리에는 혈압 조절에 좋은 칼륨이 100g당 307㎎ 들어있다. 칼륨은 혈압을 낮추고 심장을 보호하는데 도움을 준다. 브로콜리의 열랑은 100당 28kcal로 대표적인 저칼로리- 저지방 식품이다."
        );
        builder.setPositiveButton("더 보기",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"페이지로 이동합니다.",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("http://kormedi.com/1359133/%ED%98%88%EC%95%95-%EC%A1%B0%EC%A0%88-%EB%8F%95%EB%8A%94-%EC%9D%8C%EC%8B%9D-7%EA%B0%80%EC%A7%80-%EB%98%90-%EB%8B%A4%EB%A5%B8-%EB%AA%B8%EC%9D%98-%EB%B3%80%ED%99%94%EB%8A%94/")));
                startActivity(i);
            }
        });
        builder.setNegativeButton("닫기",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getActivity(),"확인.",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }

    void dial5()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(" '햇빛 알레르기'는 흔한 피부병… 자외선 차단제로 예방").setMessage("일반적으로 알려진 햇빛 알레르기는 햇빛을 단시간 쬐도 물집이 생기고 수포가 올라오게 된다. 단순히 두드러기가 난 것 처럼 피부가 올라오는 증상 수준이라면 잠시 뒤 사라지지만 작은 수포들은 시간이 지나도 사라지지 않고 가려움을 유발한다.\n" +
                "\n" +
                "김지훈 원장에 따르면 햇빛 알레르기 질환자는 광과민성 피부염의 대표적인 질환은 다형 광발진과 일광 두드러기가 발생하게 된다.\n" +
                "\n" +
                "특별한 원인 없이 자외선에 노출되면 생기는 경우가 흔히 있는데다 햇빛 쬐기를 중단하면 곧바로 증상이 사라지기 때문에 ‘햇빛 알레르기’라는 이름이 붙게 된것이다.\n" +
                "\n" +
                "\n"+"김지훈 원장은 증상이 아주 심한 사람이 아니라면 심각한 질환은 아니라는 의견을 밝혔다.\n" +
                "\n" +
                "김 원장은 \"감기만큼은 아니더라도 굉장히 흔하게 발생 하는 피부 질환중 하나\"라며 \"선천, 후천을 따지기도 어려울 정도로 너무나 흔하게 발생하기 때문에 과도한 걱정에 쌓일 필요 없다\"고 조언했다.\n" +
                "\n" +
                "김 원장에 따르면 원인이 자외선 때문이라는 점이 공통적이기에 자외선 차단제를 통해 충분히 예방이 가능하다.\n" +
                "\n" +
                "또 증상에 따른 치료가 어렵지 않고 적절한 보호조치화 함께하면 낫기 어렵지 않다는 것이 그의 의견이다.\n" +
                "\n" +
                "다만 증상이 심각할 경우 피부과를 찾아 검사를 받아 적절한 치료를 받는 것을 추천한다고 전했다.\n" +
                "\n" +
                "김 원장은 \"여름철 햇빛으로 화상을 입는 등 광 과민성 피부염이 아닌데도 이를 의심하는 경우가 있다\"며 \"만약 햇빛을 받은 부위 뿐 아니라 다른 부위에서도 홍반이나 물집이 생겨날 경우 광과민성 피부를 의심하고 전문의에게 상담을 받기를 추천한다\"고 전했다."
                );
        builder.setPositiveButton("더 보기",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"페이지로 이동합니다.",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("http://www.joongboo.com/news/articleView.html?idxno=363454039")));
                startActivity(i);
            }
        });
        builder.setNegativeButton("닫기",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getActivity(),"확인.",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }

    void dial6()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(" ‘간헐적 단식’하면 건강하고 장수한다?").setMessage("일주일에 이틀을 굶는 5:2 다이어트 혹은 하루에 16시간을 굶고 8시간 안에 식사를 하는 16/8 같은 간헐적 단식(intermittent fasting)에 대해, 연예인 등의 일부 유명 인사들은 살을 빼는 훌륭한 방법이라고 주장한다."
        +"그러나 노화 과정을 늦추기 위해 간헐적 단식을 채택하는 데는 어려움이 있다. 현대인들은 하루 세끼 식사에 익숙해 이런 단식을 실행하기가 쉽지 않기 때문이다.\n"
                +"그러면 이런 간헐적 단식의 이점을 알약으로 만들어 적용할 수 있는 방법은 없을까? 미국 컬럼비아대 연구팀은 최근 초파리를 대상으로 한 단식 실험 연구를 통해 이 방법이 가능할 것이라고 밝혔다.\n" +
                        "\n" +
                        "과학 저널 ‘네이처’(Nature) 9월 29일 자에 발표한 새로운 연구에서 이들은 간헐적 단식이 세포 내부에서 어떻게 노화 과정을 늦추는지를 보여주고, 단식하느라 굶어서 허기가 지지 않고도 단식의 건강상 이점을 얻을 수 있는 잠재적인 방법을 제시했다.\n" +
                        "\n" +
                        "일반적으로 간헐적 단식과 시간제한 식사는 하루 중 특정 시간으로 음식 섭취를 제한하지만, 전체 칼로리 섭취는 제한하지 않는다. 이와 반대로 수명을 증가시키는 것으로 알려진 식이 제한은 칼로리 섭취를 줄인다."
                +"이번 연구는 이 세척 과정을 자극하는 행동 변화나 약물이 사람들에게 유사한 건강상의 이점을 제공함으로써 노화 관련 질병을 늦추고 수명을 연장할 가능성을 열어줄 것으로 보고 있다.\n" +
                        "\n" +
                        "얼게레이트 박사는 “식사를 제한하는 것은 어떤 형태든 실천하기가 쉽지 않으며 많은 훈련이 필요하다”고 말했다.\n" +
                        "\n" +
                        "그는 “시간제한 단식에 대한 대부분의 연구는 피험자가 견딜 수 있도록 도중에 음식을 마음껏 먹을 수 있는 치팅데이(cheat day) 만들어 놓는다”고 전하고, “특히 밤에 약물을 이용해 자가 포식을 강화할 수 있다면 훨씬 쉽게 건강상의 이점을 얻을 수 있을 것”이라고 전망했다."
        );

        builder.setPositiveButton("더 보기",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"페이지로 이동합니다.",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("https://www.sciencetimes.co.kr/news/%EA%B0%84%ED%97%90%EC%A0%81-%EB%8B%A8%EC%8B%9D%ED%95%98%EB%A9%B4-%EA%B1%B4%EA%B0%95%ED%95%98%EA%B3%A0-%EC%9E%A5%EC%88%98%ED%95%9C%EB%8B%A4/")));
                startActivity(i);
            }
        });
        builder.setNegativeButton("닫기",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getActivity(),"확인.",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }
    /*
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag1);
    }
    public void OnClickHandler(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("인사말").setMessage("반갑습니다");

        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }*/
}
