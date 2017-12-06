package cs465.tripplanner.data;

public class Suggestion {
    private Trip trip;
    private String username; // suggester
    private String title;
    private float price;
    private String comment;
    private boolean isSelected;

    public Suggestion(Trip trip, String username, String title, float price, String comment) {
        this.trip = trip;
        this.username = username;
        this.title = title;
        this.price = price;
        this.comment = comment;
        this.isSelected = false;
    }

    public Trip getTrip() {
        return trip;
    }

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public String getPriceString() {
        return '$' + Float.toString(price);
    }

    public String getComment() {
        return comment;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void select() {
        isSelected = !isSelected;
    }
}
