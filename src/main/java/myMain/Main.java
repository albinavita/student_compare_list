package myMain;

import enums.StudentField;
import enums.UniversityField;
import exception.StateException;
import model.IStudentComparator;
import model.IUniversityComparator;
import model.Student;
import model.University;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import readingData.FileReader;
import utils.UtilseCompare;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    private static final String FILE_NAME = "src/main/resources/universityInfo.xlsx";

    public static void main(String[] args) {

        try {
            List<Student> studenties = FileReader.readSheetStudent(FILE_NAME);
            IStudentComparator student = UtilseCompare.getStudentComparator(StudentField.NAME);
            studenties.stream()
                    .sorted(student)
                    .forEach(System.out::println);

            List<University> universities = FileReader.readSheetUniversity(FILE_NAME);
            IUniversityComparator university = UtilseCompare.getUniversityComparator(UniversityField.PROFILE);
            universities.stream()
                    .sorted(university)
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (StateException e) {
            e.message();
        }

    }

}
