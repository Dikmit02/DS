
class _2_3inserPosition {

// Question: You are given a sorted array arr of distinct values and a target value x. 
// You need to search for the index of the target value in the array.
// If the value is present in the array, then return its index. Otherwise, 
// determine the index where it would be inserted in the array while 
// maintaining the sorted order.


// Solution: find the lower_bound

    public static void main(String[] args){
        // The insert postion is same as the lower bound 
        // lower bound is number should be equal or just greater than the number
        // let x=20
        // 19  21 => ans 20 (1)
        // 19 19  => ans 20 (2)
        // 21 => ans 20(0)
         //15 16 17 18 19 ,_ => ans 20(5) // length of array
        int[] arr={15 ,16, 17, 18, 19};
        int target =20;
        System.out.println(LowerBound(arr,target));

    }

     public static int LowerBound(int[] arr,int target) {
        int low=0,high=arr.length-1;
        int ans =arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=target){
                high=mid-1;
                ans = mid;
            }else{
                 low=mid+1;
            }
        }
        return ans;
    }
}
