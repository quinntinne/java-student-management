import java.util.List;

public interface CourseAllocationDAO {

    void addAllocation(CourseAllocation allocation);

    List<CourseAllocation> getAllAllocations();

    CourseAllocation getAllocationById(String id);

    void updateAllocation(CourseAllocation allocation);

    void deleteAllocation(String id);
}