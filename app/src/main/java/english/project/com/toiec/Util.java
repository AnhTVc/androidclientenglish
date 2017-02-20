package english.project.com.toiec;

import java.util.ArrayList;

/**
 * Created by AnhTVc on 2/13/17.
 */

public class Util {
    static boolean checkPalindrome(String inputString) {
        int length = inputString.length();
        if((length % 2) == 0){
            return false;
        }else{
            String befor = inputString.substring(0, length/2);
            String last = inputString.substring(length/2 + 1, length);

            if(befor.equals(last)){
                return true;
            }else{
                return false;
            }
        }
    }

    static int[] ratingThreshold(double threshold, int[][] ratings) {
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;

        for(int i =0; i< ratings.length; i++){
            int[] temp = ratings[i];
            int sum = 0;
            for(int j =0; j< temp.length; j++){
                sum += temp[j];
            }

            if((sum / temp.length)== threshold){
                result.add(i);
            }
        }

        int[] a = new int[result.size()];
        for(int i =0; i< result.size(); i++){
            a[i] = result.get(i);
        }
        return a;
    }
    public static void main(String[] abc){
        System.out.print(checkPalindrome("aabaa"));
        //System.out.print(ratingThreshold(3.5, [[3,4],[3,3,3,4],[4]]));
    }
}
