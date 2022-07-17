import java.util.Arrays;

public class Solution {
    public static int solution(int[] x, int[] y) {
        int[] tl;
        int[] ts;
        if(x.length > y.length) {
            tl = x;
            ts = y;
        }else{
            tl = y;
            ts = x;
        }
        boolean found = false;
        for (int i=0; i < tl.length; i++){
            found = true;
            for (int j=0; j < ts.length; j++){
                if(tl[i] == ts[j]){
                    found = false;
                    break;
                }
            }
            if (found){
                System.out.println(tl[i]);
                return tl[i];
            }
        }
        System.out.println(404);
        return 404;
    }

}
