package techniques.extract_class;

public class Employee {
    private String id;
    private String name;
    private String department;
    private String positionTitle;
    private int yearsOfExperience;

    //새로운 클래스의 인스턴스를 필드에 추가
    private SalaryDetails salaryDetails;
    public Employee(String id, String name, String department, double baseSalary, double bonusRate, String positionTitle, int yearsOfExperience) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.positionTitle = positionTitle;
        this.yearsOfExperience = yearsOfExperience;
        this.salaryDetails = new SalaryDetails(baseSalary, bonusRate);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void displayPositionDetails(){
        System.out.println("Position: " + positionTitle + ", Experience: " + yearsOfExperience + " years");
    }

    // 위임 메서드
    public void setBonusRate(double bonusRate){
        this.salaryDetails.setBonusRate(bonusRate);
    }

    //위임 메서드
    public double calculateAnnualSalary(){
        return salaryDetails.calculateAnnualSalary();
    }

    public void displayEmployeeInfo(){
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department);
        System.out.println("Base Salary: " + salaryDetails.getBaseSalary() + ", Bonus Rate: " + (salaryDetails.getBonusRate() * 100) + "%");
        displayPositionDetails();
        System.out.println("Annual Salary: " + salaryDetails.calculateAnnualSalary());
        System.out.println("---");
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("E001", "Alice", "IT", 50000.0, 0.1, "Software Engineer", 5);
        Employee emp2 = new Employee("E002", "Bob", "HR", 60000.0, 0.05, "HR Manager", 10);

        emp1.displayEmployeeInfo();
        emp2.displayEmployeeInfo();

        emp1.setBonusRate(0.15); // 보너스율 변경
        System.out.println("Alice's new annual salary: " + emp1.calculateAnnualSalary());
    }
}
