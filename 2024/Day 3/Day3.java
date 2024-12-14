import java.nio.file.*;
import java.io.IOException;
import java.util.List;
import java.util.regex.*;;

public class Day3 {
    public static void main(String[] args) {
        try {
            // Read input file
            List<String> reports = Files.readAllLines(Paths.get("2024/Day 3/input.txt"));

            // Solve part 1
            int result1 = part1(reports);
            System.out.println("Result for Part 1: " + result1);

            // --------------------------------------------------------------------------

            // Solve part 2
            int result2 = part2();
            System.out.println("Result for Part 2: " + result2);
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }
    }

    // https://stackoverflow.com/questions/600733/using-java-to-find-substring-of-a-bigger-string-using-regular-expression
    // https://regex-generator.olafneumann.org/
    private static int part1(List<String> reports) {
        int sum = 0;

        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");

        for (String report : reports) {
            Matcher matcher = pattern.matcher(report);

            while (matcher.find()) {
                sum += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
            }
        }

        return sum;
    }

    private static int part2() {
        return 0;
    }
}