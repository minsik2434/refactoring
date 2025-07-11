package techniques.encapsulate_record;

public class EmployeeData {
    public static Employee getEmployeeRecord(String employeeId){
        if ("E001".equals(employeeId)) {
            Position position = new Position("Software Engineer", "Engineering");
            return new Employee("E001", "Alice", position, 70000);
        } else if ("E002".equals(employeeId)) {
            Position position = new Position("Project Manager", "Product Development");
            return new Employee("E002", "Bob", position, 85000);
        }
        return null;
    }

    public static void main(String[] args) {
        Employee employee1 = getEmployeeRecord("E001");
        if (employee1 != null) {
            System.out.println("Employee1 Annual Salary: " + employee1.calculateAnnualSalary());
            employee1.displayInfo();
        }
    }
}
