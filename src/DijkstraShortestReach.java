import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by agali on 3/23/16.
 */

public class DijkstraShortestReach {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());

        while (T-- > 0) {
            int N = scan.nextInt();
            int E = scan.nextInt();

            scan.nextLine();
            int graph[][] = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    graph[i][j] = -1;
                }
            }

            for (int i = 0; i < E; i++) {
                int p = scan.nextInt();
                int q = scan.nextInt();
                int w = scan.nextInt();

                graph[p - 1][q - 1] = w;
                graph[q - 1][p - 1] = w;

                scan.nextLine();
            }

            int s = scan.nextInt();

            dijkstraShortReach(graph, s);

            System.out.println();
        }

        scan.close();
    }

    static void dijkstraShortReach(int[][] graph, int src) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int dist[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src - 1] = 0;
        for (int i = 0; i < graph.length; i++) {
            int u = minDistance(dist, hashSet);

            hashSet.add(u);
            for (int k = 0; k < graph.length; k++) {
                if (graph[u][k] != -1) {
                    if (dist[k] > dist[u] + graph[u][k] && dist[u] != Integer.MAX_VALUE && !hashSet.contains(k))
                        dist[k] = dist[u] + graph[u][k];
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }

        for (int i = 0; i < dist.length - 1; i++) {
            if (i == src - 1) continue;
            System.out.print(dist[i] + " ");
        }

        System.out.println(dist[dist.length - 1]);

    }

    static int minDistance(int dist[], HashSet<Integer> S) {
        int min = Integer.MAX_VALUE;
        int min_index = 0;

        for (int v = 0; v < dist.length; v++) {
            if (!S.contains(v) && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }
}