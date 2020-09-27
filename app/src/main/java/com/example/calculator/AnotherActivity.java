package com.example.calculator;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AnotherActivity extends AppCompatActivity {
    String sp1 = "";
    String sp2 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        Spinner spinner1 = (Spinner) findViewById(R.id.sp1);
        Spinner spinner2 = (Spinner) findViewById(R.id.sp2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] jinzhi = getResources().getStringArray(R.array.items);
                sp1=jinzhi[i]+"";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] jinzhi = getResources().getStringArray(R.array.items);
                sp2=jinzhi[i]+"";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


            final TextView textView = findViewById(R.id.textView);
            final TextView textans = findViewById(R.id.textViewAns);
            GridLayout gridLayout = findViewById(R.id.gridLayout);
        for(
            int i = 4; i<gridLayout.getChildCount();i++)

            {
                final Button button = findViewById(gridLayout.getChildAt(i).getId());
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String text = textView.getText().toString();
                        String ans ="";
                        switch (button.getId()) {
                            case R.id.ac:
                                text = "";
                                ans = "";
                                sp1=sp2="";
                                textView.setText(text);
                                textans.setText(ans);
                                break;
                            case R.id.ok:
                               if(sp1=="二进制"){
                                   switch (sp2){
                                       case "二进制":
                                           textans.setText(textView.getText().toString());
                                           break;
                                       case "八进制":
                                           ans=Integer.toOctalString(Integer.parseInt(text,2))+"";
                                           textans.setText(ans);
                                           break;
                                       case "十进制":
                                           ans=Integer.parseInt(text,2)+"";
                                           textans.setText(ans);
                                           break;
                                       case "十六进制":
                                           ans=Integer.hashCode(Integer.parseInt(text,2))+"";
                                           break;
                                   }
                               }else if(sp1=="八进制"){
                                   switch (sp2){
                                       case "二进制":
                                           ans=Integer.toBinaryString(Integer.parseInt(text,8));
                                           textans.setText(ans);
                                           break;
                                       case "八进制":
                                           textans.setText(textView.getText().toString());
                                           break;
                                       case "十进制":
                                           ans=Integer.parseInt(text,8)+"";
                                           textans.setText(ans);
                                           break;
                                       case "十六进制":
                                           ans=Integer.hashCode(Integer.parseInt(text,8))+"";
                                           break;
                                   }
                               }else if(sp1=="十进制"){
                                   switch (sp2){
                                       case "二进制":
                                           ans=Integer.toBinaryString(Integer.parseInt(text,10));
                                           textans.setText(ans);
                                           break;
                                       case "八进制":
                                           ans=Integer.toOctalString(Integer.parseInt(text,10));
                                           textans.setText(ans);
                                           break;
                                       case "十进制":
                                           textans.setText(textView.getText().toString());
                                           break;
                                       case "十六进制":
                                           ans=Integer.hashCode(Integer.parseInt(text,10))+"";
                                           break;
                                   }

                               }else{
                                   switch (sp2){
                                       case "二进制":
                                           ans=Integer.toBinaryString(Integer.parseInt(text,16));
                                           textans.setText(ans);
                                           break;
                                       case "八进制":
                                           ans=Integer.toOctalString(Integer.parseInt(text,16));
                                           textans.setText(ans);
                                           break;
                                       case "十进制":
                                           ans=Integer.parseInt(text,16)+"";
                                           textans.setText(ans);
                                           break;
                                       case "十六进制":
                                           textans.setText(textView.getText().toString());
                                           break;
                                   }
                               }

                                break;
                            default:
                                text += button.getText();
                                textView.setText(text);
                        }
                    }
                });

            }
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.another, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {

            case R.id.danwei:
                 intent =
                        new Intent(AnotherActivity.this, danwei.class);
                startActivity(intent);
                break;
            case R.id.backmain:
                 intent =
                        new Intent(AnotherActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.tiji:


                intent =
                        new Intent(AnotherActivity.this,tiji.class);
                startActivity(intent);
                break;
        }
        return true;
    }
    }