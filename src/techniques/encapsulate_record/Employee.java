package techniques.encapsulate_record;

import java.util.Map;

public class Employee {
    private String id;
    private String name;
    private Position position;
    private double salary;

    public Employee(String id, String name, Position position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public double calculateAnnualSalary(){
        return this.salary * 12;
    }

    public void displayInfo(){
        System.out.println("ID: " + this.id + ", Name: " + this.name + ", Position: " + this.position.getTitle() + "," + this.position.getDepartment());
    }
}
