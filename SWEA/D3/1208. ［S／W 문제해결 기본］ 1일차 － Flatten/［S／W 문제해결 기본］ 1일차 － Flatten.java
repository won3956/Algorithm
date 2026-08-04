import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] list;
	static int count, indexA, indexB, maxA, minB, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int dump_num = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine());
			count = 0;
			indexA = -1;
			indexB = -1;
			result = 0;
			list = new int[100];
			for (int k = 0; k < 100; k++) {
				list[k] = Integer.parseInt(st.nextToken());
			}
			flat(dump_num);
			System.out.println("#" + test_case + " " + result);
		}
	}

	public static void flat(int dump_num) {
		while (count < dump_num) {
			maxA = 0;
			minB = 101;
			for (int i = 0; i < 100; i++) {
				if (list[i] > maxA) {
					maxA = list[i];
					indexA = i;
				}
				if (list[i] < minB) {
					minB = list[i];
					indexB = i;
				}
			}
			if (maxA - minB <= 1) {
				break;
			}
			list[indexA] -= 1;
			list[indexB] += 1;
			count++;
		}
		maxA = 0;
		minB = 101;
		for (int i = 0; i < 100; i++) {
			if (list[i] > maxA)
				maxA = list[i];
			if (list[i] < minB)
				minB = list[i];
		}
		result = maxA - minB;
	}

}
