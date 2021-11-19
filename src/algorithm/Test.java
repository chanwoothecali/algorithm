package algorithm;

import java.util.ArrayList;

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
        QuickSort quickSort = new QuickSort();
        ArrayList<Integer> randomList = new ArrayList<>();
        for(int i=0; i<100; i++){
            int randomNum = (int)(Math.random() * 100) + 1;
            randomList.add(randomNum);
        }
        System.out.println("randomList = " + randomList);
        ArrayList<Integer> sortList = quickSort.quickSort(randomList);
        System.out.println("sortList = " + sortList);
    }
}
