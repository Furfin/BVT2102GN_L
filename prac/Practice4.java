
import java.util.*; 

class Practice4 {


    public static void main(String args[]) {
        double arr[] = {13.25, 15, 30, 1.5};
        Bessy("10,7 hello my name is Bessie and this is my essay"); // 10,7 hello my name is Bessie and this is my essay
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(toCamelCase("abcd_efg_ahahha_not_a_word"));
        System.out.println(toSnakeCase("abcdEfGhAHHAHAHhahahH"));
        overTime(arr);
        BMI("205 pounds", "73 inches");
        System.out.println(bugger(39));
        System.out.println(toStarShortHand("abbccc"));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(trouble(451999277L, 41177722899L));
        System.out.println(countUnique("AZYWABBCATTTA", 'A'));
    }

    public static void Bessy(String str) {
        Scanner scan = new Scanner(str);
        scan.useDelimiter(",|\\n| ");
        int n = scan.nextInt();
        int k = scan.nextInt();
        String word = scan.next();
        int currentLen = word.length();
        System.out.print(word);
        while( n > 1 ) {
            word = scan.next();
            if ( currentLen+word.length() <= k ) {
                currentLen+=word.length();
                System.out.print(" ");
                System.out.print(word.replace("\n",""));
            } else {
                currentLen = word.length();
                System.out.print("\n");
                System.out.print(word.replace("\n",""));
            }
            n--;
        }
        System.out.print("\n");
    }


    public static String split( String cluster ) {
        List<String> answ = new ArrayList<String>();
        String element = "";
        int balance = 0;
        element = element + cluster.charAt(0);
        if ( cluster.charAt(0) == '(' ) {
            balance += 1;
        } else {
            balance -= 1;
        }
        for ( int i = 1; i < cluster.length(); i++ ) {
            if ( cluster.charAt(i) == '(' ) {   
                balance += 1;
            } else {
                balance -= 1;
            }
            element = element + cluster.charAt(i);
            if ( balance == 0 ) {
                answ.add(element);
                element = "";
            }
        }
        return answ.toString();
    }

    public static String toCamelCase(String str) {
        for( int i = 0; i < str.length(); i++ ) {
            if ( str.charAt(i) == '_' ) {
                str = str.substring(0, i+1) + Character.toUpperCase(str.charAt(i+1)) + str.substring(i+2, str.length());
            }
        }
        return str.replace("_","");
    }

    public static String toSnakeCase(String str) {
        for( int i = 0; i < str.length(); i++ ) {
            if ( Character.isUpperCase(str.charAt(i)) ) {
                str = str.substring(0, i) + '_' + Character.toLowerCase(str.charAt(i)) + str.substring(i+1, str.length());
            }
        }
        return str;
    }

    public static void overTime(double inf[]) {
        if ( inf[1] > 17 && inf[0] >= 17) {
            System.out.format("$%.2f\n",(inf[1] - inf[0])*inf[2]*inf[3]);
        } else if (inf[1] > 17 && inf[0] < 17) {
            System.out.format("$%.2f\n",(17 - inf[0])*inf[2] + (inf[1] - 17)*inf[2]*inf[3]);
        } else {
            System.out.format("$%.2f\n",(inf[1] - inf[0])*inf[2]);
        }
    }

    public static void BMI(String str1, String str2) {
        Scanner scanM = new Scanner(str1);
        Scanner scanH = new Scanner(str2);
        double m = scanM.nextDouble();
        String mass = scanM.next();
        double h = scanH.nextDouble();
        String height = scanH.next();
        if ( mass.equalsIgnoreCase("pounds") ) {
            m = m*0.453592;
        }
        if ( height.equalsIgnoreCase("inches" )) {
            h = h*0.0254;
        }
        double BMI = m/(h*h);
        if ( BMI < 18.5 ) {
            System.out.format("%.1f underweight\n", BMI);
        } else if ( BMI >= 25 ) {
            System.out.format("%.1f overweight\n", BMI);
        } else {
            System.out.format("%.1f normal weight\n", BMI);
        }
    }

