
import java.util.Random;

/*
 * GradeBook class
 * Used to demonstrate two-dimensional arrays
 * From "Java How To Program, 10/e, Early Objects" - Chapter 7.
 */


public class GradeBook {
    private int[][] grades; //2D array holding an array of grades for each student
    private String courseName;  //Name of the course
    
    //Constructor
    public GradeBook (String courseName, int numStudents, int numGrades) {
        this.courseName = courseName;
        grades = new int[numStudents][numGrades];
    }

    public void showGrades() {
        for (int i = 0; i < grades.length; i++) {  //For loop for each student
            System.out.printf("Grades for student %d ", i+1);
            for (int grade : grades[i]) {  //For loop on each inner array of grades
                System.out.printf("%3d ",grade);
            }
            System.out.printf("Average: %3.2f", calcAverage(grades[i]));
            System.out.println();
        }
    }
    
    public double calcAverage(int[] gradesToAve) {
        int total = 0;
        for (int grade : gradesToAve) {
            total += grade;
        }
        
        return ((double) total / gradesToAve.length);
    }
    
    public static void main(String[] args) {
        String testCourseName = "Test Course";
        int numStudents = 5; //Number of students
        int numGrades = 10; //Number of grades for each student
        
        GradeBook testGradeBook = new GradeBook(testCourseName, numStudents, numGrades);
        
        //Randomly generate a set of grades
        Random randNum = new Random();
        for (int i = 0; i < testGradeBook.grades.length; i++) {
            for (int j = 0; j < testGradeBook.grades[i].length; j++) {
                testGradeBook.grades[i][j] = randNum.nextInt(101);
            }
        }
        
        testGradeBook.showGrades();
    }
    
}
