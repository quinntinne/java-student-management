public class ExamResultsManager {

    private ExamResultsDAO dao;

    public ExamResultsManager() {
        dao = new ExamResultsDBPersistence();  // ✅ will now work
    }

    public void addResult(ExamResults result) {
        dao.addResult(result);
    }

    public ExamResults getResultById(String id) {
        return dao.getResultById(id);
    }

    public void updateResult(ExamResults result) {
        dao.updateResult(result);
    }

    public void deleteResult(String id) {
        dao.deleteResult(id);
    }
}