import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class Template {
    public static void main(String[] args) {
        try {
            // Read input file
            List<String> reports = Files.readAllLines(Paths.get("input.txt"));
            System.out.println(reports);

            // Solve part 1
            int result1 = part1();
            System.out.println("Result for Part 1: " + result1);

            // --------------------------------------------------------------------------

            // Solve part 2
            int result2 = part2();
            System.out.println("Result for Part 2: " + result2);
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }
    }

    private static int part1() {
        return 0;
    }

    private static int part2() {
        return 0;
    }
}