import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CourseAllocationFilePersistence implements CourseAllocationDAO {

    private static final String FILE_NAME = "course_allocations.txt";

    @Override
    public void addAllocation(CourseAllocation allocation) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write(
                allocation.getId() + "," +
                allocation.getCourseId() + "," +
                allocation.getLecturerId() + "," +
                allocation.getSemester() + "," +
                allocation.getYear()
            );

            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CourseAllocation> getAllAllocations() {

        List<CourseAllocation> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length == 5) {
                    CourseAllocation allocation = new CourseAllocation(
                        parts[0],
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4])
                    );

                    list.add(allocation);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public CourseAllocation getAllocationById(String id) {
        for (CourseAllocation a : getAllAllocations()) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public void updateAllocation(CourseAllocation allocation) {

        List<CourseAllocation> list = getAllAllocations();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (CourseAllocation a : list) {

                if (a.getId().equals(allocation.getId())) {
                    a = allocation;
                }

                writer.write(
                    a.getId() + "," +
                    a.getCourseId() + "," +
                    a.getLecturerId() + "," +
                    a.getSemester() + "," +
                    a.getYear()
                );

                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllocation(String id) {

        List<CourseAllocation> list = getAllAllocations();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (CourseAllocation a : list) {

                if (!a.getId().equals(id)) {

                    writer.write(
                        a.getId() + "," +
                        a.getCourseId() + "," +
                        a.getLecturerId() + "," +
                        a.getSemester() + "," +
                        a.getYear()
                    );

                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}