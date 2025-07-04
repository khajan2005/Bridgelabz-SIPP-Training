import java.util.*;
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
}

interface Department {
    void assignDepartment(String department);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    public double calculateSalary() {
        return getBaseSalary();
    }

    public void assignDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentDetails() {
        return department;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Department: " + getDepartmentDetails());
    }
}

class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int workHours;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int workHours) {
        super(employeeId, name, baseSalary);
        this.workHours = workHours;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public double calculateSalary() {
        return getBaseSalary() * workHours;
    }

    public void assignDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentDetails() {
        return department;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Work Hours: " + workHours);
        System.out.println("Department: " + getDepartmentDetails());
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee fte = new FullTimeEmployee(1, "Alice", 5000);
        fte.assignDepartment("HR");
        employees.add(fte);

        PartTimeEmployee pte = new PartTimeEmployee(2, "Bob", 20, 80);
        pte.assignDepartment("IT");
        employees.add(pte);

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println();
        }
    }
}
