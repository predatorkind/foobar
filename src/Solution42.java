import java.math.BigInteger;

public class Solution42 {
    public static String solution(String M, String F){
        BigInteger B1 = new BigInteger(M);
        BigInteger B2 = new BigInteger(F);
        BigInteger cycle = new BigInteger("0");

        while(true){

            if(B1.compareTo(BigInteger.ONE)==0){
                if(B2.compareTo(BigInteger.ONE)==0){
                    return cycle.toString();
                }
            }


            if(B1.compareTo(B2)==-1){
                BigInteger temp= B1;
                B1 = B2;
                B2 = temp;
            }

            if(B2.equals(BigInteger.ONE)){
                cycle= cycle.add(B1.subtract(BigInteger.ONE));
                return cycle.toString();
            }

            if((B1.compareTo(B2)==1)){
                if(B1.divide(B2).equals(BigInteger.ONE)){
                    B1=B1.subtract(B2);
                    cycle= cycle.add(BigInteger.ONE);
                }else if(B1.mod(B2).equals(BigInteger.ZERO)){
                    cycle=cycle.add(B1.divide(B2));

                    return "impossible";
                }else{
                    cycle = cycle.add(B1.divide(B2));
                    B1=B1.mod(B2);

                }


            }

            if(B1.compareTo(B2)==0){
                if(B1.compareTo(BigInteger.ONE)==1){
                    B1=B1.subtract(B2);
                }
            }

            if(B1.compareTo(BigInteger.ONE)==0){

                if(B2.compareTo(BigInteger.ONE)==0){
                    //return Long.toString(cycle);
                    return cycle.toString();
                }
            }
            if(B1.compareTo(BigInteger.ONE)==-1){
                //System.out.println(cycle);
                return "impossible";
            }
            if(B2.compareTo(BigInteger.ONE)==-1){
                //System.out.println(cycle);
                return "impossible";
            }
        }

    }
}
