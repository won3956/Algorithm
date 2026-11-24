import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int N, M, ckCnt, answer;
	static List<Point> house, chicken;
	static Point[] result;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	answer = Integer.MAX_VALUE; //최소의 도시 치킨 거리
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	int[][] map = new int[N][N];
    	chicken = new ArrayList<>();
    	house = new ArrayList<>();
    	result = new Point[M];
    	
    	for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) house.add(new Point(i, j));
				if(map[i][j] == 2) chicken.add(new Point(i, j));
			}
		}
    	
    	comb(0, 0);
    	
    	System.out.println(answer==Integer.MAX_VALUE?0:answer);
    }
    public static void comb(int cnt, int start) { 
    	if(cnt == M) {
    		answer = Math.min(answer, getCityDis());
    		return;
    	}
    	
    	for (int i = start; i < chicken.size(); i++) {
			result[cnt] = new Point(chicken.get(i).x, chicken.get(i).y);
			comb(cnt + 1, i + 1);
		}
    	
    	return;
    }
    public static int getCityDis() {
    	int sum = 0;
    	for (Point cur : house) {
    		int dis = Integer.MAX_VALUE;
			for (Point tar : result) {
				dis = Math.min(dis, getDis(cur.x, cur.y, tar.x, tar.y));
			}
			sum += dis;
		}
    	
    	return sum;
    }    
    public static int getDis(int x, int y, int a, int b) {
    	return Math.abs(a - x) + Math.abs(b - y);
    }
}