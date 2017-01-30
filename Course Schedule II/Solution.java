public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        
        if(prerequisites == null || prerequisites.length == 0){
            for(int i = 0; i < result.length; i++){
                result[i] = i;
            }
            return result;
        }
        HashMap<Integer, Integer> indegreeMap = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            if(!indegreeMap.containsKey(prerequisites[i][0])){
                indegreeMap.put(prerequisites[i][0], 1);
            }else{
                indegreeMap.put(prerequisites[i][0], indegreeMap.get(prerequisites[i][0]) + 1);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new  HashSet<>();
        for(int i = 0; i < numCourses; i++){
            if(!indegreeMap.containsKey(i)){
                queue.offer(i);
                indegreeMap.put(i, 0);
            }
        }
        HashMap<Integer, ArrayList<Integer>> neighborMap = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            if(!neighborMap.containsKey(prerequisites[i][1])){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(prerequisites[i][0]);
                neighborMap.put(prerequisites[i][1], temp);
            }else{
                 ArrayList<Integer> temp = neighborMap.get(prerequisites[i][1]);
                 temp.add(prerequisites[i][0]);
                 neighborMap.put(prerequisites[i][1], temp);
            }
        }
        // 有一个想法 用map对应一个integer和一个装了integer的list 但是不知道会不会超时 一会回来试试
        int count = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
    //        System.out.println(course);
            result[count] = course;
            count++;
            if(neighborMap.containsKey(course) && !set.contains(course)){
                ArrayList<Integer> relatedCourse = neighborMap.get(course);
                set.add(course);
                int indegree = indegreeMap.get(course);
                for(Integer neighbor: relatedCourse){
                    indegreeMap.put(neighbor, indegreeMap.get(neighbor) - 1);
                    if(indegreeMap.get(neighbor) == 0){
                    queue.offer(neighbor);
                }
                }
                
            }
           
        }
        if(count == numCourses){
            return result;
        }else{
            return new int[0];
        }
    }
}
