import java.util.Arrays;
import java.util.Date;

public class Program {
    public static void main (String[] args) {
        Date date = new Date();
        int time = date.getSeconds();
        int[][] array = new int[10][10];
        fillArray(array,time);
        printArray(array);
        System.out.printf("Max of array is %d, Min of array is %d, Average of array is %.2f \n", maxOfArray(array), minOfArray(array), averageOfArray(array));

        int[] unSortedArray = {5,6,3,2,5,1,4,9};
        sortArray(unSortedArray);
        System.out.println(Arrays.toString(unSortedArray));
    }
    public static int rnd(int limit,int time) {
        int number = time;
        number = (number * 73129 + 95121) % 100000;
        while (number > limit) {
            number %= limit;
        }
        return number;
    }
    public static int[][] fillArray(int[][] array,int time) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                time = time + i + j;
                array[i][j] = rnd(25,time);
            }
        }
        return array;
    }
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i ++) {
            for (int j = 0; j < array.length; j ++) {
                if (array[i][j] > 9) {
                    System.out.printf("%d ", array[i][j]);
                } else {
                    System.out.printf("%d  ", array[i][j]);
                }
            }
            System.out.println();
        }
    }
    public static int maxOfArray(int[][] array){
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array.length; j++) {
                if (array[i][j] > max)
                    max = array[i][j];
            }
        }
        return max;
    }
    public static int minOfArray(int[][] array){
        int min = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array.length; j++) {
                if (array[i][j] < min)
                    min = array[i][j];
            }
        }
        return min;
    }
    public static double averageOfArray(int[][] array){
        double average;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array.length; j++) {
                sum += array[i][j];
            }
        }
        average = (double) sum/array.length/array.length;
        return average;
    }
    public static void sortArray(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    isSorted = false;
                }
            }
        }
    }
    public static void swap(int[] array, int num1, int num2) {
        int tmp = array[num1];
        array[num1] = array[num2];
        array[num2] = tmp;
    }
}
