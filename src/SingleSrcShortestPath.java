/**
 * Created by anirudhgali on 7/18/15.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Single Source Shortest Path Problem hackerrank bfs shortest reach

public class SingleSrcShortestPath {
    static List<Integer>[] adj;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int M = scan.nextInt();

            adj = (List<Integer>[]) new List[N];
            for (int j = 0; j < N; j++) {
                adj[j] = new ArrayList<Integer>(N);
            }

            for (int j = 0; j < M; j++) {
                int u = scan.nextInt();
                int v = scan.nextInt();

                adj[u - 1].add(v - 1);
                adj[v - 1].add(u - 1);
            }
            int source = scan.nextInt();
            shortestPathFrmSrc(adj, source, N);
        }
    }

    public static void shortestPathFrmSrc(List<Integer>[] g, int startnode, int N) {
        int dist[] = new int[N];
        HashSet<Integer> S = new HashSet<Integer>();
        ArrayList<Integer> Q = new ArrayList<Integer>();

        for (int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[startnode - 1] = 0;

        for(int i = 0; i < N - 1; i++){
            int u = minDistance(dist, S);

            S.add(u);
            for (int v : adj[u]) {
                if (dist[v] > dist[u] + 6 && dist[u]!= Integer.MAX_VALUE && !S.contains(v))
                    dist[v] = dist[u] + 6;
            }
        }

        for (int i = 0; i < N; i++) {
            if(i == startnode - 1)
                continue;
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print("-1 ");
            else
                System.out.print(dist[i] + " ");
        }

    }

    public static int minDistance(int dist[], HashSet<Integer> S) {
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