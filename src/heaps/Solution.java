public class Solution {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        int[] values = { 13, 16, 31, 41, 51, 100 };
        for (int value : values) {
            maxHeap.insert(value);
        }

        System.out.print("Initial heap: ");
        maxHeap.print();

        maxHeap.delete(13);
        System.out.print("heap after deleting 13: ");
        maxHeap.print();
    }
}
