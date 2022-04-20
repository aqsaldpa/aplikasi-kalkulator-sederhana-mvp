package com.example.calculatormvp.MVP.Presenter;

import android.widget.Button;
import android.widget.TextView;

import com.example.calculatormvp.MVP.Model.CalculatorModel;

public class PresenterActivity {

    private static final String AC = "AC";
    private static final float ZERO = 0;

    private boolean FirstNumber = true;

    CalculatorModel calculator;

    TextView tvOutput;
    Button btnSamaDengan, btnTambah, btnKurang, btnBagi, btnKali;

    public PresenterActivity(TextView tvOutput, Button btnSamaDengan,
                             Button btnTambah, Button btnKurang, Button btnBagi,
                             Button btnKali) {
        this.btnSamaDengan = btnSamaDengan;
        this.btnTambah = btnTambah;
        this.btnKurang = btnKurang;
        this.btnBagi = btnBagi;
        this.btnKali = btnKali;
        this.tvOutput = tvOutput;
        calculator = new CalculatorModel();

        btnSamaDengan.setEnabled(false);
    }


    public void updateMethod(String method) {
        disableButtons();
        calculator.LanjutNomerSelesai();
        switch (method) {
            case "+":
                calculator.setMethod(CalculatorModel.Method.Pertambahan);
                btnTambah.setSelected(true);
                break;
            case "-":
                calculator.setMethod(CalculatorModel.Method.Pengurangan);
                btnKurang.setSelected(true);
                break;
            case "x":
                calculator.setMethod(CalculatorModel.Method.Perkalian);
                btnKali.setSelected(true);
                break;
            case "÷":
                calculator.setMethod(CalculatorModel.Method.Pembagian);
                btnBagi.setSelected(true);
                break;
        }

        tvOutput.setText("");
        FirstNumber = true;
        disableButtons();
    }

    public void showOutput() {
        calculator.LanjutNomerSelesai();
        calculator.hitung();
        String output = calculator.getHasil();
        tvOutput.setText(output);
        resetButtons();
    }

    private void resetButtons() {
        btnBagi.setEnabled(true);
        btnKali.setEnabled(true);
        btnKurang.setEnabled(true);
        btnTambah.setEnabled(true);

        btnBagi.setSelected(false);
        btnKali.setSelected(false);
        btnKurang.setSelected(false);
        btnTambah.setSelected(false);
    }

    private void disableButtons() {
        btnBagi.setEnabled(false);
        btnKali.setEnabled(false);
        btnKurang.setEnabled(false);
        btnTambah.setEnabled(false);
    }

    public void setText(String n) {
        if (n.equals(AC)) {
            tvOutput.setText("0");
            FirstNumber = true;
            calculator.resetHasil();
            resetButtons();
            return;
        }
        if (FirstNumber) {
            tvOutput.setText(n);
            FirstNumber = false;
        } else {
            tvOutput.append(n);
        }

        calculator.updatehasil(n);

        btnSamaDengan.setEnabled(true);
    }

}
