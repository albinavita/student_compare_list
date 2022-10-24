package utils;

import comparators.*;
import enums.StudentField;
import enums.UniversityField;
import exception.StateException;
import model.IStudentComparator;
import model.IUniversityComparator;

public class UtilseCompare {

    private static final String UNIVER = "Университет";
    private static final String STUDENT = "Студент";

    private UtilseCompare() {
    }

    public static IStudentComparator getStudentComparator(StudentField student) throws StateException {
        switch (student) {
            case NAME:
              return new StudentFullName();
            case UNIVERSITY_ID:
                return new StudentUniverId();
            case NUMBER_COURSE:
                return new StudentCourseNumber();
            case AVG_EXAM_SCOPE:
                return new StudentAvgExamScope();
            default:
                throw  new StateException(STUDENT);

        }
    }

    public static IUniversityComparator getUniversityComparator(UniversityField university) throws StateException {
        switch (university) {
            case ID:
                return new UniversityId();
            case FULL_NAME:
                return new UniversityFullName();
            case SHORT_NAME:
                return new UniversityShortName();
            case YEAR_OF_FOUNDATION:
                return new UniversityYearOfFoundation();
            case PROFILE:
                return new UniversityMainProfile();
            default:
                throw  new StateException(UNIVER);
        }
    }

}
