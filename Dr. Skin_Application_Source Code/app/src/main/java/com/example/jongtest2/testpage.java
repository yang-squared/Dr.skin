package com.example.jongtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class testpage extends AppCompatActivity {
    private EditText et_id, et_pass;
    private Button btn_login, btn_register,test;
    private CheckBox checkBox;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testpage);

        test = findViewById(R.id.test);
        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences sf = getSharedPreferences("File",MODE_PRIVATE);
        String text1 = sf.getString("text1","");
        if(!(text1.equals("")))
            checkBox.setChecked(true);
        et_id.setText(text1);
       /* Boolean isChecked = preferences.getBoolean("save",false);
        checkBox.setChecked(isChecked);
        if(isChecked){
            String id = preferences.getString("id","");
            et_id.setText(id);
        }
*/
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(testpage.this, Precautions.class);
                startActivity(intent);
            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse("http://222.118.197.112:8080/Drskin/?device=mobile")));
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){
                                String userID = jsonObject.getString("userID");
                                String userPass = jsonObject.getString("userPassword");
                                Toast.makeText(getApplicationContext(), userID+"님 환영합니다!",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(testpage.this,help.class);
                                intent.putExtra("userID",userID);
                                intent.putExtra("userPass",userPass);

                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "아이디 혹은 비밀번호를 \n다시한번 확인해주세요.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID, userPass, responseListener);
                RequestQueue queue = Volley.newRequestQueue(testpage.this);
                queue.add(loginRequest);
            }
        });
    }

    /*protected  void onDestroy(){
        super.onDestroy();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("save",checkBox.isChecked());
        editor.putString("id",et_id.getText().toString());
        editor.apply();
        public void erase(View view) {
            editText1.setText("");
            editText2.setText("");
        }
*/
    public void erase(View view) {
        et_id.setText("");
        et_pass.setText("");
    }
     public void confirm(View view) {

        }

        @Override
        protected void onStop() {
            super.onStop();

            SharedPreferences sharedPreferences = getSharedPreferences("File",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            if(checkBox.isChecked()) {
                String text1 = et_id.getText().toString();
                editor.putString("text1", text1);
            }
            else
            {
                editor.putString("text1", "");
            }

        editor.commit();
    }
 }