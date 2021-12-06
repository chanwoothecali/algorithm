package algorithm;

import java.util.*;

public class Graph {

//    public HashMap<String, ArrayList<String>> graph = new HashMap<>();

    public void breadthFirstSearch(HashMap<String, ArrayList<String>> graph, String startVertex){
        Queue<String> visited = new LinkedList<>();
        Queue<String> needVisit = new LinkedList<>();

        needVisit.offer(startVertex);

        while(needVisit.size() > 0){
            String nextVertex = needVisit.poll();
            if(!visited.contains(nextVertex)){
                needVisit.addAll(graph.get(nextVertex));
                visited.offer(nextVertex);
            }
        }

        System.out.println("visited = " + visited);
    }

    public void DepthFirstSearch(HashMap<String, ArrayList<String>> graph, String startVertex){
        Queue<String> visited = new LinkedList<>();
        Stack<String> needVisit = new Stack<>();

        needVisit.push(startVertex);

        while(needVisit.size() > 0){
            String nextVertex = needVisit.pop();
            if(!visited.contains(nextVertex)){
                ArrayList<String> vertexes = graph.get(nextVertex);
                Collections.reverse(vertexes);
                needVisit.addAll(vertexes);
                visited.offer(nextVertex);
            }
        }

        System.out.println("visited = " + visited);
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        Graph graph1 = new Graph();
        graph1.DepthFirstSearch(graph, "A");
    }
}
