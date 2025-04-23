import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int value) {
        if (size == heap.length) {
            throw new IllegalStateException("Heap está cheio");
        }
        heap[size] = value;
        siftUp(size);
        size++;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[index] <= heap[parent]) {
                break;
            }
            swap(index, parent);
            index = parent;
        }
    }

    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap vazio");
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return max;
    }

    private void siftDown(int index) {
        while (index < size / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largest = leftChild;

            if (rightChild < size && heap[rightChild] > heap[leftChild]) {
                largest = rightChild;
            }

            if (heap[index] >= heap[largest]) {
                break;
            }

            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public int getSize() {
        return size;
    }
}
