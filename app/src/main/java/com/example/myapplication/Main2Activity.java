package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private TextView T1;
    private TextView T2;
    private TextView T3;
    private TextView T4;
    private TextView T5;
    private EditText editText;
    String N1,N2,N3,N4,N5 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        N1 = "0";
        N2 = "0";
        N3 = "0";
        N4 = "0";
        N5 = "0";
        T1 = (TextView)findViewById(R.id.T1);
        T2 = (TextView)findViewById(R.id.T2);
        T3 = (TextView)findViewById(R.id.T3);
        T4 = (TextView)findViewById(R.id.T4);
        T5 = (TextView)findViewById(R.id.T5);
        editText = findViewById(R.id.editText);

        Intent intent=getIntent();
        final int month = intent.getIntExtra("Month",0);

        switch (month){
            case 1:
                N1 = getString(R.string.M1_1);
                N2 = getString(R.string.M1_2);
                N3 = getString(R.string.M1_3);
                N4 = getString(R.string.M1_4);
                N5 = getString(R.string.M1_5);
                break;
            case 2:
                N1 = getString(R.string.M2_1);
                N2 = getString(R.string.M2_2);
                N3 = getString(R.string.M2_3);
                N4 = getString(R.string.M2_4);
                N5 = getString(R.string.M2_5);
                break;
            case 3:
                N1 = getString(R.string.M3_1);
                N2 = getString(R.string.M3_2);
                N3 = getString(R.string.M3_3);
                N4 = getString(R.string.M3_4);
                N5 = getString(R.string.M3_5);
                break;
            case 4:
                N1 = getString(R.string.M4_1);
                N2 = getString(R.string.M4_2);
                N3 = getString(R.string.M4_3);
                N4 = getString(R.string.M4_4);
                N5 = getString(R.string.M4_5);
                break;
            case 5:
                N1 = getString(R.string.M5_1);
                N2 = getString(R.string.M5_2);
                N3 = getString(R.string.M5_3);
                N4 = getString(R.string.M5_4);
                N5 = getString(R.string.M5_5);
                break;
            case 6:
                N1 = getString(R.string.M6_1);
                N2 = getString(R.string.M6_2);
                N3 = getString(R.string.M6_3);
                N4 = getString(R.string.M6_4);
                N5 = getString(R.string.M6_5);
                break;
        }

        T1.setText(N1);
        T2.setText(N2);
        T3.setText(N3);
        T4.setText(N4);
        T5.setText(N5);

        final Button button = (Button) findViewById(R.id.Back_button_B);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        final Button button1 = (Button) findViewById(R.id.Ans_button_B);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(editText.getText().toString().matches(""))
                {
                    Toast toast = Toast.makeText(Main2Activity.this, "欄位不能是空白!!", Toast.LENGTH_LONG);
                    toast.show();
                }
                else if(editText.getText().toString().length()<8||editText.getText().toString().length()>8){
                    Toast toast = Toast.makeText(Main2Activity.this, "發票號碼一共8碼", Toast.LENGTH_LONG);
                    toast.show();
                }
                else{
                    String enter =editText.getText().toString();
                    Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                    intent.putExtra("Month",month);
                    intent.putExtra("N1",N1);
                    intent.putExtra("N2",N2);
                    intent.putExtra("N3",N3);
                    intent.putExtra("N4",N4);
                    intent.putExtra("N5",N5);
                    intent.putExtra("enter",enter);
                    startActivity(intent);
                }

            }
        });

    }
}