import java.util.List;

public interface ExamResultsDAO {

    void addResult(ExamResults result);

    List<ExamResults> getAllResults();

    ExamResults getResultById(String id);   // ✅ important

    void updateResult(ExamResults result);

    void deleteResult(String id);
}