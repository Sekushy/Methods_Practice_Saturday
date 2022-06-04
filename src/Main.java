import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static ArrayList<Integer> convertDateToInt(String date) {
        ArrayList<Integer> splitDate = new ArrayList<>();

        String[] formattedDate = date.split("-");
        int day = Integer.parseInt(formattedDate[0]);
        int month = Integer.parseInt(formattedDate[1]);
        int year = Integer.parseInt(formattedDate[2]);

        splitDate.add(day);
        splitDate.add(month);
        splitDate.add(year);

        return splitDate;
    }
    public static String getCurrentDate() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String currentDate = date.format(formatter);
        return currentDate;
    }
    public static int getUserAge(String birthDate) {
        ArrayList<Integer> formattedBirthDate = convertDateToInt(birthDate);
        ArrayList<Integer> formattedCurrentDate = convertDateToInt(getCurrentDate());

        int age = 0;

        age = formattedCurrentDate.get(2) - formattedBirthDate.get(2);

        if (formattedCurrentDate.get(1) < formattedBirthDate.get(1)) {
            age--;
        } else if (formattedCurrentDate.get(1) == formattedBirthDate.get(1)) {
            if (formattedCurrentDate.get(0) < formattedBirthDate.get(0)) {
                age--;
            }
        }
        return age;
    }
    public static void printChineseZodiacSign(String birthDate) {
        // ArrayList<Integer> date = convertDateToInt(birthDate);
        // int year = date.get(2);

        // Linia de mai jos este forma mai scurta a celor doua linii de sus (50, 51)
        int year = convertDateToInt(birthDate).get(2);

        switch (year % 12) {
            case 0:
                System.out.println("Your zodiac is monkey");
                break;
            case 1:
                System.out.println("Your zodiac is rooster");
                break;
            case 2:
                System.out.println("Your zodiac is dog");
                break;
            case 3:
                System.out.println("Your zodiac is pig");
                break;
            case 4:
                System.out.println("Your zodiac is rat");
                break;
            case 5:
                System.out.println("Your zodiac is ox");
                break;
            case 6:
                System.out.println("Your zodiac is tiger");
                break;
            case 7:
                System.out.println("Your zodiac is rabbit");
                break;
            case 8:
                System.out.println("Your zodiac is dragon");
                break;
            case 9:
                System.out.println("Your zodiac is snake");
                break;
            case 10:
                System.out.println("Your zodiac is horse");
                break;
            case 11:
                System.out.println("Your zodiac is goat");
                break;
        }
    }
    public static void printZodiacSign(String birthDate) {
        ArrayList<Integer> formattedDate = convertDateToInt(birthDate);
        int day = formattedDate.get(0);
        int month = formattedDate.get(1);

        switch (month) {
            case 1:
                if (day <= 20) {
                    System.out.println("Capricorn");
                } else {
                    System.out.println("Aquarius");
                }
                break;
            case 2:
                if (day <= 18) {
                    System.out.println("Aquarius");
                } else {
                    System.out.println("Pisces");
                }
                break;
            case 3:
                if (day <= 19) {
                    System.out.println("Pisces");
                } else {
                    System.out.println("Aries");
                }
                break;
        }
        // TODO: Complete the zodiac based on the information you have on the above code
        // Zodiac dates reference: https://en.wikipedia.org/wiki/Zodiac
    }
    public static double getUserBMIRating(double weight, double height) {
        double bmi = (weight * weight) / height;
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("Normal weight");
        } else if (bmi >= 25 && bmi < 29.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
        return bmi;
    }
    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.2;
    }
    public static double convertCentimetersToInch(double length) {
        return length / 2.54;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please input your birthday (dd-MM-yyyy): ");
        String birthDate = sc.nextLine();
        System.out.println("Please input your height (cm): ");
        double height = sc.nextDouble();

        System.out.println("Please input your weight (kg): ");
        double weight = sc.nextDouble();

        int age = getUserAge(birthDate);
        System.out.println("Your age is: " + age);
        printChineseZodiacSign(birthDate);
        printZodiacSign(birthDate);
        getUserBMIRating(weight, height);
        System.out.println("Your height in inches: " + convertCentimetersToInch(height));
        System.out.println("Your weight in pounds: " + convertKilogramsToPounds(weight));
    }
}
