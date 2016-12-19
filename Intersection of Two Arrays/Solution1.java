public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return null;
        }
        Arrays.sort(nums1);
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                continue;
            }else if(BinarySearch(nums1, nums2[i])){
                set.add(nums2[i]);
            }
        }
        int[] result = new int[set.size()];
        int index = 0;
        for(Integer num : set){
            result[index++] = num;
        }
        return result;
  
    }
    
    
    
    public boolean BinarySearch(int[] nums1, int target){
        if(nums1 == null || nums1.length == 0){
            return false;
        }
        int start = 0;
        int end = nums1.length - 1;
            while(start + 1 < end){
                int mid = start + (end - start)/2;
                if(target < mid){
                    end = nums1[mid];
                }else if(target > nums1[mid]){
                    start = mid;
                }else{
                    return true;
                }
             }
            if(nums1[start] == target){
                return true;
            }else if(nums1[end] == target){
                return true;
            }else{
                return false;
            }
        
    }
    
}
