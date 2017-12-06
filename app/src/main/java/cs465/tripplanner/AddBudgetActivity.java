package cs465.tripplanner;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import cs465.tripplanner.data.Data;

public class AddBudgetActivity extends AddActivity {
    private EditText budgetInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        layoutId = R.layout.activity_add_budget;
        toolbarId = R.id.toolbar_add_budget;
        backId = R.id.budget_back_button;
        nextId = R.id.budget_next_button;
        backClass = AddLocationActivity.class;
        nextClass = AddDatesActivity.class;
        super.onCreate(savedInstanceState);

        budgetInput = findViewById(R.id.add_budget_input);
        budgetInput.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView input, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    AddBudgetActivity.this.updateData();
                }
                return false;
            }
        });
    }

    @Override
    public void updateData() {
        Data.get().newTrip.setBudget(budgetInput.getText().toString());
    }

}
