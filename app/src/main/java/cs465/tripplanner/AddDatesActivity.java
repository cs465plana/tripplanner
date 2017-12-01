package cs465.tripplanner;

import android.os.Bundle;

public class AddDatesActivity extends AddActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        layoutId = R.layout.activity_add_dates;
        toolbarId = R.id.toolbar_add_dates;
        backId = R.id.dates_back_button;
        nextId = R.id.dates_next_button;
        backClass = AddBudgetActivity.class;
        nextClass = AddTagsActivity.class;
        super.onCreate(savedInstanceState);
    }

    @Override
    public void updateData() {

    }

}
