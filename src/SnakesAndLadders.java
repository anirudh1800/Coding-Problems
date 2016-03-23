import java.util.HashSet;
import java.util.Scanner;

public class SnakesAndLadders {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        while (T-- > 0) {
            scan.nextLine();

            int N = scan.nextInt();
            int[][] ladders = new int[N][2];

            for (int i = 0; i < N; i++) {
                scan.nextLine();
                ladders[i][0] = scan.nextInt();
                ladders[i][1] = scan.nextInt();

            }

            scan.nextLine();

            int M = scan.nextInt();
            int[][] snakes = new int[M][2];

            for (int i = 0; i < M; i++) {
                scan.nextLine();
                snakes[i][0] = scan.nextInt();
                snakes[i][1] = scan.nextInt();
            }

            System.out.println(minRolls(ladders, snakes));
        }
        
        scan.close();

    }

    static int minRolls(int[][] ladders, int[][] snakes) {
        int[] rolls = new int[101];

        for (int i = 1; i <= 100; i++)
            rolls[i] = Integer.MAX_VALUE;

        rolls[1] = 0;

        HashSet<Integer> snakeHeads = new HashSet<>();

        for (int i = 0; i < snakes.length; i++)
            snakeHeads.add(snakes[i][0]);

        for (int i = 2; i <= 100; i++) {
            if (i > 7) {
                int min = Integer.MAX_VALUE;
                for (int k = i - 6; k < i; k++)
                    if (!snakeHeads.contains(k) && min > rolls[k])
                        min = rolls[k];
                rolls[i] = Math.min(min + 1, rolls[i]);
            } else {
                rolls[i] = 1;
            }

            for (int j = 0; j < ladders.length; j++) {
                if (ladders[j][0] == i) {
                    int temp = ladders[j][1];

                    if (rolls[i] != Integer.MAX_VALUE && rolls[i] < rolls[temp])
                        rolls[temp] = rolls[i];
                }
            }

            for (int k = 0; k < snakes.length; k++) {
                if (snakes[k][0] == i) {
                    if (rolls[snakes[k][1]] > rolls[i]) {
                        rolls[snakes[k][1]] = rolls[i];
                        i = snakes[k][1];
                        break;
                    }
                }
            }

        }

        int result;
        if (rolls[100] < 0)
            result = -1;
        else
            result = rolls[100];

        return result;
    }
}
