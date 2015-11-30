/**
 * Created by anirudhruia on 11/29/15.
 */

public class KthLargest {

    public static int kthSmallest(int heap[], int n, int k) {
        MinHeap minHeap = new MinHeap(heap, n);

        for (int i = 0; i < k - 1; i++) {
            minHeap.extractMin();
        }

        return minHeap.getMin();
    }

    public static void main(String[] args) {
        int arr[] = {12, 3, 5, 7, 19};

        System.out.println(kthSmallest(arr, arr.length, 2));
    }
}


class MinHeap {
    private int[] heap;
    private int size;

    public MinHeap(int a[], int size) {
        heap = new int[a.length];

        System.arraycopy(a, 0, heap, 0, size);
        this.size = size;

        int i = (size - 1) / 2;

        while (i >= 0) {
            minHeapify(i);
            i--;
        }

    }

    public void minHeapify(int i) {
        int l = left(i);
        int r = right(i);

        int smallest = i;

        if (l < size && heap[l] < heap[i])
            smallest = l;

        if (r < size && heap[r] < heap[smallest])
            smallest = r;

        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            minHeapify(smallest);
        }
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return (2 * i + 1);
    }

    public int right(int i) {
        return (2 * i + 2);
    }

    public int extractMin() {
        if (size == 0)
            return Integer.MAX_VALUE;

        int root = heap[0];

        if (size > 1) {
            heap[0] = heap[size - 1];
            minHeapify(0);
        }
        size--;

        return root;
    }

    public int getMin() {
        return heap[0];
    }
}