import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {

        int currentSum = arr.get(0);
        int maxSubarraySum = arr.get(0);

        int maxNonContiguousSum = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {

            int value = arr.get(i);

            // Maximum contiguous subarray
            currentSum = Math.max(value, currentSum + value);
            maxSubarraySum = Math.max(maxSubarraySum, currentSum);

            // Maximum non-contiguous subarray
            if (value > 0) {
                maxNonContiguousSum += value;
            }
        }

        // If all elements are negative
        if (maxNonContiguousSum <= 0) {
            maxNonContiguousSum = Collections.max(arr);
        }

        List<Integer> result = new ArrayList<>();

        result.add(maxSubarraySum);
        result.add(maxNonContiguousSum);

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
            new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(
                        bufferedReader.readLine()
                            .replaceAll("\\s+$", "")
                            .split(" ")
                    )
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}