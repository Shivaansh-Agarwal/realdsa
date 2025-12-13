1. What is a heap data structure?
- A complete binary tree that satisfies the heap property - each node's value is greater than or equal to it's children's value (max heap), or each node's value is lesser than or equal to it's children's value (min heap).

2. Time Complexity of Insertion or Deletion
- O(log N)

3. Applications of Heaps
- Priority Queues
- Heap Sort
- Finding Kth Smallest or Kth Largest
- Used in algorithms like Dijkstra's Algorithm for shortest path.
- Enabling network routing and Huffman coding for data compression.

---

1. How's a heap different than BST?
- Finding min/max takes O(1) in a heap. So it's mostly used in such kind of applications.

2. Why can heap be stored in an array?
- A heap can be stored in an array because it is a complete binary tree, so nodes are filled level by level without gaps, allowing parent–child relationships to be calculated using index arithmetic instead of pointers.

3. Why is heap insertion forced to happen at the end of the array?

4. Why is insertion O(log n)?

5. One real problem where heap is better than sorting?

