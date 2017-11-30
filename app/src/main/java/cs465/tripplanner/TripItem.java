package cs465.tripplanner;

import java.util.ArrayList;

/**
 * Created by szhu19 on 11/29/2017.
 */

public class TripItem {
    public String username;
    public String location;
    public int budget;
    public String[] tags;

    public TripItem(String username, String location, int budget, String[] tags) {
        this.username = username;
        this.location = location;
        this.budget = budget;
        this.tags = tags;
    }

    public String getBudgetString() {
        return "Budget: $" + budget + "/day";
    }

    public String getTagsString() {
        StringBuilder sb = new StringBuilder();
        for (String tag : tags) {
            sb.append('#');
            sb.append(tag);
            sb.append(' ');
        }
        return sb.toString();
    }
}
