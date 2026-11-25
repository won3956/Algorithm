class Solution {
    public int[] solution(String[] wallpaper) {
        int W = wallpaper[0].length();
        int H = wallpaper.length;
        int minx = W;
        int miny = H;
        int maxx = 0;
        int maxy = 0;
        for(int i = 0; i<H;i++){
            for(int j = 0; j<W; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(i < miny){
                        miny = i;
                    }
                    if(j < minx){
                        minx = j;
                    }
                    if(i > maxy){
                        maxy = i;
                    }
                    if(j > maxx){
                        maxx = j;
                    }
                }
            }
        }
        
        int luy = miny;
        int lux = minx;
        int rdy = maxy + 1;
        int rdx = maxx + 1;
        
        int[] answer = {luy, lux, rdy, rdx};
        return answer;
    }
}