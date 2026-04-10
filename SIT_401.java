// Q: Course schedular Order (Simple DAG)
// Real: Planning course completion order in a university
// Problem: Given a course (0 to n-1) and prerequisites, return a valid order.
// Kahn's algorithm - BFS

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class SIT_401 {
    public static void main(String[] args) {
        // n -> number of nodes (0 to n-1)
        // meaning: 0 --> 1, 0 --> 2, 1 --> 3, 2 --> 3
        int n = 4;

        int[][] prereq = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

        System.out.println(topoSort(n, prereq));
    }

    static List<Integer> topoSort(int n, int[][] prereq) {
        // create a graph (adjacency list)
        List<List<Integer>> graph = new ArrayList<>();
        // we create a graph like --> graph [[], [], [], []];

        // each index represents a node
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Indegree array, stores incoming edges count.
        int[] indegree = new int[n];

        // build graph + indegree, for each pair {a, b}, b --> a (b must be done before
        // a)
        for (int[] p : prereq) {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            result.add(node);

            for(int nei : graph.get(node)){
                indegree[nei]--;
            }
        }

        return result;
    }
}