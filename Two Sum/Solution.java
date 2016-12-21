public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            map.put(i, numbers[i]);
        }
        int a = 0;
        int result[] = new int[2];
        
        for(int i = 0; i < numbers.length; i++){
            int goal = target - numbers[i];
            if(map.containsValue(goal)){
                a = goal;
                result[0] = i + 1;
            }
        }
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == a){
                if(i != result[0] - 1){
                     result[1] = i + 1;

                }
            }
        }
        Arrays.sort(result);
        return result;
    }
}
