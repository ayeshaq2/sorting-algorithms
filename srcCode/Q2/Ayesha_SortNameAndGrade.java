package LA2Q2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class Ayesha_SortNameAndGrade {

    public static void main (String [] ayesha){
        Header(2,2);

        //creating some data arrays:
        String [] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};

        Integer [] grd= {(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),
                (int)(60 + Math.random()*26)};

        Vector<StudentGrade> sg= new Vector<>();            //instantiating a vector class

        //creating objects based on our initial data arrays
//        StudentGrade studOne = new StudentGrade(fnArray[0], lnArray[0], grd [0]);
//        StudentGrade studTwo = new StudentGrade(fnArray[1], lnArray[1], grd [1]);
//        StudentGrade studThree = new StudentGrade(fnArray[2], lnArray[2], grd [2]);
//        StudentGrade studFour = new StudentGrade(fnArray[3], lnArray[3], grd [3]);
//        StudentGrade studFive = new StudentGrade(fnArray[4], lnArray[4], grd [4]);
//        StudentGrade studSix = new StudentGrade(fnArray[5], lnArray[5], grd [5]);
//        StudentGrade studSeven = new StudentGrade(fnArray[6], lnArray[6], grd [6]);
//        StudentGrade studEight = new StudentGrade(fnArray[7], lnArray[7], grd [7]);


        StudentGrade [] myArray = new StudentGrade[8];
        for(int i=0,j=0; i< lnArray.length; i++, j++){

            StudentGrade sgg = new StudentGrade(fnArray[i], lnArray[i], grd[i]);
            myArray[j] = sgg;

            sg.addElement(myArray[j]);
        }


        //I realize I could have used a for loop here, I just separated them since the instructions were separated, and didnt want to change it

//        sg.addElement(studOne);
//        sg.addElement(studTwo);
//        sg.addElement(studThree);
//        sg.addElement(studFour);
//        sg.addElement(studFive);
//        sg.addElement(studSix);
//        sg.addElement(studSeven);
//        sg.addElement(studEight);

        //printing our array
        System.out.println("The Unsorted array: ");
        System.out.println(sg.toString() + "\b");

        //using the collections sort (our overridden compare to) to sort the array based on student grades
        Collections.sort(sg);
        System.out.println("The sorted array, based on grades: ");
        System.out.println(sg.toString() + "\b");

        //creating a class array
        StudentGrade [] array1 = new StudentGrade[fnArray.length];
        sg.copyInto(array1);    //copying the elements from our vector to the array


        //calling my custom insertion sort method, to arrange the array based on students first names
        AQ_InsertionSort(array1, 1);
        System.out.println("The sorted array, based on first names: ");

        //using my defined method to print the sorted array based on the sample output
        printArray(array1);

        //calling my insertion sort to arrange the array based on student last names
        AQ_InsertionSort(array1,2);
        System.out.println("\n The sorted array, based on last names: ");
        printArray(array1);

        Footer(2,2);


    }

    public static void printArray(StudentGrade [] a){
        //this method will accept an array parameter and print out the elements
        //of that array in a specified format

        for(int i=0; i<a.length; i++){
            System.out.print(a[i] + "\b");
        }

    }

    public static void AQ_InsertionSort( StudentGrade [] a, int key) {
        //This method uses insertion sort algorithm to sort an accepted array parameter, with the plus point of also
        //accepting a choice to sort based on either first names or last names

        if (key == 1) {
            //key 1 sorts based on first names

            //traversing through the accepted array
            for (int i = 0; i < a.length; i++) {
                StudentGrade firstkey = a[i]; //creating a key which starts the comparison

                //second for loop allows for the swapping of elements, as insertion sort works, by comparing the elements to the key
                for (int k= i-1; k>=0 && ((a[k].getFirstName()).compareTo(firstkey.getFirstName())>0);k--){
                        a[k+1]=a[k];
                        a[k]= firstkey;
                    }
                }

        }
        else if (key == 2) {
         //key 2 sorts based on last names

            //iterating through the entire array
            for (int i = 0; i < a.length; i++) {
                StudentGrade secondkey = a[i]; //creating a key which starts the comparison

                //second for loop sets a condition, which is getting the specific elements from the indexed array, and comparing that element to the key, then swapping elements
                //as required
                for (int k= i-1; k>=0 && ((a[k].getLastName().compareTo(secondkey.getLastName())>0));k--){

                    //swapping
                    a[k+1]=a[k];
                    a[k]= secondkey;
                }
            }
            }


        }

    public static void Header(int labex, int labq) {
        //creating a header method lists all regarding information

        System.out.print("Lab Assignment=" + labex + "-Q"+ labq +" \n Prepared by: Ayesha Qaisar " + " \n Student Number: 251255914 " +
                "\n Goal of this exercise: We will be working with some array objects, and creating our own sorting algorithm to sort the data. \n");


        System.out.println("============================================================================================= \n");
    }

    public static void Footer(int labnum, int labq) {
        //a footer method to sign out of the program once main task is completed, and it is called by the main method

        System.out.println("============================================================================================= \n");
        System.out.print("Completion of lab Assignment " + labnum + "-Q" + labq + " is successful! \n Signing off - Ayesha :)");
        System.out.println("=============================================================================================");
    }


    }
