package Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tsm_app.CustomSpinner;
import com.example.tsm_app.R;

import java.util.List;

import Entities.EventModel;
import Entities.TicketCategoryModel;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<EventModel> events;

    public void setEvents(List<EventModel> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_list, parent, false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof EventViewHolder) {
            EventViewHolder eventViewHolder = (EventViewHolder) holder;
            EventModel event = events.get(position);
            // Bind event data to the EventViewHolder here...
            switch (event.getEventImageUrl()) {
                case "@drawable/untold":
                    eventViewHolder.photo.setImageResource(R.drawable.untold);
                    break;
                case "@drawable/electric":
                    eventViewHolder.photo.setImageResource(R.drawable.electric);
                    break;
                case "@drawable/wineFestival":
                    eventViewHolder.photo.setImageResource(R.drawable.wine);
                    break;
                case "@drawable/fotbal":
                    eventViewHolder.photo.setImageResource(R.drawable.fotbal);
                    break;
                case "@drawable/concert":
                    eventViewHolder.photo.setImageResource(R.drawable.concert);
                    break;
                default:
                    break;
            }
            eventViewHolder.eventName.setText(event.getName());
            eventViewHolder.eventDescription.setText(event.getDescription());
        } else if (holder instanceof ControlsViewHolder) {
            ControlsViewHolder controlsViewHolder = (ControlsViewHolder) holder;
            String[] ticketCategories = controlsViewHolder.itemView.getResources().getStringArray(R.array.ticket_categories);

            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(controlsViewHolder.itemView.getContext(),
                    android.R.layout.simple_spinner_item, ticketCategories);
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            controlsViewHolder.optionSpinner.setAdapter(spinnerAdapter);

            controlsViewHolder.buyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String selectedOption = eventViewHolder.optionSpinner.getSelectedItem().toString();
                    String ticketCount = eventViewHolder.ticketCountInput.getText().toString();
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return events == null ? 0 : events.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {

        public ImageView photo;
        public TextView eventName;
        public TextView eventDescription;
        public Spinner optionSpinner;
        public EditText ticketCountInput;
        public Button button;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.photo);
            eventName = itemView.findViewById(R.id.title);
            eventDescription = itemView.findViewById(R.id.txtDescription);
            optionSpinner = itemView.findViewById(R.id.optionSpinner);
            ticketCountInput = itemView.findViewById(R.id.ticketCountInput);
            button = itemView.findViewById(R.id.button);

        }
    }
}
