package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Prim {
    static public class Edge{
        private final int cost;
        private final String node1;
        private final String node2;

        @Override
        public String toString() {
            return "Edge{" +
                    "cost=" + cost +
                    ", node1='" + node1 + '\'' +
                    ", node2='" + node2 + '\'' +
                    '}';
        }

        public int getCost() {
            return cost;
        }

        public String getNode1() {
            return node1;
        }

        public String getNode2() {
            return node2;
        }

        public Edge(int cost, String node1, String node2) {
            this.cost = cost;
            this.node1 = node1;
            this.node2 = node2;
        }
    }

    static class Path {
        public String node1;
        public String node2;
        public int weight;

        public Path(String node1, String node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }

        public String toString() {
            return "(" + this.node1 + ", " + this.node2 + ", " + this.weight + ")";
        }
    }

    static public class ImprovedEdge{
        private String node;
        private int cost;

        public ImprovedEdge(String node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public String getNode() {
            return node;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public String toString() {
            return "ImprovedEdge{" +
                    "node='" + node + '\'' +
                    ", cost=" + cost +
                    '}';
        }
    }

    public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges) {
        Edge currentEdge, poppedEdge, adjacentEdgeNode;
        ArrayList<Edge> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;
        PriorityQueue<Edge> priorityQueue;

        ArrayList<String> connectedNodes = new ArrayList<String>();
        ArrayList<Edge> mst = new ArrayList<Edge>();
        HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<String, ArrayList<Edge>>();

        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            if (!adjacentEdges.containsKey(currentEdge.node1)) {
                adjacentEdges.put(currentEdge.node1, new ArrayList<Edge>());
            }
            if (!adjacentEdges.containsKey(currentEdge.node2)) {
                adjacentEdges.put(currentEdge.node2, new ArrayList<Edge>());
            }
        }

        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            currentEdgeList = adjacentEdges.get(currentEdge.node1);
            currentEdgeList.add(new Edge(currentEdge.getCost(), currentEdge.node1, currentEdge.node2));
            currentEdgeList = adjacentEdges.get(currentEdge.node2);
            currentEdgeList.add(new Edge(currentEdge.getCost(), currentEdge.node2, currentEdge.node1));
        }

        connectedNodes.add(startNode);
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>());
        priorityQueue = new PriorityQueue<>();
        for (int index = 0; index < candidateEdgeList.size(); index++) {
            priorityQueue.add(candidateEdgeList.get(index));
        }

        while (priorityQueue.size() > 0) {
            poppedEdge = priorityQueue.poll();
            if (!connectedNodes.contains(poppedEdge.node2)) {
                // 해당 edge 를 mst 에 추가
                connectedNodes.add(poppedEdge.node2);
                mst.add(new Edge(poppedEdge.getCost(), poppedEdge.node1, poppedEdge.node2));

                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge>());
                for (int index = 0; index < adjacentEdgeNodes.size(); index++) {
                    adjacentEdgeNode = adjacentEdgeNodes.get(index);
                    if(!connectedNodes.contains(adjacentEdgeNode.node2)) {
                        priorityQueue.add(adjacentEdgeNode);
                    }
                }
            }
        }
        return mst;

    }

    public ArrayList<Path> improvedPrimFunc(HashMap<String, HashMap<String, Integer>> graph, String startNode) {
        ArrayList<Path> mst = new ArrayList<>();
        PriorityQueue<ImprovedEdge> keys = new PriorityQueue<>();
        HashMap<String, ImprovedEdge> keysObjects = new HashMap<>();
        HashMap<String, String> mstPath = new HashMap<>();
        Integer totalWeight = 0;
        HashMap<String, Integer> linkedEdges;
        ImprovedEdge edgeObject, poppedEdge, linkedEdge;

        for (String key : graph.keySet()) {
            if (key == startNode) {
                edgeObject = new ImprovedEdge(key, 0);
                mstPath.put(key, key);
            } else {
                edgeObject = new ImprovedEdge(key, Integer.MAX_VALUE);
                mstPath.put(key, null);
            }
            keys.add(edgeObject);
            keysObjects.put(key, edgeObject);
        }

        while (keys.size() > 0) {
            poppedEdge = keys.poll();
            keysObjects.remove(poppedEdge.node);

            mst.add(new Path(mstPath.get(poppedEdge.node), poppedEdge.node, poppedEdge.getCost()));
            totalWeight += poppedEdge.getCost();

            linkedEdges = graph.get(poppedEdge.node);
            for (String adjacent : linkedEdges.keySet()) {
                if (keysObjects.containsKey(adjacent)) {
                    linkedEdge = keysObjects.get(adjacent);

                    if (linkedEdges.get(adjacent) < linkedEdge.getCost()) {
                        linkedEdge.cost = linkedEdges.get(adjacent);
                        mstPath.put(adjacent, poppedEdge.node);

                        keys.remove(linkedEdge);
                        keys.add(linkedEdge);
                    }
                }
            }
        }

        System.out.println(totalWeight);
        return mst;
    }

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(11, "F", "G"));
    }
}
