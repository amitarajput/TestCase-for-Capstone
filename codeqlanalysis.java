import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        int bribes = 0;
    for(int i=0;i<q.size();i++){
        if(q.get(i) > i + 3) {
            System.out.println("Too chaotic"); 
            return; 
        }
    }

    for (int i = q.size() - 4; i >= 0; i--) {
        for (int j = i; j <= i + 2; j++) {
            if (q.get(j) > q.get(j+1)) {
                int temp = q.get(j);
                q.set(j, q.get(j+1));
                q.set(j+1, temp); 
                bribes++;
            }

        }
    }
        System.out.println(bribes);
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] qTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> q = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qTemp[i]);
                q.add(qItem);
            }

            Result.minimumBribes(q);
        }

        bufferedReader.close();
    }
}
