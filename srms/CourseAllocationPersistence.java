import java.util.ArrayList;

public interface CourseAllocationPersistence {

    void addCourseAllocation(CourseAllocation ca);

    ArrayList<CourseAllocation> getAllCourseAllocations();

    void updateCourseAllocation(CourseAllocation ca);

    void deleteCourseAllocation(String id);
}