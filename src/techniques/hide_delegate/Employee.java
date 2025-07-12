package techniques.hide_delegate;

public class Employee {
    private String id;
    private String name;
    private Department department;

    public Employee(String id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentName() {
        return department.getName();
    }

    public String getDepartmentManager() {
        return department.getManager();
    }
}

