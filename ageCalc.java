package classwork;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class ageCalc{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your date of birth (yyyy/mm/dd): ");
        String dob = scanner.nextLine();

        
        String[] dobParts = dob.split("/");

        
        int year = Integer.parseInt(dobParts[0]);
        int month = Integer.parseInt(dobParts[1]);
        int day = Integer.parseInt(dobParts[2]);

        
        LocalDate currentDate = LocalDate.now();

        
        LocalDate birthDate = LocalDate.of(year, month, day);


        Period age = Period.between(birthDate, currentDate);

        // Output the age to the user
        System.out.println("You are " + age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days old.");
    }
}
