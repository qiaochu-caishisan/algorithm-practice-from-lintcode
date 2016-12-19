public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        HashSet<Integer> result = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i]) && !result.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        int[] answer = new int[result.size()];
        int index = 0;
        for(Integer number : result){
            answer[index] = number;
            index++;
        }
        return answer;
    }
}
