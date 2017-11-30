package cs465.tripplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class AddBudgetActivity extends AppCompatActivity implements View.OnClickListener{
    private Button nextButton2;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budget);

        nextButton2 = (Button) findViewById(R.id.next_button2);
        nextButton2.setOnClickListener(this);

        backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.next_button2) {
            Intent i = new Intent(this, AddDatesActivity.class);
            startActivity(i);
        } else if (v.getId() == R.id.back_button) {
            Intent i = new Intent(this, AddLocationActivity.class);
            startActivity(i);
        }
    }
}
