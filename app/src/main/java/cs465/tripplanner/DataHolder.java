package cs465.tripplanner;

import java.util.ArrayList;

public class DataHolder {
    public static DataHolder singleton = new DataHolder();

    public static DataHolder get() {
        return singleton;
    }

    public ArrayList<TripItem> trips = new ArrayList<>();
    public ArrayList<TripItem> yourTrips = new ArrayList<>();

    public DataHolder() {
        for (int i = 0; i < 10; i++) {
            trips.add(new TripItem("User " + i, "Location " + i, 100 * i, new String[]{"tag1", "tag2"}));
        }

        yourTrips.add(new TripItem("yourself", "Brooklyn, NY", 100, new String[]{"photogenic", "crowd"}));
    }
}
