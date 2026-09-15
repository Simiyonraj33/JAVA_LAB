import java.util.Scanner;

class Salary {
    int id, age;
    String name, dept, gender, city;
    float da, hra, netSalary, grossSalary, tax, basicPay;
    Scanner sc = new Scanner(System.in);

    public void inputDetails() {
        System.out.print("Enter your Id: ");
        id = sc.nextInt();
        System.out.print("Enter your Name: ");
        name = sc.next();
        System.out.print("Enter Age: ");
        age = sc.nextInt();
        System.out.print("Enter Gender: ");
        gender = sc.next();
        System.out.print("Enter Department: ");
        dept = sc.next();
        System.out.print("Enter City: ");
        city = sc.next();
        System.out.print("Enter Basic Pay: ");
        basicPay = sc.nextFloat();
    }

    public void calculateSalary() {
        da = 0.3f * basicPay;
        hra = 0.2f * basicPay;
        grossSalary = basicPay + da + hra;
        if (grossSalary > 100000) {
            tax = 0.1f * basicPay;
        } else {
            tax = 0;
        }
        netSalary = grossSalary - tax;
    }

    public void display() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Name: " + name);
        System.out.println("Id: " + id);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Department: " + dept);
        System.out.println("City: " + city);
        System.out.println("Basic Pay: " + basicPay);
        System.out.println("DA: " + da);
        System.out.println("HRA: " + hra);
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("Tax: " + tax);
        System.out.println("Net Salary: " + netSalary);
    }
}

public class Employee {
    public static void main(String[] args) {
        Salary s = new Salary();
        s.inputDetails();  
        s.calculateSalary();
        s.display();
        
    }
}