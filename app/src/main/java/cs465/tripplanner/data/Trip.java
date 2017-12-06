package cs465.tripplanner.data;

import java.util.ArrayList;

public class Trip {
    private String username;
    private String location;
    private int budget;
    private ArrayList<String> tags;
    private ArrayList<Suggestion> suggestions;

    public Trip(String username) {
        this(username, null, -1, null);
    }

    public Trip(String username, String location, int budget, String[] tags) {
        this.username = username;
        setLocation(location);
        this.budget = budget;
        this.tags = new ArrayList<>();
        addTag("test");
        if (tags != null) {
            for (String tag : tags) {
                addTag(tag);
            }
        }
        this.suggestions = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getLocationString() {
        return location;
    }

    public String getBudgetString() {
        return "$" + budget;
    }

    public ArrayList<String> getTags() {
        return tags;
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

    public ArrayList<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void setLocation(String loc) {
        this.location = loc;
    }

    public void setBudget(String budget) {
        if (!budget.isEmpty()) {
            this.budget = Integer.parseInt(budget);
        } else {
            this.budget = 0;
        }
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public void addSuggestion(Suggestion suggestion) {
        suggestions.add(suggestion);
    }

}
