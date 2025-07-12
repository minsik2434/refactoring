package techniques.remove_middle_man;

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

    public Department getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

}

