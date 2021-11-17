package algorithm;

import java.util.List;

public class MergeSort {

    public void split(List<Integer> sortList){
        // 배열이 비어있거나 null이면 반환
        if(sortList == null || sortList.isEmpty()){
            return;
        }

        int size = sortList.size();
        // 배열 사이즈가 1 이하인 경우 반환
        if(sortList.size() <= 1){
            return;
        }

        int half = size / 2;
        List<Integer> leftSubList = sortList.subList(0, half);
        List<Integer> rightSubList = sortList.subList(half, size);
        System.out.println("leftSubList = " + leftSubList);
        System.out.println("rightSubList = " + rightSubList);
        split(leftSubList);
        split(rightSubList);
    }
}
