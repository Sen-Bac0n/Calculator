package com.example.calculator;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class danwei extends AppCompatActivity {
    String sp1 = "";
    String sp2 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danwei);
        Spinner spinner1 = (Spinner) findViewById(R.id.sp1);
        Spinner spinner2 = (Spinner) findViewById(R.id.sp2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.itemsMeter, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] changdu = getResources().getStringArray(R.array.itemsMeter);
                sp1=changdu[i]+"";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] changdu = getResources().getStringArray(R.array.itemsMeter);
                sp2=changdu[i]+"";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        final TextView textView = findViewById(R.id.textView);
        final TextView textans = findViewById(R.id.textViewAns);
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        for(
                int i = 4; i<gridLayout.getChildCount();i++) {
            final Button button = findViewById(gridLayout.getChildAt(i).getId());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text = textView.getText().toString();
                    String ans = "";
                    switch (button.getId()) {
                        case R.id.ac:
                            text = "";
                            ans = "";
                            sp1 = sp2 = "";
                            textView.setText(text);
                            textans.setText(ans);
                            break;
                        case R.id.ok:
                            if(sp1=="微米"){
                                switch (sp2){
                                    case "微米":
                                        textans.setText(text);
                                        break;
                                    case "毫米":
                                        ans=""+Double.parseDouble(text)*0.001;
                                        textans.setText(ans);
                                        break;
                                    case "厘米":
                                        ans=""+Double.parseDouble(text)*0.0001;
                                        textans.setText(ans);
                                        break;
                                    case "米":
                                        ans=""+Double.parseDouble(text)*0.000001;
                                        textans.setText(ans);
                                        break;
                                }
                            }else if(sp1=="毫米"){
                                switch (sp2){
                                    case "微米":
                                        ans=""+Double.parseDouble(text)*1000;
                                        textans.setText(ans);
                                        break;
                                    case "毫米":
                                        textans.setText(text);
                                        break;
                                    case "厘米":
                                        ans=""+Double.parseDouble(text)*0.1;
                                        textans.setText(ans);
                                        break;
                                    case "米":
                                        ans=""+Double.parseDouble(text)*0.001;
                                        textans.setText(ans);
                                        break;
                                }
                            }else if(sp1=="厘米") {
                                switch (sp2) {
                                    case "微米":
                                        ans = "" + Double.parseDouble(text) * 10000;
                                        textans.setText(ans);
                                        break;
                                    case "毫米":
                                        ans = "" + Double.parseDouble(text) * 10;
                                        textans.setText(ans);
                                        break;
                                    case "厘米":
                                        textans.setText(text);
                                        break;
                                    case "米":
                                        ans = "" + Double.parseDouble(text) * 0.01;
                                        textans.setText(ans);
                                        break;
                                }
                            }else{
                                switch (sp2) {
                                    case "微米":
                                        ans = "" + Double.parseDouble(text) * 1000000;
                                        textans.setText(ans);
                                        break;
                                    case "毫米":
                                        ans = "" + Double.parseDouble(text) * 1000;
                                        textans.setText(ans);
                                        break;
                                    case "厘米":
                                        ans = "" + Double.parseDouble(text) * 100;
                                        textans.setText(ans);
                                        break;
                                    case "米":
                                        textans.setText(text);
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

            case R.id.backmain:
                intent =
                        new Intent(danwei.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.another:
                intent =
                        new Intent(danwei.this, AnotherActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}