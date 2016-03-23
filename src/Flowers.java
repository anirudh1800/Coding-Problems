import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by anirudhruia on 1/18/16.
 */
public class Flowers {
    public static void main(String args[]) {

// helpers for input/output

        Scanner in = new Scanner(System.in);

        int N, K;
        N = in.nextInt();
        K = in.nextInt();

        int C[] = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = in.nextInt();
        }

        int result = minCostFlowers(C, N, K);

        System.out.println(result);
        
        scan.close();

    }

    public static int minCostFlowers(int C[], int N, int K) {
        List<Integer> cList = new ArrayList<Integer>();
        int[][] results = new int[K][2];

        for (int i = 0; i < C.length; i++)
            cList.add(C[i]);

        cList.sort(java.util.Collections.reverseOrder());

        for (int i = 0; i < K; i++) {
            results[i][1] = 0;
            results[i][0] = 0;
        }

        int min;
        int index;

        while (!cList.isEmpty()) {
            min = Integer.MAX_VALUE;
            index = -1;

            for (int i = 0; i < K; i++) {
                if (min > results[i][0]) {
                    min = results[i][0];
                    index = i;
                }
            }

            results[index][1] += (results[index][0] + 1) * cList.get(0);
            results[index][0]++;
            cList.remove(0);
        }

        int result = 0;

        for (int i = 0; i < K; i++) {
            result += results[i][1];
        }

        return result;
    }
}
