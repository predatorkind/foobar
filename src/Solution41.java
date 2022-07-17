import java.math.BigInteger;

public class Solution41 {
    public static String solution(String M, String F){
        BigInteger B1, B2;
        try {
            B1 = new BigInteger(M);
            B2 = new BigInteger(F);
        }catch (Exception e){
            System.out.println("impossible");
            System.out.println("________");
            return "impossible";
        }
        BigInteger cycle = new BigInteger("0");



        while(true){

            if(B1.compareTo(BigInteger.ONE)==0){
                if(B2.compareTo(BigInteger.ONE)==0){
                    System.out.println(cycle);
                    System.out.println("________");
                    return cycle.toString();
                }
            }
            cycle= cycle.add(BigInteger.ONE);

            if(B1.compareTo(B2)==-1){
                BigInteger temp= B1;
                B1 = B2;
                B2 = temp;
            }

            if((B1.compareTo(B2)==1)){
                B1=B1.subtract(B2);
            }

            if(B1.compareTo(B2)==0){
                if(B1.compareTo(BigInteger.ONE)==1){
                    B1=B1.subtract(B2);
                }
            }
            if(B1.compareTo(BigInteger.ONE)==0){

                if(B2.compareTo(BigInteger.ONE)==0){
                    System.out.println(cycle);
                    System.out.println("________");
                    return cycle.toString();
                }
            }
            System.out.println(B1 + " " + B2);

            if(B1.compareTo(BigInteger.ONE)==-1){
                System.out.println("impossible");
                System.out.println("________");

                return "impossible";

            }
            if(B2.compareTo(BigInteger.ONE)==-1){
                System.out.println("impossible");
                System.out.println("________");
                return "impossible";
            }
        }

    }
}
