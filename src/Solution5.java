
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;
import java.lang.Comparable;

public class Solution5 {
    static ArrayList<Integer> transientStates;
    static ArrayList<Integer> absorbingStates;

    static Rat[][] ratMatrix;
    static Rat[][] identityMatrix;
    static Rat[][] rMatrix;
    static Rat[][] qMatrix;
    static int N = 0;
    public static int[] solution(int[][] m){
        if(m.length==1)return new int[]{1,1};
        absorbingStates = new ArrayList<Integer>();
        transientStates = new ArrayList<Integer>();
        for(int i=0; i<m.length;i++){
            if(isAbsorbing(m[i])){
                absorbingStates.add(i);
            }else{
                transientStates.add(i);
            }
        }

        setRatMatrix(m);
        qMatrix = getSubMatrix(ratMatrix, transientStates, transientStates);
        rMatrix = getSubMatrix(ratMatrix, transientStates, absorbingStates);
        identityMatrix = getIdentity(qMatrix.length);
        return calculateFR();
    }
    public static int[] calculateFR(){
        Rat iMinusQ[][] = new Rat[qMatrix.length][qMatrix.length];
        for(int i=0; i<iMinusQ.length; i++){
            for(int j=0;j<iMinusQ.length;j++){
                iMinusQ[i][j] = identityMatrix[i][j].minus(qMatrix[i][j]);

            }
        }

        N = iMinusQ.length;
        Rat fMatrix[][] = new Rat[qMatrix.length][qMatrix.length];

        inverse(iMinusQ,fMatrix);

        Rat[][] fr = new Rat[fMatrix.length][rMatrix[0].length];

        for(int i=0; i< fMatrix.length; i++){

            for(int k=0;k< rMatrix[0].length;k++){
                Rat sum = Rat.ZERO;
                for(int j=0;j< fMatrix[0].length;j++){

                    sum = sum.plus(fMatrix[i][j].times(rMatrix[j][k]));

                }
                fr[i][k]=sum;

            }

        }

        int positiveCount = 0;
        for(int i=0; i<fr[0].length;i++){
            if(fr[0][i].isPositive())positiveCount++;
        }

        int[] lcmInput = new int[positiveCount];
        int index=0;
        for(int i=0; i<fr[0].length;i++){
            if(fr[0][i].isPositive()){
                lcmInput[index] = fr[0][i].den.intValue();
                index++;
            }
        }
        int lcm = lcm(lcmInput);


        int[] result = new int[fr[0].length +1];
        for(int i=0;i<fr[0].length;i++){
            int num = fr[0][i].num.intValue() * (lcm/fr[0][i].den.intValue());
            result[i]= num;
        }
        result[result.length-1]=lcm;

        return result;
    }
    public static int lcm(int[] element_array){
        int lcm = 1;
        int divisor = 2;

        while (true) {
            int counter = 0;
            boolean divisible = false;

            for (int i = 0; i < element_array.length; i++) {


                if (element_array[i] == 0) {
                    return 0;
                }
                else if (element_array[i] < 0) {
                    element_array[i] = element_array[i] * (-1);
                }
                if (element_array[i] == 1) {
                    counter++;
                }

                if (element_array[i] % divisor == 0) {
                    divisible = true;
                    element_array[i] = element_array[i] / divisor;
                }
            }

            if (divisible) {
                lcm = lcm * divisor;
            }
            else {
                divisor++;
            }

            if (counter == element_array.length) {
                return lcm;
            }
        }
    }
    static boolean inverse(Rat arr[][], Rat [][]inverse){
        // Find determinant of arr[][]
        Rat det = determinant(arr, N);
        if (det == Rat.ZERO)
        {

            return false;
        }

        // Find adjoint
        Rat [][]adj = new Rat[N][N];
        adjoint(arr, adj);

        // Find Inverse
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                inverse[i][j] = adj[i][j].divides(det) ;

        return true;
    }
    public static void getCofactor(Rat arr[][], Rat temp[][], int p, int q, int n){
        int i = 0, j = 0;

        // Looping for each element of the matrix
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                // Copying into temporary matrix only those element
                // which are not in given row and column
                if (row != p && col != q)
                {
                    temp[i][j++] = arr[row][col];

                    // Row is filled, so increase row index and
                    // reset col index
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
    static Rat determinant(Rat arr[][], int n){
        Rat D = Rat.ZERO; // Initialize result

        // Base case : if matrix contains single element
        if (n == 1)
            return arr[0][0];

        Rat [][]temp = new Rat[N][N]; // To store cofactors

        Rat sign = Rat.ONE; // To store sign multiplier

        // Iterate for each element of first row
        for (int f = 0; f < n; f++)
        {
            // Getting Cofactor of arr[0][f]
            getCofactor(arr, temp, 0, f, n);
            //D += sign * arr[0][f] * determinant(temp, n - 1);
            D = D.plus(sign.times(arr[0][f].times(determinant(temp,n-1))));
            // terms are to be added with alternate sign
            sign = sign.negate();
        }

        return D;
    }
    static void adjoint(Rat arr[][],Rat [][]adj){
        if (N == 1)
        {
            adj[0][0] = Rat.ONE;
            return;
        }

        // temp is used to store cofactors of arr[][]
        Rat sign = Rat.ONE;
        Rat [][]temp = new Rat[N][N];

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                // Get cofactor of A[i][j]
                getCofactor(arr, temp, i, j, N);

                // sign of adj[j][i] positive if sum of row
                // and column indexes is even.
                sign = ((i + j) % 2 == 0)? Rat.ONE: Rat.ONE.negate();

                // Interchanging rows and columns to get the
                // transpose of the cofactor matrix
                adj[j][i] = (sign.times(determinant(temp, N-1)));
            }
        }
    }

