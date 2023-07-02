class FindHowManyTimesAArrayHasBeenRotated {
    public static void main(String[] args){
        // int[] arr={3,-1,2,3,3,3,3};
         int[] arr={7,8,0,1,2,3,4,5,6};
        System.out.println(TimesAArrayHasBeenRotated(arr));

    }

    public static int TimesAArrayHasBeenRotated(int[] arr) {
        int low=0,high=arr.length-1;
        int ans=Integer.MAX_VALUE ;
        int index=-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[low]==arr[mid] && arr[mid]== arr[high]){
                if(arr[low]<ans){
                    ans=arr[low];
                    index=low;
                } 
                low=low+1;
                high=high-1;
                continue;
            }

            if(arr[low]<=arr[high]){
                // if low <=high means the array is already sorted and we not need to find the
                // BS on the array
                if(arr[low]<ans){
                    ans=arr[low];
                    index=low;
                }  
                break; 
            }

            // Find in the rotated sorted left half
            if(arr[low]<=arr[mid]){ 
                 ans = Math.min(ans, arr[low]);
                 if(arr[low]<ans){
                    index=low;
                    ans=arr[low];
                 }
                 low=mid+1;
            }else{ 
             // Find in the rotated sorted right half
                ans = Math.min(ans, arr[mid]);
                if(arr[mid]<ans){
                    index=mid;
                    ans=arr[mid];
                 }
                high=mid-1;
            }
        }
        return index;
    }

}
