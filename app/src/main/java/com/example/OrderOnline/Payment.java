package com.example.OrderOnline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class Payment extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Intent intent = getIntent();
        double tc = intent.getDoubleExtra("cost",0.0);
        String tcs = String.valueOf(tc);
        HashMap<String,Integer> m = (HashMap<String,Integer>)intent.getSerializableExtra("hp");
        textView1 = findViewById(R.id.bill);
        textView2 = findViewById(R.id.gt);
        pay = findViewById(R.id.pm);
        textView1.append("Item Name     Quantity\n"+"\n");
         for (Map.Entry<String,Integer> entry: m.entrySet())
         {
             if(entry.getValue()>0)
             { String it = entry.getKey();
             String fr = entry.getValue().toString();
             textView1.append(it + "                 "+ fr+"\n" );
             entry.setValue(0);
             }

         }
         textView2.append("  "+ tcs);
         pay.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText( Payment.this,"Your payment has been successful,Items will be delivered shortly ",Toast.LENGTH_SHORT).show();
                 Intent in = new Intent(Payment.this,OrderActivity.class);
                 in.putExtra("hmp",m);
                 startActivity(in);
             }
         });
    }
}