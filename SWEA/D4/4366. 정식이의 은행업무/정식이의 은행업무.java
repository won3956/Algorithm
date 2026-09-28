import java.io.*;
import java.util.*;
public class Solution {
	static long result;
	static Set<Long> nums;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String two = br.readLine();
			String three = br.readLine();
			nums = new HashSet<>();
			
			for (int i = 0; i < two.length(); i++) {
				char[] twoChar = two.toCharArray();
				if(twoChar[i] == '0') {
					twoChar[i] = '1';
				}else {
					twoChar[i] = '0';
				}
				long twoLong = Long.parseLong(new String(twoChar), 2);
				nums.add(twoLong);
			}
			out:
			for (int i = 0; i < three.length(); i++) {
				char[] threeChar = three.toCharArray();
				
				for (char j = '0'; j <= '2'; j++) {
					if(j==threeChar[i]) continue;
					threeChar[i] = j;
					
					long threeLong = Long.parseLong(new String(threeChar), 3);
					if(nums.contains(threeLong)) {
						result = threeLong;
						break out;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+result);
		}
	}
}
