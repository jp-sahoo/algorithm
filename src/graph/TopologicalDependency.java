package graph;

import java.util.*;

public class TopologicalDependency {
    public static void main(String[] args) {
        int[][] a = {{0, 1}};
        boolean can = new TopologicalDependency().canFinish(2, a);
        System.out.println(can);
    }

    /**
     * create inDegree -> for all element it will maintain number of prerequisites
     * adj map -> if a course finishes, all courses those are dependent on this course can reduce their inDegree by 1
     * so it maintains all course dependent on it
     * Queue all courses initially that doesn't have any prerequisite(0 inDegree)
     * run a BFS -> keep reducing inDegrees for courses those are depending on the processing element/course if zero, enqueue it
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap();
        for(int[] a: prerequisites) {
            inDegree[a[0]]++;
            adj.putIfAbsent(a[1], new LinkedList<>());
            adj.get(a[1]).add(a[0]);
        }
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i< inDegree.length; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()) {
            int cu = q.poll();
            count++;
            if(adj.containsKey(cu)) {
                for(int a: adj.get(cu)) {
                    if(--inDegree[a] == 0) {
                        q.add(a);
                    }
                }
            }
        }
        return count == numCourses;
    }
}