    public static void setRatMatrix(int[][] arr){
        //int[][] temp = new int[intMatrix.length][intMatrix.length];
        //for(int k=0; k< intMatrix.length; k++){
        //    temp[k] = Arrays.copyOf(intMatrix[k], intMatrix.length);
        //}
        //int[][] temp = Arrays.copyOf(intMatrix);
        //toIdentity(temp);
        ratMatrix = new Rat[arr.length][arr.length];
        for(int i=0;i< arr.length; i++){
            if(isAbsorbing(arr[i])){
                for(int j=0;j< arr.length; j++) {
                    ratMatrix[i][j] = Rat.ZERO;
                }
                ratMatrix[i][i] = Rat.ONE;
            }else{
                for(int j=0;j< arr.length; j++) {
                    ratMatrix[i][j] = new Rat(arr[i][j], getDen(arr[i]));
                }
            }
        }
    }
    public static int getDen(int[] arr){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }
    private static Rat[][] getSubMatrix(Rat arr[][], ArrayList<Integer> rows, ArrayList<Integer> cols){
        Rat [][]sub = new Rat[rows.size()][cols.size()];
        for(int i=0; i<rows.size();i++){
            for(int j=0; j< cols.size(); j++){
                sub[i][j] = arr[rows.get(i)][cols.get(j)];
            }
        }
        return sub;
    }

    public static Rat[][] getIdentity(int dim){
        Rat[][] result = new Rat[dim][dim];
        for(int j=0; j<dim;j++){
            for(int k =0; k< dim;k++){
                result[j][k] = Rat.ZERO;
            }
            result[j][j] = Rat.ONE;
        }
        return result;
    }


    private static boolean isAbsorbing(int arr[]){

        for(int i=0; i<arr.length;i++){
            if(arr[i]>0)return false;
        }
        return true;
    }
    public static class Rat implements Comparable<Rat> {

        public final static Rat ZERO = new Rat(0);
        public final static Rat ONE  = new Rat(1);

        private BigInteger num;   // the numerator
        private BigInteger den;   // the denominator (always a positive integer)


        // create and initialize a new Rat object
        public Rat(int numerator, int denominator) {
            this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
        }

        // create and initialize a new Rat object
        public Rat(int numerator) {
            this(numerator, 1);
        }


        // create and initialize a new Rat object
        public Rat(BigInteger numerator, BigInteger denominator) {
            init(numerator, denominator);
        }

        private void init(BigInteger numerator, BigInteger denominator) {

            // deal with x / 0
            if (denominator.equals(BigInteger.ZERO)) {
                throw new ArithmeticException("Denominator is zero");
            }

            // reduce fraction (if num = 0, will always yield den = 0)
            BigInteger g = numerator.gcd(denominator);
            num = numerator.divide(g);
            den = denominator.divide(g);

            // to ensure invariant that denominator is positive
            if (den.compareTo(BigInteger.ZERO) < 0) {
                den = den.negate();
                num = num.negate();
            }
        }

        // return string representation of (this)
        public String toString() {
            if (den.equals(BigInteger.ONE)) return num + "";
            else                            return num + "/" + den;
        }

        // return { -1, 0, + 1 } if a < b, a = b, or a > b
        public int compareTo(Rat b) {
            Rat a = this;
            return a.num.multiply(b.den).compareTo(a.den.multiply(b.num));
        }

        // is this Rat negative, zero, or positive?
        public boolean isZero()     { return num.signum() == 0; }
        public boolean isPositive() { return num.signum() >  0; }
        public boolean isNegative() { return num.signum() <  0; }

        // is this Rat object equal to y?
        public boolean equals(Object y) {
            if (y == this) return true;
            if (y == null) return false;
            if (y.getClass() != this.getClass()) return false;
            Rat b = (Rat) y;
            return compareTo(b) == 0;
        }

        // hashCode consistent with equals() and compareTo()
        public int hashCode() {
            return Objects.hash(num, den);
        }


        // return a * b
        public Rat times(Rat b) {
            Rat a = this;
            return new Rat(a.num.multiply(b.num), a.den.multiply(b.den));
        }

        // return a + b
        public Rat plus(Rat b) {
            Rat a = this;
            BigInteger numerator   = a.num.multiply(b.den).add(b.num.multiply(a.den));
            BigInteger denominator = a.den.multiply(b.den);
            return new Rat(numerator, denominator);
        }

        // return -a
        public Rat negate() {
            return new Rat(num.negate(), den);
        }

        // return |a|
        public Rat abs() {
            if (isNegative()) return negate();
            else return this;
        }

        // return a - b
        public Rat minus(Rat b) {
            Rat a = this;
            return a.plus(b.negate());
        }

        // return 1 / a
        public Rat reciprocal() {
            if(this.isZero())return Rat.ZERO;
            return new Rat(den, num);
        }

        // return a / b
        public Rat divides(Rat b) {
            Rat a = this;
            return a.times(b.reciprocal());
        }
    }
}
