package cs465.tripplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public class AddLocationActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(this);
        setTitle("Add Location");
    }

    public void onClick(View v) {
        if (v.getId() == R.id.next_button) {
            Intent i = new Intent(this, AddBudgetActivity.class);
            startActivity(i);
        }
    }
}
