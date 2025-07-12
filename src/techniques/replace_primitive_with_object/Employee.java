package techniques.replace_primitive_with_object;

public class Employee {
    private String name;
    private Money salary;

    public Employee(String name, double salaryAmount) {
        this.name = name;
        this.salary = new Money(salaryAmount);
    }

    public String getName() {
        return name;
    }

    public Money getSalary() {
        return salary;
    }

    public void setSalary(Money salary){
        this.salary = salary;
    }
}
