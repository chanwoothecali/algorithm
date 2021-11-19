package algorithm;

import java.util.ArrayList;

public class QuickSort {

    public ArrayList<Integer> quickSort(ArrayList<Integer> randomList){
        if(randomList == null || randomList.isEmpty()){
            return randomList;
        }
        
        if(randomList.size() == 1){
            return randomList;
        }

        int pivot = randomList.get(0);
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        for(int i=1; i<randomList.size(); i++){
            if(randomList.get(i) < pivot){
                leftList.add(randomList.get(i));
            }else {
                rightList.add(randomList.get(i));
            }
        }

        leftList = quickSort(leftList);
        rightList = quickSort(rightList);

        ArrayList<Integer> sortList = leftList;
        sortList.add(pivot);
        sortList.addAll(rightList);

        return sortList;
    }
}
