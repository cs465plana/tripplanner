package cs465.tripplanner;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddDatesActivity extends AddActivity {
    EditText addDatesFrom= (EditText) findViewById(R.id.add_dates_from);
    Calendar popupCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int yearPicked, int monthPicked,
                              int dayPicked) {
            // TODO Auto-generated method stub
            popupCalendar.set(Calendar.YEAR, yearPicked);
            popupCalendar.set(Calendar.MONTH, monthPicked);
            popupCalendar.set(Calendar.DAY_OF_MONTH, dayPicked);
            updateLabel();
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        layoutId = R.layout.activity_add_dates;
        toolbarId = R.id.toolbar_add_dates;
        backId = R.id.dates_back_button;
        nextId = R.id.dates_next_button;
        backClass = AddBudgetActivity.class;
        nextClass = AddTagsActivity.class;
        super.onCreate(savedInstanceState);

        addDatesFrom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddDatesActivity.this, date, popupCalendar
                        .get(Calendar.YEAR), popupCalendar.get(Calendar.MONTH),
                        popupCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        addDatesFrom.setText(sdf.format(popupCalendar.getTime()));
    }
    @Override
    public void updateData() {

    }

}
