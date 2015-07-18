
public class LCSnMaxSubArrayDP {


    public static void main(String[] args) {
        double[] A = new double[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        double[] out = maximum_subarray(A, 0, 15);

        for (double d : out) {
            System.out.println(d);
        }

        System.out.println(longest_common_subsequence("banana", "atana"));
    }

    public static double[] max_crossing_subarray(double[] A, int low, int mid, int high) {
        double left_sum = Double.NEGATIVE_INFINITY;
        double sum = 0;
        double max_left = mid;
        double max_right = mid;

        for (int i = mid; i >= low; i--) {
            sum += A[i];
            if (sum > left_sum) {
                left_sum = sum;
                max_left = i;
            }
        }

        double right_sum = Double.NEGATIVE_INFINITY;
        sum = 0;

        for (int j = mid + 1; j <= high; j++) {
            sum += A[j];
            if (sum > right_sum) {
                right_sum = sum;
                max_right = j;
            }
        }
        return new double[]{max_left, max_right, left_sum + right_sum};
    }

    public static double[] maximum_subarray(double[] A, int low, int high) {
        if (high == low)
            return new double[]{low, high, A[low]};
        else {
            int mid = (int) Math.ceil((low + high) / 2);

            double[] left = maximum_subarray(A, low, mid);
            double[] right = maximum_subarray(A, mid + 1, high);
            double[] cross = max_crossing_subarray(A, low, mid, high);

            if (left[2] >= right[2] && left[2] >= cross[2])
                return left;
            else if (right[2] >= left[2] && right[2] >= cross[2])
                return right;
            else
                return cross;
        }
    }


    public static char[] longest_common_subsequence(String a, String b) {
        int[][] L = new int[a.length() + 1][];

        for (int i = 0; i <= a.length(); i++)
            L[i] = new int[b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }

        int index = L[a.length()][b.length()];
        char output[] = new char[index];

        int i, j;
        i = a.length();
        j = b.length();

        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                output[index - 1] = a.charAt(i - 1);
                index--;
                i--;
                j--;
            } else if (L[i - 1][j] > L[i][j - 1]) {
                i--;
            } else
                j--;
        }
        return output;
    }
}