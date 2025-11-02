class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num); // Add current element

            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }

        // The root of the heap is the kth largest element
        return minHeap.peek();
    }
}
