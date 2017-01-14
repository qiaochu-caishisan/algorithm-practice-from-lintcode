public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start.equals(end)){
            return 1;
        }
        dict.add(start);
        dict.add(end);
        HashMap<String, ArrayList<String>> neighborMap = new HashMap<>();
        HashMap<String, Integer> distanceMap = new HashMap<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        HashSet<String> set = new HashSet<>();
        set.add(start);
        
        
        distanceMap.put(start, 0);
        while(!queue.isEmpty()){
            String string = queue.poll();
            ArrayList<String> tempList = expand(string, dict);
            neighborMap.put(string, tempList);
            
            for(String neighborString : tempList){
                if(set.contains(neighborString)){
                    continue;
                }
                distanceMap.put(neighborString, distanceMap.get(string) + 1);
                queue.offer(neighborString);
                set.add(neighborString);
                if(neighborString.equals(end)){
                    return distanceMap.get(neighborString) + 1;
                }
            }
        }
     
        return 0;
        
            
    }
    public ArrayList<String> expand(String string, Set<String> dict){
        ArrayList<String> neighborList = new ArrayList<>();
        for(int i = 0; i < string.length(); i++){
            for(char ch = 'a'; ch <= 'z'; ch++){
                if(ch != string.charAt(i)){
                    String expandString = string.substring(0, i) + ch + string.substring(i + 1);
                    if(dict.contains(expandString)){
                        neighborList.add(expandString);
                    }
                }
            }
        }
        return neighborList;
    }
}
