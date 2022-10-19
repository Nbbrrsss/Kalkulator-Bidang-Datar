package com.example.kalkulatorbidangdatar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KeduaFragment extends Fragment {
    private EditText txt_alas,txt_tinggi;
    private Button btnHasil;
    private TextView hasilLuas,hasilKeliling;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_kedua, container, false);

        txt_alas= v.findViewById(R.id.txt_alas);
        txt_tinggi= v.findViewById(R.id.txt_tinggi);
        btnHasil= v.findViewById(R.id.btnHasil);
        hasilLuas= v.findViewById(R.id.hasilLuas);
        hasilKeliling= v.findViewById(R.id.hasilKeliling);

        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nilai1 = txt_alas.getText().toString();
                String nilai2 = txt_tinggi.getText().toString();

                if(nilai1.isEmpty()){
                    txt_alas.setError("Data Tidak Boleh Kosong");
                    txt_tinggi.requestFocus();
                }else if(nilai2.isEmpty()){
                    txt_alas.setError("Data Tidak Boleh Kosong");
                    txt_tinggi.requestFocus();
                }else {
                    double alas = Double.parseDouble(nilai1);
                    double tinggi = Double.parseDouble(nilai2);

                    double luas = 0.5 * alas * tinggi;
                    hasilLuas.setText(String.format("%.2f",luas));

                    double keliling = alas + 2 * tinggi;
                    hasilKeliling.setText(String.format("%.2f",keliling));
                }
            }
        });

        return v;
    }
}