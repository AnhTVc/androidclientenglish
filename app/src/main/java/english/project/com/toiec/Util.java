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

    static boolean checkSum(ArrayList<Integer> arr, int index, int sum){
        int temp = sum - arr.get(index);
        if(temp < 0){
            return false;
        }else if(temp == 0)
            return true;
        else {
            boolean check = false;

            sum -= arr.get(index);
            arr.remove(index);
            for(int i =0; i< arr.size(); i++){
                check = checkSum(arr, i, sum);
                if(check){
                    return true;
                }
            }
            return check;
        }
    }

   /* static boolean subsetSum(int[] arr) {
        *//**
         * Tinh tong / 2
         * Loai bo cac phan tu co gia tri nho
         * Bai toan tro thanh tim so co tong bang so cho truoc
         *//*
        int tempSum = 0;
        for(int i = 0; i< arr.length; i++)
            tempSum += arr[i];


        int temphafl = 0;
        if(tempSum % 2 == 0){
            temphafl = tempSum/2;

            ArrayList<Integer> input = new ArrayList<>();
            for(int i =0; i< arr.length; i++){
                if(arr[i] < temphafl)
                    input.add(arr[i]);
            }

            boolean check = false;
            for(int i =0; i< input.size(); i++){
                check = checkSum(input, i, temphafl);
                if(check){
                    return true;
                }
            }
            return check;

        }else
            return false;
    }*/

    static boolean isCryptSolution(String[] crypt, char[][] solution) {
        int row = solution.length;

        ArrayList<String> result = new ArrayList<>();

        for(int a=0; a< crypt.length; a++){
            StringBuffer stringBuffer = new StringBuffer();
            char[] arr = crypt[a].toCharArray();
            for(int b = 0; b< arr.length; b++){
                char temp = arr[b];
                for(int j =0; j < row; j++){
                    if(solution[j][0] == temp){
                        stringBuffer.append(solution[j][1]);
                    }
                }
            }

            result.add(stringBuffer.toString());
        }

        if(Integer.valueOf(result.get(0)) + Integer.valueOf(result.get(1)) == Integer.valueOf(result.get(2))){
            if(result.get(0).toCharArray()[0] == '0' || result.get(1).toCharArray()[0] == '0'){
                int a = result.get(2).length();

                if(result.get(2).toCharArray()[0] == '0') {
                    if (a == 1) {
                        return true;
                    }
                }

                return false;
            }else
                return true;
        }

        return false;

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

    static boolean isSubsetSum(int set[], int n, int sum)
    {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than sum, then ignore it
        if (set[n-1] > sum)
            return isSubsetSum(set, n-1, sum);

       /* else, check if sum can be obtained by any of the following
          (a) including the last element
          (b) excluding the last element   */
        return isSubsetSum(set, n-1, sum) ||
                isSubsetSum(set, n-1, sum-set[n-1]);
    }
    static boolean subsetSum(int[] arr) {
        int sum = 0;
        for(int i =0; i< arr.length; i++){
            sum += arr[i];
        }

        if(sum %2 == 0){
            return isSubsetSum(arr, arr.length, sum/2);
        }
        return false;
    }
    public static void main(String[] abc){
        //System.out.print(checkPalindrome("aabaa"));
        //System.out.print(ratingThreshold(3.5, [[3,4],[3,3,3,4],[4]]));

        int []a = {87, 56, 43, 91, 27, 65, 59, 36, 32, 51, 37, 28, 75, 7, 74};
        int []b =  {3, 5, 16, 8};

        String[] crypt = {"AA", "AA", "AA"};
        char[][] solution = {{'A', '0'},
        {'T', '0'},
        {'W', '9'},
        {'E', '5'},
        {'N', '4'}};
        System.out.print(subsetSum(b));
    }
}
