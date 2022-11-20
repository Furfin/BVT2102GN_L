
import java.util.Arrays;

public class Practice2 {

    public static void main(String args[]) {
        int[] array = {10,-10,32,4,0,5,22};
        System.out.println(repeat("stop", 2));
        System.out.println(maxMin(array));
        System.out.println(isAvgWhole(array)); // 63%7
        System.out.println(Arrays.toString(cumulativeSum(array)));
        System.out.println(getDecimalPlaces("42.20"));
        System.out.println(Fibonacci(11));
        System.out.println(isValid("85447"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
    }

    public static String repeat(String word, int count) {
        String answ = "";
        for(int i = 0; i < word.length();i++) {
            answ+= new String(new char[count]).replace("\0", String.valueOf(word.charAt(i)));
        }
        return answ;
    }

    public static int maxMin(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        return max - min;
    }

    public static boolean isAvgWhole(int[] nums) {
        int sum = 0;
        for(int i = 0; i< nums.length;i++) { 
            sum+= nums[i];
        }
        return sum%nums.length == 0;
    }

    public static int recursiveHelper(int index, int[] nums) {
        if (index == 0) {
            return nums[index];
        } else {
            return nums[index] + recursiveHelper(index-1, nums);
        }
    }

    public static int[] cumulativeSum(int[] nums) {
        int[] answ = new int[nums.length];
        for(int i = 0; i<nums.length;i++) {
            answ[i] = recursiveHelper(i, nums);
        }
        return answ;
    }

    public static int getDecimalPlaces(String floatStr) {
        int dP = 0;
        boolean point = false;
        for ( int i = 0; i<floatStr.length();i++) {
            if ( point ) {
                dP++;
            }
            if ( floatStr.charAt(i) == '.' ) {
                point = true;
            }
        }
        return dP;
    }

    public static int Fibonacci(int n) {
        if ( n == 0 ) {
            return 0;
        } else if ( n == 1 ) {
            return 1;
        } else if ( n == 2 ) {
            return 1;
        } else {
            return Fibonacci(n-1) + Fibonacci(n-2);
        }
    }

    public static boolean isValid(String postIndex) {
        return (postIndex.length() == 5 && postIndex.matches("[0-9]+"));
    }

    public static boolean isStrangePair(String word1, String word2) {
        if ( (word1.length()>=2 && word2.length()>=2)
        && (word1.charAt(0) != word2.charAt(word2.length()-1) || word2.charAt(0) != word1.charAt(word1.length()-1))) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isPrefix(String word, String prefix) { 
        for(int i = 0; i<prefix.length()-1;i++) {
            if(word.charAt(i) != prefix.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSuffix(String word, String suffix) { 
        for(int i = suffix.length()-1; i>1;i--) {
            if(word.charAt((word.length()-1) - (suffix.length()-1-i)) != suffix.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static int boxSeq(int n) {
        if ( n%2 == 0 ) {
            return n;
        } else {
            return n+2;
        }
    }
}
