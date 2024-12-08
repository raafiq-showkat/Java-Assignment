import java.util.*;

public class CommandLineCalculator {

    // Function to check if a string is an operator
    public static boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }

    // Function to define operator precedence
    public static int precedence(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }

    // Function to perform basic mathematical operations
    public static double applyOperation(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Division by zero error.");
                }
                return a / b;
            default:
                return 0;
        }
    }

    // Function to evaluate expressions using two stacks
    public static double evaluateExpression(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<String> operators = new Stack<>();

        // Tokenize the expression by spaces
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            if (Character.isDigit(token.charAt(0))) {
                // If token is a number, push it to the values stack
                values.push(Double.parseDouble(token));
            } else if (token.equals("(")) {
                // Push '(' to operators stack
                operators.push(token);
            } else if (token.equals(")")) {
                // Evaluate until corresponding '('
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    double val2 = values.pop();
                    double val1 = values.pop();
                    String operator = operators.pop();
                    values.push(applyOperation(val1, val2, operator));
                }
                if (!operators.isEmpty() && operators.peek().equals("(")) {
                    operators.pop();
                }
            } else if (isOperator(token)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)) {
                    double val2 = values.pop();
                    double val1 = values.pop();
                    String operator = operators.pop();
                    values.push(applyOperation(val1, val2, operator));
                }
                operators.push(token);
            }
        }

        // Perform remaining operations
        while (!operators.isEmpty()) {
            double val2 = values.pop();
            double val1 = values.pop();
            String operator = operators.pop();
            values.push(applyOperation(val1, val2, operator));
        }

        return values.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example expressions
        String[] expressions = {
            "5 + 3 * 2",
            "( 5 + 3 ) * 2",
            "10 + ( 6 - 4 ) * 2",
        };

        System.out.println("Command-Line Calculator");
        System.out.println("======================");

        for (String exp : expressions) {
            try {
                double result = evaluateExpression(exp);
                System.out.println("Expression: " + exp);
                System.out.println("Result: " + result);
                System.out.println();
            } catch (Exception e) {
                System.out.println("Error evaluating expression: " + exp);
            }
        }

        sc.close();
    }
}
