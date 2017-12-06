package cs465.tripplanner.data;

import android.icu.text.NumberFormat;
import android.icu.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Data {
    public static Data singleton = new Data();

    public static Data get() {
        return singleton;
    }

    public static SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
    public static NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public String currentUsername;

    public ArrayList<Trip> trips = new ArrayList<>();
    public ArrayList<Trip> yourTrips = new ArrayList<>();

    public Trip newTrip;

    public Trip currentTrip;
    public Suggestion currentSuggestion;

    public Data() {
        this.currentUsername = "current user";
        Trip trip;

        for (int i = 0; i < 10; i++) {
            trip = new Trip("User " + i, "Location " + i, 1000 * i, new String[]{"tag1", "tag2"});
            trip.startDate = new Date();
            trip.endDate = new Date();
            trip.addSuggestion(new Suggestion(trip, "Another user", "Suggestion", 10, "Nice place"));
            if (i == 9) {
                for (int j = 0; j < 10; j++) {
                    trip.addSuggestion(new Suggestion(trip, "Another user", "Suggestion " + j, j * 10, "Nice place"));
                }
            }
            trips.add(trip);
        }

        trip = new Trip("Mickey", "Manhattan, NY", 1000, new String[]{"romantic", "instagram"});
        trip.startDate = new Date();
        trip.endDate = new Date();
        trip.addSuggestion(new Suggestion(trip, "Another user", "Met", 10, "Nice place"));
        trips.add(trip);


        trip = new Trip(currentUsername, "Brooklyn, NY", 100, new String[]{"photogenic", "crowd"});
        trip.startDate = new Date();
        trip.endDate = new Date();
        for (int j = 0; j < 10; j++) {
            trip.addSuggestion(new Suggestion(trip, "Another user", "Suggestion " + j, j * 10, "Nice place"));
        }
        yourTrips.add(trip);
    }

    public Trip createNewTrip() {
        newTrip = new Trip(currentUsername);
        return newTrip;
    }

    public void addNewTrip() {
        yourTrips.add(newTrip);
    }

    public static String formatCurrency(float currency) {
        String s = formatter.format(currency);
        if (s.endsWith(".00")) {
            int centsIndex = s.lastIndexOf(".00");
            if (centsIndex != -1) {
                s = s.substring(0, centsIndex);
            }
        }
        return s;
    }
}
