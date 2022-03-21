package com.example.btlandroidnhom6.thuc_hanh;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btlandroidnhom6.R;

public class Caculator extends AppCompatActivity {
    float c1,c2,c3;

    private  static  final String TAG=  Caculator.class.getSimpleName();
    private Button btnTamGiac,btnChuNhat;
    private EditText Canh1,Canh2,Canh3;
    private TextView txtChuVi,txtDientich;
    public void Anhxa(){
        btnTamGiac = findViewById(R.id.btntamgiac);
        btnChuNhat = findViewById(R.id.btnchunhat);
        Canh1=findViewById(R.id.Canh1);
        Canh2=findViewById(R.id.Canh2);
        Canh3=findViewById(R.id.Canh3);
        txtChuVi=findViewById(R.id.chuvi);
        txtDientich=findViewById(R.id.dienich);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caculator);
        Anhxa();


        btnTamGiac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=Canh1.getText()+"";
                String b=Canh2.getText()+"";
                String c=Canh3.getText()+"";
                try {
                    c1= Float.parseFloat(a);
                    c2= Float.parseFloat(b);
                    c3= Float.parseFloat(c);
                    if(c1+c2<c3||c1+c3<c2||c2+c3<c1){
                        Toast.makeText(Caculator.this,"tổng 2 cạnh của 1 tam giác" +
                                " >cạnh còn lại",Toast.LENGTH_SHORT)
                                .show();
                        return;
                    }

                    if(c1<=0||c2<=0||c3<=0) {
                        exception();
                        return;
                    }
                }catch (Exception e){
                    exception();
                    return;
                }

                float chuvi=c1+c2+c3;
                float p=chuvi/2;
                float dientich= (float) Math.sqrt(p*(p-c1)*(p-c2)*(p-c3));
                txtChuVi.setText(chuvi+"");
                txtDientich.setText(dientich+"");
            }
        });

        btnChuNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=Canh1.getText()+"";
                String b=Canh2.getText()+"";
                try {
                    c1= Float.parseFloat(a);
                    c2= Float.parseFloat(b);
                    if(c1<=0||c2<=0) {
                        exception();
                        return;
                    }
                }catch (Exception e){
                    exception();
                    return;
                }
                float chuvi=2*(c1+c2);
                float dientich= c1*c2;
                txtChuVi.setText(chuvi+"");
                txtDientich.setText(dientich+"");
            }
        });
    }
    public  void exception(){
        Toast.makeText(Caculator.this,"A và B là 1 số thực",Toast.LENGTH_SHORT).show();
    }


}