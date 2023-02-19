
class Practice1 {

    public static void main(String[] args) {
        System.out.println(remainder(4, 3));
        System.out.println(TriArea(3, 3));
        System.out.println(animals(2, 3, 5));
        System.out.println(profitableGamble(0.2, 50, 9));
        System.out.println(ctoa('A'));
        System.out.println(addUpTo(10));
        int[] arr = {3,4,5};
        System.out.println(sumOfCubes(arr));
        System.out.println(abcmath(5, 2, 1));
        System.out.println(abcmath(1, 2, 3));
    }

    static private int remainder(int num1, int num2){
        return num1%num2;
    }

    static private double TriArea(int num1, int num2){
        return (num1*num2)/2.0;
    }
    
    static private int animals(int num1, int num2, int num3){
        return num1*2 + num2*4 + num3*4;
    }

    static private boolean profitableGamble(double num1, double num2, double num3){
        return num1*num2 > num3;
    }

    static private String operation(double num1, double num2, double num3){
        if ( num3 == num1+num2 ) {
            return "added";
        } else if ( num3 == num1 - num2 ) {
            return "subtracted";
        } else if ( num3 == num1/num2 ) {
            return "divide";
        } else if ( num3 == num1*num2 ) {
            return "multiply";
        } else {
            return "none";
        }
    }

    static private int ctoa(char character){
        return (int) character;
    }

    static private int addUpTo(int num) {
        if ( num <= 0 ) {
            return 0;
        } else { 
            return addUpTo(num-1) + num;
        }
    }

    static private int nextEdge( int a, int b ) {
        return a+b-1;
    }

    static private int sumOfCubes( int[] numsArr ) {
        int sum = 0;
        for ( int i = 0; i<numsArr.length;i++ ) {
            sum+=numsArr[i]*numsArr[i]*numsArr[i];
        }
        return sum;
    }
    
    static private boolean abcmath( int a, int b, int c ) {
        for ( int i = 0; i<b;i++ ) {
            a+=a;
        }
        return a%c == 0;
    }
}