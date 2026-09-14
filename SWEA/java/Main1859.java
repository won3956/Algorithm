import java.util.*;
import java.io.*;
class Main1859
{
    static int maxValue, maxIndex;
    static int result;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            result = 0;
			int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] lst = new int[N];
            for(int i = 0; i<N;i++){
                lst[i] = Integer.parseInt(st.nextToken());
            }
            findMax(lst);
            solve(lst);
            System.out.println("#" + test_case + ' ' + result);
		}
	}
    public static void solve(int[] lst){
        if(maxIndex > 0){	// 
            for(int i = 0; i<maxIndex; i++){
            	result += maxValue - lst[i];
            } //결과값에 더하고
            int[] newlst = remakelst(lst);	// 자르고 붙이기
            if(newlst.length == 0){  // maxValue 가 맨 마지막 값일 경우
                return;
            }
            else{	// 지우고 남은 배열이 있으면
                solve(newlst);  //다시 호출
            }
        }
        else{ //최댓값이 맨 앞의 수일경우
            int[] newlst = remakelst(lst);	// 자르고 붙이기
            if(newlst.length == 0){  // maxValue 가 맨 마지막 값일 경우
                return;
            }
            else{	// 지우고 남은 배열이 있으면
                solve(newlst);  //다시 호출
            }
        }
    }
    public static int[] remakelst(int[] lst){
        if(lst.length-maxIndex-1 > 0){
            int[] nextlst = new int[lst.length-maxIndex-1];
            int k = 0;
            for(int i = maxIndex +1; i<lst.length; i++){
                nextlst[k++] = lst[i];
            }
            return nextlst;
        }
        else{ // maxValue 가 맨 마지막 값일 경우
            return new int[0];
        }
    }
    public static void findMax(int[] lst){
        maxValue = lst[0];
        for(int i = 1; i<lst.length;i++){
            if(maxValue < lst[i]){
                maxValue = lst[i];
                maxIndex = i;
            }
        }
    }
}