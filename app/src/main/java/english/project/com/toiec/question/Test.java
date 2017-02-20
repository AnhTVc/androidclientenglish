package english.project.com.toiec.question;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by VietAnh on 2/19/2017.
 */

public class Test {
    static boolean ktSNT (int a)
    {
        int i = 0;
        for(i = 2; i <= (int)Math.sqrt(a); i++)
        {
            if( a % i == 0 || a < 2 && a != 2)
            {
                return false;
            }
        }
        return true;
    }

    static boolean isPowerOfTwo2(String n) {
        try {
            int a = Integer.parseInt(n);
            if(a<=0)
                return false;

            while(a>2){
                int t = a>>1;
                int c = t<<1;

                if(a-c != 0)
                    return false;

                a = a>>1;
            }

            return true;
        }catch (Exception e){
            BigInteger a = new BigInteger(n);
            if(a.modPow(new BigInteger("2"), a).intValue() == 0){
                return true;
            }else {
                return false;
            }

        }
    }

    static int primesSum2(int n) {
        if(n == 1){
            return 0;
        }else{
            double sum = 0;
            for(int i =2; i<= n ;i++){
                if(ktSNT(i))
                    sum += i;
            }
            return (int) sum;
        }


    }

    static int missingNumber(int[] arr) {
        int n = arr.length + 1;
        for(int i =0; i< n; i++){
            for(int j =0; j< arr.length; j++){
                if(arr[j] == i){
                    break;
                }

                if(j == arr.length -1){
                    if(arr[j] != i){
                        return i;
                    }
                }
            }
        }
        return 0;
    }


    static String stringReformatting(String s, int k) {
        s = s.replace("-","");
        char[] charArray = s.toCharArray();
        ArrayList<Character> result = new ArrayList<>();
        int index = 0;
        for(int i = charArray.length - 1; i >= 0; i--){
            index ++;
            result.add(charArray[i]);
            if(index % k == 0 && i != 0){
                result.add("-".charAt(0));
            }
        }
        StringBuilder builder = new StringBuilder(result.size());
        for(Character ch: result)
        {
            builder.append(ch);
        }
        String temp = builder.toString();
        return new StringBuffer(temp).reverse().toString();
    }

    static String reverseParentheses(String s) {
        String result = s;
        try {
            int lastIndex = 0;
            int count = 0;

            while(lastIndex != -1){

                lastIndex = s.indexOf("(",lastIndex);

                if(lastIndex != -1){
                    count ++;
                    lastIndex += "(".length();
                }
            }
            String a = "(";
            String b = ")";
            boolean check = true;

            for(int i =0; i< count; i++){
                if(check){
                    StringBuilder stringBuilder = new StringBuilder();
                    String sub = result.substring(result.indexOf("(") + 1, result.lastIndexOf(")"));
                    stringBuilder.append(result.substring(0,result.indexOf("(")));
                    stringBuilder.append(new StringBuilder(sub).reverse().toString());
                    stringBuilder.append(result.substring(result.lastIndexOf(")") + 1,result.length()));
                    result = stringBuilder.toString();
                    check = false;
                }else {
                    String sub = result.substring(result.indexOf(")") + 1, result.lastIndexOf("("));
                    StringBuilder stringBuilder1 = new StringBuilder();
                    stringBuilder1.append(result.substring(0,result.indexOf(")")));
                    stringBuilder1.append(new StringBuilder(sub).reverse().toString());
                    stringBuilder1.append(result.substring(result.lastIndexOf("(") + 1,result.length()));
                    result = stringBuilder1.toString();
                    check = true;
                }
            }
        }catch (Exception e){

        }


        return result;
    }

    static String reverseVowelsOfString(String s) {
        ArrayList<Character> strings = new ArrayList<>();
        char[] input = s.toCharArray();
        for(int i =0; i< input.length; i++){

            if(input[i] == "a".charAt(0) || input[i] == "e".charAt(0) || input[i] == "i".charAt(0)
                    || input[i] == "o".charAt(0)||input[i] == "u".charAt(0)||
                    input[i] == "A".charAt(0) || input[i] == "E".charAt(0) || input[i] == "I".charAt(0)
                    || input[i] == "O".charAt(0)||input[i] == "U".charAt(0)){
                strings.add(input[i]);
            }
        }
        int index = strings.size() -1;
        for(int i =0; i< input.length; i++){

            if(input[i] == "a".charAt(0) || input[i] == "e".charAt(0) || input[i] == "i".charAt(0)
                    || input[i] == "o".charAt(0)||input[i] == "u".charAt(0)||
                    input[i] == "A".charAt(0) || input[i] == "E".charAt(0) || input[i] == "I".charAt(0)
                    || input[i] == "O".charAt(0)||input[i] == "U".charAt(0)){
                input[i] = strings.get(index);
                index --;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(char a: input){
            stringBuilder.append(String.valueOf(a));
        }
        return stringBuilder.toString();
    }


    public static void main(String[] abc){
        System.out.print(isPowerOfTwo2("17179869184"));

    }
}
