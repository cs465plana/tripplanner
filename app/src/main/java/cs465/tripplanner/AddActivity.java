package cs465.tripplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public abstract class AddActivity extends AppCompatActivity implements DataUpdater {
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
            backButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    AddActivity.this.updateData();

                    Intent i = new Intent(AddActivity.this, backClass);
                    i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivityIfNeeded(i, 0);
                }
            });
        }
        if (nextId != -1) {
            nextButton = findViewById(nextId);
            nextButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    AddActivity.this.updateData();

                    Intent i = new Intent(AddActivity.this, nextClass);
                    i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivityIfNeeded(i, 0);
                }
            });
        }
    }
}
