package bryanze.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizelin
 * @date 2024/11/21
 */
public class aa {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        //write your code here......
        Employee ming = new Employee("小明", 2500);
        Employee jun = new Employee("小军", 8000);
        Employee hong = new Employee("小红", 100000);
        employees.add(ming);
        employees.add(jun);
        employees.add(hong);
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            double res = dfs(employee);
            System.out.print(employee.getName() + "应该缴纳的个人所得税是: ");
            System.out.printf("%.1f", res);
            if (i < employees.size() - 1) {
                System.out.println();
            }
        }
    }

    public static double dfs(Employee user){
        double income = user.getSalary();
        double tax = 0.0;
        double taxableIncome = income - 3500;

        if (taxableIncome <= 0) {
            tax = 0.0;
        } else if (taxableIncome <= 1500){
            tax = taxableIncome * 0.03 - 0;
        } else if (taxableIncome <= 4500) {
            tax = taxableIncome * 0.1 - 105;
        }else if (taxableIncome <= 9000) {
            tax = taxableIncome * 0.2 - 555;
        }else if (taxableIncome <= 35000) {
            tax = taxableIncome * 0.25 - 1005;
        }else if (taxableIncome <= 55000) {
            tax = taxableIncome * 0.3 - 2755;
        }else if (taxableIncome <= 80000) {
            tax = taxableIncome * 0.35 - 5505;
        }else  {
            tax = taxableIncome * 0.45 - 13505;
        }
        //System.out.println(tax);
        return tax;
    }
}
class Employee{
    private String name;
    private double salary;
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}