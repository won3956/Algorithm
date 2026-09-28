import java.io.*;
import java.util.*;
public class Solution {
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int two = Integer.parseInt(br.readLine(), 2);
			int three = Integer.parseInt(br.readLine(), 3);
			
			System.out.println(two +" "+three);
		}
	}
}
