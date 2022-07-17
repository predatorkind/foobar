
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {



        //int map[][] = {{0,1,1,0},{0,0,0,1},{1,1,0,0},{1,1,1,0}};
        //int map[][] = {{0,1,1,0},{0,0,0,1},{1,1,0,0},{1,1,1,0},{1,1,1,0}};
        //int map[][] = {{0,1,1,1},{0,0,0,0}};
        //int map[][] = {{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}};
        //int map[][] = {{0,0,0,0},{0,1,0,0},{0,1,1,0},{0,0,0,0}};
        //int map[][] = {{0,0,0,0,0,0},{1,1,1,1,1,0},{0,0,0,0,0,0},{0,1,1,1,1,1},{0,1,1,1,1,1},{0,0,0,0,0,0}};
        //int map[][] = {{0,0,0},{0,0,0},{0,0,0}};
        //int map[][] = {{0,1,1,0,0,0}, {0,1,1,0,0,0}, {0,1,0,0,0,0}, {0,1,0,0,1,0}, {0,1,0,0,1,0}, {0,0,0,0,1,0}};
        //int map[][] = {{0,1,0,0,0,1,0,0,0}, {0,0,0,1,0,0,0,1,0}};

       int map[][] ={{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0}};

        System.out.println(Solution6.solution(map));

        map = new int[][]{{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 0}};

        System.out.println(Solution6.solution(map));

        map = new int[][]{{0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}};

        System.out.println(Solution6.solution(map));










        //System.out.println(Arrays.toString(Solution5.swapInner(0, 3, (new int[]{6, 9, 1, 10}))));
        //int[][]result = Solution5.sortM(new int[][]{{0, 2, 1, 0, 0},{0, 0, 0, 3, 4},{0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}});
        //int[][]result = Solution5.sortM(new int[][]{{0, 1, 0, 0, 0, 1},{4, 0, 0, 3, 2, 0},{0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}});
        //int[][]result = Solution5.sortM(new int[][]{{0, 2, 1, 0, 0},{0, 0, 0, 3, 4},{0,3,0,1,0}, {0,0,0,0,0}, {0,0,0,0,0}});
        /*
        for(int i=0; i<result.length;i++){
            System.out.println(Arrays.toString(result[i]));
        }
        /*



        int[][] resultR = Solution5.getSubR(result);
        for(int i=0; i<resultR.length;i++){
            System.out.println(Arrays.toString(resultR[i]));
        }
        int[][] resultQ  = Solution5.getSubQ(result);
        for(int i=0; i<resultQ.length;i++){
            System.out.println(Arrays.toString(resultQ[i]));
        }
        */
        //System.out.println();
        //Solution5.setIntMatrix(new int[][]{{0, 2, 1, 0, 0},{0, 0, 0, 3, 4},{0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}});
        //Solution5.setIntMatrix(new int[][]{{0, 2, 1, 0, 0},{0, 0, 0, 3, 4},{0,3,0,1,0}, {0,0,0,0,0}, {0,0,0,0,0}});
        //Solution5.setIntMatrix(new int[][]{{0, 1, 0, 0, 0, 1},{4, 0, 0, 3, 2, 0},{0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}});

        /*
        for(int i=0; i<Solution5.intMatrix.length;i++){
            System.out.println(Arrays.toString(Solution5.intMatrix[i]));
        }
        System.out.println();
        Solution5.setRatMatrix();
        for(int i=0; i<Solution5.ratMatrix.length;i++){
            System.out.println(Arrays.toString(Solution5.ratMatrix[i]));
        }

        Solution5.identityMatrix = Solution5.getIdentity(Solution5.intMatrix);
        for(int i=0; i<Solution5.identityMatrix.length;i++){
            System.out.println(Arrays.toString(Solution5.identityMatrix[i]));
        }

        Solution5.rMatrix = Solution5.getSubR(Solution5.intMatrix);
        for(int i=0; i<Solution5.rMatrix.length;i++){
            System.out.println(Arrays.toString(Solution5.rMatrix[i]));
        }

        Solution5.qMatrix = Solution5.getSubQ(Solution5.intMatrix);
        for(int i=0; i<Solution5.qMatrix.length;i++){
            System.out.println(Arrays.toString(Solution5.qMatrix[i]));
        }

        System.out.println(Arrays.toString(Solution5.solution(new int[][]{{0, 2, 1, 0, 0},{0, 0, 0, 3, 4},{0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}})));
        System.out.println(Arrays.toString(Solution5.solution(new int[][]{{0, 1, 0, 0, 0, 1},{4, 0, 0, 3, 2, 0},{0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}})));
        System.out.println(Arrays.toString(Solution5.solution(new int[][]{{0}})));
        System.out.println(Arrays.toString(Solution5.solution(new int[][]{{0,1},{1,0}})));
        */
    }
}
