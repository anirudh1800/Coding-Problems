import java.util.Scanner;

/**
 * Created by anirudhruia on 1/17/16.
 */

public class JimAndOrders {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int[][] fanOrders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            String[] values = line.split(" ");
            int value1, value2;

            value1 = Integer.parseInt(values[0]);
            value2 = Integer.parseInt(values[1]);

            fanOrders[i][0] = value1 + value2;
            fanOrders[i][1] = i + 1;
        }

        int t = n;

        while (t > 0) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < t; i++) {
                if (min > fanOrders[i][0]) {
                    min = fanOrders[i][0];
                    index = i;
                }
            }

            System.out.print((fanOrders[index][1]) + " ");
            for (int i = index; i < t - 1; i++) {
                fanOrders[i][0] = fanOrders[i + 1][0];
                fanOrders[i][1] = fanOrders[i + 1][1];
            }

            t--;
        }
    }
}


