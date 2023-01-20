package Model;

import java.util.*;

/**
 * Class that facilitates integration between
 * the .csv files in the resources folder and
 * the rest of the system.
 */
public class FileReaderCSV {

    private static final Map<Integer, String> questions = readQuestions();
    private static final Map<String, Map<Integer, Integer>> medicines = readMedicineCollection();
    private static final Map<Integer, String[]> options = readOptions();

    /**
     * Reads all the questions which can be asked from Questions.csv and puts it into a map.
     * @return questions
     */
    private static Map<Integer, String> readQuestions() {
        Map<Integer, String> questions = new HashMap<>();
        try (Scanner fileInput = new Scanner(
                FileReaderCSV.class.getResourceAsStream("/KnowledgeBase/Questions.csv"))) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] parts = line.split(",", 2);
                questions.put(Integer.parseInt(parts[0]), parts[1]);
            }
        }
        return questions;
    }

    /**
     * Reads all medicine from Medicine.csv and puts it into a map.
     * @return medicines
     */
    private static Map<String, Map<Integer, Integer>> readMedicineCollection() {
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

    /**
     * Reads the possible responses to the questions from Options.csv and puts it into a map.
     * @return options
     */
    private static Map<Integer, String[]> readOptions() {
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

    /**
     * Get a question's relations to the medicines.
     * @param index the index (id) of the question
     * @return a map <Medicine Name, Value>.
     */
    public static Map<String, Integer> getColumnCSV(int index) {
        Map<String, Map<Integer, Integer>> map = readMedicineCollection();
        Map<String, Integer> medicine = new HashMap<>();
        for(String key : medicines.keySet()) {
            medicine.put(key, map.get(key).get(index));
        }
        return medicine;
    }

    /**
     * Get the questions' id and text.
     * @return a map <QuestionID (index), Text>
     */
    public static Map<Integer, String> getQuestionsCSV() {
        return questions;
    }

    /**
     * Get the possible answers for all questions.
     * @return a map <QuestionID (index), [Option1, Option2]>
     */
    public static Map<Integer, String[]> getOptionsCSV() {
        return options;
    }

    /**
     * Get the medicines' specifications.
     * @return a map <MedicineID (name), <QuesitonID (index), Value>>
     */
    public static Map<String, Map<Integer, Integer>> getMedicinesCSV() {
        return medicines;
    }
}
