package com.example.jongtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Hospital_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_page);

        Button btn1 = (Button)findViewById(R.id.button);
        Button btn2 = (Button)findViewById(R.id.button1);
        Bundle bundle = getIntent().getExtras();
        String text = bundle.getString("text");

        TextView texts = (TextView) findViewById(R.id.Text);
        texts.setText(text);
        TextView textview1 = (TextView) findViewById(R.id.num);
        TextView textview2 = (TextView) findViewById(R.id.sog);
        TextView textview3 = (TextView) findViewById(R.id.time);
        ImageView picture = (ImageView)findViewById(R.id.picture);
        Intent i = new Intent(Intent.ACTION_VIEW);
        Intent j = new Intent(Intent.ACTION_VIEW);

        switch(text){
            case "서울대병원":
                textview1.setText("02-1588-0700");
                textview2.setText("본원을 비롯한 어린이병원, 암병원 그리고 의생명연구원으로 구성. \n 1,751개 병상을 운영하고 있으며 1일 9,000명의 외래환자를 1,800명의 의사 등 8천명의 직원이 돌보고 있습니다.");
                textview3.setText("평일 08:00 - 18:00\n예약센터에서 예약\n\n" +
                        "토요일 08:00 - 18:00\n예약센터에서 예약\n\n" +
                        "일요일 08:00 - 18:00 ");
                picture.setImageResource(R.drawable.seoul_univ);
                i.setData((Uri.parse("https://www.snuh.org/main.do")));
                j.setData((Uri.parse("tel:02-1588-0700")));
                break;

            case "서울아산병원":
                textview1.setText("02-1688-7575");
                textview2.setText(" 강릉·정읍·보령·홍천·보성·금강·영덕아산병원 등 아산복지재단이 운영하는 8개 지방병원의 모병원으로, 1989년 6월 서울중앙병원으로 개원하여 2002년 4월 지금의 이름으로 변경하였다. 산하에 아산생명과학연구소를 두고 기초의학 및 임상의학 분야 연구를 지원하고 있으며 학술잡지 및 학술도서를 발간한다.");
                textview3.setText("평일 08:30 - 17:30\n응급진료 24시간 가능\n" +
                        "주말 휴무 응급진료 24시간 가능\n" +
                        "공휴일 휴무 응급진료 24시간 가능");
                picture.setImageResource(R.drawable.hospital1);
                i.setData((Uri.parse("http://www.amc.seoul.kr/asan/main.do")));
                j.setData((Uri.parse("tel:02-1688-7575")));
                break;

            case "가톨릭대학교 서울성모병원":
                textview1.setText("02-1588-1511");
                textview2.setText(" 가톨릭대학교 서울성모병원은 지상 22층, 지하 6층, 1,374병상, 연면적 19만 제곱미터로 단일병원 건물로는 대한민국 최대의 크기를 자랑합니다.\n 뿐만 아니라 국내 최고 수준의 최첨단 장비를 도입하고, 세계적인 수준의 의료진을 다수 영입하였습니다. 환자중심의 서비스 및 진료시스템의 도입으로 한 차원 높은 의료문화를 선보이고자 합니다.");
                textview3.setText("평일 08:00 - 18:00\n" +
                        "주말 00:00 - 24:00 응급실\n" +
                        "공휴일 00:00 - 24:00 응급실");
                picture.setImageResource(R.drawable.hospital2);
                i.setData((Uri.parse("https://www.cmcseoul.or.kr/page/main")));
                j.setData((Uri.parse("tel:02-1588-1511")));
                break;

            case "고려대학교의료원 안암병원":
                textview1.setText("02-1577-0083");
                textview2.setText(" 최상의 진료를 위한 노력의 일환으로 환자의 안전을 최우선의 가치로 두고 있습니다.\n 이미 네 차례나 국제적인 의료안전의 인증기관인 JCI(Joint Commission International)의 인증을 취득하고 유지하면서 의료 안전의 문화를 철저하게 실천하고 있습니다. 또한 국내뿐 아니라 국제적으로도 손색이 없는 최상, 최첨단의 진료를 위해 모든 교직원들이 모든 분야에서 최선을 다하고 있다고 자부합니다.");
                textview3.setText("평일 09:00 - 17:30\n" +
                        "토요일 09:00 - 12:00\n" +
                        "일요일 휴무\n" +
                        "공휴일 휴무");
                picture.setImageResource(R.drawable.hospital3);
                i.setData((Uri.parse("http://anam.kumc.or.kr/main/index.do")));
                j.setData((Uri.parse("tel:02-1577-0083")));
                break;

            case "중앙대학교병원":
                textview1.setText("02-1800-1114");
                textview2.setText(" 지난 반세기 의학 발전과 국민 건강증진을 위해 노력해 온 중앙대학교병원은 우수한 의료진과 전문화된 인력이 고객을 최우선으로 하는 최상의 의료서비스를 제공하고 있으며, 최신 기종의 로봇수술(다빈치Si) 시스템과 국내 최초로 도입한 256채널 iCT, PET-CT, MRI, 선형가속기 등 최적의 진료인프라를 구축하고 이를 위해 지속적으로 투자하고 있습니다.");
                textview3.setText("월~금 08시30분~11시30분/13시00분~16시00분 (점심 12시00분~13시30분)\n" +
                        "토 08시30분~11시30분 (점심 오전 진료)\n" +
                        "일 휴무, 공휴일 휴무");
                picture.setImageResource(R.drawable.hospital4);
                i.setData((Uri.parse("http://ch.cauhs.or.kr/")));
                j.setData((Uri.parse("tel:02-1800-1114")));
                break;

            case "아주대학교병원":
                textview1.setText("031-1688-6114");
                textview2.setText(" 2020년 4회 연속 상급종합병원으로 지정됐으며, 보건복지부 의료질평가에서 전국 상급·종합병원 중 7개 병원만 받는 최상위 등급(1-가)을 획득하는 등 의료의 질적 수준이 국내 최고임을 인정받았습니다.\n 특히 경기남부 권역응급의료센터와 권역외상센터는 대량 재해와 감염환자 발생에 대비할 수 있는 완벽한 체계를 갖추고 24시간 빈틈없이 전국의 응급환자와 중증 외상환자의 치료를 위해 힘쓴 결과 보건복지부 평가에서 전국 1위의 평가를 받았습니다.");
                textview3.setText("평일 09:00 - 17:00\n" +
                        "토요일 09:00 - 12:00\n" +
                        "일요일 휴무 응급센터 종일진료\n" +
                        "공휴일 휴무 응급센터 종일진료");
                picture.setImageResource(R.drawable.hospital5);
                i.setData((Uri.parse("http://hosp.ajoumc.or.kr/")));
                j.setData((Uri.parse("tel:031-1688-6114")));
                break;

            case "경희의료원":
                textview1.setText("02-958-8114");
                textview2.setText(" 1971년 개원 동대문구 회기동 위치, 경희대병원-치과병원-한방병원-후마니타스암병원.");
                textview3.setText("평일 09:00 - 17:00\n" +
                        "토요일 09:00 - 12:00\n" +
                        "일요일 휴무\n" +
                        "공휴일 휴무");
                picture.setImageResource(R.drawable.hospital6);
                i.setData((Uri.parse("http://www.khmc.or.kr/index.php")));
                j.setData((Uri.parse("tel:02-958-8114")));
                break;

            case "건국대학교병원":
                textview1.setText("02-1588-1533");
                textview2.setText(" 의료 환경의 급격한 변화에 대응하고 양질의 의료서비스를 제공하기위해 건국대학교병원이 다시 태어났습니다. 지하4층 지상 13층, 연면적 2만5,000평의 새 병원은 최첨단 의료 장비와 완벽한 전산화 시스템을 갖추고 있으며, 유능하고 덕망 있는 의료진과 마음 따뜻한 직원들이 조화를 이루고 있습니다. 건국대학교병원은 이러한 안정적 진료 환경을 바탕으로 여러분께 알찬 서비스를 제공하기 위해 최선을 다할 것입니다.");
                textview3.setText("평일 08:30 - 17:30\n" +
                        "토요일 08:30 - 12:00\n" +
                        "일요일 휴무 응급센터 종일진료\n" +
                        "공휴일 휴무 응급센터 종일진료");
                picture.setImageResource(R.drawable.hospital7);
                i.setData((Uri.parse("https://www.kuh.ac.kr/main.do")));
                j.setData((Uri.parse("tel:02-1588-1533")));
                break;

            case "인하대학교 부속병원":
                textview1.setText("032-890-2114");
                textview2.setText(" 인하대병원은 1996년 5월27일 세계화의 관문인 인천에서 국내 최고 수준의 의료진과 초현대식 시설 및 첨단 의료장비를 갖추고 인천 최초의 대학병원으로 개원하였습니다.");
                textview3.setText("평일 08:00 - 16:30\n" +
                        "토요일 08:00 - 11:30 응급센터 종일진료\n" +
                        "일요일 휴무 응급센터 종일진료\n" +
                        "공휴일 휴무 응급센터 종일진료");
                picture.setImageResource(R.drawable.hospital8);
                i.setData((Uri.parse("https://www.inha.com/page/main")));
                j.setData((Uri.parse("tel:032-890-2114")));
                break;

            case "순천향대학교 서울병원":
                textview1.setText("02-709-9114");
                textview2.setText(" 40여년 동안 인간사랑의 설립이념과 성실, 봉사, 연구의 원훈으로 인술을 펼쳐온 순천향대학교부속 서울병원은 최신 의학지식을 갖춘 교수진과 첨단 의료시설, 쾌적한 환경, 환자를 주인으로 모시는 고객감동의 친절서비스로 대학병원으로서의 사명과 역할을 다함으로써 명실공히 하늘의 뜻을 받들어 인술을 펼쳐 가는 고향마을로 자리매김해 나갈 것입니다.");
                textview3.setText("평일 09:00 - 17:00\n" +
                        "토요일 09:00 - 12:00\n" +
                        "일요일 00:00 - 24:00\n 응급센터 종일진료\n" +
                        "공휴일 휴무");
                picture.setImageResource(R.drawable.hospital9);
                i.setData((Uri.parse("https://www.schmc.ac.kr/seoul/index.do")));
                j.setData((Uri.parse("tel:02-709-9114")));
                break;

            case "세브란스병원":
                textview1.setText("02-1599-1004");
                textview2.setText("세브란스병원은 국내 최초로 진료의 전문화를 통한 의료의 질 향상을 추구하여 재활병원, 심장혈관병원, 안과병원, 어린이병원과 응급진료센터, 국제진료센터 등 전문센터와 암클리닉을 운영하고 있습니다.");
                textview3.setText("평일 08:00 - 15:30\n진료접수시간\n\n" +
                        "토요일 08:00 - 11:30\n진료접수시간 오전진료");
                picture.setImageResource(R.drawable.sebrance);
                i.setData((Uri.parse("https://sev.severance.healthcare/sev/index.do")));
                j.setData((Uri.parse("tel:02-1599-1004")));
                }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(j);
            }
        });
    }
}