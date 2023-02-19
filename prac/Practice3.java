


public class Practice3 { 
    public static void main(String args[]) {
        int[] arr1 = {1,3,4,4,4,4,4,4,4,4};
        int[] arr2 = {2,5,7};
        System.out.println(solutions(1,0,1));
        System.out.println(findZip("all zip files are... yeah"));
        System.out.println(checkPerfect(496));
        System.out.println(flipEndChars("addA"));
        System.out.println(isValidHexCode("#eEec/5"));
        System.out.println(same(arr1, arr2));
        System.out.println(isKaprekar(9));
        System.out.println(longestZero("00010"));
        System.out.println(nextPrime(30));
        System.out.println(rightTringle(105, 100, 145));
    }

    public static int solutions(double a, double b, double c) {
        double d = b*b - 4*a*c;
        if ( d < 0 ) {
            return 0;
        } else if ( d == 0 ) {
            return 1;
        } else {
            return 2;
        }
    }

    public static int findZip(String zipStr) {
        return zipStr.replaceFirst("zip", "   ").indexOf("zip");
    }

    public static boolean checkPerfect(int num) {
        int sum = 1;
        for ( int i = 2; i<=num/2; i++) {
            if(num%i == 0) {
                sum+=i;
            }
        }
        return sum == num;
    }

    public static String flipEndChars(String str) {

        if ( str.length() < 2 ) {
            return "Incompatible.";
        } else if ( str.charAt(0) == str.charAt(str.length()-1) ) {
            return "Two's a pair";
        } else {
            char[] ch = str.toCharArray();
            char temp = ch[0];
            ch[0] = ch[ch.length - 1];
            ch[ch.length - 1] = temp;
            return String.valueOf(ch);
        }
    }

    public static boolean isValidHexCode(String hexWord) {
        return hexWord.length() == 7 && hexWord.replaceFirst("#", "").matches("[a-zA-Z0-9]*");
    }

    public static boolean same(int[] arr1, int[] arr2) {
        return java.util.Arrays.stream(arr1).distinct().count() == java.util.Arrays.stream(arr2).distinct().count();
    }

    public static boolean isKaprekar(int num) {
        Double num2 = Double.valueOf(num*num);
        String str = num2.toString();
        if ( str.replace(".0", "").length() <= 1 ) {
            return num == num*num;
        } else if ( str.length()%2 == 0 ) {
            return Double.parseDouble(str.substring(0, str.length()/2-1)) + Double.parseDouble(str.substring(str.length()/2-1)) == num;
        } else {
            return Double.parseDouble(str.substring(0, str.length()/2-1)) + Double.parseDouble(str.substring(str.length()/2-1)) == num;
        }
    }

    public static String longestZero(String str) {
        int zero_counter = 0;
        int max_count = 0;
        for ( int i = 0; i < str.length(); i++ ) {
            if ( str.charAt(i) != '0' ) {
                if ( max_count < zero_counter ) {
                    max_count = zero_counter;
                }
                zero_counter = 0;
            } else {
                zero_counter++;
            }
        }
        return new String(new char[max_count]).replace("\0", "0");
    }

    public static boolean isPrime(int num) {
        for ( int i = 2; i<=num/2;i++ ) {
            if ( num%i == 0 ) {
                return false;
            }
        }
        return true;
    }

    public static int nextPrime(int num) {
        if ( isPrime(num) ) {
            return num;
        } else {
            return nextPrime(num+1);
        }
    }

    public static boolean rightTringle(int a, int b, int c) {
        if ( a > b && a > c ) {
            return a*a == b*b + c*c;
        } else if ( b > a && b > c ) {
            return b*b == a*a + c*c;
        } else {
            return b*b + a*a == c*c;
        }
    }
}
