// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static void main(String[] args) {
         int[] coins = {2,3,5,7};
        int tar = 10;

        
        // coinChangeCombination(coins,tar,0,"");
        System.out.println("Hello, World! \n");
        coinChangeCombination_Infi(coins,tar,0,"");
        System.out.println("Hello, World! \n");
            //  coinChangeCombination2(coins,tar,0,"");
             coinChangeCombination_Infi2(coins,tar,0,"");
    }
        public static int coinChangeCombination_Infi(int[] coins,int tar,int idx,String ans){
        if(tar == 0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i = idx; i < coins.length; i++){
            if(tar - coins[i] >= 0)
               count += coinChangeCombination_Infi(coins,tar - coins[i],i,ans + coins[i] + " ");
        }

        return count;
    }

    public static int coinChangeCombination(int[] coins,int tar,int idx,String ans){
        if(tar == 0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i = idx; i < coins.length; i++){
            if(tar - coins[i] >= 0)
               count += coinChangeCombination(coins,tar - coins[i],i + 1,ans + coins[i] + " ");
        }

        return count;

    }
    public static int coinChangeCombination2(int[] coins,int tar,int idx,String ans){
        if(tar == 0 || idx == coins.length){
            if(tar == 0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if(tar - coins[idx] >= 0)
          count += coinChangeCombination2(coins,tar - coins[idx], idx + 1, ans + coins[idx] + " ");
        count += coinChangeCombination2(coins,tar, idx + 1, ans);
    
        return count;
    }

    public static int coinChangeCombination_Infi2(int[] coins,int tar,int idx,String ans){
        if(tar == 0 || idx == coins.length){
            if(tar == 0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if(tar - coins[idx] >= 0)
          count += coinChangeCombination_Infi2(coins,tar - coins[idx], idx, ans + coins[idx] + " ");
        count += coinChangeCombination_Infi2(coins,tar, idx + 1, ans);
    
        return count;
    }
}