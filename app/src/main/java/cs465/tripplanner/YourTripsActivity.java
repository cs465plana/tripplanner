package cs465.tripplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class YourTripsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_trips);

        Toolbar toolbar = findViewById(R.id.toolbar_your_trips);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ImageButton closeButton = findViewById(R.id.your_trips_close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        FloatingActionButton fab = findViewById(R.id.your_trips_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(YourTripsActivity.this, AddLocationActivity.class);
                startActivity(i);
            }
        });

        TripListAdapter adapter = new TripListAdapter(DataHolder.get().yourTrips);
        RecyclerView trip_list_view = findViewById(R.id.your_trip_list);
        trip_list_view.setHasFixedSize(true);
        trip_list_view.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setReverseLayout(true);
        llm.setStackFromEnd(true);
        trip_list_view.setLayoutManager(llm);
    }

}
