package cs465.tripplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AddTagsActivity extends AddActivity {
    private ImageButton finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        layoutId = R.layout.activity_add_tags;
        toolbarId = R.id.toolbar_add_tags;
        backId = R.id.tags_back_button;
        nextId = -1;
        backClass = AddDatesActivity.class;
        nextClass = null; // TODO
        super.onCreate(savedInstanceState);

        finishButton = findViewById(R.id.add_finish_button);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddTagsActivity.this, HomeActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivityIfNeeded(i, 0);
            }
        });
    }

}