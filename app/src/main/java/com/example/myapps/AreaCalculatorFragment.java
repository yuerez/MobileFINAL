package com.example.myapps;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AreaCalculatorFragment extends Fragment {

    private EditText etLength, etWidth, etBase, etHeight, etRadius;
    private Button btnCalculateRectangle, btnCalculateTriangle, btnCalculateCircle;
    private TextView tvResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_area_calculator, container, false);

        etLength = view.findViewById(R.id.etLength);
        etWidth = view.findViewById(R.id.etWidth);
        etBase = view.findViewById(R.id.etBase);
        etHeight = view.findViewById(R.id.etHeight);
        etRadius = view.findViewById(R.id.etRadius);
        btnCalculateRectangle = view.findViewById(R.id.btnCalculateRectangle);
        btnCalculateTriangle = view.findViewById(R.id.btnCalculateTriangle);
        btnCalculateCircle = view.findViewById(R.id.btnCalculateCircle);
        tvResult = view.findViewById(R.id.tvResult);

        btnCalculateRectangle.setOnClickListener(v -> calculateRectangleArea());
        btnCalculateTriangle.setOnClickListener(v -> calculateTriangleArea());
        btnCalculateCircle.setOnClickListener(v -> calculateCircleArea());

        return view;
    }

    private void calculateRectangleArea() {
        double length = Double.parseDouble(etLength.getText().toString());
        double width = Double.parseDouble(etWidth.getText().toString());
        double area = length * width;
        tvResult.setText("Rectangle Area: " + area);
    }

    private void calculateTriangleArea() {
        double base = Double.parseDouble(etBase.getText().toString());
        double height = Double.parseDouble(etHeight.getText().toString());
        double area = 0.5 * base * height;
        tvResult.setText("Triangle Area: " + area);
    }

    private void calculateCircleArea() {
        double radius = Double.parseDouble(etRadius.getText().toString());
        double area = Math.PI * radius * radius;
        tvResult.setText("Circle Area: " + area);
    }
}
