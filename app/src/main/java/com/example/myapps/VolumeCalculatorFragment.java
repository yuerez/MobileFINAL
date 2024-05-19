package com.example.myapps;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VolumeCalculatorFragment extends Fragment {

    private EditText etLength, etWidth, etHeight, etBase, etPyramidHeight, etRadius;
    private Button btnCalculateCuboid, btnCalculatePyramid, btnCalculateCylinder;
    private TextView tvResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_volume_calculator, container, false);

        etLength = view.findViewById(R.id.etLength);
        etWidth = view.findViewById(R.id.etWidth);
        etHeight = view.findViewById(R.id.etHeight);
        etBase = view.findViewById(R.id.etBase);
        etPyramidHeight = view.findViewById(R.id.etPyramidHeight);
        etRadius = view.findViewById(R.id.etRadius);
        btnCalculateCuboid = view.findViewById(R.id.btnCalculateCuboid);
        btnCalculatePyramid = view.findViewById(R.id.btnCalculatePyramid);
        btnCalculateCylinder = view.findViewById(R.id.btnCalculateCylinder);
        tvResult = view.findViewById(R.id.tvResult);

        btnCalculateCuboid.setOnClickListener(v -> calculateCuboidVolume());
        btnCalculatePyramid.setOnClickListener(v -> calculatePyramidVolume());
        btnCalculateCylinder.setOnClickListener(v -> calculateCylinderVolume());

        return view;
    }

    private void calculateCuboidVolume() {
        double length = Double.parseDouble(etLength.getText().toString());
        double width = Double.parseDouble(etWidth.getText().toString());
        double height = Double.parseDouble(etHeight.getText().toString());
        double volume = length * width * height;
        tvResult.setText("Cuboid Volume: " + volume);
    }

    private void calculatePyramidVolume() {
        double base = Double.parseDouble(etBase.getText().toString());
        double height = Double.parseDouble(etPyramidHeight.getText().toString());
        double volume = (1.0/3.0) * base * base * height;
        tvResult.setText("Pyramid Volume: " + volume);
    }

    private void calculateCylinderVolume() {
        double radius = Double.parseDouble(etRadius.getText().toString());
        double height = Double.parseDouble(etHeight.getText().toString());
        double volume = Math.PI * radius * radius * height;
        tvResult.setText("Cylinder Volume: " + volume);
    }
}
