    import java.io.*;
    import java.math.*;
    import java.security.*;
    import java.text.*;
    import java.util.*;
    import java.util.concurrent.*;
    import java.util.regex.*;
  
    class Result {
        /*
         * Complete the 'diagonalDifference' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts 2D_INTEGER_ARRAY arr as parameter.
         */
        public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
            int d1 = 0 ;
            int d2 = 0 ;
            int n = arr.get(0).size() ; // size of the Matrix

            for (int i = 0 ; i<n ; i++ ) {
                for (int j=0 ; j<n ; j++) {
                    if(i==j)// diagonal 1
                    {
                        d1 = d1 + arr.get(i).get(j) ;
                    }
                    if( (i+j) == n-1 ) // diagonal 2
                    {
                        d2 = d2 + arr.get(i).get(j) ;
                    }
                }
            }
            // Finding the Absolute difference.
            if(d1 >= d2 ) return (d1-d2) ;
            else return (d2-d1) ;
        }
    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> arrRowItems = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    int arrItem = Integer.parseInt(arrRowTempItems[j]);
                    arrRowItems.add(arrItem);
                }

                arr.add(arrRowItems);
            }

            int result = Result.diagonalDifference(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
