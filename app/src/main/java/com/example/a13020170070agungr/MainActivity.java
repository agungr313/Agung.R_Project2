package com.example.a13020170070agungr;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText ETDiagonal1, ETDiagonal2;
    private TextView hasil;
    private Button hitung, reset;
    Toast toast;
    double i,e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.header);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        ETDiagonal1 = (EditText)findViewById(R.id.editText);
        ETDiagonal2    = (EditText)findViewById(R.id.editText2);

        hitung  = (Button)findViewById(R.id.btnhitung);
        reset   = (Button)findViewById(R.id.btnreset);

        hasil      = (TextView)findViewById(R.id.txtluas);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String FormPanjang = ETDiagonal1 .getText().toString().trim();
                    String FormLebar = ETDiagonal2.getText().toString().trim();
                    if (FormPanjang != null && FormLebar != null){
                        int a = Integer.parseInt(ETDiagonal1.getText().toString());
                        int b = Integer.parseInt(ETDiagonal2.getText().toString());
                        i = 0.5*(a*b);
                        hasil.setText("Luas  :  "+i);
                        Context context = getApplication();
                        toast = Toast.makeText(context, "BERHASIL !", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }catch(Exception e) {
                    Log.e("Error", String.valueOf(e));
                    hasil.setText("");
                    toast = Toast.makeText(getApplication(), "DATA YANG DIINPUTKAN KOSONG !", Toast.LENGTH_SHORT);
                    toast.show();
                }


            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ETDiagonal1.setText("");
                ETDiagonal2.setText("");
                hasil.setText("");
                ETDiagonal1.setActivated(false);
                ETDiagonal2.setActivated(false);
                hasil.setActivated(false);
            }
        });












    }

}
