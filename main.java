import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get grades for different components
        double assignmentGrade = getInput(scanner, "assignment");
        double quizGrade = getInput(scanner, "quiz");
        double midtermGrade = getInput(scanner, "midterm exam");
        double finalExamGrade = getInput(scanner, "final exam");

        // Calculate overall grade
        double overallGrade = calculateOverallGrade(assignmentGrade, quizGrade, midtermGrade, finalExamGrade);

        // Determine letter grade
        char letterGrade = getLetterGrade(overallGrade);

        // Display results
        System.out.println("\nYour overall grade is: " + overallGrade + "%");
        System.out.println("Your letter grade is: " + letterGrade);

        scanner.close();
    }

    public static double getInput(Scanner scanner, String componentName) {
        while (true) {
            try {
                System.out.print("Enter your " + componentName + " grade (0-100): ");
                double grade = scanner.nextDouble();

                // Validate the input is within range
                if (grade >= 0 && grade <= 100) {
                    return grade;
                } else {
                    System.out.println("Please enter a valid grade between 0 and 100.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Oops! That's not a valid number. Please try again.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    public static char getLetterGrade(double percentage) {
        if (percentage >= 90) {
            return 'A';
        } else if (percentage >= 80) {
            return 'B';
        } else if (percentage >= 70) {
            return 'C';
        } else if (percentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static double calculateOverallGrade(double assignmentGrade, double quizGrade, double midtermGrade, double finalExamGrade) {
        // Assign weights to each component
        double assignmentWeight = 0.2;
        double quizWeight = 0.1;
        double midtermWeight = 0.3;
        double finalExamWeight = 0.4;

        return (assignmentGrade * assignmentWeight) +
               (quizGrade * quizWeight) +
               (midtermGrade * midtermWeight) +
               (finalExamGrade * finalExamWeight);
    }
}
