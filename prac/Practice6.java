import java.util.*; 

public class Practice6 {
    public static void main(String args[]) {
        System.out.println(bell(6));
        System.out.println(translateWord("ate"));
        System.out.println(translateSentance("ahahah, ahahha Chicken?!!!"));
        System.out.println(validColor("rgb(255,256,255)") );
        System.out.println(validColor("rgba(0,0,0,0.123456789)"));
        System.out.println(stripURLparams("https://edabit.com?a=1&b=2&a=2"));
        System.out.println(getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year"));
        System.out.println(ulam(206));
        System.out.println(longestNonrepeatingSubstring("abcabcbb"));
        System.out.println(convertToRoman(104));
        System.out.println(formula("6 * 4 = 24 = 24 * 1"));
        System.out.println(palindromedescendant("1021"));
        System.out.println(palindromedescendant("23336014"));
    }


    static private int stirl(int m, int k) {
        if ( m == 0 && k == 0) {
            return 1;
        } else if ( k == 0) {
            return 0;
        } else if ( k > m) {
            return 0;
        } else {
            return stirl(m-1, k-1) + k*stirl(m-1, k);
        }
    }

    static private int bell(int n) {
        int answ = 0;
        for ( int i = 0; i <= n; i++) {
            answ += stirl(n, i);
        }
        return answ;
    }

    static private String translateWord(String word) {
        StringBuilder add = new StringBuilder();
        if ( word.length() <= 0 ) {
            return "";
        }
        if (word.charAt(0) == 'a' || word.charAt(0) == 'e'
        || word.charAt(0) == 'i' || word.charAt(0) == 'o'
        || word.charAt(0) == 'u' || word.charAt(0) == 'A'
        || word.charAt(0) == 'E' || word.charAt(0) == 'I'
        || word.charAt(0) == 'O'
        || word.charAt(0) == 'U') {
            return word + "yay";
        } else {
            for ( int i = 0; i<word.length(); i++ ) {
                if (word.charAt(i) == 'a' || word.charAt(i) == 'e'
                || word.charAt(i) == 'i' || word.charAt(i) == 'o'
                || word.charAt(i) == 'u' || word.charAt(i) == 'A'
                || word.charAt(i) == 'E' || word.charAt(i) == 'I'
                || word.charAt(i) == 'O'
                || word.charAt(i) == 'U') {
                    return word.substring(i) + add.toString() + "ay";
                } else {
                    add.append(word.charAt(i));
                }
            }
        }
        return "";
    }

    public static String translateSentance(String str) {
        StringBuilder answ = new StringBuilder();
        StringBuilder word = new StringBuilder("");

        int i = 0;
        while( i < str.length() ) {
            if ( Character.isAlphabetic(str.charAt(i)) ) {
                word.append(str.charAt(i));
            } else if ( word.length() != 0 ) {
                if ( Character.isUpperCase(word.charAt(0))) {
                    answ.append(translateWord(word.toString()).toUpperCase().charAt(0)+translateWord(word.toString()).substring(1).toLowerCase());
                } else {
                    answ.append(translateWord(word.toString().toLowerCase()).toLowerCase());
                }
                answ.append(str.charAt(i));
                word = new StringBuilder("");
            } else {
                answ.append(str.charAt(i));
                word = new StringBuilder("");
            }
            i++;

        }
        return answ.toString();
    }

    public static boolean validColor(String str) {
        int rgba = 0;
        if ( str.contains("rgba(")) {
            rgba = 1;
            str = str.replace("rgba(", "");
            str = str.replace(")", "");
        } else if (str.contains("rgb(")) {
            str = str.replace("rgb(", "");
            str = str.replace(")", "");
        } else {
            return false;
        }
        String word;
        Scanner scan = new Scanner(str);
        scan.useDelimiter(",");
        int count = 0;
        if ( rgba == 1 ) {
            while( scan.hasNext() ) {
                word = scan.next();
                count++;
                if ( word.length() == 0 || count > 4 ) {
                    return false;
                }
                if ( (Double.parseDouble(word) > 255 || Double.parseDouble(word) < 0) && count <= 3 )  {
                    return false;
                } else if ( (Double.parseDouble(word) > 1 || Double.parseDouble(word) < 0) ) {
                    return false;
                }
            }
        } else {
            while( scan.hasNext() ) {
                word = scan.next();
                count++;
                if ( word.length() == 0 || count > 3 ) {
                    return false;
                }
                if ( Double.parseDouble(word) > 255 || Double.parseDouble(word) < 1)  {
                    return false;
                }
            }
        }   
        return true;
    }

    public static String stripURLparams(String url, String ... params) {
        String word;
        List<String> param = new ArrayList<String>(Arrays.asList(params));
        List<String> allowedParam = new ArrayList<>();
        String newParam;
        Scanner scan = new Scanner(url);
        scan.useDelimiter("\\?");
        StringBuilder address = new StringBuilder(scan.next());
        word = scan.next();
        String paramss = word;

        Scanner paramScan;

        scan = new Scanner(word);
        scan.useDelimiter("&");

        while(scan.hasNext()) {
            word = scan.next();
            paramScan = new Scanner(word).useDelimiter("=");
            newParam = paramScan.next();
            
            if ( !param.contains(newParam) ) {
                allowedParam.add(newParam);
                param.add(newParam);
            } else if ( allowedParam.contains(newParam) ) {
                allowedParam.remove(newParam);
            }
        }

        if ( allowedParam.size() != 0 ) {
            address.append("?");
        }
        scan = new Scanner(paramss);
        scan.useDelimiter("&");
        while(scan.hasNext()) {
            paramss = scan.next();
            paramScan = new Scanner(paramss).useDelimiter("=");
            newParam = paramScan.next();
            if ( allowedParam.contains(newParam) ) {
                address.append(paramss);
                address.append("&");
            }
        }
        if (address.charAt(address.length()-1) == '&' ) {
            address = new StringBuilder(address.subSequence(0, address.length()-1));
        }

        return address.toString();

    }

    public static String getHashTags(String str) {
        String word1 = "";
        String word2 = "";
        String word3 = "";
        String new_word2 = "";
        String new_word3 = "";
        Scanner scan = new Scanner(str);
        String word;
        scan.useDelimiter(" |,");
        while( scan.hasNext() ) {
            word = scan.next();
            
            if ( word.length() > word1.length() ) {
                new_word2 = word1;
                word1 = word;
                new_word3 = word2;
                word3 = new_word3;
                word2 = new_word2;
            } else if ( word.length() > word2.length() ) {
                new_word3 = word2;
                word2 = word;
                word3 = new_word3;
            } else if ( word.length() > word3.length() ) {
                word3 = word;
            }
        }
        String[] answ = new String[]{"#"+word1, "#"+word2, "#"+word3};
        return Arrays.toString(answ);
    }

    static int ulam(int n) {
        Vector<Integer> arr = new Vector<Integer>();
        arr.add(1);
        arr.add(2);
        int i = 3;
        while(arr.size() < n + 1) {
            int count = 0;
            for (int j = 0; j < arr.size() - 1; j++) {
                for (int k = j + 1; k < arr.size(); k++) {
                    if (arr.get(j) + arr.get(k) == i) {
                        count++;
                    }
                    if (count > 1)
                        break;
                }
                if (count > 1)
                    break;
            }
            if (count == 1) {
                arr.add(i);
            }
            i++;
        }

        return arr.get(n);
    }

    static public String longestNonrepeatingSubstring(String str) {
        StringBuilder answ = new StringBuilder("" + str.charAt(0));
        String ransw = "";
        for(int i = 1; i < str.length(); i++) {
            if ( answ.lastIndexOf("" + str.charAt(i)) != -1 ) {
                if ( answ.toString().length() > ransw.length() ) {
                    ransw = answ.toString();
                    answ = new StringBuilder();
                }
            } else {
                answ.append(str.charAt(i));
            }
        }
        return ransw;
    }

    public static String convertToRoman(int input) {
        StringBuilder s = new StringBuilder();
        while (input >= 1000) {
            s.append("M");
            input -= 1000;
        }
        while (input >= 900) {
            s.append("CM");
            input -= 900;
        }
        while (input >= 500) {
            s.append("D");
            input -= 500;
        }
        while (input >= 400) {
            s.append("CD");
            input -= 400;
        }
        while (input >= 100) {
            s.append("C");
            input -= 100;
        }
        while (input >= 90) {
            s.append("XC");
            input -= 90;
        }
        while (input >= 50) {
            s.append("L");
            input -= 50;
        }
        while (input >= 40) {
            s.append("XL");
            input -= 40;
        }
        while (input >= 10) {
            s.append("X");
            input -= 10;
        }
        while (input >= 9) {
            s.append("IX");
            input -= 9;
        }
        while (input >= 5) {
            s.append("V");
            input -= 5;
        }
        while (input >= 4) {
            s.append("IV");
            input -= 4;
        }
        while (input >= 1) {
            s.append("I");
            input -= 1;
        }    
        return s.toString();
    }


    public static boolean formula(String str) {
        List<String> expressions = new ArrayList<>(Arrays.asList(str.split("=")));
        List<Double> results = new ArrayList<>();
        Double num1, num2;
        String operation;
       
        for ( int i = 0; i < expressions.size(); i++) {
            
            Scanner scan = new Scanner(expressions.get(i));
            num1 = Double.parseDouble(scan.next());
            if ( scan.hasNext() ) {
                operation = scan.next();
                num2 = Double.parseDouble(scan.next());
                if ( "+".equals(operation) ) {
                    num1 = num1+num2;
                } else if ( "-".equals(operation) ) {
                    num1 = num1-num2;
                } else if ( operation.equals("*") ) {
                    num1 = num1*num2;
                } else if ( "/".equals(operation) ) {
                    num1 = num1/num2;
                }
            }   
            results.add(num1);
        }

        for ( int i = 1; i < results.size(); i++) {
            if ( Double.compare(results.get(i-1), results.get(i)) != 0 ) {
                return false;
            }
        }
        return true;
    }

    public static String reverseString(String s){
        StringBuilder container = new StringBuilder();
        for(int i = s.length()-1;i>=0;i--){
            container.append(s.charAt(i));
        }
        return container.toString();
    }

    //method for checking string for palindrome
    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }

    public static boolean palindromedescendant(String str) {
        StringBuilder newstr = new StringBuilder();
        for ( int i = 0; i < str.length()/2; i+=2 ) {
            
            newstr.append(String.valueOf((int)str.charAt(i) + (int)str.charAt(i+1) - '0' - '0'));
        }

        if ( isPalindrome(str) ) {
            return true;
        } else if (  newstr.length() >= 2 && palindromedescendant(newstr.toString()) ) {
            return true;
        } else {
            return false;
        }
    }
    
}
