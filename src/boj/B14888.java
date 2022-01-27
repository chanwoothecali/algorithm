package boj;

public class B14888 {
    static int N, max, min;
    static int[] numbers, order;
    static final int[] operators = new int[5];

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        numbers = new int[N + 1];
        order = new int[N];
        for (int i = 1; i <= N; i++) {
            numbers[i] = scan.nextInt();
        }
        for (int i = 1; i <= 4; i++) {
            operators[i] = scan.nextInt();
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static void reqFunc(int k, int value) {
        if(k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }else {
            for (int i = 1; i <= 4; i++) {
                if(operators[i] > 0){
                    order[k] = i;
                    operators[i]--;
                    int result = calculate(value, i, numbers[k + 1]);
                    reqFunc(k + 1, result);
                    operators[i]++;
                    order[k] = 0;
                }
            }
        }
    }

    // 피연산자 2개와 연산자가 주어졌을 때 연산하는 함수
    private static int calculate(int currVal, int operator, int nextVal) {
        switch (operator) {
            case 1:
                currVal += nextVal;
                break;
            case 2:
                currVal -= nextVal;
                break;
            case 3:
                currVal *= nextVal;
                break;
            case 4:
                currVal /= nextVal;
                break;
            default:
                break;
        }
        return currVal;
    }

    public static void main(String[] args) {
        input();

        reqFunc(1, numbers[1]);
        System.out.println(max);
        System.out.println(min);
    }
}
