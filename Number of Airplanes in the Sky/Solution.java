/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        if(airplanes == null || airplanes.size() == 0){
            return 0;
        }
        int num = 0;
        
        int max = Integer.MIN_VALUE;
        for(Interval i: airplanes){
            if(i.end > max){
                max = i.end;
            }
        }
        int[] line = new int[max + 1];
        for(Interval i : airplanes){
           
                line[i.start]++;
          
           
                line[i.end]--;
           
        }
        
        max = Integer.MIN_VALUE;
        for(int i = 0; i < line.length; i++){
            num += line[i];
            if(num > max){
                max = num;
            }
        }
        return max;
        
    }
}
