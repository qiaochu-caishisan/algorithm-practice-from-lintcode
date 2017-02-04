public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        if(S.length == 0 || S == null){
            return 0;
        }
        int ans = 0;
        Arrays.sort(S);
        for(int i = 0; i < S.length; i++){
            int left = 0;
            int right = i - 1;
            while(left < right){
                if(S[left] + S[right] > S[i]){
                    ans += right - left;
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ans;
    }
}
