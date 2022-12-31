package LA2Q1;

import java.sql.SQLOutput;
import java.util.Arrays;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class AyeshaTestingSortingMethods {

    public static void main (String [] xxx){

        Header(2,1);

        int sz= 50000;
        Integer [] array1 = new Integer[sz];        //creating an integer array of size 5, which can be updated later on
        Integer [] backupArray = new Integer[sz];

        for(int i=0; i< array1.length; i++){        //populating the array with random values
            array1[i]= (int)((13+ Math.random()*(93-13+1)));
        }

        System.arraycopy(array1,0,backupArray,0,backupArray.length);        //copying the array to a backup array which can be used each time for sorting

        List<Integer> arr1 =Arrays.asList(array1);  //creating a List from our array to use for Collections sort

        //Testing our collections sort
        System.out.print("\nCOLLECTIONS SORT -->");
//        System.out.println("\nThe Unsorted Array 1: " + arr1);
        long starting = System.nanoTime();
        Collections.sort(arr1);         //sorting the array based on the overridden compareTo method
        long finishing =System.nanoTime();
//        System.out.println("Sorted Array 1 using Collections sort: " + arr1);

                //printing the time that the Collections sort takes
        System.out.printf("Time taken to sort using Collections sort: %.2f milliseconds \n", ((finishing-starting)/1E6));


        //Testing our selection sort method
        System.out.print("\nSELECTION SORT -->");
        System.arraycopy(backupArray,0,array1,0,array1.length);
//        System.out.println("\nThe unsorted array: "+ Arrays.toString(array1));
        //printing out the time using nano function and converting to milliseconds, 2 decimal places
        System.out.printf("Time taken for selection sort: %.2f milliseconds \n", ((selectionSort(array1))/1E6));
//        System.out.println("The sorted array: " + Arrays.toString(array1));


        //Testing out bubble sort method
        System.out.print("\nBUBBLE SORT -->");
        System.arraycopy(backupArray,0,array1,0,array1.length);
//        System.out.println("\nThe unsorted array: " + Arrays.toString(array1));
        System.out.printf("Time taken for bubble sort: %.2f milliseconds\n", ((bubbleSort(array1))/1E6));
//        System.out.println("The sorted array: " + Arrays.toString(array1));


        //Testing out insertion sort method
        System.out.print("\nINSERTION SORT -->");
        System.arraycopy(backupArray,0,array1,0,array1.length);
//        System.out.println("\nThe unsorted array: " + Arrays.toString(array1));
//      insertionSort(array1);
        System.out.printf("Time taken for Insertion sort: %.2f milliseconds\n", ((insertionSort(array1))/1E6));
//        System.out.println("The sorted array: " + Arrays.toString(array1));


        //testing our merge sort method
        System.out.print("\nMERGE SORT -->");
        System.arraycopy(backupArray,0,array1,0,array1.length);
//        System.out.println("\nThe unsorted array: " + Arrays.toString(array1));
        System.out.printf("Time taken for merge sort: %.2f milliseconds \n", ((mergeSort(array1))/1E6));
//        System.out.println("The sorted array: " + Arrays.toString(array1));


        //testing our quicksort method
        System.out.print("\nQUICK SORT -->");
        System.arraycopy(backupArray,0,array1,0,array1.length);
//        System.out.println("\nThe unsorted array: " + Arrays.toString(array1));
        System.out.printf("Time taken for quick sort: %.2f milliseconds \n", ((quickSort(array1,0,(array1.length)-1))/1E6));
//        System.out.println("The sorted array: " +Arrays.toString(array1));


        //testing out bucket sort method
        System.out.print("\nBUCKET SORT -->");
        System.arraycopy(backupArray,0,array1,0,array1.length);
//        System.out.println("\nThe unsorted array: " +Arrays.toString(array1));
        System.out.printf("Time taken for bubble sort: %.2f milliseconds\n", ((bucketSort(array1, 0, (array1.length-1),2))/1E6));
//        System.out.println("The sorted array: " + Arrays.toString(array1));

        Footer(2,1);

    }


    public static <T extends Comparable<? super T>> long selectionSort(T[] a){
        //selection sort finds the smallest element in the array, and swaps it with the first place in the array. In the second iteration
        //the second-smallest element is looked for through the whole array and once it is found, it is swapped with the second place in the array.
        //this process is repeated until the array is sorted.
        //the time complexity for this algorithm would be worst case O(n squared) and best case would be O(n)?
        //the space complexity for this algorithm would be O(1)



        long start= System.nanoTime();          //noting the starting time

        for(int i=0; i< a.length; i++){         //traversing through the whole array
            int indexofSmallest = i;            //setting an index for the smallest element, since each iteration is updates, it initially takes the first element to be the smallest and compares in the following code

            for( int j =i+1; j<a.length; j++){
                //setting a new iterator which goes through the array based on the smallest index we set (in each iteration)

                if((a[j].compareTo(a[indexofSmallest]))<0){
                    //if statement, with a condition that if an element in the array is smaller than the chosen index,it will be swapped

                    indexofSmallest= j;          //index changed
                    T temporary = a[i];          //creating a temporary object to store the new smallest index

                    a[i]=a[indexofSmallest];
                    a[indexofSmallest]= temporary;
                }
            }
        }

        long finish = System.nanoTime();
        long ans= finish-start;
        return ans;
    }

    public static <T extends Comparable<? super T>> long bubbleSort( T[] a){
        //bubble sort compares elements pair wise, selecting a pair at the beginning, and swapping the greater element to the right side. This
        //element is then compared with the next element and swapped if necessary. This process continues and in one iteration, it moves the largest
        //element to the end (right-most) of the array

        //worst time complexity is o(n squared) but this can be made to o(n) for a best case, in the scenario that all the elements are already sorted for
        //the first iteration

        //space complexity for is O(1) since an extra space is always created for an element in order to allow for swapping.

        long start= System.nanoTime();  //noting the start time

        //boolean nextPass = true;

        for (int i=1; i< a.length; i++){              //for each iteration equal to the number of elements -1
            for( int j=0; j<a.length-i; j++){         //traversing through each element in the array

                if ((a[j].compareTo(a[j+1]))>0){      //taking the first element of the array and comparing it to the next element, swapping if the
                                                      //first element is greater than the next one.
                    //swapping:
                    T temporary = a[j];               //setting a temporary node-element as the first element of our pair
                    a[j] = a[j+1];                    //to swap the elements, we set the first element to the second element
                    a[j+1] = temporary;               //setting the second element in out pair to the temporary (first one) we created earlier
                }
            }
        }

        long finish = System.nanoTime();            //noting our finishing time

        long ans= finish-start;
        return ans;
    }

    public static <T extends Comparable<? super T>> long insertionSort( T[] a){
        //insertion sort selects the first element in the array (a) and compares it to the next element, in the scenario that the second element is smaller
        //than our first selected one, it will create a new space, and remove the second element from the array into the new space, move the first element into its
        //original place in the array and then bring the second (smaller) element to the first element's old spot. This continues for the rest of the array, where our element
        //a is compared with the next element, but at the same time on each iteration, each element that is removed from the array is compared with each previous element and put back in the
        //right spot, orderly

        //time complexity for the best case scenario of insertion sort would be o(n squared) as there's an iteration through all the elements for each element (nested for loop)
        //space complexity is O(1) to hold the element that it swaps

        long start = System.nanoTime();             //noting the start time

        for( int i =1; i<a.length; i++){            //traversing through the elements in the array from the second element
            T key = a[i];                           //choosing a key which will be compared with the adjacent elements

            //traversing and comparing the elements of the array to the key
            for(int j= i-1; (j>=0 && (a[j].compareTo(key)>0)); j--){

                //if our key is smaller than the element, then that element is swapped accordingly
                a[j+1]= a[j];         //adjacent element is brought to the previous spot
                a[j]=key;             //and our current element becomes the key, upon which the next iteration will be compared
            }
        }

        long finish= System.nanoTime();         //noting ending time
        long ans= finish-start;    //calculating final time
        return ans;

    }

    public static <T extends Comparable<? super T>> long mergeSort( T[] S){
        //merge sort divides the array into halves until further division is not possible, and then compares the most recent division pairs,
        //after comparison it merges them back into pairs, and then compares 2 pairs by initially comparing each pair's first element and second element to form an ordered group
        //this is repeated until the array is entirely merged together, and is in order

        //for this algorithm, that is recursive our time complexity is O(n log n) since it consistently divides the array each time
        //and then sorts it.
        //space complexity is also n log n, extra spaces are consistently required as the array is divided

        long start = System.nanoTime();             //noting the start time


        int n = S.length;

        //if our array length can't be halved, then there is nothing to return (single element)
        if(n<2) return 0;

        //halving the array
        int mid = n/2;


        T[] S1 = Arrays.copyOfRange(S,0, mid);          //splitting the halved array into two separate arrays
        T[] S2= Arrays.copyOfRange(S, mid, n);


        mergeSort(S1);              //recursive calls for our halved arrays, to reach a point where the elements can no longer be halved further
        mergeSort(S2);

        //setting two 'pointers' which would be our most recent divided pair
        int i=0, j=0;
        while (i + j <S.length){
            //a while loop to check each iteration, ensuring all elements are merged back

            if(j== S2.length || (i < S1.length && (S2[j].compareTo(S1[i])>0))){
                //if/else statement that chooses an OR condition between the second pointer reaching its max length or first array being incomplete,
                //and comparing the element of our final divided pair with the element from the first array (in ascending order)

                //if true, then the pair of elements is merged together in ascending order
                S[i+j] = S1 [i++];
            } else{
                S[i+j] = S2[j++];
            }
        }
        long finish = System.nanoTime();        //noting finished time
        long ans= finish-start;                 //calculating total time taken

        return ans;

    }

    public static <T extends Comparable<? super T>> long quickSort( T[] c, int a, int b) {
        //The algorithm I am implementing here is Quick sort with in-place partitioning since I'd like to see
        //a reduced run time. This quick sort will select a pivot (usually the last element) and I have set up two pointers
        //the first element in the array, and the second last element.

        //time complexity for worse case quick sort is O(n squared)
        //space complexity for the quick sort algorithm since this is in-place would be O(1)

        long start = System.nanoTime();     //noting the start time

        if (a >= b) {
            //if the start is equal to the end, the array is already sorted
            return 0;
        }

        T pivot = c[b];
        int left = a;
        int right = b - 1;
        T temp;     //setting a temporary object for swapping

        while (left <= right) {
            //within the while loop, the pointers, allow to traverse through, starting at the pivot
            //until a value equal than or larger than the pivot is reached

            while (left <= right && (c[left].compareTo(pivot) < 0)) {
                //while traversing through the array, if a value smaller than the pivot or left pointer is reached
                //then the left pointer is incremented for the next iteration

                left++;
            }
            while (left <= right && (c[right].compareTo(pivot) > 0)) {
                //while traversing through the array, if a value larger than the pivot/left pointer is reached,
                //right pointer is decremented

                right--;
            }

            if (left <= right) {
                //to swap the elements:

                temp = c[left];         //larger element is placed as temporary
                c[left] = c[right];     //the left pointer is assigned to the right pointer
                c[right] = temp;        //the swap takes place as the right pointer is assigned to temporary
                left++;
                right--;
            }
        }

        //changing the spot of the pivot for a second iteration
        temp = c[left];
        c[left] = c[b];
        c[b] = temp;

        //once the swap is done, calling the method again for the right and left sides of the array, until
        //all elements have been traversed through and arranged.

        quickSort(c, a, left - 1);
        quickSort(c, left + 1, b);

        long finish = System.nanoTime();       //noting finish time

        long ans = finish-start;                //calculating final time
        return ans;
    }


    public static long bucketSort(Integer [] a, int first, int last, int maxDigits){
        //Bucket sort arranges items, not by comparing them but places them into buckets based on their radix/base.
        //It considers numbers with more than one digit as strings and compares them based on each digit (bit) starting with either
        //the most significant bit or least significant bit. Once an arrangement is achieved, it is continued for the remaining bits/digits,
        //and the final pattern achieved, is sorted in ascending order.

        //since it does not really compare objects, the time complexity for this would be O(n), we are still
        //looking at each number for the number of digits it has and putting them in the right bucket
        //space complexity would be best case 0(n) and worst case nlogn

        long start = System.nanoTime();

        //creating 10 buckets since the radix is 10 in our case
        Vector<Integer>[] bucket = new Vector[10];

        //instantiating each bucket, based on a different base
        for (int i=0; i<10; i++){
            bucket [i] = new Vector <>();
        }

        for (int i=0; i<maxDigits; i++){
            //clearing the buckets
            for(int j=0; j<10; j++){
                bucket[j].removeAllElements();
            }

            //Placing an element a[index] and the end of each specified bucket(based on the last digit)
            for(int index = first; index <= last; index++){
                Integer digit = findDigit(a[index], i);     //calling our defined method to separate the required digit from the number
                bucket[digit].add(a[index]);
            }

            //once all the elements have been put into buckets, now we go through all the elements and put them back in the array
            int index =0;
            for(int m =0; m<10; m++){
                for(int n=0; n<bucket[m].size(); n++){
                    //for each bucket, all the elements are put back as the index is updated, and then
                    //we increment the bucket number, and the process is repeated.

                    a[index++] = bucket[m].get(n);
                }
            }
        }

        long finish = System.nanoTime();
        long ans = finish - start;

        return ans;
    }

    public static Integer findDigit(int number, int i){
        //this method will extract a digit from a number with more than 1 digit

        int target = 0;         //setting a target
        for(int k=0; k<= i; k++){
            //going through the number

            target = number%10;     //choosing a mod 10 for the first digit, since our radix is 10

            number = number /10;    //choosing division by 10 for our second digit
        }
        return target;
    }

    public static void Header(int labex, int labq) {
        //creating a header method lists all regarding information

        System.out.print("Lab Assignment=" + labex + "-Q"+ labq +" \n Prepared by: Ayesha Qaisar " + " \n Student Number: 251255914 " +
                "\n Goal of this exercise: We will be working with some sorting algorithm and testing their runtimes \n");


        System.out.println("============================================================================================= \n");
    }

    public static void Footer(int labnum, int labq) {
        //a footer method to sign out of the program once main task is completed, and it is called by the main method

        System.out.println("============================================================================================= \n");
        System.out.print("Completion of lab Assignment " + labnum + "-Q" + labq + " is successful! \n Signing off - Ayesha :)");
        System.out.println("=============================================================================================");
    }





}
