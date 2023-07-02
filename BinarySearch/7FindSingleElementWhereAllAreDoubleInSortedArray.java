class FindSingleElementInSortedArray{
    //Problem
    //Given a sorted array arr[] of size N. 
    //Find the element that appears only once in the array. 
    //All other elements appear exactly twice. 

   // N = 11
   //arr[] = {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65}
   //Output: 4


   // Right sorted if (odd,even ) eliminate right half
   // Left sorted if (even,odd) eliminate left half

   //Solution 
   //1 check if single element return
   //2 check if first and second elements are not equal return 1 element
   //3 check if last and second last elements are not equal return last element
   //4 trim down the serach space to 1 and total-1;
   //5 check mid is on which section (before target or after target) 

    // Hint: observation on the input array. 
    // All elements before the required have the first occurrence at even index (0, 2, ..) 
    // and the next occurrence at odd index (1, 3, …). 
    // And all elements after the required elements have the 
    // first occurrence at an odd index and the next occurrence at an even index.
    // ===>Before Target same element on (even,odd)
    // ===>After Target same element on (odd,even)

    public static void main(String[] args){
        // int[] arr={3,-1,2,3,3,3,3};
         int[] arr={7,8,0,1,2,3,4,5,6};
        System.out.println(SingleElementInSortedArray(arr));
    }   

    public static int SingleElementInSortedArray(int[] arr) {
     
      int n=arr.length;

      if(n==1) return arr[0];
      if(arr[0]!=arr[1]) return arr[0];
      if(arr[n-1]!=arr[n-2]) return arr[n-2];
      
      int low=1,high=arr.length-2;
      while(low<=high){
        int mid=(low+high)/2;

        // mere se left b alag and right b alag I am the anser
        if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]) 
            return arr[mid];
        
        // check the position of the mid
        // ie even or odd

        // (mid ==odd && mein and just piche equal)  || (mid==even && mein and just age equal)
        // left half sorted eliminate left half
        if(
            (mid%2==1 && arr[mid-1]==arr[mid]) 
            ||
            (mid%2==0  && arr[mid]==arr[mid+1])
        ){
            low=mid+1;
        }else{
            high=mid-1;
        }
      }
      return -1;
    }
}