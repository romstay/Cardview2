package com.example.lauchersplash;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;



public class countactivity extends AppCompatActivity {
    public int count = 0 ;
    public int countFibo = 0 ;
    public int maxFibo = 0;
    public TextView showCount;
    public TextView showCountFibo;
    public TextView showMaxFibo;
    public EditText maxNumber;
    public Button buttonToast;
    public Button buttonCount;
    public Button buttonMax;
    public Button buttonReset;
    public Toast toastA;
    public int[] warna;
    public LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countactivity);

        buttonToast=(Button)findViewById(R.id.buttonToast);
        buttonCount=(Button)findViewById(R.id.buttonCount);
        buttonReset=(Button)findViewById(R.id.buttonReset);
        buttonMax=(Button)findViewById(R.id.buttonMax);
        showCount=(TextView)findViewById(R.id.textCount);
        showCountFibo=(TextView)findViewById(R.id.textCountFibo);
        showMaxFibo=(TextView)findViewById(R.id.textMaxFibo);
        maxNumber=(EditText)findViewById(R.id.maxNumber);
        warna = getResources().getIntArray(R.array.warna_background_fibo);
        linear =(LinearLayout) findViewById(R.id.linear);

        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toastA != null) { toastA.cancel(); }
                toastA = Toast.makeText(getApplicationContext(), "Angka Fibonacci : " + countFibo, Toast.LENGTH_SHORT);
                toastA.show();
            }
        });

        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { calculate(view); }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { reset(view); }
        });

        buttonMax.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String getNumber = maxNumber.getText().toString();
                maxFibo = Integer.parseInt(getNumber);
                showMaxFibo.setText(getNumber);
                if(toastA != null) { toastA.cancel(); }
                toastA = Toast.makeText(getApplicationContext(), "Angka Maksimum fibonacci diubah menjadi " + getNumber, Toast.LENGTH_SHORT);
                toastA.show();
            };
        });

    }
    protected void calculate(View view){
        if(calculateFibo(count + 1) >= maxFibo){
            if(toastA != null) toastA.cancel();
            toastA = Toast.makeText(getApplicationContext(),"Sudah Mencapai Maksimum !!", Toast.LENGTH_SHORT);
            toastA.show();
        }else{
            count++;
            linear.setBackgroundColor(warna[count % 3]);
            countFibo = calculateFibo(count);
            showCount.setText("Tombol Hitung diklik sebanyak : " + Integer.toString(count));
            showCountFibo.setText(Integer.toString(countFibo));
            if(count % 5 == 0){
                if(toastA != null) toastA.cancel();
                toastA = Toast.makeText(getApplicationContext(),"Tombol hitung diklik : "+ count + " Kali", Toast.LENGTH_SHORT);
                toastA.show();
            }
        }
    }

    protected int calculateFibo(int n){
        if(n <= 1) {
            linear.setBackgroundColor(warna[2]);
            return n;
        }
        int prev,current,next;
        prev = 0;
        current = 1;
        for (int i = 2; i <= n; i++) {
            next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }

    protected void reset(View view){
        count = 0;
        countFibo = 0;
        showCount.setText("Tombol Hitung diklik sebanyak : " + Integer.toString(count));
        showCountFibo.setText(Integer.toString(countFibo));
        linear.setBackgroundColor(Color.WHITE);
    }
}