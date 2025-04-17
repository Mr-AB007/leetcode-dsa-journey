
//303. Range Sum Query - Immutable
class RangeSumQuery {
    int [] prefixsum; // -2,-2,1,-4,-3,-4
    public RangeSumQuery(int[] nums ) {//-2, 0, 3, -5, 2, -1  //1-4
        int n = nums.length;

        prefixsum = new int[n];
        prefixsum[0] = nums[0]; 
    // Fill in the prefix array such that prefix[i] stores the sum of elements from 0 to i
        for(int i = 1;i < n ; i++){
            prefixsum[i] = prefixsum[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        // If the range starts from index 0, return prefix[right] directly
        if(left == 0)
           return prefixsum[right];

        // Otherwise, subtract the prefix sum up to left-1 to get the range sum
        return prefixsum[right] - prefixsum[left-1];
    }
}

/**
 * Your RangeSumQuery object will be instantiated and called as such:
 * RangeSumQuery obj = new RangeSumQuery(nums);
 * int param_1 = obj.sumRange(left,right);
 */
