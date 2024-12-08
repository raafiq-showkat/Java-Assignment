import java.util.Scanner;

public class StringManipulationToolkit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== String Manipulation Toolkit ===");
            System.out.println("1. Reverse a String");
            System.out.println("2. Convert to Uppercase");
            System.out.println("3. Convert to Lowercase");
            System.out.println("4. Check for Palindrome");
            System.out.println("5. Count Vowels and Consonants");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            choice = in.nextInt();
            in.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter a string to reverse: ");
                    String str1 = in.nextLine();
                    System.out.println("Reversed String: " + reverseString(str1));
                    break;
                case 2:
                    System.out.print("Enter a string to convert to uppercase: ");
                    String str2 = in.nextLine();
                    System.out.println("Uppercase String: " + str2.toUpperCase());
                    break;
                case 3:
                    System.out.print("Enter a string to convert to lowercase: ");
                    String str3 = in.nextLine();
                    System.out.println("Lowercase String: " + str3.toLowerCase());
                    break;
                case 4:
                    System.out.print("Enter a string to check for palindrome: ");
                    String str4 = in.nextLine();
                    if (isPalindrome(str4)) {
                        System.out.println("The string is a palindrome.");
                    } else {
                        System.out.println("The string is not a palindrome.");
                    }
                    break;
                case 5:
                    System.out.print("Enter a string to count vowels and consonants: ");
                    String str5 = in.nextLine();
                    countVowelsAndConsonants(str5);
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        in.close();
    }

    // Reverse a string
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    // Check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        String reversed = reverseString(str);
        return str.equalsIgnoreCase(reversed);
    }

    // Count vowels and consonants in a string
    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        String lowerCaseStr = str.toLowerCase();

        for (char ch : lowerCaseStr.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
