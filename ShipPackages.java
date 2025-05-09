class Solution { 
    public int shipWithinDays(int[] weights, int days) {
        // Time Complexity: O(N * log(Sum - Max)), where N is the number of weights
        // Space Complexity: O(1)

        int low = 0;
        int high = 0;

        for(int w:weights) {
            low = Math.max(low, w);
            high += w;
        }

        while(low < high) {
            int mid = low + (high - low) / 2; //avoiding Integer overflow
            int day = 1, target = 0;

            for(int w: weights) {
                if (target + w > mid) {
                    target = 0;
                    day++;
                }
                target += w;
            }

            if(day > days) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
}
