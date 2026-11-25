import java.util.*;
class Solution {
    static int H, W;
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        H = board.length;
        W = board[0].length;
        int answer = 0;
        for(int tar : moves){
            int doll = grab(board, tar);
            if(!stack.isEmpty() && doll != 0){
                if(stack.peek() == doll){
                    stack.pop();
                    answer += 2;
                }
                else{
                    stack.push(doll);
                }
            }
            else{
                stack.push(doll);
            }
        }
        return answer;
    }
    public static int grab(int[][] board, int tar){
        for(int i = 0; i < W; i++){
            if(board[i][tar - 1] != 0){
                int temp = board[i][tar - 1];
                board[i][tar - 1] = 0;
                return temp;
            }
        }
        return 0;
    }
}