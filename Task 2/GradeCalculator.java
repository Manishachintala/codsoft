import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();
        
        // Validate number of subjects
        if (numSubjects <= 0) {
            System.out.println("Please enter a valid number of subjects.");
            sc.close();  // Close the scanner before exiting
            return;
        }
        
        int totalMarks = 0;
        int maxMarksPerSubject = 100;
        
        // Loop to get marks for each subject
        for (int i = 1; i <= numSubjects; i++) {
            int marks = -1; // Initialize marks with an invalid value
            // Repeat until valid marks are entered
            while (marks < 0 || marks > maxMarksPerSubject) {
                System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
                marks = sc.nextInt();
                
                // Validate marks input
                if (marks < 0 || marks > maxMarksPerSubject) {
                    System.out.println("Marks should be in the range of 0 to 100. Please enter valid marks.");
                }
            }
            
            totalMarks += marks; // Accumulate total marks
        }
        
        // Calculate and display the result
        double averageMarks = (double) totalMarks / numSubjects;
        System.out.println("Total marks obtained: " + totalMarks + " out of " + (numSubjects * maxMarksPerSubject));
        System.out.println("Average marks: " + averageMarks);
        
        // Close the scanner after use
        sc.close();
    }
}

