package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        /*MergeSort mergeSort = new MergeSort();
        ArrayList<Integer> randomList = new ArrayList<>();
        for(int i=0; i<100; i++){
            int randomNum = (int)(Math.random() * 100) + 1;
            randomList.add(randomNum);
        }
        System.out.println("randomList = " + randomList);
        ArrayList<Integer> sortList = mergeSort.mergeSort(randomList);
        System.out.println("sortList = " + sortList);*/
        /*QuickSort quickSort = new QuickSort();
        ArrayList<Integer> randomList = new ArrayList<>();
        for(int i=0; i<100; i++){
            int randomNum = (int)(Math.random() * 100) + 1;
            randomList.add(randomNum);
        }
        System.out.println("randomList = " + randomList);
        ArrayList<Integer> sortList = quickSort.quickSort(randomList);
        System.out.println("sortList = " + sortList);*/
        /*SequentialSearch sequentialSearch = new SequentialSearch();
        int[] ints = new int[100];
        for(int i=0; i<100; i++){
            ints[i] = (int)(Math.random() * 100);
            System.out.print(ints[i] + ", ");
        }
        int search = sequentialSearch.search(ints, 5);
        System.out.println("ints = " + ints);
        System.out.println("search = " + search);*/
        BinarySearch binarySearch = new BinarySearch();
        int[] ints = new int[100];
        for(int i=0; i<100; i++){
            ints[i] = (int)(Math.random() * 100);
        }
        Arrays.sort(ints);
        int searchData = 25;
        int index = binarySearch.searchIndexRecursiveCall(ints, searchData);
        for(int i=0; i<100; i++){
            System.out.print("["+ints[i]+"]");
        }
        System.out.println();
        for(int i=0; i<100; i++){
            if(ints[i] == searchData){
                System.out.println("i = " + i);
                break;
            }
        }
        System.out.println("index = " + index);
    }
}
