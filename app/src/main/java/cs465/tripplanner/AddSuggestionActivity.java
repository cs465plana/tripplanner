package cs465.tripplanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import cs465.tripplanner.data.Data;
import cs465.tripplanner.data.Suggestion;

public class AddSuggestionActivity extends AppCompatActivity {

    TextView titleView;
    TextView priceView;
    TextView commentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_suggestion);

        titleView = findViewById(R.id.add_suggestion_title);
        priceView = findViewById(R.id.add_suggestion_price);
        commentView = findViewById(R.id.add_suggestion_comment);

        ImageButton backButton = findViewById(R.id.add_suggestion_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button addButton = findViewById(R.id.add_suggestion_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Suggestion s = new Suggestion(Data.get().currentTrip, Data.get().currentUsername, titleView.getText().toString(), Float.parseFloat(priceView.getText().toString()), commentView.getText().toString());
                Data.get().currentTrip.addSuggestion(s);
                finish();
            }
        });
    }
}
