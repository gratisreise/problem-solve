import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] count;
    static int N, M;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        count = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
        }
        
        int maxCount = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            DFS(i);
        }
        
        for (int i = 1; i <= N; i++) {
            maxCount = Math.max(maxCount, count[i]);
        }
        
        for (int i = 1; i <= N; i++) {
            if (count[i] == maxCount) {
                System.out.print(i + " ");
            }
        }
    }
    
    static void DFS(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            
            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    count[neighbor]++;
                    stack.push(neighbor);
                }
            }
        }
    }
}
