package cs465.tripplanner;

class TripItem {
    private String username;
    private String location;
    private int budget;
    private String[] tags;

    public TripItem(String username, String location, int budget, String[] tags) {
        this.username = username;
        this.location = location;
        this.budget = budget;
        this.tags = tags;
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
}
