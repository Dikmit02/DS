class smallestDivisor
{

// Problem Statement:Given an array of integers nums and an integer threshold,
// we will choose a positive integer divisor, divide all the array by it, 
// and sum the division's result. Find the smallest divisor such that the 
// result mentioned above is less than or equal to threshold.

// Each result of the division is rounded to the nearest integer 
// greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

// Solution: use binary search between 1 and max(arr) and eliminate the half 
// which divisor sum is not possible
    public static void main(String[] args)   {
        int[] nums = {1,2,5,9};
        int  threshold = 6;
        // System.out.println(smallestDivisor_(nums,threshold));
        System.out.println(smallestDivisor_BinarySearch(nums,threshold));
    }

    public static int smallestDivisor_(int[] nums, int threshold) {
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
        max=Math.max(max, nums[i]);
        }
        
        for(int i=1;i<=max;i++){
            double sum=0;
            for(int j=0;j<nums.length;j++){
                sum+=Math.ceil((double)nums[j]/(double)i);
            }
            if((int)sum<=threshold){
                return i;
            }
        }

        return max;
    }

    public static int smallestDivisor_BinarySearch(int[] nums, int threshold) {
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
        max=Math.max(max, nums[i]);
        }


        int low=1;
        int high=max;
        while(low<=high){
            int mid=low+(high-low)/2;
            double sum=0;
            for(int j=0;j<nums.length;j++){
                sum+=Math.ceil((double)nums[j]/(double)mid);
            }
            if((int)sum<=threshold){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}