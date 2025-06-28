public class Doctor {
    private String id;
    private String name;
    private boolean available;

    public Doctor(String id, String name, boolean available) {
        this.id = id;
        this.name = name;
        this.available = available;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}

