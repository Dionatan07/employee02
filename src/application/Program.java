package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = teclado.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Employee #" + i + " data: ");
            System.out.print("Outsourced (y/n)? ");
            char response = teclado.next().charAt(0);
            System.out.print("Name: ");
            teclado.nextLine();
            String name = teclado.nextLine();
            System.out.print("Hours: ");
            Integer hours = teclado.nextInt();
            System.out.print("Value per hour: ");
            Double valuePerHour = teclado.nextDouble();

            if (response == 'y') {
                System.out.print("Additional charge: ");
                Double additionalCharge = teclado.nextDouble();

                list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            } else {
                list.add(new Employee(name, hours, valuePerHour));
            }
        }
        System.out.println();
        System.out.println("PAYMENTS: ");
        for (Employee emp : list) {
            System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));

        }


    }
}
