package comparators;

import model.IStudentComparator;
import model.Student;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class StudentUniverId implements IStudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getUniversityId(), o2.getUniversityId());
    }
}
