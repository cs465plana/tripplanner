package cs465.tripplanner;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TripListAdapter extends RecyclerView.Adapter<TripListAdapter.TripListItemHolder> {
    private ArrayList<TripItem> vals;

    public TripListAdapter(ArrayList<TripItem> vals) {
        this.vals = vals;
    }

    @Override
    public TripListItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_item_view, parent, false);
        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(listItem.getContext(), TripDetailsActivity.class);
                listItem.getContext().startActivity(i);
            }
        });
        return new TripListItemHolder(listItem);
    }

    @Override
    public void onBindViewHolder(TripListItemHolder holder, int position) {
        TripItem item = vals.get(position);
        holder.locTextView.setText(item.getLocationString());
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
