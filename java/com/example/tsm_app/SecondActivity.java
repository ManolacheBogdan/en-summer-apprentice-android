package com.example.tsm_app;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        View cardLayout1 = findViewById(R.id.Untold);
        TextView orderTextView1 = cardLayout1.findViewById(R.id.commandNr);
        TextView titleTextView1 = cardLayout1.findViewById(R.id.eventName);
        TextView detailsTextView1 = cardLayout1.findViewById(R.id.commandDetails);
        TextView dataTextView1 = cardLayout1.findViewById(R.id.orderedAt);
        TextView numberTextView1 = cardLayout1.findViewById(R.id.ticketNr);
        TextView priceTextView1 = cardLayout1.findViewById(R.id.totalPrice);
        orderTextView1.setText("Comanda nr. 1");
        titleTextView1.setText("Untold");
        detailsTextView1.setText("Detalii comanda:");
        dataTextView1.setText("Data comenzii: 07/04/2023");
        numberTextView1.setText("Numar bilete:");
        priceTextView1.setText("Pret total: 8400 RON");

        View cardLayout2 = findViewById(R.id.electric);
        TextView orderTextView2 = cardLayout2.findViewById(R.id.commandNr);
        TextView titleTextView2 = cardLayout2.findViewById(R.id.eventName);
        TextView detailsTextView2 = cardLayout2.findViewById(R.id.commandDetails);
        TextView dataTextView2 = cardLayout2.findViewById(R.id.orderedAt);
        TextView numberTextView2 = cardLayout2.findViewById(R.id.ticketNr);
        TextView priceTextView2 = cardLayout2.findViewById(R.id.totalPrice);
        orderTextView2.setText("Comanda nr. 2");
        titleTextView2.setText("Electric Castle");
        detailsTextView2.setText("Detalii comanda:");
        dataTextView2.setText("Data comenzii: 15/06/2023");
        numberTextView2.setText("Numar bilete:");
        priceTextView2.setText("Pret total: 600 RON");

        View cardLayout3 = findViewById(R.id.celtic);
        TextView orderTextView3 = cardLayout3.findViewById(R.id.commandNr);
        TextView titleTextView3 = cardLayout3.findViewById(R.id.eventName);
        TextView detailsTextView3 = cardLayout3.findViewById(R.id.commandDetails);
        TextView dataTextView3 = cardLayout3.findViewById(R.id.orderedAt);
        TextView numberTextView3 = cardLayout3.findViewById(R.id.ticketNr);
        TextView priceTextView3 = cardLayout3.findViewById(R.id.totalPrice);
        orderTextView3.setText("Comanda nr. 3");
        titleTextView3.setText("Festivalul Celtic Transilvania");
        detailsTextView3.setText("Detalii comanda:");
        dataTextView3.setText("Data comenzii: 01/12/2022");
        numberTextView3.setText("Numar bilete:");
        priceTextView3.setText("Pret total: 900 RON");

        View cardLayout4 = findViewById(R.id.fotbal);
        TextView orderTextView4 = cardLayout4.findViewById(R.id.commandNr);
        TextView titleTextView4 = cardLayout4.findViewById(R.id.eventName);
        TextView detailsTextView4 = cardLayout4.findViewById(R.id.commandDetails);
        TextView dataTextView4 = cardLayout4.findViewById(R.id.orderedAt);
        TextView numberTextView4 = cardLayout4.findViewById(R.id.ticketNr);
        TextView priceTextView4 = cardLayout4.findViewById(R.id.totalPrice);
        orderTextView4.setText("Comanda nr. 4");
        titleTextView4.setText("UCL final");
        detailsTextView4.setText("Detalii comanda:");
        dataTextView4.setText("Data comenzii: 13/03/2024");
        numberTextView4.setText("Numar bilete:");
        priceTextView4.setText("Pret total: 7200 RON");



        Button deleteOrderButton = findViewById(R.id.deleteOrderButton);
        deleteOrderButton.setOnClickListener(v -> Toast.makeText(SecondActivity.this, "Order deleted!", Toast.LENGTH_SHORT).show());


        Button saveOrderButton = findViewById(R.id.saveOrderButton);
        saveOrderButton.setOnClickListener(v -> Toast.makeText(SecondActivity.this, "Order saved!", Toast.LENGTH_SHORT).show());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_app_bar_for_orders, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle the "Go Back" button click
        if (item.getItemId() == R.id.goBack) {
            onBackPressed(); // Navigate back to the previous screen
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
