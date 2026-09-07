import java.util.Scanner;

class SalaryTransformationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double basic = sc.nextDouble();

        double hra = basic * 0.20;  
        double da = basic * 0.10;    
        double ta = basic * 0.05;    

        double grossSalary = basic + hra + da + ta;


        double pf = basic * 0.12;    
        double tax = grossSalary * 0.05; 

        double netSalary = grossSalary - pf - tax;

        System.out.println("\n----- Salary Details -----");
        System.out.println("Employee Name : " + name);
        System.out.println("Basic Salary  : " + basic);
        System.out.println("HRA           : " + hra);
        System.out.println("DA            : " + da);
        System.out.println("TA            : " + ta);
        System.out.println("Gross Salary  : " + grossSalary);
        System.out.println("PF Deduction  : " + pf);
        System.out.println("Tax Deduction : " + tax);
        System.out.println("Net Salary    : " + netSalary);

        sc.close();
    }
}