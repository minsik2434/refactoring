package techniques.combinefunctionsintotransform;

public class DataRecord {
    private String firstName;
    private String lastName;
    private int birthYear;

    public DataRecord(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }
}
