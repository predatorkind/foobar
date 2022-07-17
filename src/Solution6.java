import java.util.Arrays;


public class Solution6 {

        //shortest distance found
        static int minDist;
        //shortest distance possible
        static int minPosDist;
        //locations in grid already visited with the shortest distance to reach the location stored in it
        static int[][] visited;


        public static int solution(int[][] map) {
            int destY = map.length-1;
            int destX = map[0].length-1;
            minPosDist = map.length + map[0].length -1;
            minDist = 0;

            visited = new int[destY+1][destX+1];
            for(int i = 0; i< map.length; i++){
                visited[i] = Arrays.copyOf(map[i], map[i].length);
            }

            //check possible routes without removing walls
            traverseMap(map, 0,0, 1,destX, destY);

            //check possible routes by removing 1 wall
            for (int j = 0; j< map.length; j++){
                for(int i=0; i<map[0].length; i++){
                    if(map[j][i]==1){
                        int temp[][] = new int[destY+1][destX+1];

                        for(int k = 0; k< map.length; k++){
                            temp[k] = Arrays.copyOf(map[k], map[k].length);
                        }
                        temp[j][i] = 0;
                        //reset visited
                        visited = new int[destY+1][destX+1];
                        for(int m = 0; m< temp.length; m++){
                            visited[m] = Arrays.copyOf(temp[m], temp[m].length);
                        }


                        traverseMap(temp,0,0,1, destX,destY);
                    }
                }
            }

            return minDist;
        }

        private static void traverseMap(int[][]map, int locX, int locY, int dist, int destX, int destY){
            //shortest route found already
            if(minDist==minPosDist)return;

            //stop traversing if current distance > shortest distance
            if(minDist>0){
                if(dist>=minDist)return;
            }
            //are we there yet?
            if(locX == destX && locY == destY){
                minDist = dist;
                return;
            }

            int tempMap[][] = new int[destY+1][destX+1];
            for(int i = 0; i< map.length; i++){
                tempMap[i] = Arrays.copyOf(map[i], map[i].length);
            }

            //mark current loc as visited (same as impassable)
            tempMap[locY][locX] = 1;
            //store distance to the current location
            visited[locY][locX] = dist;

            //test for dead end
            //if adjacent location was reached in fewer steps before, it is classed as impassable
            boolean left = true;
            boolean right = true;
            boolean up = true;
            boolean down = true;

            // test right
            if(locX == destX || tempMap[locY][locX+1]== 1 || (visited[locY][locX+1]!=0 && visited[locY][locX+1]<= dist +1)) right = false;
            //test down
            if(locY == destY || tempMap[locY+1][locX]==1 || (visited[locY+1][locX]!= 0 && visited[locY+1][locX]<= dist+1)) down = false;
            //test left
            if(locX == 0 || tempMap[locY][locX-1] == 1 || (visited[locY][locX-1]!= 0 && visited[locY][locX-1]<= dist+1)) left = false;
            //test up
            if(locY == 0 || tempMap[locY-1][locX]== 1 || (visited[locY-1][locX]!=0 && visited[locY-1][locX]<= dist+1)) up = false;

            //if dead end stop traversing
            if(left==false && right==false && up==false && down==false){

                return;
            }

            //carry on traversing in passable directions
            if(right){
                traverseMap(tempMap,locX +1, locY, dist+1, destX, destY);
            }
            if(down) {
                traverseMap(tempMap, locX, locY+1, dist+1, destX, destY);
            }

            if(up){
                traverseMap(tempMap, locX, locY-1, dist+1, destX, destY);
            }
            if(left){
                traverseMap(tempMap, locX-1, locY, dist+1, destX, destY);
            }
        }

}
