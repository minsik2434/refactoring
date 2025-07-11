package techniques.encapsulate_record;

public class Position {
    private String title;
    private String department;

    public Position(String title, String department) {
        this.title = title;
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }
}
