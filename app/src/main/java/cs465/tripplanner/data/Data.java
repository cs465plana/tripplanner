package cs465.tripplanner.data;

import java.util.ArrayList;

public class Data {
    public static Data singleton = new Data();

    public static Data get() {
        return singleton;
    }

    public String currentUsername;

    public ArrayList<Trip> trips = new ArrayList<>();
    public ArrayList<Trip> yourTrips = new ArrayList<>();

    public Trip newTrip;

    public Trip currentTrip;
    public Suggestion currentSuggestion;

    public Data() {
        currentUsername = "current_user";

        for (int i = 0; i < 10; i++) {
            Trip trip = new Trip("User " + i, "Location " + i, 100 * i, new String[]{"tag1", "tag2"});
            trip.addSuggestion(new Suggestion(trip, "Another user", "Suggestion", 10, "Nice place"));
            if (i == 9) {
                for (int j = 0; j < 10; j++) {
                    trip.addSuggestion(new Suggestion(trip, "Another user", "Suggestion " + j, j * 10, "Nice place"));
                }
            }
            trips.add(trip);
        }
        Trip trip = new Trip(currentUsername, "Brooklyn, NY", 100, new String[]{"photogenic", "crowd"});
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
}
