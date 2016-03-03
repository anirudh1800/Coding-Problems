import java.util.Scanner;

public class SherLockAndArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        while (T-- > 0) {
            scan.nextLine();
            int N = scan.nextInt();
            boolean flag = false;

            scan.nextLine();
            int array[] = new int[N];

            for (int i = 0; i < N; i++)
                array[i] = scan.nextInt();

            for (int i = 0; i < N; i++) {
                int left_sum = 0;
                int right_sum = 0;

                for (int j = 0; j < i; j++)
                    left_sum += array[j];

                for (int j = i + 1; j < N; j++)
                    right_sum += array[j];

                if (left_sum == right_sum) {
                    flag = true;
                    System.out.println("YES");
                    break;
                }
            }

            

            if (!flag)
                System.out.println("NO");
        }
    }
}