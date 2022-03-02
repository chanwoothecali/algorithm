package boj;

public class B1002 {

    private final FastReader scan = new FastReader();
    private StringBuilder sb = new StringBuilder();

    private static class Circle{
        private int x;
        private int y;
        private int r;

        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    public void main() {
        int T = scan.nextInt();

        while (T-- > 0) {
            Circle a = drawCircle();
            Circle b = drawCircle();
            int result = solve(a, b);
            sb.append(result).append('\n');
        }
        System.out.println(sb.toString());
    }

    private Circle drawCircle() {
        int x = scan.nextInt();
        int y = scan.nextInt();
        int r = scan.nextInt();

        return new Circle(x, y, r);
    }

    private int solve(Circle a, Circle b) {
        // int형으로 비교해야 == 비교가 가능

        // 두 점 간의 거리
        int squareBetweenDistance = calculateSquareBetweenDistance(a, b);
        // 두 반지름의 합
        int squareSumRadius = (int) (Math.pow(a.r + b.r, 2));
        // 두 반지름의 차
        int squareGabRadius = (int) Math.pow(a.r - b.r, 2);

        // 좌표값이 같고 반지름도 같으면 원이 겹치기에 무한
        if (isSameCircle(a, b)) return -1;

        if (squareBetweenDistance > squareSumRadius) return 0;

        if (squareBetweenDistance < squareGabRadius) return 0;

        if (squareBetweenDistance == squareSumRadius) return 1;

        if (squareBetweenDistance == squareGabRadius) return 1;

        return 2;
    }

    private boolean isSameCircle(Circle a, Circle b) {
        return calculateSquareBetweenDistance(a, b) == 0 && a.r == b.r;
    }

    private int calculateSquareBetweenDistance(Circle a, Circle b) {
        int xDistance = Math.abs(a.x - b.x);
        int yDistance = Math.abs(a.y - b.y);

        return (int) (Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }

    public static void main(String[] args) {
        B1002 b1002 = new B1002();
        b1002.main();
    }
}
