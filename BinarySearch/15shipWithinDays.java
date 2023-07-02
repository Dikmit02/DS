 class shipWithinDays {

// '''
// Problem Statement: A conveyor belt has packages that must be shipped from one port to another within days days.
// The ith package on the conveyor belt has a weight of weights[i]. 
// Each day, we load the ship with packages on the conveyor belt (in the order given by weights). 
// We may not load more weight than the maximum weight capacity of the ship.
// Return the least weight capacity of the ship that will result in all the 
// packages on the conveyor belt being shipped within days days.
// Example 1:
// Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
// Output: 15
// Explanation: A ship capacity of 15 is the minimum to ship all the 
// packages in 5 days like this:
// 1st day: 1, 2, 3, 4, 5
// 2nd day: 6, 7
// 3rd day: 8
// 4th day: 9
// 5th day: 10
// Note that the cargo must be shipped in the order given, so using a ship 
// of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
// '''
    public static void main(String[] args)   {
        int[] nums = {3,2,2,4,1,4};
        int  threshold = 3;
        System.out.println(shipWithinDays_(nums,threshold));
        System.out.println(shipWithinDays_BinarySearch(nums,threshold));

    }

    public static int  calculateRequiredDays(int[] nums, int capacity){
        int load=0;
        int daysSoFar=1;

        for(int i=0; i<nums.length; i++){
            if(load+nums[i]>capacity){
                daysSoFar+=1;
                load=nums[i];
            }else{
                load+=nums[i];
            }
        } 
        return daysSoFar;
    }


    public static int shipWithinDays_(int[] nums, int days) {
        
        int max=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            max=Math.max(max, nums[i]);
            sum+=nums[i];
        }
        for(int capacity=max;capacity<=sum;capacity++){
           int reqdays=calculateRequiredDays(nums, capacity);
    
           if(reqdays<=days){
            return capacity;
           }
        }

        return max;
    }


    public static int shipWithinDays_BinarySearch(int[] nums, int days) {
        int max=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            max=Math.max(max, nums[i]);
            sum=sum+nums[i];
        }
        int low=max;
        int high=sum;
        while(low<=high){
           int mid=low+(high-low)/2;
           int reqdays=calculateRequiredDays(nums, mid);
           if(reqdays<=days){
             high=mid-1;
           }else{
            low=mid+1;
           }
        }
        return low;
    }

}
