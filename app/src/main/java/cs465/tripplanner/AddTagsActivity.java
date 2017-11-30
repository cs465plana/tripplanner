package cs465.tripplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddTagsActivity extends AppCompatActivity implements View.OnClickListener {
    private Button finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tags);

        finishButton = (Button) findViewById(R.id.finish_button);
        finishButton.setOnClickListener(this);
        setTitle("Add Location");
    }

    public void onClick(View v) {
        if (v.getId() == R.id.finish_button) {
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
        }
    }
}
