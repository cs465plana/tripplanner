package cs465.tripplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddDatesActivity extends AppCompatActivity implements View.OnClickListener {
    private Button nextButton3;
    private Button backButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budget);

        nextButton3 = (Button) findViewById(R.id.next_button3);
        nextButton3.setOnClickListener(this);

        backButton2 = (Button) findViewById(R.id.back_button2);
        backButton2.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.next_button3) {
            Intent i = new Intent(this, FinalActivity.class);
            startActivity(i);
        } else if (v.getId() == R.id.back_button2) {
            Intent i = new Intent(this, AddBudgetActivity.class);
            startActivity(i);
        }
    }
}
