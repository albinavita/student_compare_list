package comparators;

import enums.StudyProfile;
import model.IUniversityComparator;
import model.University;
import org.apache.commons.lang3.StringUtils;

public class UniversityMainProfile implements IUniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getMainProfile().getTitle(), o2.getMainProfile().getTitle());
    }
}
