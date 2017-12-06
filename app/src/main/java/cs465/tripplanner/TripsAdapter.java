package cs465.tripplanner;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cs465.tripplanner.data.Data;
import cs465.tripplanner.data.Trip;

public class TripsAdapter extends RecyclerView.Adapter<TripsAdapter.TripHolder> {
    private boolean isUserView;
    private ArrayList<Trip> list;

    public TripsAdapter(boolean isUserView) {
        this.isUserView = isUserView;
        this.list = !isUserView ? Data.get().trips : Data.get().yourTrips;
    }

    @Override
    public TripHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_view, parent, false);
        return new TripHolder(listItem);
    }

    @Override
    public void onBindViewHolder(TripHolder holder, int position) {
        final Trip item = list.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data.get().currentTrip = item;
                Intent i = new Intent(view.getContext(), SuggestionsActivity.class);
                view.getContext().startActivity(i);
            }
        });
        holder.locTextView.setText(item.getLocationString());
        holder.budgetTextView.setText(item.getBudgetString());
        holder.tagsTextView.setText(item.getTagsString());
        if (isUserView) {
            holder.usernameTextView.setVisibility(View.GONE);
        } else {
            holder.usernameTextView.setText("posted by " + item.getUsername());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class TripHolder extends RecyclerView.ViewHolder {
        private TextView locTextView;
        private TextView budgetTextView;
        private TextView tagsTextView;
        private TextView usernameTextView;

        public TripHolder(View itemView) {
            super(itemView);
            locTextView = itemView.findViewById(R.id.trip_loc_text);
            budgetTextView = itemView.findViewById(R.id.trip_budget_text);
            tagsTextView = itemView.findViewById(R.id.trip_tags_text);
            usernameTextView = itemView.findViewById(R.id.trip_username_text);
        }
    }
}
