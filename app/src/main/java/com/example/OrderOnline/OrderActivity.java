package com.example.OrderOnline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderActivity extends AppCompatActivity {
    private EditText autoCompleteTextView;

    private int rs = 101;
    private double ct = 0.0;
    private Button btnAdd;
    private Button btnOrder;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        listView = findViewById(R.id.list_view);
        CustomAdapter customAdapter = new CustomAdapter(this, getFoodItem());
        listView.setAdapter(customAdapter);
         HashMap<String, Double> m = new HashMap<>();
        m.put("Item1", 150.00);
        m.put("Item2", 150.00);
        m.put("Item3", 135.00);
        m.put("Item4", 140.00);
        m.put("Item5", 130.00);
        m.put("Item6",85.00);
        m.put("Item7",90.00);
        m.put("Item8",75.00);

         HashMap<String, Integer>[] m1 = new HashMap[]{new HashMap<>()};
        m1[0].put("Item1", 0);
        m1[0].put("Item2", 0);
        m1[0].put("Item3", 0);
        m1[0].put("Item4", 0);
        m1[0].put("Item5", 0);
        m1[0].put("Item6", 0);
        m1[0].put("Item7", 0);
        m1[0].put("Item8", 0);


        autoCompleteTextView = findViewById(R.id.auto_complete);

        btnAdd = findViewById(R.id.ad_to);
        btnOrder = findViewById(R.id.order_now);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = autoCompleteTextView.getText().toString();
                if (s != null) {
                    if (m.containsKey(s) == true) {
                        ct = ct + m.get(s);
                        m1[0].put(s, m1[0].get(s)+1);
                    } else {
                        Toast.makeText(OrderActivity.this, "Item not available", Toast.LENGTH_SHORT).show();
                    }
                }
                autoCompleteTextView.setText("");
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(OrderActivity.this,Payment.class);
                intent2.putExtra("hp", m1[0]);
                intent2.putExtra("cost",ct);
                startActivity(intent2);
                onRestart();
                Intent ine = getIntent();
                m1[0] = (HashMap<String, Integer>) ine.getSerializableExtra("hmp");

            }
        });


    }


    private ArrayList<FoodItems> getFoodItem() {
        FoodItems foodItems1 = new FoodItems();
        foodItems1.setItemName("Item1");
        foodItems1.setItemCost(150.00);
        FoodItems foodItems2 = new FoodItems();
        foodItems2.setItemName("Item2");
        foodItems2.setItemCost(150.00);
        FoodItems foodItems3 = new FoodItems();
        foodItems3.setItemName("Item3");
        foodItems3.setItemCost(135.00);
        FoodItems foodItems4 = new FoodItems();
        foodItems4.setItemName("Item4");
        foodItems4.setItemCost(140.00);
        FoodItems foodItems5 = new FoodItems();
        foodItems5.setItemName("Item5");
        foodItems5.setItemCost(130.00);
        FoodItems foodItems6 = new FoodItems();
        FoodItems foodItems7 = new FoodItems();
        FoodItems foodItems8 = new FoodItems();
        foodItems6.setItemName("Item6");foodItems6.setItemCost(85.00);
        foodItems7.setItemName("Item7");foodItems7.setItemCost(90.00);
        foodItems8.setItemName("Item8");foodItems8.setItemCost(75.00);



        ArrayList<FoodItems> versionArrayList = new ArrayList<FoodItems>();
        versionArrayList.add(foodItems1);
        versionArrayList.add(foodItems2);
        versionArrayList.add(foodItems3);
        versionArrayList.add(foodItems4);
        versionArrayList.add(foodItems5);
        versionArrayList.add(foodItems6);
        versionArrayList.add(foodItems7);
        versionArrayList.add(foodItems8);
        return versionArrayList;
    }

}