import java.io.*;
import java.util.*;

public class Solution {
	static long year;
	static int month;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			year = Long.parseLong(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			int quo = (int) ((year - 2016) % 13);
			long rem = (year - 2016) / 13;
			year -= rem;
			month -= quo;
			if(month <= 0) {
				year -= 1;
				month += 13;
			}
			System.out.println("#"+test_case+" "+ year+" "+month);
		}
	}
}
