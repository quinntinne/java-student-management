import java.util.ArrayList;

public class ResultsManager {

    private ArrayList<ExamResults> results = new ArrayList<>();

    public void addResult(ExamResults result) {
        results.add(result);
    }

    public ArrayList<ExamResults> getResults() {
        return results;
    }
}