    public static int bugger(int num) {
        String str = String.valueOf(num);
        Scanner scan = new Scanner(str).useDelimiter("");
        int iters = 0;
        int curr_num = 1;

        while(true && num >= 10) {
            while(scan.hasNext()) {
                curr_num = curr_num*scan.nextInt();
            }
            iters++;
            if ( curr_num<= 9 ) {
                break;
            } else {
                num = curr_num;
                curr_num = 1;
                str = String.valueOf(num);
                scan = new Scanner(str).useDelimiter("");
            }
        }
        return iters;
    }

    static public String toStarShortHand(String str) {
        int count = 1;
        for( int i = 1; i < str.length(); i++ ) {
            if ( str.charAt(i) != str.charAt(i-1) ) {
                if ( count > 1 ) {
                    str = str.substring(0, i-count)+str.charAt(i-1)+'*'+String.valueOf(count)+str.substring(i, str.length());
                    count = 0;
                    break;
                }
            } else {
                count++;
            }
        }
        if ( count == 0 ) {
            return toStarShortHand(str);
        } else {
            if ( count != 1 ) {
                int i = str.length();
                str = str.substring(0, i-count)+str.charAt(i-1)+'*'+String.valueOf(count)+str.substring(i, str.length());
    
            }
                return str;
        }   
    }

    public static boolean doesRhyme(String str1, String str2) {
        Scanner scan1 = new Scanner(str1);
        Scanner scan2 = new Scanner(str2);
        String word1 = scan1.next();
        String word2 = scan2.next();
        List<String> vowels1 = new ArrayList<String>();
        List<String> vowels2 = new ArrayList<String>();
        while( scan1.hasNext() ) {
            word1 = scan1.next();
        }
        while( scan2.hasNext() ) {
            word2 = scan2.next();
        }
        for ( int i = 0; i<word1.length(); i++ ) {
            if (word1.charAt(i) == 'a' || word1.charAt(i) == 'e'
            || word1.charAt(i) == 'i' || word1.charAt(i) == 'o'
            || word1.charAt(i) == 'u' || word1.charAt(i) == 'A'
            || word1.charAt(i) == 'E' || word1.charAt(i) == 'I'
            || word1.charAt(i) == 'O'
            || word1.charAt(i) == 'U') {
                vowels1.add(""+Character.toLowerCase(word1.charAt(i)));
            }
        }
        for ( int i = 0; i<word2.length(); i++ ) {
            if (word2.charAt(i) == 'a' || word2.charAt(i) == 'e'
            || word2.charAt(i) == 'i' || word2.charAt(i) == 'o'
            || word2.charAt(i) == 'u' || word2.charAt(i) == 'A'
            || word2.charAt(i) == 'E' || word2.charAt(i) == 'I'
            || word2.charAt(i) == 'O'
            || word2.charAt(i) == 'U') {
                vowels2.add(""+Character.toLowerCase(word2.charAt(i)));
            }
        }
        return vowels1.equals(vowels2);  
    }

    public static boolean trouble(Long num1, Long num2) {
        List<String> nums = new ArrayList<String>();
        int count1 = 1;
        int count2 = 1;
        String str1 = String.valueOf(num1) + '|';
        String str2 = String.valueOf(num2) + '|';
        for ( int i = 1; i < String.valueOf(num1).length(); i++) {
            if ( str1.charAt(i) !=  str1.charAt(i-1) ) {
                if ( count1 == 3 ) {
                    nums.add(""+str1.charAt(i-1));
                }
                count1 = 1;
            } else {
                count1++;
            }
        }

        for ( int i = 1; i < str2.length(); i++) {
            if ( str2.charAt(i) !=  str2.charAt(i-1) ) {
                if ( count2 == 2 && nums.contains(""+str2.charAt(i-1))) {
                    System.out.println(str2.charAt(i-1));
                    return true;
                }
                count2 = 1;
            } else {
                count2++;
            }
        }
        return false;
    }

    public static long countUnique(String str, char del) {
        HashSet<String> books = new HashSet<String>();
        int balance = 0;
        for ( int i = 0; i < str.length(); i++ ) {
            if ( str.charAt(i) == del ) {
                balance = Math.abs(balance - 1);
            } else if ( balance == 1 ) {
                books.add(""+str.charAt(i));
            }
        }
        return books.size();
    }
}