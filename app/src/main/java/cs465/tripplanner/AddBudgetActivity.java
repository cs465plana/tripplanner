package cs465.tripplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class AddBudgetActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton nextButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budget);

        Toolbar toolbar = findViewById(R.id.toolbar_add_budget);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        backButton = findViewById(R.id.budget_back_button);
        nextButton = findViewById(R.id.budget_next_button);
        backButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    public void onClick(View v) {
//        if (v.getId() == R.id.next_button2) {
//            Intent i = new Intent(this, AddDatesActivity.class);
//            startActivity(i);
//        } else if (v.getId() == R.id.back_button) {
//            Intent i = new Intent(this, AddLocationActivity2.class);
//            startActivity(i);
//        }
    }
}
