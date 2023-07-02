class FindKthMissing {
// Given an array arr of positive integers sorted in a strictly 
// increasing order, and an integer k.
// Return the kth positive integer that is missing from this array.
// Example 1:
// Input: arr = [2,3,4,7,11], k = 5
// Output: 9
// Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...].
// The 5th missing positive integer is 9.

// Solution: the missing number would be 1 and max(arr) 
// find the missing numbers before mid i.e arr[mid]-(mid+1)
// then shift low and high accordingly, 
// return high+k+1 or low+k
// 
        public static void main(String[] args)   {
        int[] nums = {1,2,3,4};
        int  k = 2;
        System.out.println(findKthPositive_(nums,k));
        System.out.println(findKthPositive_BS(nums,k));

    }

    public static int findKthPositive_(int[] arr, int k) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=k){
                k++;
            }else{
                break;
            }
        }
        return k;
    }
     public static int findKthPositive_BS(int[] arr, int k) {
        int low=0;
        int high=arr.length-1;
         while(low<=high){
                int mid=low+(high-low)/2;
                int missing=arr[mid]-(mid+1);
                if(missing<k){
                    low=mid+1;
                }else{
                    high=mid-1;  
                }
        }
        // int missing=arr[high]-high-1;
        // int more=k-missing;
        // int ans=arr[high]+more;
        // high+1+k
        // low+k
        return low+k;
    }
}
