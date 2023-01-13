package Model;

import java.util.*;

public class FileReaderCSV {

    public Map<Integer, String> readQuestions(String filename) {
        Map<Integer, String> questions = new HashMap<>();
        try (Scanner fileInput = new Scanner(
                FileReaderCSV.class.getResourceAsStream("/KnowledgeBase/" + filename + ".csv"))) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] parts = line.split(",");
                questions.put(Integer.parseInt(parts[0]), parts[1]);
            }
        }
        return questions;
    }

    public Map<String, Map<Integer, Integer>> readMedicineCollection(String filename) {
        Map<String, Map<Integer, Integer>> medicines = new HashMap<>();
        try (Scanner fileInput = new Scanner(
                FileReaderCSV.class.getResourceAsStream("/KnowledgeBase/" + filename + ".csv"))) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] parts = line.split(",");
                
            }
        }
    }
    /*public static void main(String[] args) {
        System.out.println(readQuestions("Questions"));
    }*/
}
