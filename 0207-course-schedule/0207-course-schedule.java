class Solution {
    
    boolean adjMatrix[][];

    void addDirectedEdge(int v1, int v2)
    {
        adjMatrix[v1][v2] = true;
    }

    boolean cyclicUtil(int v,boolean[] visited, boolean[] recStack)
    {
        if(recStack[v])
           return true;
        if(visited[v])
            return false;

        visited[v] = true;

        recStack[v] = true;

        for(int i = 0; i < visited.length; i++){
            if(adjMatrix[v][i])
            {
                if(cyclicUtil(i,visited,recStack))
                    return true;
            }
        }

        recStack[v] = false;

        return false;       
    }
    boolean cyclic(int numCourses)
    {
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for(int v = 0; v< numCourses; v++){
            if(cyclicUtil(v,visited,recStack))
                return true;

        }
        return false;
    }

    public boolean canFinish(int numCourses, int[][] req) {
        if(numCourses <= 1)
            return true;
        
        adjMatrix = new boolean[numCourses][numCourses];
        
        int rows = req.length;
        
        for(int row = 0; row <rows; row++){
            addDirectedEdge(req[row][1],req[row][0]);
        }
        
        if(cyclic(numCourses))
          return false;
        return true;

    }
}