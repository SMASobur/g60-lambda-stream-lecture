package se.lexicon.stream;

import se.lexicon.functional_lambda.Todo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamAPIDemo {
    void main() {
        //Predicate<Integer> isEven = number -> number % 2 == 0;
        List<Integer> numbers = List.of(-2,-1,1, 2, 3, 4, 5,6,7,8,9,10);

        List<Integer> evenNumbers = numbers.stream()
                //.filter(isEven)
                .filter(number-> number % 2 ==0)
                .toList();
        System.out.println(evenNumbers);

        Predicate<Integer> isOdd = n -> n % 2 != 0;
        List<Integer> oddNumbers = numbers.stream()
                .filter(isOdd)
                .toList();
        System.out.println(oddNumbers);


        List<Employee> employees = Arrays.asList(
                new Employee("Anna", "Engineering", 30, 60000),
                new Employee("Erik", "Engineering", 35, 70000),
                new Employee("Karin", "HR", 28, 50000),
                new Employee("Lars", "HR", 40, 45000),
                new Employee("Sofia", "Finance", 32, 65000),
                new Employee("Gustav", "Finance", 25, 55000),
                new Employee("Ingrid", "Engineering", 45, 80000),
                new Employee("Oskar", "Engineering", 29, 62000),
                new Employee("Maja", "HR", 33, 52000),
                new Employee("Nils", "Finance", 38, 68000),
                new Employee("Astrid", "Engineering", 27, 58000),
                new Employee("Sven", "HR", 42, 47000),
                new Employee("Elin", "Finance", 31, 64000),
                new Employee("Johan", "Engineering", 36, 72000),
                new Employee("Linnea", "HR", 26, 48000)
        );


        // Filter employees in the "Engineering" department earning more than 60k
        System.out.println("\n--- Employees in the Engineering department earning more than 60k ---");
        List<Employee> filteredList = employees.stream()
                .filter((employee -> employee.getDepartment().equals("Engineering")))
                .filter(employee -> employee.getSalary()> 60000)
                .toList();
        filteredList.forEach(employee -> System.out.println("Employee: " + employee));

        // Get Employee names and sorted by salary
        System.out.println("\n--- Get Employee names and sorted by salary ---");

        List<String> namesSortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(employee-> employee.getSalary()))
                .map(employee -> employee.getName())
                .toList();
        namesSortedBySalary.forEach(name -> System.out.println("Name: " + name));



        System.out.println("\n--- Calculate total salary expense ---");
        double totalSalaryExpense = employees.stream()
                .mapToDouble(employee -> employee.getSalary())
                .sum();
        System.out.println("Total salary expense: " + totalSalaryExpense);


        //TODO: Counting the total number of employees in the list.
        System.out.println("\n---  Total number of employees ---");
        long totalEmployees = employees.stream()
                .count();
        System.out.println("Total employees: "+ totalEmployees);

        //Alternative way
        int totalEmployees1 = employees.size();
        System.out.println("Total Emplayees: "+ totalEmployees1);

        //TODO: Get unique departments
    }
}
