package com.example.calculatormvp.MVP.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculatormvp.MVP.Presenter.PresenterActivity;
import com.example.calculatormvp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvOutput;
    private Button btnAc, btnBagi,
            btn7, btn8, btn9, btnKali,
            btn4, btn5, btn6, btnKurang,
            btn1, btn2, btn3, btnTambah,
            btn0, btnPeriod, btnSamaDengan;

    private PresenterActivity presenterActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();

        presenterActivity = new PresenterActivity(tvOutput, btnSamaDengan,
                btnTambah, btnKurang, btnBagi, btnKali);


    }

    private void initializeComponents() {
        tvOutput = findViewById(R.id.tv_output);

        btnAc = findViewById(R.id.btn_ac);
        btnBagi = findViewById(R.id.btnbagi);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnKali = findViewById(R.id.btnPerkalian);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btnKurang = findViewById(R.id.btnPengurangan);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btnTambah = findViewById(R.id.btnPertambahan);
        btn0 = findViewById(R.id.btn0);
        btnPeriod = findViewById(R.id.btntitik);
        btnSamaDengan = findViewById(R.id.btnSamaDengan);


        btnAc.setOnClickListener(this);
        btnBagi.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnKali.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btnKurang.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btnTambah.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnPeriod.setOnClickListener(this);
        btnSamaDengan.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ac:
                presenterActivity.setText(btnAc.getText().toString());
                break;
            case R.id.btnbagi:
                presenterActivity.updateMethod(btnBagi.getText().toString());
                break;
            case R.id.btn7:
                presenterActivity.setText(btn7.getText().toString());
                break;
            case R.id.btn8:
                presenterActivity.setText(btn8.getText().toString());
                break;
            case R.id.btn9:
                presenterActivity.setText(btn9.getText().toString());
                break;
            case R.id.btnPerkalian:
                presenterActivity.updateMethod(btnKali.getText().toString());
                break;
            case R.id.btn4:
                presenterActivity.setText(btn4.getText().toString());
                break;
            case R.id.btn5:
                presenterActivity.setText(btn5.getText().toString());
                break;
            case R.id.btn6:
                presenterActivity.setText(btn6.getText().toString());
                break;
            case R.id.btnPengurangan:
                presenterActivity.updateMethod(btnKurang.getText().toString());
                break;
            case R.id.btn1:
                presenterActivity.setText(btn1.getText().toString());
                break;
            case R.id.btn2:
                presenterActivity.setText(btn2.getText().toString());
                break;
            case R.id.btn3:
                presenterActivity.setText(btn3.getText().toString());
                break;
            case R.id.btnPertambahan:
                presenterActivity.updateMethod(btnTambah.getText().toString());
                break;
            case R.id.btn0:
                presenterActivity.setText(btn0.getText().toString());
                break;
            case R.id.btntitik:
                presenterActivity.setText(btnPeriod.getText().toString());
                break;
            case R.id.btnSamaDengan:
                presenterActivity.showOutput();
                break;

        }
    }
}
