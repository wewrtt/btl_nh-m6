package com.example.btlandroidnhom6.thuc_hanh;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btlandroidnhom6.R;

public class Caculator extends AppCompatActivity {
    float a,b;

    private  static  final String TAG=  Caculator.class.getSimpleName();
    private Button btnAdd,btnSub,btnMul,btnDivision;
    private EditText soA,soB;
    private TextView txtRes;
    public void Anhxa(){
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDivision = findViewById(R.id.btnDivision);
        soA=findViewById(R.id.edtA);
        soB=findViewById(R.id.edtB);
        txtRes=findViewById(R.id.txtRes);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caculator);
        Anhxa();


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1=soA.getText()+"";
                String number2=soB.getText()+"";
                try {
                    a= Float.parseFloat(number1);
                    b= Float.parseFloat(number2);
                }catch (Exception e){
                    exception();
                }

                float add= a+b;
                txtRes.setText(add+"");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String number1=soA.getText()+"";
                    String number2=soB.getText()+"";
                    a= Float.parseFloat(number1);
                    b= Float.parseFloat(number2);
                }catch (Exception e){
                    exception();
                }
                float add= a-b;
                txtRes.setText(add+"");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String number1=soA.getText()+"";
                    String number2=soB.getText()+"";
                    a= Float.parseFloat(number1);
                    b= Float.parseFloat(number2);
                }catch (Exception e){
                    exception();
                }
                float add= a*b;
                txtRes.setText(add+"");
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String number1=soA.getText()+"";
                    String number2=soB.getText()+"";
                    a= Float.parseFloat(number1);
                    b= Float.parseFloat(number2);
                }catch (Exception e){
                    exception();
                }
                float add= a/b;
                txtRes.setText(add+"");
            }
        });
    }
    public  void exception(){
        Toast.makeText(Caculator.this,"A và B là 1 số thực",Toast.LENGTH_SHORT).show();
    }


}