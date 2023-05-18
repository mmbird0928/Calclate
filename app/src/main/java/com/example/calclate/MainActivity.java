package com.example.calclate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //インスタンスを用意
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button btnplus;
    private Button btnmainasu;
    private Button btnkakeru;
    private Button btnwaru;
    private Button btnikoru;
    private Button btnc;
    private TextView calctext;
    private TextView calctext2;
    private int calcphase = 0;
    private int operator = 0;
    private String text;
    private StringBuilder sb;
    private StringBuilder sb2;
    private int calc1;
    private int calc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //メインメソッドのようなもの
        //アプリ起動時に実行するもの

        //インスタンスとid名を紐づけする
        btn1 = findViewById(R.id.btn1);
        //ボタンにクリック機能をつける
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        btnplus = findViewById(R.id.btnplus);
        btnplus.setOnClickListener(this);
        btnmainasu = findViewById(R.id.btnmainasu);
        btnmainasu.setOnClickListener(this);
        btnkakeru = findViewById(R.id.btnkakeru);
        btnkakeru.setOnClickListener(this);
        btnwaru = findViewById(R.id.btnwaru);
        btnwaru.setOnClickListener(this);
        btnikoru = findViewById(R.id.btnikoru);
        btnikoru.setOnClickListener(this);
        btnc = findViewById(R.id.btnc);
        btnc.setOnClickListener(this);

        //文字を加えたり、くっつけたりする時に使用、削除もできる
        //イメージは文字を保管できる箱
        //onClickメソッドで使用できるようにする
        sb = new StringBuilder();
        sb2 = new StringBuilder();

        calctext = findViewById(R.id.calctext);
    }

    private  void btncolorback() {
        btnplus.setBackgroundColor(Color.rgb(68,68,68));
        btnmainasu.setBackgroundColor(Color.rgb(68,68,68));
        btnkakeru.setBackgroundColor(Color.rgb(68,68,68));
        btnwaru.setBackgroundColor(Color.rgb(68,68,68));
    }

    private void btncolor() {
        switch (operator) {
            case(0):
                btncolorback();
            case(1):
                btnplus.setBackgroundColor(Color.rgb(200,200,200));
                btnmainasu.setBackgroundColor(Color.rgb(68,68,68));
                btnkakeru.setBackgroundColor(Color.rgb(68,68,68));
                btnwaru.setBackgroundColor(Color.rgb(68,68,68));
                break;
            case(2):
                btnmainasu.setBackgroundColor(Color.rgb(200,200,200));
                btnplus.setBackgroundColor(Color.rgb(68,68,68));
                btnkakeru.setBackgroundColor(Color.rgb(68,68,68));
                btnwaru.setBackgroundColor(Color.rgb(68,68,68));
                break;
            case(3):
                btnkakeru.setBackgroundColor(Color.rgb(200,200,200));
                btnmainasu.setBackgroundColor(Color.rgb(68,68,68));
                btnplus.setBackgroundColor(Color.rgb(68,68,68));
                btnwaru.setBackgroundColor(Color.rgb(68,68,68));
                break;
            case(4):
                btnwaru.setBackgroundColor(Color.rgb(200,200,200));
                btnmainasu.setBackgroundColor(Color.rgb(68,68,68));
                btnkakeru.setBackgroundColor(Color.rgb(68,68,68));
                btnplus.setBackgroundColor(Color.rgb(68,68,68));
                break;

            default:
                break;
        }
    }

    public void all() {
        switch (operator) {
            case(0):
                calc2 = Integer.parseInt(text);
                sb2.append(text);
                sb.delete(0, sb.length());
                break;
            case (1):
                plus();
                break;
            case (2):
                mainasu();
                break;
            case (3):
                kakeru();
                break;
            case (4):
                waru();
                break;
        }
    }

    public void plus() {
        if(!text.equals("")) {
            //Int型に変換　Integer.parseInt(変換したいString型)
            calc1 = Integer.parseInt(text);
        }

        calc2 += calc1;
        calc1 = 0;

        sb2.append(text);
        sb.delete(0, sb.length());

        calctext.setText(String.valueOf(calc2));
    }

    public void mainasu() {
        if(!text.equals("")) {
            //Int型に変換　Integer.parseInt(変換したいString型)
            calc1 = Integer.parseInt(text);
        }

        calc2 -= calc1;
        calc1 = 0;

        sb2.append(text);
        sb.delete(0, sb.length());

        calctext.setText(String.valueOf(calc2));
    }

    public void kakeru() {
        if(!text.equals("")) {
            //Int型に変換　Integer.parseInt(変換したいString型)
            calc1 = Integer.parseInt(text);
        }

        calc2 *= calc1;
        calc1 = 0;

        sb2.append(text);
        sb.delete(0, sb.length());

        calctext.setText(String.valueOf(calc2));
    }

    public void waru() {
        if(!text.equals("")) {
            //Int型に変換　Integer.parseInt(変換したいString型)
            calc1 = Integer.parseInt(text);
        }

        try {
            calc2 /= calc1;
        } catch(Exception e) {
        }
        calc1 = 0;

        sb2.append(text);
        sb.delete(0, sb.length());

        calctext.setText(String.valueOf(calc2));
    }


    //View.OnClickListenerを継承するときオーバーライドするがあるもの
    //クリックした際の機能の設定
    @SuppressLint("DefaultLocale")
    @Override
    public void onClick(View view) {

        text = calctext.getText().toString();

        switch(view.getId()) {
            case(R.id.btn1):
                if(sb.length() < 10) {
                    //文字を加える
                    sb.append("1");
                    //文字を書き出す
                    calctext.setText(sb);
                }
                break;

            case(R.id.btn2):
                if(sb.length() < 10) {
                    sb.append("2");
                    calctext.setText(sb);
                }
                break;

            case(R.id.btn3):
                if(sb.length() < 10) {
                    sb.append("3");
                    calctext.setText(sb);
                }
                break;

            case(R.id.btn4):
                if(sb.length() < 10) {
                    sb.append("4");
                    calctext.setText(sb);
                }
                break;

            case(R.id.btn5):
                if(sb.length() < 10) {
                    sb.append("5");
                    calctext.setText(sb);
                }
                break;

            case(R.id.btn6):
                if(sb.length() < 10) {
                    sb.append("6");
                    calctext.setText(sb);
                }
                break;

            case(R.id.btn7):
                if(sb.length() < 10) {
                    sb.append("7");
                    calctext.setText(sb);
                }
                break;

            case(R.id.btn8):
                if(sb.length() < 10) {
                    sb.append("8");
                    calctext.setText(sb);
                }
                break;

            case(R.id.btn9):
                if(sb.length() < 10) {
                    sb.append("9");
                    calctext.setText(sb);
                }
                break;

            case(R.id.btn0):
                if(sb.length() == 0) {
                    break;
                } else if (sb.length() < 10) {
                sb.append("0");
                calctext.setText(sb);
                }
                break;

            case(R.id.btnplus):
                all();
                operator = 1;
                btncolor();
                break;

            case(R.id.btnmainasu):
                all();
                operator = 2;
                btncolor();
                break;

            case(R.id.btnkakeru):
                all();
                operator = 3;
                btncolor();
                break;

            case(R.id.btnwaru):
                all();
                operator = 4;
                btncolor();
                break;

            case(R.id.btnc):
                //削除する
                //delete(削除する文字列の始点, 削除する文字列の終点)
                sb.delete(0, sb.length());
                calc1 = 0;
                calc2 = 0;
                calctext.setText(String.valueOf(calc2));
                operator = 0;
                btncolorback();
                break;

            case(R.id.btnikoru):
                if(operator == 0) {
                    break;
                } else {
                    all();
                }
                btncolorback();
                calctext.setText(String.valueOf(calc2));
                operator = 0;
                break;
        }

    }
}