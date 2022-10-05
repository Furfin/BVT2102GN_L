package lab1;
public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if(isPalindrome(s)){
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
    //string reversal method
    public static String reverseString(String s){
        String container = "";
        for(int i = s.length()-1;i>=0;i--){
            container+=s.charAt(i);
        }
        return container;
    }

    //method for checking string for palindrome
    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }
}
