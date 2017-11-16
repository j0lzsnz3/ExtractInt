package com.test.extractint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("---- Choose Menu ----");
        spinnerArray.add("Pizza 120000");
        spinnerArray.add("Burger 51000");

        txtResult = findViewById(R.id.tview_result);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner sItems = findViewById(R.id.spinner);
        sItems.setAdapter(adapter);

        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 1){
                    String selectedItem = sItems.getSelectedItem().toString();
                    Scanner in = new Scanner(selectedItem).useDelimiter("[^0-9]+");
                    int integer = in.nextInt();

                    txtResult.setText(Integer.toString(integer));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
