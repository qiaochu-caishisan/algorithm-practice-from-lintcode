
public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
         dict.add(start);
         dict.add(end);
        Queue<String> queue = new LinkedList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        //为什么要有一个distance来记录当前的string距离start的距离呢？因为这道题里面我们要求的其实是最短的那几条路 最短的道路一定是每次都向前前进一格 没有浪费的步数  那为什么不可以不记录distance 然后直接在最后用size()找一个最短路径呢？因为这样会超时，遍历之后得到最短size 再一个一个比较list的长度 是非常耗时的一项工作 所以我们使用一个代替方法 直接在找neighbors的时候就记录下distance 这样的话 我们在回溯深搜的时候 就加一个限制条件 每次必须找前进了一步的 这样的话 找出来自然而然就是最短的路径啦
        HashMap<String, Integer> distance = new HashMap<>();
        
        queue.offer(start);
        distance.put(start, 0);
        for(String string : dict){
            map.put(string, new ArrayList<String>());
        }
        
        while(!queue.isEmpty()){
            String crt = queue.poll();
            ArrayList<String> neighborlist = expand(crt, dict);
            for(String string : neighborlist){
                map.get(string).add(crt);
            }
            
            for(String string : neighborlist){
                if(!distance.containsKey(string)){
                    distance.put(string, distance.get(crt) + 1);
                    queue.offer(string);
                }
            }
        }
         

         List<List<String>> result = new ArrayList<>();
         List<String> path = new ArrayList<>();
         helper(distance, start, end, map, path, result);
         
         return result;
    }
    public void helper(HashMap<String, Integer> distance, String start, String end, HashMap<String, ArrayList<String>> map, List<String> path, List<List<String>> result){
        path.add(start);
        if(path.size() != 0 && path.get(path.size() - 1).equals(end)){
                if(!result.contains(path)){
                    //path.add(0, "hit");
                    result.add(new ArrayList<String> (path));
                    return;
                }
            
                
            }
           for(String string : map.get(start)){
               if(distance.containsKey(string) && distance.get(string) == distance.get(start) + 1){
                   helper(distance, string, end, map, path, result);
                   path.remove(path.size() - 1);
               }
               
              
               
           }
        
    }
    public  ArrayList<String> expand(String crt, Set<String> dict) {
        ArrayList<String> expansion = new ArrayList<String>();

        for (int i = 0; i < crt.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != crt.charAt(i)) {
                    String expanded = crt.substring(0, i) + ch
                            + crt.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }

        return expansion;
    }
}
