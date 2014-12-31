
import java.util.Random;

/*
 * GradeBook class
 * Used to demonstrate two-dimensional arrays
 * Based on "Java How To Program, 10/e, Early Objects" - Chapter 7.
 */

public class GradeBook {
    private int[][] grades; //2D array holding an array of grades for each student
    private String courseName;  //Name of the course
    
    //Constructor
    public GradeBook(String courseName, int numStudents, int numGrades) {
        this.courseName = courseName;
        grades = new int[numStudents][numGrades];
    } //End constructor
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    } //End setCourseName
    
    public String getCourseName() {
        return this.courseName;
    } //End getCourseName

    public void showGrades() {
        System.out.println("Course: " + this.courseName);
        //For loop for each student
        for (int i = 0; i < grades.length; i++) {
            System.out.printf("Grades for student %d ", i+1);
            //For loop on each inner array of grades
            for (int grade : grades[i]) {  
                System.out.printf("%3d ", grade);
            }
            
            System.out.printf("Average: %3.2f", calcAverage(grades[i]));
            System.out.println();
        }
    } //End showGrades
    
    public double calcAverage(int[] gradesToAve) {
        int total = 0;
        for (int grade : gradesToAve) {
            total += grade;
        }
        
        return ((double) total / gradesToAve.length);
    } //End calcAverage
    
    public static void main(String[] args) {
        String testCourseName = "Test Course";
        int numStudents = 5; //Number of students
        int numGrades = 10; //Number of grades for each student
        
        GradeBook testGradeBook = new GradeBook(testCourseName, numStudents, 
                numGrades);
        
        //Randomly generate a set of grades
        Random randNum = new Random();
        for (int i = 0; i < testGradeBook.grades.length; i++) {
            for (int j = 0; j < testGradeBook.grades[i].length; j++) {
                testGradeBook.grades[i][j] = randNum.nextInt(101);
            }
        }
        
        testGradeBook.showGrades();
    } //End main
    
} //End GradeBook
