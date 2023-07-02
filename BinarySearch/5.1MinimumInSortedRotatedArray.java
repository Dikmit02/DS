class MinimumInSortedRotatedArray {

// Problem Statement: Given an integer array arr of size N, 
// sorted in ascending order (with distinct values). 
// Now the array is rotated between 1 to N times which is unknown. 
// Find the minimum element in the array. 


// Solution: always check which part of array is sorted 
// then set ans as min of that sorted part then eliminate the 
// sorted part and move to the unsorted part

// Note: the key solution here is the sorted part might or 
// might not contain the minimum element

// This solution will be same if we want to get the pivot index in roated sorted array

      public static void main(String[] args){
        int[] arr={7,8,0,1,2,3,4,5,6};
        System.out.println(findMinimumInSortedRotatedArray(arr));

      }

    public static int findMinimumInSortedRotatedArray(int[] arr) {
        int low=0,high=arr.length-1;
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            // Find in the rotated sorted left half
            if(arr[low]<=arr[mid]){ 
                ans = Math.min(ans, arr[low]);
                low=mid+1;
            }else{ 
             // Find in the rotated sorted right half
                ans = Math.min(ans, arr[mid]);
                high=mid-1;
            }
        }
        return ans;
    }

}
