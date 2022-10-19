package com.example.kalkulatorbidangdatar;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class KetigaFragment extends Fragment {
    private Button btnHasil;
    private EditText txt_jari2;
    private TextView hasilLuas,hasilKeliling;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ketiga, container, false);

        btnHasil = v.findViewById(R.id.btnHasil);
        txt_jari2 = v.findViewById(R.id.txt_jari2);
        hasilLuas = v.findViewById(R.id.hasilLuas);
        hasilKeliling = v.findViewById(R.id.hasilKeliling);

        btnHasil.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                String nilai = txt_jari2.getText().toString();
                if(nilai.isEmpty()) {
                    txt_jari2.setError("Data Tidak Boleh Kosong");
                    txt_jari2.requestFocus();
                }else {
                    Double jari = Double.parseDouble(nilai);

                    Double luas = 3.14 * (jari * jari);
                    hasilLuas.setText(String.format("%.2f",luas));

                    Double keliling = 2 * (3.14) * jari;
                    hasilKeliling.setText(String.format("%.2f",keliling));
                }
            }
        });
        return v;
    }
}