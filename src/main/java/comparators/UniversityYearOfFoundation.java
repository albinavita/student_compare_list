package comparators;

import model.IUniversityComparator;
import model.University;

public class UniversityYearOfFoundation implements IUniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
