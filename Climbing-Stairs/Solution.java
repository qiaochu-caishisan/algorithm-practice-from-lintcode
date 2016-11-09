public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if(n <= 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        //state
        int[] state = new int[n];
        
        //initialize
        state[0] = 1;
        state[1] = 2;
        
        //function
        for(int i = 2; i < n; i++){
            state[i] = state[i-1] + state[i-2];
        }
        
        //answer
        return state[n-1];
    }
}
