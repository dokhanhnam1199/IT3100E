import java.util.Scanner;

public class EquationSolver {

    public static void firstDegree(double a, double b) {
        if (a != 0) {
            double solution = -b / a;
            System.out.println("The solution is x = " + solution);
        } else if (b != 0) {
            System.out.println("The equation has no solution.");
        } else {
            System.out.println("The equation has infinitely many solutions.");
        }
    }

    public static void twoVariables(double a1, double b1, double c1, double a2, double b2, double c2) {
        double determinant = a1 * b2 - a2 * b1;

        if (determinant != 0) {
            double x = (c1 * b2 - c2 * b1) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            System.out.println("The solution is x = " + x + ", y = " + y);
        } else if (a1 * c2 == a2 * c1) {
            System.out.println("The system has infinitely many solutions.");
        } else {
            System.out.println("The system has no solution.");
        }
    }

    public static void secondDegree(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The roots are x1 = " + root1 + " and x2 = " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("The equation has one double root x = " + root);
        } else {
            System.out.println("The equation has no real roots.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter coefficients for the first-degree equation (ax + b = 0):");
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();

        firstDegree(a, b);

        System.out.println("\nEnter coefficients for the system of equations:");
        System.out.print("a1: ");
        double a1 = scanner.nextDouble();
        System.out.print("b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("c1: ");
        double c1 = scanner.nextDouble();
        System.out.print("a2: ");
        double a2 = scanner.nextDouble();
        System.out.print("b2: ");
        double b2 = scanner.nextDouble();
        System.out.print("c2: ");
        double c2 = scanner.nextDouble();

        twoVariables(a1, b1, c1, a2, b2, c2);

        System.out.println("\nEnter coefficients for the second-degree equation (ax^2 + bx + c = 0):");
        System.out.print("a: ");
        a = scanner.nextDouble();
        System.out.print("b: ");
        b = scanner.nextDouble();
        System.out.print("c: ");
        double c = scanner.nextDouble();

        while (a == 0) {
            System.out.println("Coefficient 'a' cannot be zero for a second-degree equation.");
            System.out.print("a: ");
            a = scanner.nextDouble();
            System.out.print("b: ");
            b = scanner.nextDouble();
            System.out.print("c: ");
            c = scanner.nextDouble();
        }

        secondDegree(a, b, c);

        scanner.close();
        System.exit(0);
    }
}