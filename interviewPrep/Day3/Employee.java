package InterviewPrep.Day3;

public class Employee {
    private String name;
    private double salary;
    private String department;
    private int age;

    public Employee(String name, String department, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public int getAge() {
        return this.age;
    }

    public String getDepartment() {
        return this.department;
    }

    public String toString() {
        return "Name: " + this.name + ", Salary: " + this.salary + ", Department: " 
            + this.department + ", Age: " + this.age + "\n";
    }
}
