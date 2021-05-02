import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'candies' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static long candies(int n, List<Integer> arr) {
    // Write your code here
        int[] li=new int[n];
        int[] ri=new int[n];
        Arrays.fill(li,1);
        Arrays.fill(ri,1);
        for(int i=0,j=n-1;i<n-1;i++,j--){
            int ch1= arr.get(i);
            int ch2= arr.get(i+1);
            if(ch2>ch1)
                ri[i+1]=ri[i]+1; 
            int ch3= arr.get(j);
            int ch4= arr.get(j-1);
            if(ch4>ch3 && li[j-1]<=li[j])
                li[j-1]=li[j]+1; 
        }
        long sum=0;
        for(int i=0;i<n;i++)sum+=Math.max(li[i],ri[i]);
        return sum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
