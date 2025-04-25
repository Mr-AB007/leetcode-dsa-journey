class SubarraySumEqualsK {
    //subarray-sums-divisible-by-k
//binary-subarrays-with-sum
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int prefixSum = 0;

        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0,1);

        for(int i = 0; i < n; i++){
            
            prefixSum += nums[i];
            if(freq.containsKey(prefixSum - k))
                count += freq.get(prefixSum - k);

            freq.put(prefixSum,freq.getOrDefault(prefixSum,0)+1);

        }
        return count;
    }
}
