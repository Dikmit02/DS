class _3_1firstOccurence {
    public static void main(String[] args){
        int[] arr={15, 17 ,17 ,17 ,17 , 18, 19};
        int target =16;
        System.out.println(firstOccurence_LowerBound(arr,target));
        System.out.println(firstOccurence(arr,target));
    }

    public static int firstOccurence_LowerBound(int[] arr,int target) {
        int low=0,high=arr.length-1;
        int first =arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=target){
                high=mid-1;
                first = mid;
            }else{
                 low=mid+1;
            }
        }
        // condition to be check for the lower bound
        if(first==arr.length || arr[first]!=target) return -1;
        return first;
    }

    public static int firstOccurence(int[] arr,int target) {
        int low=0,high=arr.length-1;
        int first =-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                high=mid-1;
                first = mid;
            }
            else if(arr[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return first;
    }

}