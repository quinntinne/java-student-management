import java.util.ArrayList;

public interface ExamResultsPersistence {

    void addExamResult(ExamResults er);

    ArrayList<ExamResults> getAllExamResults();

    void updateExamResult(ExamResults er);

    void deleteExamResult(String id);
}