import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Input the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Input scores for each subject
        int totalScore = 0;
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter the score for Subject " + i + ": ");
            int score = scanner.nextInt();
            totalScore += score;
        }

        // Calculate the average
        double average = (double) totalScore / numSubjects;

        // Assign letter grade based on the average
        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display the results
        System.out.println("\nResults:");
        System.out.println("Average Score: " + average);
        System.out.println("Grade: " + grade);

        // Close the scanner
        scanner.close();
    }
}
