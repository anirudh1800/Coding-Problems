import java.util.*;

/**
 * Created by agali on 5/1/16.
 */
public class CutTheTree {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        int n = Integer.parseInt(input);

        input = scan.nextLine();
        int[] weights = Arrays.asList(input.split(" ")).stream().map(Integer::valueOf).mapToInt(i -> i).toArray();
        List<Integer>[] adjList = new LinkedList[n];

        while (scan.hasNextLine()) {
            String[] edge = scan.nextLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);

            if (adjList[a - 1] == null) {
                adjList[a - 1] = new LinkedList<>();
            }

            adjList[a - 1].add(b - 1);

            if (adjList[b - 1] == null) {
                adjList[b - 1] = new LinkedList<>();
            }

            adjList[b - 1].add(a - 1);
        }

        int[] tree_sums = new int[weights.length];
        tree_sums[0] = weights[0];

        int sum = dfs(0, adjList, weights, null, tree_sums);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
//            System.out.println(tree_sums[i]);
            min = Integer.min(min, Math.abs(sum - 2 * tree_sums[i]));
        }

        System.out.println(min);
        //System.out.println(minCut(adjList, weights));
    }

//    static int minCut(final List<Integer>[] adjGraph, final int[] weights) {
//        int min = Integer.MAX_VALUE;
//        int Tree = dfs(0, adjGraph, weights, null);
//
//        ArrayDeque<Integer> visited = new ArrayDeque<>();
//        ArrayDeque<Integer> unvisited = new ArrayDeque<>();
//
//        unvisited.addFirst(0);
//        while (!unvisited.isEmpty()) {
//            int next = unvisited.peekFirst();
//            visited.add(unvisited.removeFirst());
//
//            for (int node : adjGraph[next]) {
//                if (visited.contains(node)) continue;
//
//                int sum = dfs(node, adjGraph, weights, new ArrayDeque<>(visited));
//                min = Integer.min(min, Math.abs(Tree - 2 * sum));
//
//                System.out.println(min + " " + next + " -> " + node + " sum " + sum);
//                unvisited.addFirst(node);
//            }
//        }
//
//        return min;
//    }

    static int dfs(final int root, final List<Integer>[] adjGraph, final int[] weights, ArrayDeque<Integer> visited, int[] tree_sums) {
        int sum = weights[root];

        if (visited == null) visited = new ArrayDeque<>();

        visited.add(root);
        for (int node : adjGraph[root]) {
            if (!visited.contains(node)) {
                tree_sums[node] = dfs(node, adjGraph, weights, visited, tree_sums);
                sum += tree_sums[node];
            }
        }

        return sum;
    }
}
