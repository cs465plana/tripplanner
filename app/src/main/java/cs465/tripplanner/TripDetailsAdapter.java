package cs465.tripplanner;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class TripDetailsAdapter extends RecyclerView.Adapter<TripDetailsAdapter.TripDetailsItemHolder> {
    private ArrayList<String> vals;

    public TripDetailsAdapter(ArrayList<String> vals) {
        this.vals = vals;
    }

    @Override
    public TripDetailsItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.suggestion_item_view, parent, false);
//        listItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(listItem.getContext(), TripDetailsActivity.class);
//                listItem.getContext().startActivity(i);
//            }
//        });
        return new TripDetailsAdapter.TripDetailsItemHolder(listItem);
    }

    @Override
    public void onBindViewHolder(TripDetailsItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return vals.size();
    }


    public static class TripDetailsItemHolder extends RecyclerView.ViewHolder {
        public TripDetailsItemHolder(View itemView) {
            super(itemView);
        }
    }
}
