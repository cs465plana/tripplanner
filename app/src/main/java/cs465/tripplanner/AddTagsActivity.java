package cs465.tripplanner;

import android.os.Bundle;

public class AddTagsActivity extends AddActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        layoutId = R.layout.activity_add_tags;
        toolbarId = R.id.toolbar_add_tags;
        backId = R.id.tags_back_button;
        nextId = -1;
        backClass = AddDatesActivity.class;
        nextClass = null; // TODO
        super.onCreate(savedInstanceState);
    }

}