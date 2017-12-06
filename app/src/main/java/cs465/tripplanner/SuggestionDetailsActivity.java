package cs465.tripplanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.view.RowLayout;

import cs465.tripplanner.data.Data;

public class SuggestionDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion_details);

        ImageButton backButton = findViewById(R.id.suggestion_details_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView priceView = findViewById(R.id.suggestion_details_price);
        priceView.setText(Data.get().currentSuggestion.getPriceString());

        for (String tag : Data.get().currentSuggestion.getTrip().getTags()) {
            TextView tagTextView = (TextView) getLayoutInflater().inflate(R.layout.tag_view, null);
            RowLayout tagsView = findViewById(R.id.suggestion_details_tags);
            tagTextView.setText('#' + tag);
            tagsView.addView(tagTextView);
        }

        TextView commentsView = findViewById(R.id.suggestion_details_comments);
        commentsView.setText(Data.get().currentSuggestion.getComment());
    }
}
