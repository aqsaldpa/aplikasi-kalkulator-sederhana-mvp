package com.example.calculatormvp.MVP.Model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class CalculatorModel {
    private float output = 0;
    private boolean hasAnswer = false;

    List<Object> Hasil;
    String number = "0";

    //identifikasi method yg akan digunakan
    public enum Method {
        Pertambahan, Pengurangan, Pembagian, Perkalian, kosong
    }

    //inisiasi model
    public CalculatorModel() {
        Hasil = new ArrayList<>();
    }

    //set method dimana ia akan dibutuhkan
    public void setMethod(Method method) {
        if (Hasil.size() >= 3) {
            hitung();
        }
        Hasil.add(method);
    }

    //Perhitungan angka
    public void hitung() {
        if (Hasil.size() >= 3) {
            float n1 = 0, n2 = 0, jwb = 0;

            if (Hasil.get(0) instanceof String) {
                n1 = Float.parseFloat((String) Hasil.get(0));
            }
            if (Hasil.get(2) instanceof String) {
                n2 = Float.parseFloat((String) Hasil.get(2));
            }
            if (Hasil.get(1) instanceof Method) {
                Method Methodini = (Method) Hasil.get(1);
                switch (Methodini) {
                    case Pertambahan:
                        jwb = n1 + n2;
                        break;
                    case Pembagian:
                        jwb = n1 / n2;
                        break;
                    case Pengurangan:
                        jwb = n1 - n2;
                        break;
                    case Perkalian:
                        jwb = n1 * n2;
                        break;
                    case kosong:
                        jwb = 0;
                    default:
                        break;
                }
            }
            output = jwb;
            Hasil.clear();
            Hasil.add(String.valueOf(jwb));
        }
    }

    //Mengkontrol lanjutan sama dengan
    public void LanjutNomerSelesai() {
        if (Hasil.size() == 1) return;

        Hasil.add(number);
        number = "0";
    }

    //Mengupdate nilai angka
    public void updatehasil(String n) {
        number += n;
    }

    //Mengembalikan hasil ke bentuk string
    public String getHasil() {
        return NumberFormat.getInstance().format(output);
    }

    //mereset hasil
    public void resetHasil() {
        Hasil.clear();
    }
}
