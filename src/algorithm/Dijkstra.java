package algorithm;

import java.util.*;

public class Dijkstra {

    static public class Edge{
        private final String vertex;
        private final int cost;

        Edge(String vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        Edge(int cost, String vertex) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "vertex='" + vertex + '\'' +
                    ", cost=" + cost +
                    '}';
        }
    }

    public HashMap<String, Integer> dijkstraPath(HashMap<String, ArrayList<Edge>> graph, String start) {
        Edge edgeNode;
        ArrayList<Edge> nodeList;
        int currentDistance, weight, distance;
        String currentNode, adjacent;
        HashMap<String, Integer> distances = new HashMap<>();

        for (String vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((Comparator.comparingInt(o -> o.cost)));
        priorityQueue.offer(new Edge(start, 0));

        while (priorityQueue.size() > 0){

            System.out.println("distances = " + distances);
            System.out.println("priorityQueue = " + priorityQueue);

            edgeNode = priorityQueue.poll();

            System.out.println("edgeNode = " + edgeNode);

            assert edgeNode != null;
            currentDistance = edgeNode.cost;
            currentNode = edgeNode.vertex;

            if(distances.get(currentNode) < currentDistance) {
                continue;
            }

            nodeList = graph.get(currentNode);
            System.out.println("nodeList = " + nodeList);
            System.out.println();

            for (Edge adjacentNode : nodeList) {
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.cost;
                distance = currentDistance + weight;

                if (distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(distance, adjacent));
                }
            }

        }

        return distances;
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<>());
        graph.put("C", new ArrayList<>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<>(Collections.singletonList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<>(Collections.singletonList(new Edge(5, "A"))));
        HashMap<String, Integer> dijkstraPath = dijkstra.dijkstraPath(graph, "A");
        System.out.println("dijkstraPath = " + dijkstraPath);
    }
}
