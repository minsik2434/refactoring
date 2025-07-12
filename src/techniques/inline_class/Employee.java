package techniques.inline_class;

public class Employee {
    private String id;
    private String name;

    // 1. 우선 필드를 먼저 옮긴다
    private String street;
    private String city;
    private String zipCode;

    public Employee(String id, String name, String street, String city, String zipCode) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    //2. 위임 메서드를 실제 로직으로 변경한다
    public String getStreet(){
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getFullAddress() {
        return street + ", " + city + " " + zipCode;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("E001", "Alice", "123 Main St", "Anytown", "12345");
        System.out.println("Employee: " + emp1.getName());
        System.out.println("Address: " + emp1.getFullAddress());
        System.out.println("City: " + emp1.getCity());

        Employee emp2 = new Employee("E002", "Bob", "456 Oak Ave", "Otherville", "67890");
        System.out.println("Employee: " + emp2.getName());
        System.out.println("Address: " + emp2.getFullAddress());
    }
}
