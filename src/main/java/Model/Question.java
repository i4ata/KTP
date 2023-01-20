package Model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Question class. The objects holds the question itself in text and the subsets of medicine under each options.
 * It also holds the two possible options to choose from.
 */
public class Question {
    private final String text;
    private final Set<String> yes = new HashSet<>();
    private final Set<String> no = new HashSet<>();
    private final String[] options;

    /**
     * The constructor. It extracts the options and question text from the csv files and fills the subsets based on
     * Medicine.csv
     * @param index of the question in the .csv file.
     */
    public Question(int index) {
        this.text = FileReaderCSV.getQuestionsCSV().get(index);
        this.options = FileReaderCSV.getOptionsCSV().get(index);
        Map<String, Integer> values = FileReaderCSV.getColumnCSV(index);
        for(String name : values.keySet())
        {
            if (values.get(name) == 1)
            {
                yes.add(name);
            } else if (values.get(name) == -1)
            {
                no.add(name);
            }
        }
    }

    /**
     * @return The Question String
     */
    public String getQuestion()
    {
        return text;
    }

    /**
     * @return The subset of medicine under the first option
     */

    public Set<String> getYes()
    {
        return yes;
    }
    /**
     * @return The subset of medicine under the second option
     */

    public Set<String> getNo()
    {
        return no;
    }
    /**
     * @return The option Strings
     */

    public String[] getOptions() { return options; }
}