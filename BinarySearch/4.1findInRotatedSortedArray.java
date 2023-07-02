class _4_1_findInRotatedSortedArray{


// 
// Problem Statement: Given an integer array arr of size N, 
// sorted in ascending order (with distinct values) and a target value k. 
// Now the array is rotated at some pivot point unknown to you. 
// Find the index at which k is present and if k is not present return -1.

// Solution: always check which part of array is sorted 
// then check if target can be between that sorted part 
// if true eliminate the other half 
// if not eliminate this half
// 
    public static void main(String [] args) {

        int[] arr={7,8,9,1,2,3,4,5,6};
        int target =1;
        System.out.println(findInRotatedSortedArray(arr,target));

    }

    public static int findInRotatedSortedArray(int[] arr,int target) {
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]==target){
                return mid;
            }
            // Find in the rotated sorted left half
            if(arr[low]<=arr[mid]){ // condition to check if the array is sorted in left half
                // check if the target is exist in the sorted left array or not
                if(arr[low]<=target && target<=arr[mid])
                    high=mid-1;
                else 
                    low=mid+1;  
            }else{ 
             // Find in the rotated sorted right half
               if(arr[mid]<=target && target<=arr[high])
                    low=mid+1;
                else 
                    high=mid-1;

            }

        }
        return -1;
    }
   
}