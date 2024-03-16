import javax.swing.*;

public class TwoNumber {
	public static void main(String[] args) {
		String strNum1, strNum2;
		strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number",
				JOptionPane.INFORMATION_MESSAGE);
		double num1 = Double.parseDouble(strNum1);
		strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number",
				JOptionPane.INFORMATION_MESSAGE);
		double num2 = Double.parseDouble(strNum2);
		double sum = num1 + num2;
		double difference = Math.abs(num1 - num2);
		double product = num1 * num2;
		double quotient1 = num1 / num2;
		double quotient2 = num2 / num1;
		System.out.println("sum: " + sum);
		System.out.println("difference: " + difference);
		System.out.println("product: " + product);
		System.out.println("quotient1: " + quotient1);
		System.out.println("quotient2: " + quotient2);
		System.exit(0);
	}
}