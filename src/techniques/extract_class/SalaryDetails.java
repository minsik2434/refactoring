package techniques.extract_class;

public class SalaryDetails {
    private double baseSalary;
    private double bonusRate;

    public SalaryDetails(double baseSalary, double bonusRate) {
        this.baseSalary = baseSalary;
        this.bonusRate = bonusRate;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBonusRate() {
        return bonusRate;
    }

    public void setBonusRate(double bonusRate) {
        this.bonusRate = bonusRate;
    }

    public double calculateAnnualSalary(){
        return baseSalary * (1 + bonusRate);
    }
}
