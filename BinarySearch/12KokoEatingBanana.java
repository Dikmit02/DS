class KokoEatingBanana{
//
// Koko loves to eat bananas. There are n piles of bananas, 
// the ith pile has piles[i] bananas. 
// The guards have gone and will come back in h hours.
// Koko can decide her bananas-per-hour eating speed of k. 
// Each hour, she chooses some pile of bananas and eats k bananas from that pile. 
// If the pile has less than k bananas, 
// she eats all of them instead and will not eat any more bananas during this hour.
// Return the minimum integer k such that she can eat all the bananas within h hours.
// Example 1:
// Input: piles = [3,6,7,11], h = 8
// Output: 4      

// Solution: ans could be between 1 banana per hour and max(arr) banana per hour 
// so use binary search to eliminate the half which not have the ans
//

public static void main(String[] args){
    int arr[]={805306368,805306368,805306368};
    // int hours=18;
    System.out.println(KokoEatingBanana_(arr,1000000000));


}

public static int ceil(int[] arr,int divisor){
    double sum=0;
    for(int i=0;i<arr.length;i++){
       sum+=Math.ceil((double)arr[i]/(double)divisor);   
    }
    return (int)sum;
}

 public static int KokoEatingBanana_(int[] arr,int hours) {
   int max=arr[0];
   for(int i=1;i<arr.length;i++){
    max=Math.max(max,arr[i]);
   }
   
   
   int low=1;
   int high=max;
   int ans=high;

   while(low<=high){
    int mid=low+(high-low)/2; 
    if(ceil(arr,mid)<=hours){
        ans=Math.min(mid,ans);
        high=mid-1;
    }else{
        low=mid+1;
    }
   }
 

return ans;
}


}

