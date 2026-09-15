//만약 충전소를 2 개 지어도, 전기 자동차를 구입할 수 없는 집이 있을 경우에는, -1 를 출력한다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1 {
	static int result, N;
	static int[][] houses;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			houses = new int[N][3];
			result = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				houses[i] = new int[] {x, y, d};
			}
			setCharge();
			if(result == Integer.MAX_VALUE) result = -1;
			System.out.println("#"+test_case+" "+result);
		}
	}
	public static void setCharge() {
		boolean onlyone = false;
		for (int cx = -15; cx < 16; cx++) {
			point1:
			for (int cy = -15; cy < 16; cy++) {
				int[] distances = new int[N];
				boolean[] check = new boolean[N];
				for (int i = 0; i < N; i++) {
					if(cx == houses[i][0] && cy == houses[i][1]) continue point1;
					int distance = getDis(cx, cy, houses[i][0], houses[i][1]);
					if(distance <= houses[i][2]) {
						check[i] = true;
						distances[i] = distance;
					}
				}
				int cnt = getCnt(check);
				if(cnt==0)continue;
				if(cnt==N) {
					if(onlyone) {
						result = Math.min(result, getSum(distances));
					}else {
						onlyone = true;
						result = getSum(distances);
					}
					
				}
				if(!onlyone) {
					for (int cx2 = -15; cx2 < 16; cx2++) {
						point2:
						for (int cy2 = -15; cy2 < 16; cy2++) {
							int[] distances2 = new int[N];
							if(cx2 == cx && cy2 == cy) continue;
							for (int i = 0; i < N; i++) {
								if(cx2 == houses[i][0] && cy2 == houses[i][1]) continue point2;
								int distance2 = getDis(cx2, cy2, houses[i][0], houses[i][1]);
								
								if(check[i]) {
									distances2[i] = distances[i];
									if(distance2 <= houses[i][2]) {
										distances2[i] = Math.min(distances2[i], distance2);
									}
								}else {
									if(distance2 <= houses[i][2]) {
										distances2[i] = distance2;
									}else {
										continue point2;
									}
								}
								
							}
							result = Math.min(getSum(distances2), result);
						}
					}
				}
			}
		}
		
	}
	
	public static int getDis(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	public static int getSum(int[] distances) {
		int sum = 0;
		for (int i : distances) {
			sum+=i;
		}
		return sum;
	}
	public static int getCnt(boolean[] check) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(check[i]) {
				cnt++;
			}
		}
		return cnt;
	}
}
