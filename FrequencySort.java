//input: 1,1,1,5,2,2,2,2,6,6,6,6,6,6,7,7,7,7,7,7,7
//output:7,7,7,7,7,7,7,6,6,6,6,6,6,2,2,2,2,1,1,1,5
import java.util.*;

public class FrequencySort {
    public static int[] sortByFrequency(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
      
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> sortedList = new ArrayList<>();
        for (int num : arr) {
            sortedList.add(num);
        }

        // Custom sorting: first by frequency (desc), then by value (desc)
        sortedList.sort((a, b) -> {
            int freqCompare = freqMap.get(b) - freqMap.get(a); // Sort by frequency (desc)
            return freqCompare != 0 ? freqCompare : Integer.compare(b, a); // Sort by value (desc) if same frequency
        });

        // Convert list back to array
        int[] result = new int[arr.length];
        for (int i = 0; i < sortedList.size(); i++) {
            result[i] = sortedList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 5, 2, 2, 2, 2, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7};
        int[] sortedArr = sortByFrequency(arr);
        System.out.println(Arrays.toString(sortedArr)); // Correctly print the sorted array
    }
}