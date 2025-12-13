public class Solution {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        int[] values = { 10, 7, 11, 5, 4, 13 };
        for (int value : values) {
            maxHeap.insert(value);
            System.out.print("Inserted " + value + " into the max-heap: ");
            maxHeap.print();
        }
    }
}
