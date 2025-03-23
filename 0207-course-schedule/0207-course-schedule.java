class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjLst = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adjLst.add(new ArrayList<>());
        }

        //fill the adjList iterating over prereq
        for(int[] prereqiste : prerequisites){
            adjLst.get(prereqiste[1]).add(prereqiste[0]);
        }

        //array to track the visited nodes 
        int[] visitState = new int[numCourses];

        //perform dfs on the graph 
        for(int course = 0; course < numCourses;course++){
            if(visitState[course] == 0){
                //mechanism to detect cycle - if it has cycle we can terminate the funciton 
                if(hasCycle(course, adjLst, visitState)) return false;
            }
        }
        return true;   
    }

        //helper function to detect cycle
        private boolean hasCycle(int course, List<List<Integer>> adjList, int[] visitState){
            
                
            //mark that course as visited 
            visitState[course] = 1;
            //explore the connected edges
            for(int neighbor : adjList.get(course)){

                //if this neighbor is already in visitState arr 
                if(visitState[neighbor] == 1){
                    return true;
                }
                //if we havent found the visited state 
                if(visitState[neighbor] == 0){
                    if(hasCycle(neighbor, adjList, visitState)){
                        return true;
                    }
                }
            }
            //some sort of flag to set the curr node as complete 
            visitState[course] = 2;
            return false;
        }
 
}