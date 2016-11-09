public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        if(L == null || L.length == 0){
            return 0;
        }
        
        int start = 1;
        int length = 0;;
        int max = 0;
        for (int i = 0; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }       
        
        int end = max;
        
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            
            // if(find_k(L,mid) == k){
            //     return mid;
            // }else 
            if(find_k(L,mid) < k){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        if(find_k(L,start) >= k){
            return start;
        }
        if(find_k(L,end) >= k){
            return end;
        }
        return 0;
    }
    public int find_k(int[] L, int length){
        int kn = 0;
       for( int i = 0; i < L.length; i++){
                kn = kn + L[i]/length;
            }
            return kn;
    }
    
}
