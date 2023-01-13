package Model;

import java.util.*;

public class FileReaderCSV {

    public static Map<Integer, String> readQuestions() {
        Map<Integer, String> questions = new HashMap<>();
        try (Scanner fileInput = new Scanner(
                FileReaderCSV.class.getResourceAsStream("/KnowledgeBase/Questions.csv"))) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] parts = line.split(",");
                questions.put(Integer.parseInt(parts[0]), parts[1]);
            }
        }
        return questions;
    }

    public static Map<String, Map<Integer, Integer>> readMedicineCollection() {
        Map<String, Map<Integer, Integer>> medicines = new HashMap<>();
        try (Scanner fileInput = new Scanner(
                FileReaderCSV.class.getResourceAsStream("/KnowledgeBase/Medicine.csv"))) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] parts = line.split(",");
                Map<Integer, Integer> answers = new HashMap<>();
                for (int i = 1; i < parts.length; i++) {
                    answers.put(i, Integer.parseInt(parts[i]));
                }
                medicines.put(parts[0], answers);
            }
        }
        return medicines;
    }

    public static Map<Integer, String[]> readOptions() {
        Map<Integer, String[]> options = new HashMap<>();
        try (Scanner fileInput = new Scanner(
                FileReaderCSV.class.getResourceAsStream("/KnowledgeBase/Options.csv"))) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] parts = line.split(",");
                String[] words = new String[2];
                for (int i = 1; i < parts.length; i++) {
                    words[i-1] = parts[i];
                }
                options.put(Integer.parseInt(parts[0]), words);
            }
        }
        return options;
    }

    public static Map<String, Integer> getColumn(int index) {
        Map<String, Map<Integer, Integer>> map = readMedicineCollection();
        Map<String, Integer> medicine = new HashMap<>();
        for(String key : map.keySet()) {
            medicine.put(key, map.get(key).get(index));
        }
        return medicine;
    }
}
