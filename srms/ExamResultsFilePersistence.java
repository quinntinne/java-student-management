import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExamResultsFilePersistence implements ExamResultsDAO {

    private final String fileName = "exam_results.txt";

    // =========================
    // ADD
    // =========================
    @Override
    public void addResult(ExamResults result) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(result.getId() + "," +
                    result.getStudentId() + "," +
                    result.getCourseId() + "," +
                    result.getMarks());

            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // GET ALL
    // =========================
    @Override
    public List<ExamResults> getAllResults() {

        List<ExamResults> results = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length == 4) {

                    ExamResults result = new ExamResults(
                            parts[0],
                            parts[1],
                            parts[2],
                            Integer.parseInt(parts[3])
                    );

                    results.add(result);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }

    // =========================
    // GET BY ID (FIXED)
    // =========================
    @Override
    public ExamResults getResultById(String id) {

        List<ExamResults> results = getAllResults();

        for (ExamResults r : results) {
            if (r.getId().equals(id)) {
                return r;
            }
        }

        return null;
    }

    // =========================
    // UPDATE
    // =========================
    @Override
    public void updateResult(ExamResults updatedResult) {

        List<ExamResults> results = getAllResults();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (ExamResults r : results) {

                if (r.getId().equals(updatedResult.getId())) {
                    r = updatedResult;
                }

                writer.write(r.getId() + "," +
                        r.getStudentId() + "," +
                        r.getCourseId() + "," +
                        r.getMarks());

                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE
    // =========================
    @Override
    public void deleteResult(String id) {

        List<ExamResults> results = getAllResults();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (ExamResults r : results) {

                if (!r.getId().equals(id)) {

                    writer.write(r.getId() + "," +
                            r.getStudentId() + "," +
                            r.getCourseId() + "," +
                            r.getMarks());

                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}