package com.example.tsm_app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

public class FilterSpinner extends androidx.appcompat.widget.AppCompatSpinner{
    public FilterSpinner(Context context) {
        super(context);
        init();
    }

    public FilterSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        String[] defaultOptions = {"Pret", "Nume"};
        setOptions(defaultOptions);
    }

    public void setOptions(String[] options) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        setAdapter(adapter);
    }
}
