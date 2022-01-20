package algorithm;

import java.util.*;

public class Kruskal {

    static Map<String, String> genealogy = new HashMap<>();
    static Map<String, Integer> rank = new HashMap<>();

    static public class Edge{
        private final int cost;
        private final String nodeV;
        private final String nodeU;

        public int getCost() {
            return cost;
        }

        public String getNodeV() {
            return nodeV;
        }

        public String getNodeU() {
            return nodeU;
        }

        public Edge(int cost, String nodeV, String nodeU) {
            this.cost = cost;
            this.nodeV = nodeV;
            this.nodeU = nodeU;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "nodeV='" + nodeV + '\'' +
                    ", nodeU='" + nodeU + '\'' +
                    ", cost=" + cost +
                    '}';
        }
    }

    public String find(String node) {
        // path compression 기법
        if(!genealogy.get(node).equals(node)) {
            genealogy.put(node, find(genealogy.get(node)));
        }
        return genealogy.get(node);
    }

    public void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        // union-by-rank 기법
        if(rank.get(root1) > rank.get(root2)) {
            genealogy.put(root2, root1);
        }else if(rank.get(root1) < rank.get(root2)){
            genealogy.put(root1, root2);
        }else {
            genealogy.put(root1, root2);
            rank.put(root2, rank.get(root2)+1);
        }
    }

    public void makeDisjointSet(String node) {
        genealogy.put(node, node);
        rank.put(node, 0);
    }

    public ArrayList<Edge> kruskalAlgo(ArrayList<String> vertices, ArrayList<Edge> edges) {
        ArrayList<Edge> mst = new ArrayList<>();

        // 1. 초기화
        for (String vertex : vertices) {
            makeDisjointSet(vertex);
        }

        // 2. 간선 cost 기반 sorting
        edges.sort(Comparator.comparing(Edge::getCost));
        for (Edge currentEdge : edges) {
            if(!find(currentEdge.getNodeU()).equals(find(currentEdge.getNodeV()))) {
                union(currentEdge.getNodeV(), currentEdge.getNodeU());
                mst.add(currentEdge);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal();
        ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));
        kruskal.kruskalAlgo(vertices, edges);
    }
}
