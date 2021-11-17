package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        List<Integer> sortList = new ArrayList<>();
        for(int i=0; i<10; i++){
            int randomNum = (int)(Math.random() * 100) + 1;
            sortList.add(randomNum);
        }
        mergeSort.split(sortList);
    }
}
