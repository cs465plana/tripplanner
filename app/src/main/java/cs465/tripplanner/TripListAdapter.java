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
    public ArrayList<String> vals;

    public TripListAdapter(ArrayList<String> vals) {
        this.vals = vals;
    }

    @Override
    public TripListItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_item_view, parent, false);
        return new TripListItemHolder(listItem);
    }

    @Override
    public void onBindViewHolder(TripListItemHolder holder, int position) {
        holder.locTextView.setText(vals.get(position));
    }

    @Override
    public int getItemCount() {
        return vals.size();
    }


    public static class TripListItemHolder extends RecyclerView.ViewHolder {
        private TextView locTextView;

        public TripListItemHolder(View itemView) {
            super(itemView);
            locTextView = itemView.findViewById(R.id.trip_loc_text);
        }
    }
}
