import java.io.*;
import java.util.*;

public class Main28278 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cm = Integer.parseInt(st.nextToken());
            switch (cm) {
                case 1:
                    int temp = Integer.parseInt(st.nextToken());
                    stack.push(temp);
                    break;
                case 2:
                    int pop = stack.pop();
                    sb.append(pop + "\n");
                    break;
                case 3:
                    int size = stack.size();
                    sb.append(size + "\n");
                    break;
                case 4:
                    int empty = stack.empty();
                    sb.append(empty + "\n");
                    break;
                case 5:
                    int peek = stack.peek();
                    sb.append(peek + "\n");
                    break;
            }
        }
        System.out.println(sb);

    }
    
    public static class Stack {
        public int[] arr;
        public int point;
        
        public Stack(int max){
            point = 0;
            arr = new int[max];
        }

        public int push(int temp){
            return arr[point++] = temp;
        }

        public int pop(){
            if(point>0){
                return arr[--point];
            }else return -1;
        }

        public int size(){
            return point;
        }

        public int empty(){
            if(point==0) return 1;
            else return 0;
        }

        public int peek(){
            if(point > 0) return arr[point-1];
            else return -1;
        }
    }
}
