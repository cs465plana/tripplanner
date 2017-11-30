package cs465.tripplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    int layoutId, toolbarId;
    int backId, nextId;
    Class backClass, nextClass;
    private ImageButton backButton, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);

        Toolbar toolbar = this.findViewById(toolbarId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (backId != -1) {
            backButton = findViewById(backId);
            backButton.setOnClickListener(this);
        }
        if (nextId != -1) {
            nextButton = findViewById(nextId);
            nextButton.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        if (v.getId() == backId) {
            i = new Intent(this, backClass);
        } else if (v.getId() == nextId) {
            i = new Intent(this, nextClass);
        }
        if (i != null) {
            i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivityIfNeeded(i, 0);
        }
    }
}
