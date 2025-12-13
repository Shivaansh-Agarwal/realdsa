import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private List<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
    }

    public void insert(int value) {
        this.heap.add(value);
        int index = heap.size() - 1;
        while (index > 0) {
            int parentIndex = (index-1)/2;
            int parent = heap.get(parentIndex);
            int curr = heap.get(index);
            if (curr > parent) {
                heap.set(index, parent);
                heap.set(parentIndex, curr);
                index = (index-1)/2;
            } else {
                break;
            }
        }
    }

    public void delete(int value) {
        int index = -1;
        for (int i=0; i<heap.size(); i++) {
            if (heap.get(i) == value) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return;
        }
        heap.set(index, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        while (true) {
            int leftChild = 2*index + 1;
            int rightChild = 2*index + 2;
            int largest = index;
            if (leftChild < heap.size() && heap.get(leftChild) > heap.get(largest)) {
                largest = leftChild;
            }
            if (rightChild < heap.size() && heap.get(rightChild) > heap.get(largest)) {
                largest = rightChild;
            }
            if (largest != index) {
                int temp = heap.get(index);
                heap.set(index, heap.get(largest));
                heap.set(largest, temp);
                index = largest;
            } else {
                break;
            }
        }
    }

    public void print() {
        for (int i=0; i<heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println("");
    }
    
}
