import java.util.Scanner;

public class DaysInMonth {
    public static int getMonthNumber(String monthName) {
        if (monthName.startsWith("jan")) {
            return 1;
        } else if (monthName.startsWith("feb")) {
            return 2;
        } else if (monthName.startsWith("mar")) {
            return 3;
        } else if (monthName.startsWith("apr")) {
            return 4;
        } else if (monthName.startsWith("may")) {
            return 5;
        } else if (monthName.startsWith("jun")) {
            return 6;
        } else if (monthName.startsWith("jul")) {
            return 7;
        } else if (monthName.startsWith("aug")) {
            return 8;
        } else if (monthName.startsWith("sep")) {
            return 9;
        } else if (monthName.startsWith("oct")) {
            return 10;
        } else if (monthName.startsWith("nov")) {
            return 11;
        } else if (monthName.startsWith("dec")) {
            return 12;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the month (e.g., January, Jan, 1): ");
        String monthInput = scanner.nextLine().toLowerCase();
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        
        int monthNumber = getMonthNumber(monthInput);

        int daysInMonth;

        switch (monthNumber) {
            case 1, 3, 5, 7, 8, 10, 12:
                daysInMonth = 31;
                break;
            case 4, 6, 9, 11:
                daysInMonth = 30;
                break;
            case 2:
                if (year % 4 == 0) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
            default:
                System.out.println("Please enter a valid month (e.g., January, Jan, 1).");
                return;
        }

        System.out.println("Number of days in " + monthInput + " " + year + ": " + daysInMonth);
        
        scanner.close();

        System.exit(0);
    }
}
