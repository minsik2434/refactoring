package techniques.hide_delegate;

public class Department {
    private String name;
    private String manager;

    public Department(String name, String manager) {
        this.name = name;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public String getManager() {
        return manager;
    }
}
