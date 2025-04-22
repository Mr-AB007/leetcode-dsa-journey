

/*
Problem Statement:
Given a binary array `nums`, return the maximum length of a contiguous subarray 
with an equal number of 0s and 1s.

Example:
Input: nums = [0,1]
Output: 2

Approach:
- Replace 0s with -1s.
- Use prefix sum and a HashMap to store the first occurrence of each sum.
- If the same prefix sum appears again, it means the elements in between sum to 0
  (equal number of 1s and -1s => equal number of 1s and 0s).
*/

class ContinuousArray {
    public int findMaxLength(int[] nums) {
        int n = nums.length;

        // HashMap to store the first occurrence index of each prefix sum
        Map<Integer, Integer> firstSeen = new HashMap<>();

        // Initialize prefix sum 0 to be at index -1
        // This helps in cases where the subarray starts from index 0
        firstSeen.put(0, -1);

        int maxLength = 0;   // Stores the length of the longest valid subarray
        int prefixSum = 0;   // Running sum where 0 is treated as -1

        for (int i = 0; i < n; i++) {
            // Treat 0 as -1 and 1 as +1
            prefixSum += (nums[i] == 0) ? -1 : 1;

            // If this prefix sum has been seen before,
            // it means the subarray between that index and the current one has equal 0s and 1s
            if (firstSeen.containsKey(prefixSum)) {
                int length = i - firstSeen.get(prefixSum);
                maxLength = Math.max(maxLength, length);
            } else {
                // Otherwise, store the first occurrence of this prefix sum
                firstSeen.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}
