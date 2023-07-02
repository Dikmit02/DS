 
class _2_4floorAndCeil {
    public static void main(String[] args){

        // Floor
        // largest element <=x
        // arr[mid]<=x

        // Ceil
        // smallest element >=x , same as lower bound

        // 19 21 if x=20 , then ceil=> 21 and floor is 19
        // 19 20 20 20 , if x=20 , then ceil=> 20 and floor is 20




// Problem Statement: 
// You're given an sorted array arr of n integers and an integer x.
// Find the floor and ceiling of x in arr[0..n-1].
// The floor of x is the largest element in the array which is smaller than or equal to x.
// The ceiling of x is the smallest element in the array greater than or equal to x.

// Example 1:
// Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 5
// Result: 4 7
// Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

// Solution: check for arr[mid]<=x for ceil, and eliminate the left half
//           check for arr[mid]>=x for floor, and eliminate the right half

        int[] arr={15 ,16, 17, 18, 19};
        int target =20;
        System.out.println(Ceil(arr,target));
        System.out.println(Floor(arr,target));
    }
    public static int Ceil(int[] arr,int target) {
        int low=0,high=arr.length-1;
        int ans =-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=target){
                high=mid-1;
                ans = arr[mid];
            }else{
                 low=mid+1;
            }
        }
        return ans;
    }


    public static int Floor(int[] arr,int target) {
        int low=0,high=arr.length-1;
        int ans =-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]<=target){       
                low=mid+1;
                ans = arr[mid];
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
