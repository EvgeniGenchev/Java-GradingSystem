package gencho;

import java.util.Scanner;

public class Main {

    public static Scanner keyboardInput = new Scanner(System.in);
    public static String[][] students;
    public static int passRecord;
    

    public static double gradeBook(){

        double count = 0;

        for(var i = 0 ; i < students.length; i++){

            System.out.print("Enter student "+ (i+1) +" info: ");

            System.out.print("\nName: ");
                students[i][0] = keyboardInput.nextLine();

            System.out.print("Grade: ");
                students[i][1] = keyboardInput.nextLine();

            if((Double.parseDouble(students[i][1]) <= 1.0) || (Double.parseDouble(students[i][1]) > 10.0)) {
                i--;
            }
        }
        for( var i = 0 ; i < students.length; i++){
            count = count + Double.parseDouble(students[i][1]);
            if(Double.parseDouble(students[i][1]) >= 5.5){
                passRecord ++ ;
            }
        }

        return count;
    }

    public static void printInfo(){
        System.out.print("\n   GradeBook\n-----------------\n");
        for(var i=0 ; i < students.length ; i++){
            System.out.println(students[i][0] + " : " +students[i][1]);
        }
        System.out.println("-----------------");
    }

    public static void averageGrade(double sum){
        System.out.println(String.format("Average: %.1f", sum/students.length));
    }

    public static void passCounter(){
        System.out.println( "\n" + passRecord + " have passed\n  List of passed:");
        if(passRecord < 0) System.out.println("None");
        else {
            for (var i = 0; i < students.length; i -= -1) {
                if (Double.parseDouble(students[i][1]) >= 5.5) {
                    System.out.println("    " + students[i][0] + " : " + students[i][1]);
                }
            }
        }
    }

    public static void main(String[] args) {

	    System.out.println("How many grades will be entered?");
	    var input = keyboardInput.nextLine();
	    int stdCount = Integer.parseInt(input);

	    students = new String[stdCount][2];

	    double sum = gradeBook();
	    printInfo();
	    averageGrade(sum);
	    passCounter();

    }
}
