class Employee {
    // Attributes
    private String name;
    private int id;
    private double basicSalary;
    private double grossSalary;

    // Constructor
    public Employee(String name, int id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
    }

    // Method to calculate gross salary
    public void calculateGrossSalary(double hraPercent, double allowancePercent) {
        double hra = (hraPercent / 100) * basicSalary;
        double allowances = (allowancePercent / 100) * basicSalary;
        grossSalary = basicSalary + hra + allowances;
    }

    // Method to apply a bonus
    public void applyBonus(double bonus) {
        grossSalary += bonus;
    }

    // Method to print updated salary details
    public void printSalaryDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("");
    }
}
public class EmployeeSalaryManagementSystem {
    public static void main(String[] args) {
        // Create multiple employee objects
        Employee emp1 = new Employee("Mubashir", 1, 100000);
        Employee emp2 = new Employee("Fahad", 2, 200000);
        Employee emp3 = new Employee("Shabahat", 3, 300000);

        // Calculate gross salary for each employee
        emp1.calculateGrossSalary(20, 10); // HRA: 20%, Allowances: 10%
        emp2.calculateGrossSalary(25, 15); // HRA: 25%, Allowances: 15%
        emp3.calculateGrossSalary(30, 20); // HRA: 30%, Allowances: 20%

        // Apply bonus
        emp1.applyBonus(5000); // Bonus for emp1
        emp2.applyBonus(7000); // Bonus for emp2
        emp3.applyBonus(10000); // Bonus for emp3

        // Print updated salary details
        System.out.println("Employee Salary Details:");
        System.out.println("");
        emp1.printSalaryDetails();
        emp2.printSalaryDetails();
        emp3.printSalaryDetails();
    }
}
