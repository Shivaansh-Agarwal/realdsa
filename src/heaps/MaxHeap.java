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

    public void print() {
        for (int i=0; i<heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println("");
    }
    
}
