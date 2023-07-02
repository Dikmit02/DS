class _3_3_calculateOccurence {

    public static void main(String[] args){
        int[] arr={15 , 17 ,17 ,17 ,17 , 18, 19};
        int target =16;
        int first=_3_1firstOccurence.firstOccurence(arr, target);
        int totalOccurence;
        if(first==-1){
            totalOccurence= 0;
            System.out.println(totalOccurence);
            return;
        }
        int last=_3_2lastOccurence.lastOccurence(arr, target);
        totalOccurence= last-first+1;
        System.out.println(totalOccurence);
        
    }


}