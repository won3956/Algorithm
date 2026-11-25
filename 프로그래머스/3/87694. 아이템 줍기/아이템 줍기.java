import java.util.*;

class Solution {
    static int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}}; // 우 하 좌 상
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] scaledRectangle = new int[rectangle.length][4];

        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < 4; j++) {
                scaledRectangle[i][j] = rectangle[i][j] * 2;
            }
        }
        characterX *= 2; characterY *= 2; itemX *= 2; itemY *= 2;
        
        answer = bfs(scaledRectangle, characterX, characterY, itemX, itemY) / 2;
        return answer;
    }
    public int bfs(int[][] rectangle, int characterX, int characterY, int itemX, int itemY){
        boolean[][] visited = new boolean[101][101];
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {characterX, characterY, 0});
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int curX = cur[0];
            int curY = cur[1];
            int count = cur[2];
            
            if(curX == itemX && curY == itemY){
                return count;
            }
            
            for(int[] add : dir){
                int nextX = curX + add[0];
                int nextY = curY + add[1];
                if (!inRange(nextX, nextY)) continue;
                if(visited[nextX][nextY]) continue;
                if(canMove(nextX, nextY, rectangle)){
                    que.offer(new int[] {nextX, nextY, count + 1});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return -1;
    }
    // 어느 좌표가 둘레에 해당하는지 -> 1 어느 사각형의 테두리인가? -> 2 어떤 사각형이든 내부에 포함되지 않는가?
    public boolean canMove(int x, int y, int[][] rectangle){
        return isOnAnyEdge(x, y, rectangle) && !isInsideAnyRectangle(x, y, rectangle);
    }
    public boolean isOnAnyEdge(int x, int y, int[][] rectangle){ //1
        for(int[] r : rectangle){
            // 사각형 하나씩 좌표가 변에 위치하는지 확인
            boolean onVEdge = (x == r[0] || x == r[2]) && r[1] <= y && y <= r[3];
            boolean onHEdge = (y == r[1] || y == r[3]) && r[0] <= x && x <= r[2];
            
            if (onVEdge || onHEdge) {
                return true;
            }
        }
        
        return false;
    }
    public boolean isInsideAnyRectangle(int x, int y, int[][] rectangle){ //2
        for(int[] r : rectangle){
            // 사각형 하나씩 내부에 존재하는지 확인
            if(x > r[0] && x < r[2] && y > r[1] && y < r[3]){
                return true;
            }
        }
        
        return false;
    }
    public boolean inRange(int x, int y){
        return x >= 0 && x < 101 && y >= 0 && y < 101;
    }
}