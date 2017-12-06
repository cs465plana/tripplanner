package cs465.tripplanner;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;

import cs465.tripplanner.data.Data;

public class AddDatesActivity extends AddActivity {
    EditText addDatesFrom;
    EditText addDatesTo;
    Calendar myCalendar;
    Date from;
    Date to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        layoutId = R.layout.activity_add_dates;
        toolbarId = R.id.toolbar_add_dates;
        backId = R.id.dates_back_button;
        nextId = R.id.dates_next_button;
        backClass = AddBudgetActivity.class;
        nextClass = AddTagsActivity.class;
        super.onCreate(savedInstanceState);

        myCalendar = Calendar.getInstance();

        addDatesFrom = (EditText) findViewById(R.id.add_dates_from);
        addDatesFrom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(AddDatesActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        from = myCalendar.getTime();
                        addDatesFrom.setText(Data.dateFormatter.format(from));
                    }
                }, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        addDatesTo = (EditText) findViewById(R.id.add_dates_to);
        addDatesTo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(AddDatesActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        to = myCalendar.getTime();
                        addDatesTo.setText(Data.dateFormatter.format(to));
                    }
                }, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    @Override
    public void updateData() {
        Data.get().newTrip.startDate = from;
        Data.get().newTrip.endDate = to;
    }

}
