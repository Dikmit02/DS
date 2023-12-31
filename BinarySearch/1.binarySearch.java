class BinarySearch {
     static void main(String[] args) {
        int[] arr={1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9};
        int target =5;
        System.out.println(BS(arr,target));
        
    }

    public static int BS(int[] arr,int target) {
        int low=0,high=arr.length;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}