package techniques.replace_primitive_with_object;

public class Client {
    public static void main(String[] args) {
        Employee employee = new Employee("Alice", 70000.0);
        System.out.println("Employee Name : " + employee.getName());
        System.out.println("employee salary = " + employee.getSalary());

        employee.setSalary(new Money(8000.0));
        System.out.println("Update Salary:" + employee.getSalary());
    }
}
