class _2_2upperBound {
    public static void main(String[] args){
        // arr[mid]>x
        // uppper bound is number should  just greater than the number
        // let x=20
        // 19 20 21 => ans 21 (2)
        // 19 19 21 => ans 21 (2)
        // 19 20 20 20 20 21 => ans 20(5)
         //15 16 17 18 19 ,_ => ans 20(5) // length of array
        int[] arr={19, 19  ,21};
        int target =20;
        System.out.println(UpperBound(arr,target));

    }

    public static int UpperBound(int[] arr,int target) {
        int low=0,high=arr.length-1;
        int ans =arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>target){
                high=mid-1;
                ans = mid;
            }else{
                 low=mid+1;
            }
        }
        return ans;
    }

}
