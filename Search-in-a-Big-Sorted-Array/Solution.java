/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        int k = 10;
        int n = 0;
        while(reader.get(n * k) < target){
            n++;
        }
        
        int start = (n - 1) * k;
        int end = n * k;
        
        if(reader.get(n * k) == Integer.MAX_VALUE){
            for(int i = 1; i <= k; i++){
                if(reader.get((n - 1) * k + i) == Integer.MAX_VALUE){
                    end = (n - 1) * k + (i - 1);
                }
            }
        }
        
        
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            
            if(target == reader.get(mid)){
                end = mid;
            }else if(target < reader.get(mid)){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        if(target == reader.get(start)){
            return start;
        }else if(target == reader.get(end)){
            return end;
        }else{
            return -1;
        }
    }
}
