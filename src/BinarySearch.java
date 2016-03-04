/**
 * Created by agali on 3/4/16.
 */

public class BinarySearch {
    // binarySearch implementation
    public static int binarySearch(int[] sortedArray, int low, int high, int target) {
        if (low < high) {
            int mid = (low + high) / 2;

            if (sortedArray[mid] == target)
                return mid;
            else if (sortedArray[mid] < target) {
                return binarySearch(sortedArray, mid + 1, high, target);
            } else {
                return binarySearch(sortedArray, low, mid, target);
            }
        }

        return target > sortedArray[low] ? low + 1 : low;
    }

    // Stub code
    public static void main(String args[]) {
        // Assumption: No duplicates
        int array[] = {2, 4, 5, 6, 10, 34};

        System.out.println(binarySearch(array, 0, array.length - 1, 36));

    }
}
