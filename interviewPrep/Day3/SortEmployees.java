package InterviewPrep.Day3;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class SortEmployees {

    public static void main(String args[]) {
        List<Employee> employeeList = Arrays.asList(
            new Employee("Aman", "IT", 50000, 28),
            new Employee("Rahul", "HR", 70000, 25),
            new Employee("AMAN", "IT", 50000, 22),
            new Employee("Zaid", "IT", 70000, 30),
            new Employee("Aman", "HR", 60000, 26)
        );

        // Sort by 
        // dept A-Z
        // Salary High-Low
        // Age low to High
        employeeList.sort(Comparator.comparing(Employee::getDepartment, String.CASE_INSENSITIVE_ORDER)
                            .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())
                            .thenComparing(Comparator.comparingInt(Employee::getAge)));

        System.out.println(employeeList);


        Collections.sort(employeeList, Comparator.comparingDouble(Employee::getSalary));

        System.out.println("Comparison by salary");

        System.out.println(employeeList);

        Collections.sort(employeeList, Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.println("Comparison by salary reversed order");

        System.out.println(employeeList);

        employeeList.sort(Comparator.comparing(Employee::getName, String.CASE_INSENSITIVE_ORDER));
        
        System.out.println("Comparison by Name");

        System.out.println(employeeList);

        Collections.sort(employeeList, Comparator.comparing(Employee::getName).reversed());

        System.out.println("Comparison by Name reversed");

        System.out.println(employeeList);

        // FIrst by name then by salary descending if same name

        Collections.sort(employeeList, Comparator.comparing(Employee::getName)
                    .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed()));       
        System.out.println(employeeList);

    }
}
