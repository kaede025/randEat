package com.marcus.randeat;

import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 100;
    private EditText edNumber;
    private Button bExam;
    private Button bEat;
//    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Resource GO TO res

        //auth = FirebaseAuth.getInstance();
      //  auth.addAuthStateListener(this);

        findViews();
        bEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bEat(v);
            }
        });
    }

    private void findViews() {
        edNumber = findViewById(R.id.editText);
        bEat = findViewById(R.id.button);
        bExam = findViewById(R.id.button2);
    }

    public void bEat(View v){
        String ans = edNumber.getText().toString();
        if(ans.equals("")) {
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("no input")
                    .setTitle("Warning")
                    .show();
            return;
        }
        int ians = Integer.parseInt(ans);
        edNumber.setText("");  //clear textView
        new AlertDialog.Builder(MainActivity.this)
                .setMessage("吃土")
                .setTitle("alert")
                .setPositiveButton("WTF!",null)
                .show();

    }

    public void bExam(View v){
        Random qq = new Random();
        int answer = qq.nextInt(4);
        switch (answer){
            case(1):
                //Log.d("exam1" , String.valueOf(answer));  寫入LOG
                /*  AlertDialog 標準建立方式
                AlertDialog.Builder adBuilder = new AlertDialog.Builder(this);
                adBuilder.setMessage("飯");
                adBuilder.show();
                */
                new AlertDialog.Builder(this)
                        .setMessage("吃麵")
                        .setTitle("alert範例")
                        .show();
                // Anonymouse 匿名建立方式 直接設定並顯示不額外建立object
                break;
            case(2):
                new AlertDialog.Builder(this)
                        .setMessage("吃水餃")
                        .setTitle("AD內按鈕範例")
                        .setPositiveButton("OK",null)
                        .setNeutralButton("cancel",null)
                        .show();
                break;
            case(3):
                new AlertDialog.Builder(this)
                        .setMessage("吃土")
                        .setTitle("AD內按鈕範例2")
                        .setNegativeButton("NO!",null)
                        .show();
                break;
            default:
                // 浮動對話用法
                Toast.makeText(this,"飯", Toast.LENGTH_LONG).show();
                break;
        }
    }
/*
    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user == null){
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                                .setAvailableProviders(Arrays.asList(
                                        new AuthUI.IdpConfig.EmailBuilder().build(),
                                        new AuthUI.IdpConfig.GoogleBuilder().build(),
                                        new AuthUI.IdpConfig.PhoneBuilder().build()
                    )).build(),
                    RC_SIGN_IN);
        }else{

        }
    }
    */
}
