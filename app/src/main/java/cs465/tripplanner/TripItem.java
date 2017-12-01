package cs465.tripplanner;

import java.util.ArrayList;

class TripItem {
    private String username;
    private String location;
    private int budget;
    private ArrayList<String> tags;

    public TripItem(String username) {
        this(username, null, -1, null);
    }

    public TripItem(String username, String location, int budget, String[] tags) {
        this.username = username;
        this.location = location;
        this.budget = budget;
        this.tags = new ArrayList<>();
        if (tags != null) {
            for (String tag : tags) {
                addTag(tag);
            }
        }
    }

    public String getUsernameString() {
        return username;
    }

    public String getLocationString() {
        return location;
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

    public void setLocation(String loc) {
        this.location = loc;
    }

    public void setBudget(String budget) {
        this.budget = Integer.parseInt(budget);
    }

    public void addTag(String tag) {
        tags.add(tag);
    }
}
