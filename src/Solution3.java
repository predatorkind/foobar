import java.util.Arrays;
import java.util.ArrayList;


public class Solution3 {
    public static int solution(String n, int b) {

        int result =findPattern(n, b, new ArrayList<String>());

        System.out.println(result);



        return result;
    }

    private static int findPattern(String n, int b, ArrayList<String> list){
        if(list.contains(n)){
            int indx = list.indexOf(n);
            list.add(n);
            return (list.size()-1)-indx;
        }else{
            list.add(n);
            return findPattern(genNewId(n,b), b, list);
        }

    }
    private static String genNewId(String n, int b){
        int k = n.length();
        String x = sortD(n);
        String y = sortA(n);
        int xInt = Integer.parseInt(x,b);
        int yInt = Integer.parseInt(y,b);
        String z = Integer.toString(xInt-yInt,b);
        if (z.length()<k){
            for(int i=0;i< k-z.length(); i++){
                z = "0" + z;
            }
        }
        return z;
    }
    private static String sortD(String s){
        char sArray[]= s.toCharArray();
        int size = sArray.length;
        char temp;
        for(int i = 0; i < size; i++ ) {
            for(int j = i+1; j < size; j++) {
                if(sArray[i]<sArray[j]) {
                    temp = sArray[i];
                    sArray[i] = sArray[j];
                    sArray[j] = temp;
                }
            }
        }
        String sD = new String(sArray);
        return sD;
    }
    private static String sortA(String s){
        char sArray[] = s.toCharArray();
        Arrays.sort(sArray);
        String sA = new String(sArray);
        return sA;
    }

}
