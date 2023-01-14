package Model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question {
    private int qNumber;
    private String text;
    private Set<String> yes = new HashSet<>();
    private Set<String> no = new HashSet<>();
    private String[] options;

    public Question(int index) {
        this.qNumber = index;
        this.text = FileReaderCSV.getQuestionsCSV().get(index);
        this.options = FileReaderCSV.getOptionsCSV().get(index);
        Map<String, Integer> values = FileReaderCSV.getColumnCSV(index);
        System.out.println(values);
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

    public String getQuestion()
    {
        return text;
    }
    public int getIndex() {
        return qNumber;
    }
    public Set<String> getYes()
    {
        return yes;
    }
    public Set<String> getNo()
    {
        return no;
    }
    public String[] getOptions() { return options; }

    public void print() {
        System.out.println(qNumber + text);
    }

    public static void main(String[] args) {
        new Question(5);
    }
}