package algorithm;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public ArrayList<Integer> mergeSort(ArrayList<Integer> sortList) {
        // 배열이 비어있거나 null이면 반환
        if (sortList == null || sortList.isEmpty()) {
            return sortList;
        }

        int size = sortList.size();
        // 배열 사이즈가 1 이하인 경우 반환
        if (size <= 1) {
            return sortList;
        }

        int half = size / 2;
        ArrayList<Integer> leftSubList = mergeSort(new ArrayList<>(sortList.subList(0, half)));
        ArrayList<Integer> rightSubList = mergeSort(new ArrayList<>(sortList.subList(half, size)));

        return merge(leftSubList, rightSubList);
    }

    private ArrayList<Integer> merge(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;
        int leftSize = leftList.size();
        int rightSize = rightList.size();

        while (leftPoint < leftSize && rightPoint < rightSize) {
            int leftArgs = leftList.get(leftPoint);
            int rightArgs = rightList.get(rightPoint);
            if (leftArgs < rightArgs) {
                mergedList.add(leftArgs);
                leftPoint++;
            } else {
                mergedList.add(rightArgs);
                rightPoint++;
            }

            if (leftPoint == leftSize) {
                mergedList.addAll(new ArrayList<>(rightList.subList(rightPoint, rightSize)));
                break;
            } else if (rightPoint == rightSize) {
                mergedList.addAll(new ArrayList<>(leftList.subList(leftPoint, leftSize)));
                break;
            }
        }
        return mergedList;
    }
}
