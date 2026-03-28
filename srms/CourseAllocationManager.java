public class CourseAllocationManager {

    private CourseAllocationDAO courseAllocationDAO;

    // Constructor
    public CourseAllocationManager() {
        // This MUST match your existing DAO implementation class name
        courseAllocationDAO = new CourseAllocationFilePersistence();
    }

    // Add allocation
    public void addAllocation(CourseAllocation allocation) {
        courseAllocationDAO.addAllocation(allocation);
    }

    // Get allocation by ID
    public CourseAllocation getAllocationById(String id) {
        return courseAllocationDAO.getAllocationById(id);
    }

    // Update allocation
    public void updateAllocation(CourseAllocation allocation) {
        courseAllocationDAO.updateAllocation(allocation);
    }

    // Delete allocation
    public void deleteAllocation(String id) {
        courseAllocationDAO.deleteAllocation(id);
    }
}