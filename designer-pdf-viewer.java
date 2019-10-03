/*
*
*This question can be found here: https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
*
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        HashMap<Character,Integer> myHash = new HashMap();

        //hash values of alphabets
        for(int i =0; i< h.length ; i++){
            myHash.put(alphabet[i],h[i]);
        }
        //find the tallest letter
        int maxVal = 0; //value of tallest letter
        for(int i = 0; i < word.length(); i++){
            if(myHash.get(word.charAt(i))>maxVal){
                maxVal = myHash.get(word.charAt(i));
            }
        }

        //return area = maxval * string.length()
        return maxVal*word.length();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
