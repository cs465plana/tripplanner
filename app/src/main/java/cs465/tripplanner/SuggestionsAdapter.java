package cs465.tripplanner;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cs465.tripplanner.data.Data;
import cs465.tripplanner.data.Suggestion;

public class SuggestionsAdapter extends RecyclerView.Adapter<SuggestionsAdapter.SuggestionHolder> {
    private ArrayList<Suggestion> list;

    public SuggestionsAdapter(ArrayList<Suggestion> list) {
        this.list = list;
    }

    @Override
    public SuggestionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.suggestion_view, parent, false);
        return new SuggestionHolder(listItem);
    }

    @Override
    public void onBindViewHolder(SuggestionHolder holder, int position) {
        final Suggestion item = list.get(position);
        holder.usernameView.setText("suggested by " + item.getUsername());
        holder.titleView.setText(item.getTitle());
        holder.priceView.setText(item.getPriceString());
        holder.moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data.get().currentSuggestion = item;
                Intent i = new Intent(view.getContext(), SuggestionDetailsActivity.class);
                view.getContext().startActivity(i);
            }
        });
        if (item.getTrip().getUsername() != Data.get().currentUsername) {
            holder.addButton.setVisibility(View.GONE);
        } else {
            if (item.isSelected()) {
                holder.addButton.setImageResource(R.drawable.added_button);
            } else {
                holder.addButton.setImageResource(R.drawable.add_button);
            }
            holder.addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageView button = (ImageView) view;
                    item.select();
                    if (item.isSelected()) {
                        button.setImageResource(R.drawable.added_button);
                    } else {
                        button.setImageResource(R.drawable.add_button);
                    }
                    SuggestionsActivity activity = (SuggestionsActivity) view.getContext();
                    TextView remaining = activity.findViewById(R.id.suggestions_budget_remaining);
                    remaining.setText("Budget remaining: " + Data.get().currentTrip.getBudgetRemainingString());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class SuggestionHolder extends RecyclerView.ViewHolder {
        private TextView usernameView;
        private TextView titleView;
        private TextView priceView;
        private ImageView moreButton;
        private ImageView addButton;

        public SuggestionHolder(View itemView) {
            super(itemView);
            usernameView = itemView.findViewById(R.id.suggestion_username);
            titleView = itemView.findViewById(R.id.suggestion_title);
            priceView = itemView.findViewById(R.id.suggestion_price);
            moreButton = itemView.findViewById(R.id.suggestion_more_button);
            addButton = itemView.findViewById(R.id.suggestion_add_button);
        }
    }
}
