class _3_2lastOccurence {
    public static void main(String[] args){
        int[] arr={15 , 17 ,17 ,17 ,17 , 18, 19};
        int target =16;
        System.out.println(lastOccurence_UpperBound(arr,target));
        System.out.println(lastOccurence(arr,target));
    }

    public static int lastOccurence_UpperBound(int[] arr,int target) {
        int low=0,high=arr.length-1;
        int last =arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>target){
                high=mid-1;
                last = mid;
            }else{
                low=mid+1;
            }
        }
        // condition to be check for the lower bound
        if(last==arr.length || arr[last]!=target) return -1;
        return last-1;
    }

    public static int lastOccurence(int[] arr,int target) {
        int low=0,high=arr.length-1;
        int last =-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                low=mid+1;
                last = mid;
            }
            else if(arr[mid]<target)
                low=mid+1;
            else
                high=mid-1;
            
        }
        return last;
    }

}
