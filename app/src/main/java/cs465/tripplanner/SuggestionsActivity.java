package cs465.tripplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.view.RowLayout;

import cs465.tripplanner.data.Data;

public class SuggestionsActivity extends AppCompatActivity {
    SuggestionsAdapter adapter;
    LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_suggestions);
        if (Data.get().currentTrip.getUsername() == Data.get().currentUsername) {
            fab.setVisibility(View.GONE);
        } else {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), AddSuggestionActivity.class);
                    startActivity(i);
                }
            });

        }

        RecyclerView recyclerView = findViewById(R.id.suggestions_list);

        adapter = new SuggestionsAdapter(Data.get().currentTrip.getSuggestions());
        recyclerView.setAdapter(adapter);

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setReverseLayout(true);
        llm.setStackFromEnd(true);
        recyclerView.setLayoutManager(llm);

        ImageButton backButton = findViewById(R.id.suggestions_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView locTextView = findViewById(R.id.suggestions_loc_text);
        locTextView.setText(Data.get().currentTrip.getLocationString());

        TextView budgetTextView = findViewById(R.id.suggestions_budget_text);
        budgetTextView.setText(Data.get().currentTrip.getBudgetString());

        TextView datesTextView = findViewById(R.id.suggestions_dates_text);
        datesTextView.setText(Data.get().currentTrip.getDatesString());

        RowLayout tagsView = findViewById(R.id.suggestions_tags_list);
        for (String tag : Data.get().currentTrip.getTags()) {
            TextView tagTextView = (TextView) getLayoutInflater().inflate(R.layout.tag_small_view, null);
            tagTextView.setText('#' + tag);
            tagsView.addView(tagTextView);
        }

        TextView budgetRemainingView = findViewById(R.id.suggestions_budget_remaining);
        budgetRemainingView.setText("Budget remaining: " + Data.get().currentTrip.getBudgetRemainingString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.notifyDataSetChanged();
    }
}
