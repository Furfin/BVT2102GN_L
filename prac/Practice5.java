
import java.util.Arrays;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*; 

public class Practice5 {
    public static void main(String args[]) {
        int[] data = {83, 34, -7, 5, -11, 1, 5, -9};
        System.out.println(Arrays.toString(encrypt("Hello")));
        System.out.println(decrypt(data));
        System.out.println(canMove("rook", "A8", "H8"));
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(sumDigProd(16, 28));
        System.out.println(Arrays.toString(sameVowelGroup(new String[]{"toe", "ocelot", "maniac"})));
        System.out.println(validateCard("1234567890123452"));

        
        numToEng(116);
        numToEng(949);
        numToRus(116);
        numToRus(949);

        System.out.println(getSha256Hash("password123"));

        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));

        hexLattice(19);
        hexLattice(37);
    }
    
    public static int[] encrypt(String str) {
        int[] answ = new int[str.length()];
        answ[0] = (int) str.charAt(0);
        for( int i = 1; i < str.length(); i++ ) {
            answ[i] = (int) str.charAt(i) - (int) str.charAt(i-1) ;
        }
        return answ;
    }
    
    public static String decrypt(int[] arr) {
        StringBuilder answ = new StringBuilder(arr[0]);
        int prev = arr[0];
        for( int i = 1; i < arr.length; i++ ) {
            prev = arr[i] + prev;
            answ = answ.append((char)prev);
        }
        return answ.toString();
    }

    public static boolean canMove(String f, String start, String finish) {

        int x1 = (int) start.charAt(0) - (int) 'A';
        int x2 = (int) finish.charAt(0) - (int) 'A';
        int y1 = Character.valueOf(start.charAt(1)) - (int)'0';
        int y2 = Character.valueOf(finish.charAt(1)) - (int)'0';

        if ( f == "pawn" ) {
            return Math.abs(y1-y2) <= 2 && (Math.abs(y1-y2) > 0);
        } else if ( f == "knight" ) {
            return (Math.abs(y1-y2) <= 2 && Math.abs(y1-y2) > 0) && (Math.abs(x1-x2) <= 2 && Math.abs(x1-x2) > 0);
        } else if ( f == "rook" ) {
            return (Math.abs(y1-y2) == 0 && Math.abs(x1-x2) != 0) || (Math.abs(y1-y2) != 0 && Math.abs(x1-x2) == 0);
        } else if ( f == "bishop" ) {
            return (Math.abs(y1-y2) == Math.abs(x1-x2)) && (Math.abs(x1-x2) > 0);
        } else if ( f == "queen" ) {
            return ((Math.abs(y1-y2) == 0 && Math.abs(x1-x2) != 0) || (Math.abs(y1-y2) != 0 && Math.abs(x1-x2) == 0)) ||
            (Math.abs(y1-y2) == Math.abs(x1-x2)) && (Math.abs(x1-x2) > 0);
        } else if ( f == "king" ) {
            return (Math.abs(y1-y2) == 1) || (Math.abs(x1-x2) == 1);
        } else {
            return false;
        
        }
    }

    public static boolean canComplete(String str1, String str2) {
        for ( int i = 0; i < str2.length(); i++ ) {
            if ( str2.charAt(i) == str1.charAt(0) ) {
                str1 = str1.substring(1);
            }
        }
        return str1.isEmpty();
    }

    public static int bugger(int num) {
        StringBuilder str = new StringBuilder(String.valueOf(num));
        Scanner scan = new Scanner(str.toString()).useDelimiter("");
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
                str = new StringBuilder(String.valueOf(num));
                scan = new Scanner(str.toString()).useDelimiter("");
            }
        }
        return curr_num;
    }

    public static int sumDigProd(int... num) {
        int answ = 0;

        for (int i : num)
            answ+=i;

        return bugger(answ);
    }

    public static boolean doesRhyme(String word1, String word2) {
        HashSet<String> vowels2 = new HashSet<String>();
        HashSet<String> vowels1 = new HashSet<String>();

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

    static public String[] sameVowelGroup(String[] strings) {
        List<String> answ = new ArrayList<String>();
        
        for ( int i = 0; i < strings.length; i++ ) {
            if ( doesRhyme(strings[0], strings[i]) ) {
                answ.add(strings[i]);
            }
        }

        return answ.toArray(new String[answ.size()]);
    }

    public static boolean validateCard(String card) {
        int sum = 0;
        int buff = 0;
        card = new StringBuilder(card).reverse().toString();  
        for (int i = 1; i < card.length(); ++i) {
            buff = card.charAt(i) - '0';
            if (i % 2 == 1) {
                sum += buff;
            } else {
                buff *= 2;
                if (buff >= 10) {
                    sum += buff/ 10 + buff % 10;
                } else {
                    sum += buff;
                }
            }
        }
        
        
        return (10 - sum%10 == card.charAt(0) - '0') && card.length() >= 13 && card.length() <= 17;
    }

    static void numToEng(int number)  {  
        char[] num = String.valueOf(number).toCharArray();
        int len = num.length;  


        String[] onedigit = new String[] {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};  
        String[] twodigits = new String[] {"", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};  
        String[] multipleoftens = new String[] {"",  "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};  
        if (len == 1) {  
            System.out.println(onedigit[num[0]-'0']);  
            return;  
        }  
        int x = 0;
        if (len == 3)   {  
            if (num[x] - '0' != 0) {  
                System.out.print(onedigit[num[x] - '0'] + " ");  
                System.out.print("Hundred"+ " ");  
            }  
            --len;  
            x++; 
        }            
        if (num[x] - '0' == 1) {  
            int sum = num[x] - '0' + num[x + 1] - '0';  
            System.out.println(twodigits[sum]);  
            return;  
        } else   {  
            int i = (num[x] - '0');  
            if (i > 0)  
                System.out.print(multipleoftens[i]+ " ");  
            else   
                System.out.print("");  
            x++;  
            if (num[x] - '0' != 0)  
                System.out.println(onedigit[num[x] - '0']);  
        }  
    } 

    static void numToRus(int number)  {  
        char[] num = String.valueOf(number).toCharArray();
        int len = num.length;  


        String[] onedigit = new String[] {"Ноль", "Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь", "Девять"};
        String[] onedigith = new String[] {"", "Сто", "Двести", "Триста", "Четыреста", "Пятьсот", "Шестьсот", "Семьсот", "Восемьсот", "Девятьсот"};  
        String[] twodigits = new String[] {"", "Десять", "Одиннадцать", "Двенадцать", "Тринадцать", "Четырнадцать", "Пятнадцать"
        , "Шестнадцать", "Семнадцать", "Восемнадцать", "Девятнадцать"};  
        String[] multipleoftens = new String[] {"",  "", "Двадцать", "Тридцать", "Сорок", "Пятдесят", "Шестьдесят", "Семдесят", "Восемьдесят", "Девяносто"};  
        if (len == 1) {  
            System.out.println(onedigit[num[0]-'0']);  
            return;  
        }  
        int x = 0;
        if (len == 3)   {  
            if (num[x] - '0' != 0) {  
                System.out.print(onedigith[num[x] - '0'] + " ");  
            }  
            --len;  
            x++; 
        }            
        if (num[x] - '0' == 1) {  
            int sum = num[x] - '0' + num[x + 1] - '0';  
            System.out.println(twodigits[sum]);  
            return;  
        } else   {  
            int i = (num[x] - '0');  
            if (i > 0)  
                System.out.print(multipleoftens[i]+ " ");  
            else   
                System.out.print("");  
            x++;  
            if (num[x] - '0' != 0)  
                System.out.println(onedigit[num[x] - '0']);  
        }  
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static String getSha256Hash(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hash);
        } catch(NoSuchAlgorithmException e) {
            return "0x";
        }
    }

    public static String correctTitle(String str) {
        Scanner scan = new Scanner(str);
        String word;
        StringBuilder answ = new StringBuilder();
        List<String> exceptions = List.of("and", "the", "of", "in");
        scan.useDelimiter(" ");
        while( scan.hasNext() ) {
            word = scan.next();
            if ( exceptions.contains(word.toLowerCase()) ) {
                answ.append(word.toLowerCase());
                answ.append(" ");
            } else {
                answ.append(word.substring(0, 1).toUpperCase());

                answ.append(word.substring(1).toLowerCase());
                answ.append(" ");
            }
        }
        return answ.toString();
    }

    public static void hexLattice(int num) {
        int side = 1;
        int numb = 1;
        int buff = 0;
        String line;
        if (num%6 != 1) {
            System.out.println("Unacceptable");
            return;
        } else if ( side == num ) {
            System.out.println("o");
            return;
        } else {
            while( numb != num) {
                numb+=6*side;
                side++;
            }
        }
        
        int min_side = side;
        while(true) {
            buff += side;
            
            if ( num - (buff*2 + side + 1) == 0 ) {
                break;
            }
            side++;
        }
        int i = 0;
        String format;
        while ( min_side+i != side+1 ) {
            line = new String(new char[min_side+i]).replace("\0", "o ");
            format = "%" + String.valueOf( side - min_side - i + 1 + line.length()) + "s\n"; 
            System.out.printf(format,line);
            i++;
        }
        line = new String(new char[side+1]).replace("\0", "o ");
        format = "%" + String.valueOf( line.length()) + "s\n"; 
        System.out.printf(format,line);
        side++;
        i = 1;
        while ( min_side - 1 != side - i ) {
            line = new String(new char[side-i]).replace("\0", "o ");
            format = "%" + String.valueOf( i + line.length()) + "s\n"; 
            System.out.printf(format,line);
            i++;
        }



    }

}
