class Solution {
    public class State{
        int cost; // 이동 비용
        int index; 
        boolean[] mask; // 완성했는지 여부
        State(int cost, int index, boolean[] mask){
            this.cost = cost;
            this.index = index;
            this.mask = mask;
        }
    }
    static int result, length;
    
    public int solution(String name) {
        result = 0;
        length = name.length();
        for(int i = 0; i < length; i++){
            result += findIndex(name, i);
        }
        result += cal(name);
        return result;
    }
    
    public int cal(String name){
        // 오른쪽으로만 이동하는 경우
        int minMove = length - 1;

        for (int i = 0; i < length; i++) {
            int next = i + 1;

            // i 다음에 연속된 A는 방문할 필요가 없음
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            int left = i;
            int right = length - next;

            // 오른쪽 구간 먼저 방문한 뒤 돌아서 왼쪽 구간 방문
            minMove = Math.min(minMove, left * 2 + right);

            // 왼쪽 구간 먼저 방문한 뒤 돌아서 오른쪽 구간 방문
            minMove = Math.min(minMove, right * 2 + left);
        }

        return minMove;
    }
    
    public int findIndex(String name, int index){
        char target = name.charAt(index);
        int difA = target - 'A';
        int difB = 'Z' - target + 1;
        return Math.min(difA, difB);
    }    
}