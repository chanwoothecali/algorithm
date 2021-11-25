package algorithm;

import java.util.Arrays;

public class BinarySearch {
    int[] ints;

    public int searchIndexRecursiveCall(int[] ints, int searchData) {
        this.ints = ints;
        return searchIndexRecursiveCall(searchData, 0, ints.length);
    }

    private int searchIndexRecursiveCall(int searchData, int left, int right) {
        int mid = (left+right)/2;
        System.out.println("ints["+mid+"] " + ints[mid] + ", left : " + left + ", right : " + right);
        if(left > right) return -1;

        if(ints[mid] == searchData){
            return mid;
        }else if(ints[mid] > searchData){
            return searchIndexRecursiveCall(searchData, left, mid-1);
        }else if(ints[mid] < searchData){
            return searchIndexRecursiveCall(searchData, mid+1, right);
        }else {
            return -1;
        }
    }
}
