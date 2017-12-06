package cs465.tripplanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import cs465.tripplanner.data.Data;

public class SuggestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        RecyclerView recyclerView = findViewById(R.id.suggestions_list);

        SuggestionsAdapter adapter = new SuggestionsAdapter(Data.get().currentTrip.getSuggestions());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setReverseLayout(true);
        llm.setStackFromEnd(true);
        recyclerView.setLayoutManager(llm);

        ImageButton backButton = findViewById(R.id.trip_details_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView locTextView = findViewById(R.id.trip_detail_loc_text);
        locTextView.setText(Data.get().currentTrip.getLocationString());

        TextView budgetTextView = findViewById(R.id.trip_detail_budget_text);
        budgetTextView.setText(Data.get().currentTrip.getBudgetString());


    }
}
