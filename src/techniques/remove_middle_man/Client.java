package techniques.remove_middle_man;

public class Client {
    public static void main(String[] args) {
        Department itDept = new Department("IT", "Alice Manager");
        Employee emp1 = new Employee("E001", "Bob", itDept);
        System.out.println("Employee: " + emp1.getName());

        System.out.println("Department: " + emp1.getDepartment().getName());
        System.out.println("Department Manager: " + emp1.getDepartment().getManager());

        Department hrDept = new Department("HR", "Charlie Manager");
        Employee emp2 = new Employee("E002", "David", hrDept);
        System.out.println("Employee: " + emp2.getName());
        System.out.println("Department Manager: " + emp2.getDepartment().getManager());
    }
}
