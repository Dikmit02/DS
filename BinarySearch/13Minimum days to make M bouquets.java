class MinimumdaysToMakeMBouquets {

// Problem:Minimum Number of Days to Make m Bouquets
// You are given an integer array bloomDay, an integer m and an integer k.
// You want to make m bouquets. To make a bouquet, 
// you need to use k adjacent flowers from the garden.
// The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] 
// and then can be used in exactly one bouquet.
// Return the minimum number of days you need to wait to be able to make m bouquets 
// from the garden. If it is impossible to make m bouquets return -1

// Solution:days could be between min(arr) and max(arr)
// Note: only valid when k adjacent  
    public static void main(String[] args){
        int[] bloomDay={7,7,7,7,12,7,7};
        // {7,7,7,7,6,7,7,12,1};
        int m=2; 
        int k=3;
        System.out.println(MinimumdaysToMakeMBouquets_(bloomDay,m,k));
    }

public static boolean isPossible(int[] bloomDay, int day,int m, int k){
    int counter=0;
    int bouquetSofar=0;
    for(int i=0;i<bloomDay.length;i++){
        if(bloomDay[i]<=day){
            counter+=1;
        }else{
            counter=0;
        }
        if(counter!=0&& counter%k==0){
            bouquetSofar+=1;
            counter=0;
        }
        if(bouquetSofar==m){
            return true;
        }
    }
    return false;
}


public static int MinimumdaysToMakeMBouquets_(int[] bloomDay, int m, int k){
    if(m*k>bloomDay.length) return -1;
    int min=bloomDay[0];
    int max=bloomDay[0];
    for(int i=1;i<bloomDay.length;i++){
        min=Math.min(min, bloomDay[i]);
        max=Math.max(max, bloomDay[i]);
    }
    int low=min;
    int high=max;
    int ans=Integer.MAX_VALUE;
    while(low<=high){
        int mid=low+(high-low)/2;
        boolean kk=isPossible(bloomDay, mid,m,k);
        if(kk){
            ans=Math.min(mid,ans);
            high=mid-1;
        }else{
            low=mid+1;
        }
    }
    if(ans==Integer.MAX_VALUE) return -1;
    return ans;
}

}


