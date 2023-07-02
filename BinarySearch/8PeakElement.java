 class PeakElement {
// Problem Statement: Given an array, 
// find a peak element(print anyone, if many are found). 
// A peak element is one such that it is either greater than or equal to its neighbors.
// For the first and last element, it is enough to look at its only one neighbor.

// Solution: check for mid and if element adjacent to is smaller, 
// if not check if it on increasing slope or decreasing slope then 
// eliminate the part accordingly.

// Note: Assume that before first index and after last index there is -infinity,
// if first>second ,first is peek
// if last >second ,last is peek
    public static void main(String[] args){
         int[] arr={2,6,3,7,8,9};
         System.out.println(PeakElement_(arr));
    }     
    
    public static int PeakElement_(int[] arr) {
        int n=arr.length;
        if(n==1) return 0;
        if(arr[0]>arr[1]) return 0;
        if(arr[n-1]>arr[n-2]) return n-1;
        
        int low=1;
        int high=n-2;

        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(arr[mid]>arr[mid-1]){
                low=mid+1;
            }else if(arr[mid]>arr[mid+1]){
                high=mid-1;
            }else{
                // to handle multiple peaks and return any one
                low=mid+1;
            }
        }
        return -1;
    }
}
