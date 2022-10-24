package readingData;

import enums.StudyProfile;
import model.Student;
import model.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileReader {
    private static final String UNIVERS = "Университеты";
    private static final String STUDENTS = "Студенты";

    private FileReader(){
    }
    public static List<University> readSheetUniversity(String fileName) throws IOException {
        List<University> universities = new ArrayList<>();
        Workbook book = createBook(fileName);
        Sheet sheet = book.getSheet(UNIVERS);
        Iterator<Row> rows = sheet.iterator();
        rows.next();
        while (rows.hasNext()) {
            Row current = rows.next();
            University university = new University();
            university.setId(current.getCell(0).getStringCellValue());
            university.setFullName(current.getCell(1).getStringCellValue());
            university.setShortName(current.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int)current.getCell(3).getNumericCellValue());
            university.setMainProfile(StudyProfile.valueOf(current.getCell(4).getStringCellValue()));

            universities.add(university);
        }
        book.close();
        return universities;
    }

    public static List<Student> readSheetStudent(String fileName) throws IOException {
        List<Student> studenties = new ArrayList<>();
        Workbook book = createBook(fileName);
        Sheet sheet = book.getSheet(STUDENTS);
        Iterator<Row> rows = sheet.iterator();
        rows.next();
        while (rows.hasNext()) {
            Row current = rows.next();
            Student student = new Student();
            student.setFullName(current.getCell(0).getStringCellValue());
            student.setUniversityId(current.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int) current.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float) current.getCell(3).getNumericCellValue());

            studenties.add(student);
        }
        book.close();
        return studenties;
    }

    public static Workbook createBook(String fileName) {
        Workbook book = null;
        try (FileInputStream stream = new FileInputStream(fileName)) {
            book = new XSSFWorkbook(stream);

        } catch (IOException e){
            e.printStackTrace();
        }
        return book;
    }
}
