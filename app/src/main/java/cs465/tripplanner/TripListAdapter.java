package cs465.tripplanner;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by szhu19 on 11/29/2017.
 */

public class TripListAdapter extends RecyclerView.Adapter<TripListAdapter.TripListItemHolder> {
    public ArrayList<TripItem> vals;

    public TripListAdapter(ArrayList<TripItem> vals) {
        this.vals = vals;
    }

    @Override
    public TripListItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_item_view, parent, false);
        return new TripListItemHolder(listItem);
    }

    @Override
    public void onBindViewHolder(TripListItemHolder holder, int position) {
        TripItem item = vals.get(position);
        holder.locTextView.setText(item.location);
        holder.budgetTextView.setText(item.getBudgetString());
        holder.tagsTextView.setText(item.getTagsString());
    }

    @Override
    public int getItemCount() {
        return vals.size();
    }


    public static class TripListItemHolder extends RecyclerView.ViewHolder {
        private TextView locTextView;
        private TextView budgetTextView;
        private TextView tagsTextView;

        public TripListItemHolder(View itemView) {
            super(itemView);
            locTextView = itemView.findViewById(R.id.trip_loc_text);
            budgetTextView = itemView.findViewById(R.id.trip_budget_text);
            tagsTextView = itemView.findViewById(R.id.trip_tags_text);
        }
    }
}
