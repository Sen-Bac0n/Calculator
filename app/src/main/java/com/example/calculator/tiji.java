package com.example.calculator;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class tiji extends AppCompatActivity {
    String sp11 = "";
    String sp22 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiji);
        Spinner spinner11 = (Spinner) findViewById(R.id.sp11);
        Spinner spinner22 = (Spinner) findViewById(R.id.sp22);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.itemstiji, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner11.setAdapter(adapter);
        spinner22.setAdapter(adapter);
        spinner11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] changdu = getResources().getStringArray(R.array.itemstiji);
                sp11 = changdu[i] + "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner22.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] changdu = getResources().getStringArray(R.array.itemstiji);
                sp22 = changdu[i] + "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        final TextView textView = findViewById(R.id.textView);
        final TextView textans = findViewById(R.id.textViewAns);
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        for (
                int i = 4; i < gridLayout.getChildCount(); i++) {
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
                            sp11 = sp22 = "";
                            textView.setText(text);
                            textans.setText(ans);
                            break;
                        case R.id.okk:

                            if (sp11.equals("升")) {
                                switch (sp22) {
                                    case "升":
                                        textans.setText(text);
                                        break;
                                    case "毫升":
                                        ans = "" + Double.parseDouble(text) * 1000;
                                        textans.setText(ans);
                                        break;
                                    case "立方厘米":
                                        ans = "" + Double.parseDouble(text) * 1000;
                                        textans.setText(ans);
                                        break;
                                    case "立方米":
                                        ans = "" + Double.parseDouble(text) * 1;
                                        textans.setText(ans);
                                        break;
                                }
                            }else if(sp11=="毫升"){
                                switch (sp22) {
                                    case "升":
                                        ans = "" + Double.parseDouble(text) * 0.001;
                                        textans.setText(ans);
                                        break;
                                    case "毫升":
                                        textans.setText(text);
                                        break;
                                    case "立方厘米":
                                        ans = "" + Double.parseDouble(text) * 1;
                                        textans.setText(ans);
                                        break;
                                    case "立方米":
                                        ans = "" + Double.parseDouble(text) * 0.001;
                                        textans.setText(ans);
                                        break;
                                }
                            }else if(sp11=="立方厘米"){
                                switch (sp22) {
                                    case "升":
                                        ans = "" + Double.parseDouble(text) * 0.001;
                                        textans.setText(ans);
                                        break;
                                    case "毫升":
                                        textans.setText(text);
                                        break;
                                    case "立方厘米":
                                        ans = "" + Double.parseDouble(text) * 1;
                                        textans.setText(ans);
                                        break;
                                    case "立方米":
                                        ans = "" + Double.parseDouble(text) * 0.001;
                                        textans.setText(ans);
                                        break;
                                }
                            }else if(sp11=="立方米"){
                                switch (sp22) {
                                    case "升":
                                        ans = "" + Double.parseDouble(text) ;
                                        textans.setText(ans);
                                        break;
                                    case "毫升":
                                        ans = "" + Double.parseDouble(text)*1000 ;
                                        textans.setText(ans);
                                        break;
                                    case "立方厘米":
                                        ans = "" + Double.parseDouble(text) * 1000;
                                        textans.setText(ans);
                                        break;
                                    case "立方米":
                                        ans = "" + Double.parseDouble(text) ;
                                        textans.setText(ans);
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
        getMenuInflater().inflate(R.menu.tiji, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {

            case R.id.backmain:
                intent =
                        new Intent(tiji.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.another:
                intent =
                        new Intent(tiji.this, AnotherActivity.class);
                startActivity(intent);
                break;
            case R.id.danwei:
                intent =
                        new Intent(tiji.this, danwei.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}