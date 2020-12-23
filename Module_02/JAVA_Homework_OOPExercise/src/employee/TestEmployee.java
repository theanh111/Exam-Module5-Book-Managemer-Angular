package employee;

import employee.Employee;

public class TestEmployee {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Thai To", "Le",5000000);
        System.out.println(employee);
        System.out.println("Full Name: " + employee.getName());
        System.out.println("Salary a year: " + employee.getAnnualSalary());
        System.out.println("Salary raise: " + employee.raiseSalary(20));
    }
}
