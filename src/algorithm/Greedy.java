package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Greedy {
    public void coinMix(Integer price, Integer[] coinList){
        Arrays.sort(coinList, Collections.reverseOrder());

        int totalCoin = 0;
        int totalMoney = 0;
        int i = 0;
        int moneyLeft = price;
        /*for (int i = 0; i < coinList.length; i++) {
            Integer coin = coinList[i];
            int numberOfCoin = price / coin;
            System.out.println(coin + "원: " + numberOfCoin + "개");
            price -= numberOfCoin * coin;
            totalCoin += numberOfCoin;
        }*/
        while(totalMoney < price){
            Integer coin = coinList[i++];
            int numberOfCoin = moneyLeft / coin;
            if(i >= coinList.length){
                numberOfCoin += 1;
            }
            System.out.println(coin + "원: " + numberOfCoin + "개");
            moneyLeft -= numberOfCoin * coin;
            totalCoin += numberOfCoin;
            totalMoney += numberOfCoin * coin;
        }
        System.out.println("totalCoin = " + totalCoin);
    }

    public double fractionalKnapsackProblemValue(double capacity, Integer[][] objectData){
        Arrays.sort(objectData, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                int vPerW1 = o1[0] * 10 / o1[1];
                int vPerW2 = o2[0] * 10 / o2[1];
                if(vPerW1 == vPerW2){
                    return o1[0] - o2[0];
                }else {
                    return vPerW1 - vPerW2;
                }
            }
        });

        double totalValue = 0;

        for (Integer[] objectDatum : objectData) {
            int objectWeight = objectDatum[0];

            if(capacity >= objectWeight){
                totalValue += objectDatum[1];
                System.out.println("무게: "+objectWeight+", 가치: "+objectDatum[1]);
                capacity -= objectWeight;
            }else {
                double ratio = capacity / objectWeight;
                System.out.println("무게: "+objectWeight+", 가치: "+objectDatum[1] + ", 비중: " + ratio);
                totalValue += objectDatum[1] * ratio;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Greedy greedy = new Greedy();
        Integer[] coinList = {50,  100, 500, 10};
        greedy.coinMix(4731 ,coinList);
        Integer[][] objectData = {{20,10}, {25,8}, {15,15}, {30,5}, {10,10}};
        double problemValue = greedy.fractionalKnapsackProblemValue(30.0, objectData);
        System.out.println("problemValue = " + problemValue);
    }
}
