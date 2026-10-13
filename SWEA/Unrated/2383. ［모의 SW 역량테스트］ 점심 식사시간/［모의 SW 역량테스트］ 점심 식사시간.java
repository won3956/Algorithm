import java.io.*;
import java.util.*;

/* [문제]
 * 최대한 빠른 시간 내에 내려가야 함
 * 이동 시간 = 
 * 입구까지 이동 시간 :  | PR - SR | + | PC - SC |
 *       + 
 * 계단을 내려가는 시간 :  1 + K (계단 길이)
 * 계단 위에는 동시에 최대 3명까지만 올라가 있을 수 있다.
 * 
 * [제약사항]
 * 1. Java 3초
 * 2. 4 ≤ N ≤ 10
 * 3. 1 ≤ 사람의 수 ≤ 10
 * 4. 계단의 입구는 반드시 2개이며, 서로 위치가 겹치지 않는다.
 * 5. 2 ≤ 계단의 길이 ≤ 10
 * 6. 초기에 입력으로 주어지는 사람의 위치와 계단 입구의 위치는 서로 겹치지 않는다.
 * 
 * [입력]
 * 1은 사람을, 2 이상은 계단의 입구, 그 K값은 계단의 길이
 */

public class Solution {
	static int N, result;
	static int[][] map;
	static int[] selected;
	static List<Person> persons;
	static List<Stair> stairs;
	static class Person{
		int row, col;
		public Person(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	static class Stair {
		int row, col, length;
		public Stair(int row, int col, int length) {
			this.row = row;
			this.col = col;
			this.length = length;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			persons = new ArrayList<>();
			stairs = new ArrayList<>();
			result = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						persons.add(new Person(i, j));
					}
					else if(map[i][j] > 1) {
						stairs.add(new Stair(i, j, map[i][j]));
					}
				}
			}
			selected = new int[persons.size()];
			dfs(0);
			System.out.println("#"+test_case+" "+ result);
		}
	}
	public static void dfs(int depth) {
		if(depth == persons.size()) {
			simul();
			return;
		}
		selected[depth] = 0;
		dfs(depth + 1);
		selected[depth] = 1;
		dfs(depth + 1);
	}
	public static void simul() {
		List<Integer>[] arrive = new ArrayList[2];
		arrive[0] = new ArrayList<>();
		arrive[1] = new ArrayList<>();
		
		for (int i = 0; i < persons.size(); i++) {
			Person p = persons.get(i);
			Stair s = stairs.get(selected[i]);
			int dis = Math.abs(p.row - s.row) + Math.abs(p.col - s.col);
			
			arrive[selected[i]].add(dis + 1);
		}
		int time = 0;
		for (int i = 0; i < 2; i++) {
			Collections.sort(arrive[i]);
			int[] finish = new int[arrive[i].size()];
			for (int j = 0; j < finish.length; j++) {
				int start = arrive[i].get(j);
				if(j >= 3) {
					start = Math.max(start,  finish[j-3]);
				}
				finish[j] = start + stairs.get(i).length;
				if(j == finish.length - 1) {
					time = Math.max(time, finish[j]);
				}
			}
		}
		result = Math.min(result, time);
	}
}