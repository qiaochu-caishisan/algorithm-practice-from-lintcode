/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        sort(nuts, bolts, 0, compare, nuts.length - 1);
        
    }
    public void sort(String[] nuts, String[] bolts, int l, NBComparator compare, int r){
        if( l > r){
            return;
        }
        
        int partition_index = partition(nuts, bolts[l], l, r, compare);
        partition(bolts, nuts[partition_index], l, r, compare);
        sort(nuts, bolts, l, compare, partition_index-1);
        sort(nuts, bolts, partition_index+1, compare, r);
    }
    public int partition(String[] str, String pivot, int l, int r, NBComparator compare){
        for(int i = l; i <= r; i++){
            if(compare.cmp(str[i], pivot) == 0){
                String temp = str[l];
                str[l] = str[i];
                str[i] = temp;
            }
        }
        
        int left = l;
        int right = r;
        String pivotptr = str[l];
        while(left < right){
            //这里之所以两次比较的意义是因为pivot既有可能是bolts也有可能是nults因为这个partition函数是给nults和bolts分别快排分解都会使用的。
             while (left < right && 
            (compare.cmp(str[right], pivot) == 1 || 
            compare.cmp(pivot, str[right]) == -1)) {
                right--;
            }
            str[left] = str[right];
            
            while (left < right && 
            (compare.cmp(str[left], pivot) == -1 || 
            compare.cmp(pivot, str[left]) == 1)) {
                left++;
            }
            str[right] = str[left];
        }
        str[left] = pivotptr;
        return left;
    }
};
