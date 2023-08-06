package com.example.tsm_app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

public class CustomSpinner extends androidx.appcompat.widget.AppCompatSpinner {

    public CustomSpinner(Context context) {
        super(context);
        init();
    }

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        // Set default options ("VIP" and "Standard")
        String[] defaultOptions = {"VIP", "Standard"};
        setOptions(defaultOptions);
    }

    public void setOptions(String[] options) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        setAdapter(adapter);
    }
}