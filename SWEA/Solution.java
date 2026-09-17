
import java.io.*;
import java.util.*;

/* 	1. 원자의 최초 위치는 2차원 평면상의 [x, y] 이다.
	2. 원자는 각자 고유의 움직이는 방향을 가지고 있다. (상하좌우 4방향)
	3. 1초에 1만큼의 거리를 이동한다.
	4. 두 개 이상의 원자가 동시에 충돌 할 경우 충돌한 원자들은 모두 보유한 에너지를 방출하고 소멸된다.
	
	두 원자 사이의 거리가 홀수이면 x.5초 이후 충돌 => 좌표 * 2 로 스케일링
	시뮬레이션 
	1. 0.5초 이동 => 좌표 스케일링
	2. 부딫히는 원자 확인 => x,y 좌표가 같은 원자 => 탐색 시간 줄이기 필요
	
	[제약사항]
	원자들의 이동 방향은 상(0), 하(1), 좌(2), 우(3)로 주어짐
	N 은 1,000개 이하
	K 는 1 이상 100 이하
	[x, y] 는 -1,000 이상 1,000 이하

 * 	[입력]
 * 	N개의 줄에 원자들의 x 위치, y 위치, 이동 방향, 보유 에너지 K
 *
 * 	[출력] 
 * 	에너지 총합
 */

public class Solution {
	static int N, result;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static Atom[] atoms;

	static class Atom {
		int x;
		int y;
		int dir;
		int k;

		public Atom(int x, int y, int dir, int k) {
			this.x = 2 * x;
			this.y = 2 * y;
			this.dir = dir;
			this.k = k;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			result = 0;
			atoms = new Atom[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				atoms[i] = new Atom(x, y, dir, k);
			}
		}
	}
}