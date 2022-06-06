import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*
    In Java, o metoda trebuie sa respecte urmatoarea structura
    MODIFICATOR ACCESS -> public, private, protected (pentru ce faceti acum, folosim doar public)
    TIPUL DE RETURNARE -> reprezinta ce tip de date are variabila data la return si poate fi ORICE variabila
                       -> in cazul in care nu doriti a returna ceva, atunci tipul este void
    NUMELE METODEI -> un nume care sa denote intentia si care, de preferat, sa fie un verb
     */


    /**
     * Metoda proceseaza un format de data (dd-MM-yyyy ex: 01-11-2001, 31-10-1976) si il converteste din string intr-o lista de numere intregi
     * @param date - o data de forma dd-MM-yyyy
     * @return o lista de numere intregi unde prima pozitie este ziua, a doua este luna iar a treia este anul
     */
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

    /**
     * Metoda o sa returneze un string in forma dd-MM-yyyy folosid data curenta de la momentul apelari
     * @return - un string cu data de la momentul apelari
     */
    public static String getCurrentDate() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String currentDate = date.format(formatter);
        return currentDate;
    }

    /**
     * Metoda calculeaza varsta utilizatorului prin a scadea initial anul curent - anul nasterii
     * iar apoi verifica daca luna curenta este mai mica in comparatie cu luna primita din data nasterii
     * caz in care, scade cu 1 anul obtinut din calcul initial al anului curent si cel al nasterii (deoarece
     * utilizatul nu si-a sarbatorit inca ziua de nastere in anul curent) altfel daca lunile sunt egale,
     * trebuie sa aplicam aceasi logica si pentru a verifica daca utilizatorul si-a sarbatorit deja ziua de nastere
     * sau nu, in luna respectiva.
     * @param birthDate - un string de forma dd-MM-yyyy
     * @return - un integer care reprezinta varsta
     */
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

    /**
     * Metoda verifica anul nasterii iar apoi afla zodia utilizatorului folosind zodiacul chinezesc
     * Pentru mai multe info referitor la determinarea zodiei: https://en.wikipedia.org/wiki/Chinese_zodiac
     * @param birthDate - trimitem data in dd-MM-yyyy ca string
     */
    public static void printChineseZodiacSign(String birthDate) {
        // ArrayList<Integer> date = convertDateToInt(birthDate);
        // int year = date.get(2);

        // Linia de mai jos este forma mai scurta a celor doua linii de sus (80, 81)
        int year = convertDateToInt(birthDate).get(2);

        // Vom lua anul introdus de utilizator si apoi il vom imparti la 12 SI VOM VERIFICA RESTUL! Nu rezultatul
        // Ex: 2016 / 12 => 168 si rest 0 deci o sa intre pe case 0 -> Monkey
        // Ex: 2018 / 12 => 168 si rest 2 deci o sa intre pe case 2 -> Dog

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
        // TODO: Completati zodiacul pe baza informatiilor de mai sus
        // Zilele zodiacului pot fi gasite aici: https://en.wikipedia.org/wiki/Zodiac
    }

    /**
     * Metoda o sa calculeze BMI-ul (Body Mass Index https://en.wikipedia.org/wiki/Body_mass_index)
     * si printeaza un mesaj cu categoria in care utilizatorul se incadreaza
     * @param weight - greutatea utilizatorului in KG
     * @param height - inaltimea utilizatorului in CM
     * @return - Indexul de masa corporala exprimat intr-un double
     */
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

    /**
     * Metoda o sa faca conversia unui numar de KG primit in Pounds pe baza formulei de conversie
     * Un pound are valoarea de 2.2 KG
     * @param kilograms - unitatea dorita a fi convertita
     * @return - valoarea in pounds reprezentata cu un double
     */
    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.2;
    }

    /**
     * Metoda o sa faca conversia unui numar de CM primit, in Inch pe baza formulei de conversie
     * Un inch are valoarea de 2.54 CM
     * @param length - unitatea dorita a fi convertita
     * @return - valoarea in inch reprezentata cu un double
     */
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
