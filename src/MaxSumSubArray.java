import java.util.Scanner;

/**
 * Created by agali on 1/27/16.
 */


// Divide and Conquer Strategy

public class MaxSumSubArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.valueOf(scan.nextLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }

        System.out.println(findMaxSumSubArray(0, n - 1, nums));
        
        scan.close();

    }

    public static int findMaxSumSubArray(int low, int high, int[] nums) {
        if (low < high) {
            int mid = (low + high) / 2;
            int left_sum = findMaxSumSubArray(0, mid, nums);
            int right_sum = findMaxSumSubArray(mid + 1, high, nums);
            int cross_sum = crossing_sum_subarray(low, mid, high, nums);

            if (left_sum < right_sum) {
                if (right_sum < cross_sum) {
                    return cross_sum;
                } else return right_sum;
            } else if (left_sum < cross_sum) {
                return cross_sum;
            } else
                return left_sum;
        }else if(low == high){
            if(nums[low] < 0)
                return 0;
            else return nums[low];
        }

        return 0;
    }

    public static int crossing_sum_subarray(int low, int mid, int high, int[] nums) {
        int left_sum = 0;
        int right_sum = 0;
        int sum = 0;

        for (int i = mid; i >= low; i--) {
            if (nums[i] != 0) {
                sum += nums[i];
                if (sum > left_sum) {
                    left_sum = sum;
                }
            } else  break;
        }

        sum = 0;

        for (int i = mid + 1; i <= high; i++) {
            if (nums[i] != 0) {
                sum += nums[i];
                if (sum > right_sum) {
                    right_sum = sum;
                }
            } else break;
        }

        return left_sum + right_sum;
    }

}


