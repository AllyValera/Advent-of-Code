import java.nio.file.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Day1 {
    public static void main(String[] args) {
        try {
            // Read input file
            List<String> lines1 = Files.readAllLines(Paths.get("2024/Day 1/input1.txt"));

            // Processing into 2 arrays for the 2 cols.
            int[] leftColumn = new int[lines1.size()];
            int[] rightColumn = new int[lines1.size()];

            for (int i = 0; i < lines1.size(); i++) {
                String[] parts = lines1.get(i).split("\\s+"); // Whitespace regex
                leftColumn[i] = Integer.parseInt(parts[0]);  
                rightColumn[i] = Integer.parseInt(parts[1]);
            }
            
            // Solve part 1
            int result1 = part1(leftColumn, rightColumn);
            System.out.println("Result for Part 1: " + result1);

            // --------------------------------------------------------------------------

            // Read input file - not needed; can use same input list and arrays

            // Solve part 2
            int result2 = part2(leftColumn, rightColumn); 
            System.out.println("Result: " + result2);
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }
    }

    private static int part1(int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);

        int sol = 0;

        for (int i = 0; i < left.length; i++) {
            sol += Math.abs(left[i] - right[i]);
        }

        return sol;
    }

    private static int part2(int[] left, int[] right) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : left) {
            map.put(i, 0);
        }

        for (int i : right) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
        }

        int sol = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sol += entry.getKey() * entry.getValue();
        }

        return sol;
    }
}