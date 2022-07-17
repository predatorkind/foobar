import java.util.ArrayList;
import java.lang.System;
import java.math.BigInteger;

public class Solution4 {
    public static String solution(String x, String y){
        try {
            BigInteger M, F;
            try {
                M = new BigInteger(x);
                F = new BigInteger(y);
            } catch (NumberFormatException e) {
                System.out.println(e);
                return "impossible";
            }
            //if ((M % 2 == 0) && (F % 2 == 0)) return "impossible";
            ArrayList<String> permuts = new ArrayList<String>();

            int cycleCount = 1;
            long result;
            boolean imp;

            while (true) {

                permuts = retPermuts(cycleCount);

                for (int i = 0; i < permuts.size() - 1; i++) {
                    BigInteger currentM = BigInteger.ONE;
                    BigInteger currentF = BigInteger.ONE;
                    char pArray[] = permuts.get(i).toCharArray();
                    for (int j = 0; j < pArray.length; j++) {

                        if (pArray[j] == '0') {
                            currentM = currentM.add(currentF);
                        } else {
                            currentF = currentF.add(currentM);
                        }

                    }
                    result = checkResult(currentM, currentF, M, F);
                    if (result == 1) return Long.toString(cycleCount);
                    if (result == 2) permuts.set(i, "2");
                }
                imp = true;
                for (String r : permuts) {
                    if (!r.equals("2")) imp = false;
                    break;
                }
                if (imp) return "impossible";
                cycleCount++;
            }
        }catch(Exception e){
            System.out.println(e);
            return "impossible";
        }


    }

    private static ArrayList<String> retPermuts(int len){
        ArrayList<String> permuts= new ArrayList<String>();
        genPermuts(len, new long[len], 0, permuts);

        return permuts;
    }

    private static void genPermuts(long len, long arr[], int pos, ArrayList<String> list){


        if(len==pos){

            String s = "";
            for(int c=0; c<arr.length; c++){
                s+=arr[c];
            }

            list.add(s);
            return;
        }

        arr[pos]=0;
        genPermuts(len, arr, pos +1, list);
        arr[pos]=1;
        genPermuts(len, arr, pos +1, list);

    }

    private static int checkResult(BigInteger curM, BigInteger curF, BigInteger tarM, BigInteger tarF){
        if(tarM==BigInteger.ZERO && curF==tarF)return 1;
        if(curM==tarM && tarM==BigInteger.ZERO)return 1;
        if(curM==tarM && curF==tarF)return 1;
        if(curM.compareTo(tarM)==1 || curF.compareTo(tarF)==1)return 2;
        return 0;
    }
}
