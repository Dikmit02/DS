class findInRotatedSortedArrayWithDuplicates{
// Problem Statement:  Given an integer array arr of size N, 
// sorted in ascending order (may contain duplicate values) and a target value k. 
// Now the array is rotated at some pivot point unknown to you. 
// Return True if k is present and otherwise, return False. 

// Solution: always check which part of array is sorted 
// then check if target can be between that sorted part 
// if true eliminate the other half 
// if not eliminate this half 
// Note:this array will contain duplicate so 
// if element at low ,mid and high are equal 
// just skip the iteration and replace low with low +1 and high with high-1
    public static void main(String[] args){
        int[] arr={3,1,2,3,3,3,3};
        // low=3,
        // high=3
        // mid=3
        // therefore the condition to check the roated left half and rotated right half will failed
        // if(arr[low]==arr[mid] && arr[mid]== arr[high]){
              //low=low+1;
              //  high=high-1;
              //continue;
            // }
            // and trim down the search space

        int target =1;
        System.out.println(findInRotatedSortedArrayWithDuplicates_(arr,target));


    }

     public static int findInRotatedSortedArrayWithDuplicates_(int[] arr,int target) {
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]==target){
                return mid;
            }
            if(arr[low]==arr[mid] && arr[mid]== arr[high]){
                low=low+1;
                high=high-1;
                continue;
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