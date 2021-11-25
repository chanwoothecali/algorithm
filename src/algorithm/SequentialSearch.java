package algorithm;

import java.util.ArrayList;

public class SequentialSearch {

    public int search(int[] integers, int searchData) {
        for(int i=0; i<integers.length; i++){
            if(integers[i] == searchData){
                return i;
            }
        }
        return -1;
    }
}
