import java.util.Scanner;

/**
 * Created by agali on 2/4/16.
 */

public class EvenTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        int[][] adjMatrix = new int[N][N];

        for(int i = 0; i < M; i++){
            scan.nextLine();

            int a = scan.nextInt();
            int b = scan.nextInt();

            adjMatrix[a-1][b-1] = 1;
            adjMatrix[b-1][a-1] = 1;
        }

        int cuts = 0;

        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(adjMatrix[i][j] == 1 && (1 + dfs(j, adjMatrix)) % 2 != 0){
                    adjMatrix[i][j] = 0;
                    adjMatrix[j][i] = 0;
                    cuts++;
                }
            }
        }

        System.out.println(cuts);
        scan.close();
    }

    static int dfs(int i, int[][] adjMatrix){
        int count = 1;
        for(int j = i + 1; j < adjMatrix.length; j++){
            if(adjMatrix[i][j] == 1){
                count += dfs(j, adjMatrix);
            }
        }

        return count;
    }
}
