import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[][] arr;
	static boolean[][] visited;
	static int sr, sc;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static int found;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			br.readLine();
			arr = new int[16][16];
			found = 0;
			visited = new boolean[16][16];
			for(int i = 0; i < 16; i++) {
				String input = br.readLine();
				for(int j = 0; j < 16; j++) {
					arr[i][j] = input.charAt(j) - '0';
					if(arr[i][j]==2) {
						sr = i; sc = j;
					}
				}
			}
			dfs(sr, sc);
			System.out.println("#"+ test_case+" "+found);
		}
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		if(arr[r][c]==3)	{
			found = 1;
			return;
		}
		
		for (int idx = 0; idx < 4; idx++) {
			int nr = r + dr[idx];
			int nc = c + dc[idx];
			if(!inrange(nr, nc)) continue;
			if(visited[nr][nc]) continue;
			if(arr[nr][nc]==1) continue;
			dfs(nr, nc);
			if(found==1) return;
		}
	}
	public static boolean inrange(int r, int c) {
		return r>=0&&r<16&&c>=0&&c<16;
	}
}