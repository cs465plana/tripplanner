package cs465.tripplanner;

import android.os.Bundle;

public class AddBudgetActivity extends AddActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        layoutId = R.layout.activity_add_budget;
        toolbarId = R.id.toolbar_add_budget;
        backId = R.id.budget_back_button;
        nextId = R.id.budget_next_button;
        backClass = AddLocationActivity.class;
        nextClass = AddDatesActivity.class;
        super.onCreate(savedInstanceState);
    }

}
