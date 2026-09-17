
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

class Solution
{
    static String result;
    static int n;
    static char[] arr;
	public static void main(String args[]) throws Exception
	{
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            n = Integer.parseInt(st.nextToken());
            arr = s.toCharArray();
            result = "";

            solve(0, 0);
            System.out.println("#" + test_case + " " + result);
		}
	}
    public static void solve(int depth, int count) {
        if (count == n) {
            String current = new String(arr);
            if (current.compareTo(result) > 0) {
                result = current;
            }
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                change(i, j);
                solve(i, count + 1);
                change(j, i);
            }
        }
    }
    
    private static void change(int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}