public class Pratice3test {
    
    public static void main(String arg[]) {
        System.out.println(flipEndChars("Aboba"));
    }

    public static String flipEndChars(String str) {
        if ( str.length() < 2 ) {
            return "It's not campatible";
        } else if ( str.charAt(0) == str.charAt(str.length()-1) ) {
            return "Two is the pair";
        } else {
            return str.charAt(str.length()-1) + str.substring(1, str.length()-1) + str.charAt(0);
        }
    }

}
