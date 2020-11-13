package com.Jonathan;

import java.text.NumberFormat;
import java.util.Scanner;

public class Project_mortgage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("quit")) {
            System.out.println("Hello and welcome to your mortgage calculator. \nType \"go\" to start and \"quit\" to finish.");
            System.out.print("Input: ");
            input = scanner.next().toLowerCase();
            if (input.equals("quit"))
                break;

            if (input.equals("go")) {

                int principal = 0;
                float rate = 0;
                float r = 0;
                byte years = 0;
                int n = 0;

                while (true) {
                    System.out.print("Principal (£1K - £1M): ");
                    principal = scanner.nextInt();
                    if (principal < 1000 || principal > 1_000_000) {
                        System.out.println("Please enter a value between 1000 and 1,000,000.");
                        continue;
                    } else {
                        break;
                    }
                }

                while (true) {
                    System.out.print("Annual Interest Rate: ");
                    rate = scanner.nextFloat();
                    if (rate <= 0 || rate > 30) {
                        System.out.println("Please enter a value greater than 0 and less than 30.");
                        continue;
                    } else {
                        r = (rate / 100) / 12;
                        break;
                    }

                }

                while (true) {
                    System.out.print("Period (years): ");
                    years = scanner.nextByte();
                    if (years < 1 || years > 30){
                        System.out.println("Please enter a value between 1 and 30.");
                        continue;
                    } else {
                        n = years * 12;
                        break;
                    }

                }

                double top = r * (Math.pow(1 + r, n));
                double bottom = (Math.pow(1 + r, n)) - 1;

                double mortgage = principal * (top / bottom);
                String result = NumberFormat.getCurrencyInstance().format(mortgage);


                System.out.println("Mortgage: " + result + "\nIf you would like to calculate another mortgage please type 1 however if you would like to quit please type 2");
                int again = scanner.nextInt();
                if (again == 1) {
                    continue;
                } else if (again == 2) {
                    break;
                }
            }
        }

    }
}
