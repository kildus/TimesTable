package com.demo.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewNumbers;
    private SeekBar seekBar;
    private ArrayList<Integer> numbers;

    private int min = 1;
    private int max = 20;
    private int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewNumbers = findViewById(R.id.listViewNumbers);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMin(min);
        seekBar.setMax(max);

        numbers = new ArrayList<>();
        final ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, numbers);

        listViewNumbers.setAdapter(arrayAdapter);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numbers.clear();
                for (int i = min; i <= count; i++){
                    numbers.add(progress * i);
                }
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar.setProgress(10);
    }
}
