import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private double salary;
    private String department;

    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public int compareTo(Employee other) {
        // Сортировка по умолчанию: возрастанию возраста, по убыванию зарплаты, по наименованию отдела
        if (this.age != other.age) {
            return Integer.compare(this.age, other.age);
        } else if (this.salary != other.salary) {
            return Double.compare(other.salary, this.salary);
        } else {
            return this.department.compareTo(other.department);
        }
    }

    public static class AgeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            // Сортировка по возрасту (возрастанию)
            return Integer.compare(e1.age, e2.age);
        }
    }

    public static class SalaryComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            // Сортировка по зарплате (убыванию)
            return Double.compare(e2.salary, e1.salary);
        }
    }
}

public class Homework {
    public static void main(String[] args) {
        // Создаем список из разных сотрудников
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 30, 5000.0, "Sales"));
        employees.add(new Employee("Alice", 25, 6000.0, "Marketing"));
        employees.add(new Employee("Bob", 350, 4000.0, "IT"));
        employees.add(new Employee("Bab", 135, 300.0, "IT"));
        employees.add(new Employee("Bib", 335, 2000.0, "IT"));
        employees.add(new Employee("Boob", 351, 1000.0, "IT"));
        employees.add(new Employee("Alice Cooper", 250, 8000.0, "Marketing"));
        // Добавьте остальные сотрудники сюда...

        // Сортируем список по умолчанию
        Collections.sort(employees);

        // Выводим список на консоль
        for (Employee employee : employees) {
            System.out.println(employee.getName() + ", " + employee.getAge() + ", " + employee.getSalary() + ", " + employee.getDepartment());
        }

        System.out.println("------age");

        // Сортируем список по возрасту
        Collections.sort(employees, new Employee.AgeComparator());

        // Выводим список на консоль
        for (Employee employee : employees) {
            System.out.println(employee.getName() + ", " + employee.getAge() + ", " + employee.getSalary() + ", " + employee.getDepartment());
        }

        System.out.println("------Salary");

        // Сортируем список по зарплате
        Collections.sort(employees, new Employee.SalaryComparator());

        // Выводим список на консоль
        for (Employee employee : employees) {
            System.out.println(employee.getName() + ", " + employee.getAge() + ", " + employee.getSalary() + ", " + employee.getDepartment());
        }
    }
}