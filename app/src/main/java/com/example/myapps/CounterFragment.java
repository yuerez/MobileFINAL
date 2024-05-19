package com.example.myapps;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CounterFragment extends Fragment {

    private TextView tvCounter;
    private Button btnIncrement, btnDecrement, btnReset;
    private int counter;
    private SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter, container, false);

        tvCounter = view.findViewById(R.id.tvCounter);
        btnIncrement = view.findViewById(R.id.btnIncrement);
        btnDecrement = view.findViewById(R.id.btnDecrement);
        btnReset = view.findViewById(R.id.btnReset);

        sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        counter = sharedPreferences.getInt("counter", 0);
        tvCounter.setText(String.valueOf(counter));

        btnIncrement.setOnClickListener(v -> updateCounter(1));
        btnDecrement.setOnClickListener(v -> updateCounter(-1));
        btnReset.setOnClickListener(v -> resetCounter());

        return view;
    }

    private void updateCounter(int value) {
        counter += value;
        tvCounter.setText(String.valueOf(counter));
        saveCounter();
    }

    private void resetCounter() {
        counter = 0;
        tvCounter.setText(String.valueOf(counter));
        saveCounter();
    }

    private void saveCounter() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("counter", counter);
        editor.apply();
    }
}
