package com.example.tsm_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import android.widget.Spinner;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapters.EventAdapter;
import Entities.EventModel;
import Service.IEventService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import RetrofitClient.RetrofitClient;



public class MainActivity extends AppCompatActivity  implements SearchView.OnQueryTextListener {

        private List<EventModel> eventsList = new ArrayList<>();


       String[] ticketCategories = {"VIP", "Standard"};
        private Spinner filterSpinner;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

         /*   View cardLayout1 = findViewById(R.id.Untold);
            ImageView photoImageView1 = cardLayout1.findViewById(R.id.photo);
            TextView titleTextView1 = cardLayout1.findViewById(R.id.title);
            TextView descriptionTextView1 = cardLayout1.findViewById(R.id.txtDescription);
            photoImageView1.setImageResource(R.drawable.untold);
            titleTextView1.setText("Untold (03/08/2023 - 07/08/2023)");
            descriptionTextView1.setText("Cel mai mare festival de muzica electronica din Romania, cu artisti veniti din toate colturile lumii, cum ar fi Asia, America de Nord, si o gama larga de tari Europene!");


            View cardLayout2 = findViewById(R.id.electric);
            ImageView photoImageView2 = cardLayout2.findViewById(R.id.photo);
            TextView titleTextView2 = cardLayout2.findViewById(R.id.title);
            TextView descriptionTextView2 = cardLayout2.findViewById(R.id.txtDescription);
            photoImageView2.setImageResource(R.drawable.electric);
            titleTextView2.setText("Electric Castle (19/07/2023 - 23/07/2023)");
            descriptionTextView2.setText("Festival organizat anual la castelul Banffy, combinand mai multe genuri muzicale, atat cu tehnologia, cat si cu arta transmisa de mari artisti din toata lumea! ");


            View cardLayout3 = findViewById(R.id.celtic);
            ImageView photoImageView3 = cardLayout3.findViewById(R.id.photo);
            TextView titleTextView3 = cardLayout3.findViewById(R.id.title);
            TextView descriptionTextView3 = cardLayout3.findViewById(R.id.txtDescription);
            photoImageView3.setImageResource(R.drawable.celtic);
            titleTextView3.setText("Festivalul Celtic Transilvania (21/07/2023 - 23/07/2023) ");
            descriptionTextView3.setText("Este un eveniment complex, unic in Romania si chiar in estul Europei, in care se combina armonios activitatile de reconstituire istorica a perioadei celtice a Transilvaniei, cu muzică folk, rock si metal!");


            View cardLayout4 = findViewById(R.id.fotbal);
            ImageView photoImageView4 = cardLayout4.findViewById(R.id.photo);
            TextView titleTextView4 = cardLayout4.findViewById(R.id.title);
            TextView descriptionTextView4 = cardLayout4.findViewById(R.id.txtDescription);
            photoImageView4.setImageResource(R.drawable.fotbal);
            titleTextView4.setText("UCL final");
            descriptionTextView4.setText("Cea de a 69-a editie a celui mai mare eveniment fotbalistic inter-cluburi va avea loc pe stadionul Wembley, in editia 2023-2024, pentru a 8-a oara in istoria UEFA Champions League!");
*/
            /*EventModel event1 = new EventModel(5,"Festival De Muzica","Aleea Stadioului 2, Cluj-Napoca", "Untold", "Muzica Electronica si nu numai", "2023-03-08 00:00:00.000", "2023-06-08 00:00:00.000", "Standard", "@drawable/untold" );
            events.add(event1);*/

            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            EventAdapter eventAdapter = new EventAdapter(eventsList);
            recyclerView.setAdapter(eventAdapter);

            Retrofit retrofit = RetrofitClient.getRetrofitInstance();
            IEventService eventService = retrofit.create(IEventService.class);

            Call<List<EventModel>> call = eventService.fetchAllEvents(null, null);
            call.enqueue(new Callback<List<EventModel>>() {
                @Override
                public void onResponse(Call<List<EventModel>> call, Response<List<EventModel>> response) {
                    if (response.isSuccessful()) {
                        List<EventModel> events = response.body();
                        if (events != null) {
                            for (EventModel event : events) {
                                Log.d("EVENT", "Event Name: " + event.getName());
                            }
                        }
                    } else {
                        Log.e("API ERROR", "Error: " + response.message());
                    }
                }

                @Override
                public void onFailure(Call<List<EventModel>> call, Throwable t) {
                    Log.e("NETWORK ERROR", "Error: " + t.getMessage());
                }
            });

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.top_app_bar, menu);

            MenuItem searchItem = menu.findItem(R.id.search_item);
            SearchView searchView = (SearchView) searchItem.getActionView();
            searchView.setOnQueryTextListener(this);

            MenuItem filterMenuItem = menu.findItem(R.id.filter);
            filterSpinner = (Spinner) filterMenuItem.getActionView();

            List<String> filterOptions = new ArrayList<>();
            filterOptions.add("Nume");
            filterOptions.add("Pret");

            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_spinner_item,
                    filterOptions
            );

            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            filterSpinner.setAdapter(spinnerAdapter);

            filterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selectedOption = (String) parent.getItemAtPosition(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });


            return true;
        }

        @Override
        public boolean onQueryTextSubmit(String query) {
            performSearch(query);
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            performSearch(newText);
            return true;
        }

        private void performSearch(String query) {
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.Cart) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }







