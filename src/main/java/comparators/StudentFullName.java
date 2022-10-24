package comparators;

import model.IStudentComparator;
import model.Student;
import org.apache.commons.lang3.StringUtils;

public class StudentFullName implements IStudentComparator {

    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getFullName(), o2.getFullName());
    }
}
