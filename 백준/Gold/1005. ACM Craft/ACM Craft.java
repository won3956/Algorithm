import java.io.*;
import java.util.*;

public class Main {
	static int N, K, W, result;
	static int[] buildTime, countTo;
	static List<Edge> edgeList;
	static boolean[] isbuild;
	static class Edge {
		int from, to;
		Edge(int from, int to){
			this.from = from;
			this.to = to;
		}
	}
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int T = Integer.parseInt(br.readLine());
    	for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			edgeList = new ArrayList<>();
			countTo = new int[N + 1];
			buildTime = new int[N + 1];
			isbuild = new boolean[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				buildTime[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				edgeList.add(new Edge(from, to));
				countTo[to]++;
			}
			W = Integer.parseInt(br.readLine());
			result = bfs();
			System.out.println(result);
		}
    }
    public static int bfs() {
    	int[] finishTime = new int[N + 1];
    	Queue<Integer> que = new ArrayDeque<>();
    	
    	for (int i = 1; i <= N; i++) {
    		if(countTo[i] == 0) {
    			finishTime[i] = buildTime[i];
        		que.offer(i);
    		}
		}
    	
    	while(!que.isEmpty()) {
    		int from = que.poll();
    		
    		for (Edge e : edgeList) {
    			if(e.from == from) {
	    			int to = e.to;
					if(e.from == from) {
						countTo[to]--;
						finishTime[to] = Math.max(finishTime[to], finishTime[from] + buildTime[to]);
						if(countTo[to] == 0) {
							que.offer(to);
						}
					}
    			}
			}
    	}
    	
    	return finishTime[W];
    }
}