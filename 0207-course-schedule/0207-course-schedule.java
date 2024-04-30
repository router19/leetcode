class Solution {


    List<Integer>[] adjList;
    
    /*
    The intuition behind this approach is that if there is a cycle in the graph, 
    there will be at least one node that cannot be visited since it will always have a nonzero indegree. 
    On the other hand, if there are no cycles, 
    all the nodes can be visited by starting from the nodes with no incoming edges and removing their 
    outgoing edges one by one. If all the nodes are visited in the end, it means that it is possible to 
    finish all the courses.

    /**
    Algorithm:
        Add all nodes with in-degree 0 to a queue.
        While the queue is not empty:
        Remove a node from the queue.
        For each outgoing edge from the removed node, decrement the in-degree of the destination node by 1.
        If the in-degree of a destination node becomes 0, add it to the queue.
        If the queue is empty and there are still nodes in the graph, the graph contains a cycle and cannot be topologically sorted.
        The nodes in the queue represent the topological ordering of the graph.
     */
    public boolean canFinish(int n, int[][] req) {
        //return true if only 1 or less than 1 course
        if(n <= 1)
            return true;

        //stores the indegree of the vertices    
        int indegree[] = new int[n];

        //resultant topological sort of the graph,
        //if the size of the topological sort is same as that of numCourse(i.e. vertices of the graph), the all
        //courses can be finished
        List<Integer> result = new ArrayList<>();

        //Initializing the adjacency list for graph creation
        adjList = new ArrayList[n];
        
        int rows = req.length;
        
        //do below for all edges of the graph
        for(int[] pair : req){

            //the course we are targetting to finish
            int course = pair[0];
            //the preReq course which must be completed
            int preReq = pair[1];

            //initialize the adj list for vertex(course preReq)
            if(adjList[preReq] == null){
                adjList[preReq] = new ArrayList<>();
            }

            //Add an edge from preReq to course we are targetting
            adjList[preReq].add(course);

            //increase the indegree of targetted course
            // as it can only be started when its indegree(preReq courses) are zero
            indegree[course]++;
               
            
        }

        //As per Kahn's algo, start with vertex with 0 indegree
        //means we start with courses with no preReq courses
        Queue<Integer> q = new LinkedList<>();
        for(int v = 0; v < n; v++)
        {
            if(indegree[v] == 0)
              q.offer(v);
        }
        //repeat while queue is empty
        //queue can be empty once all the eventual zero indegree courses has been visited or no more
        //courses can be covered due to presence of cycle in dependency
        while(!q.isEmpty()){
            int currCourse = q.poll();
            //As the course currCourse is completed , add to the list of courses completed so far
            result.add(currCourse);

            //for all the nextCourse whose preReq was currCourse has 1 less preq course now
            if(adjList[currCourse] != null){
                for(int nextCourse : adjList[currCourse]){
                    //decrease the preReq of nextCourse
                    indegree[nextCourse]--;

                    //As nextCourse preReq courses are completed, we can add them to queue
                    //such that they can be started now
                    if(indegree[nextCourse] == 0){
                        q.offer(nextCourse);
                    }
                }
            }
        }

        //if we covered all the courses then size of topo sort(result.size) would be that of numCourses
        return (result.size() == n);
          

    }
}