public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int result = 0;
        int left = 0;
        int right = heights.length - 1;
        int leftHeight = heights[left];
        int rightHeight = heights[right];
        if(left >= right){
            return result;
        }
        while(left < right){
            if(leftHeight < rightHeight){
                left++;
                if(heights[left] >= leftHeight){
                    leftHeight = heights[left];
                }else{
                    result += leftHeight - heights[left];
                }
            }else{
                right--;
                if(heights[right] >= rightHeight){
                    rightHeight = heights[right];
                }else{
                    result += rightHeight - heights[right];
                }
            }
        }
        return result;
    }
}
