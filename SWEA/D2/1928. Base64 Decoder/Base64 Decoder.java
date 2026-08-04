import java.io.*;
import java.util.*;
public class Solution {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=T;test_case++){
			String str = br.readLine();
			String newstr = decode(str);
			System.out.println("#"+test_case+" "+newstr);
		}
	}
	public static String decode(String str) {
		String newstr = "";
		for(int i = 0; i<str.length(); i+=4) {
			int char1 = getValue(str.charAt(i));
			int char2 = getValue(str.charAt(i+1));
			int char3 = getValue(str.charAt(i+2));
			int char4 = getValue(str.charAt(i+3));
			
			int buffer = (char1 << 18) | (char2 << 12) | (char3 << 6) | char4;
			
			newstr += (char) ((buffer >> 16) & 255);
			newstr += (char) ((buffer >> 8) & 255);
			newstr += (char) (buffer & 255);
		}
		return newstr;
	}
	public static int getValue(char c) {
		if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a' + 26;
        } else if (c >= '0' && c <= '9') {
            return c - '0' + 52;
        } else if (c == '+') {
            return 62;
        } else if (c == '/') {
            return 63;
        }
        return 0;
	}
}
