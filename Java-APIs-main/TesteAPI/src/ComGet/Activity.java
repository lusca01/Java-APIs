package ComGet;

public class Activity {
    String activity;
    String type;
    int participants;
    double price;
    String link;
    long key;
    double accessibility;

    public String getActivity() {
        return activity;
    }

    public String getType() {
        return type;
    }

    public int getParticipants() {
        return participants;
    }

    public double getPrice() {
        return price;
    }

    public String getLink() {
        return link;
    }

    public long getKey() {
        return key;
    }

    public double getAccessibility() {
        return accessibility;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activity='" + activity + '\'' +
                ", type='" + type + '\'' +
                ", participants=" + participants +
                ", price=" + price +
                ", link='" + link + '\'' +
                ", key=" + key +
                ", accessibility=" + accessibility +
                '}';
    }
}
