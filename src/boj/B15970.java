package boj;

import java.util.Arrays;

public class B15970 {

    static int N;
    static FastReader scan = new FastReader();
    static Point[] graph;

    static class Point implements Comparable<Point>{
        int x, y; //좌표, 색깔

        @Override
        public int compareTo(Point o) {
            if(this.y == o.y) return this.x - o.x;
            return this.y - o.y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static void input() {
        N = scan.nextInt();
        graph = new Point[N];
        for (int i = 0; i < N; i++) {
            String[] strings = scan.nextLine().split(" ");
            graph[i] = new Point(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
        }
    }

    static void solve() {
        Arrays.sort(graph);

        for (int i = 0; i < N; i++) {
            System.out.println(graph[i].toString());
        }

        int length = 0;
        if (graph[0].y == graph[1].y) {
            length += graph[1].x - graph[0].x;
        }
        System.out.println(length);
        for (int i = 1; i < N - 1; i++) {
            length += compare(graph[i - 1], graph[i], graph[i + 1]);
            System.out.println(length);
        }
        if (N > 2 && graph[N - 1].y == graph[N - 2].y) {
            length += graph[N - 1].x - graph[N - 2].x;
        }

        System.out.println(length);
    }

    private static int compare(Point prev, Point curr, Point next) {
        /*
        int prevLength = Integer.MAX_VALUE;
        int nextLength = Integer.MAX_VALUE;
        if(curr.y == prev.y) prevLength = curr.x - prev.x;
        if(curr.y == next.y) nextLength = next.x - curr.x;*/

        if (curr.y == prev.y && curr.y == next.y) {
            if (curr.x - prev.x <= next.x - curr.x) {
                return curr.x - prev.x;
            } else {
                return next.x - curr.x;
            }
        } else if (curr.y == prev.y) {
            return curr.x - prev.x;
        } else if (curr.y == next.y) {
            return next.x - curr.x;
        } else {
            return 0;
        }

        /*if (prevLength <= nextLength) {
            return prevLength;
        } else {
            return nextLength;
        }*/
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
