package LA2Q2;
import java.util.*;

public class StudentGrade implements Comparable<StudentGrade> {
    //setting 3 fields for our class
    private String firstName;
    private String lastName;
    private Double grade;

    public StudentGrade(){}             //constructor w/o arguments

    public StudentGrade(String fName, String lName, double gr ){        //constructor with arguments
        this.firstName= fName;
        this.lastName= lName;
        this.grade=gr;
    }

    //creating getter and setter methods for all out private fields:
    public void setGrade(double grade) {
        this.grade = grade;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Double getGrade(){
        return grade;

    }

    //overriding the compareTo method so it compares based on our desired field, grades
    public int compareTo(StudentGrade a) {

        return this.getGrade().compareTo(a.getGrade());
    }

    //overriding the toString method so it prints based on the given output
    public String toString(){

        String output = String.format("\b\b\b%10s %8s  :  %sf\b\b\b\n", firstName,lastName, grade );


        return output;
    }






}


