import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {
    private static int invalidLinesSkipped = 0;

    public static void main(String[] args) {
        // Step 1: read scores from file
        String inputFile = args.length > 0 ? args[0] : "scores.txt";
        String outputFile = args.length > 1 ? args[1] : "report.txt";

        // Step 4 test: calculate an average from a small hardcoded list.
        ArrayList<Integer> testScores = new ArrayList<>();
        testScores.add(80);
        testScores.add(90);
        testScores.add(100);
        System.out.println("Average test: " + calculateAverage(testScores));

        ArrayList<Integer> scores = readScores(inputFile);

        if (scores.isEmpty()) {
            System.out.println("No valid scores were found.");
            writeReport(scores, 0.0, 0, 0, outputFile);
            return;
        }

        // Step 2: calculate statistics
        double avg = calculateAverage(scores);
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int score : scores) {
            if (score > highest) highest = score;
            if (score < lowest) lowest = score;

            if (score >= 90) countA++;
            else if (score >= 80) countB++;
            else if (score >= 70) countC++;
            else if (score >= 60) countD++;
            else countF++;
        }

        // Step 3: write and print report
        writeReport(scores, avg, highest, lowest, outputFile);
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        invalidLinesSkipped = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmedLine = line.trim();
                if (trimmedLine.isEmpty()) continue;
                try {
                    scores.add(Integer.parseInt(trimmedLine));
                } catch (NumberFormatException e) {
                    invalidLinesSkipped++;
                    System.out.println("Warning: skipped invalid score: " + trimmedLine);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) return 0.0;
        double total = 0.0;
        for (int score : scores) total += score;
        return total / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores, double avg, int high,
                                   int low, String outputFile) {
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        for (int score : scores) {
            if (score >= 90) countA++;
            else if (score >= 80) countB++;
            else if (score >= 70) countC++;
            else if (score >= 60) countD++;
            else countF++;
        }

        String[] lines = {
            "=== Grade Analysis Report ===",
            String.format("Total scores processed: %d", scores.size()),
            String.format("Invalid lines skipped: %d", invalidLinesSkipped),
            String.format("Average score: %.2f", avg),
            String.format("Highest score: %d", high),
            String.format("Lowest score: %d", low),
            "Grade distribution:",
            String.format("  A (90-100): %d", countA),
            String.format("  B (80-89):  %d", countB),
            String.format("  C (70-79):  %d", countC),
            String.format("  D (60-69):  %d", countD),
            String.format("  F (below 60): %d", countF)
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error writing report: " + e.getMessage());
        }
    }
}
