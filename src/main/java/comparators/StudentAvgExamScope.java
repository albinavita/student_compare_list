package comparators;

import model.IStudentComparator;
import model.Student;

public class StudentAvgExamScope implements IStudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o2.getAvgExamScore(), o1.getAvgExamScore());
    }
}
