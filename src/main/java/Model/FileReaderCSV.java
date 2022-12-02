package Model;

import java.util.*;

public class FileReaderCSV {

    public static Map<String, String[]> readKB(String category) {
        Map<String, String[]> medicineSpecs = new HashMap<>();
        try (Scanner fileInput = new Scanner(
                FileReaderCSV.class.getResourceAsStream("/KnowledgeBase/" + category + "Medicine.csv"))) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] parts = line.split(",");
                medicineSpecs.put(parts[0], Arrays.copyOfRange(parts, 1, parts.length));
            }
        }
        return medicineSpecs;
    }
    public static void main(String[] args) {
        System.out.println(readKB("ThroatPain"));
    }
}
