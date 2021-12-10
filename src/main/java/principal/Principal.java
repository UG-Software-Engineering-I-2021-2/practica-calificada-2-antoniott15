package principal;

import pair.Pair;
import teacher.Teacher;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Principal {
    private final int yearToCalculate;
    private List<String> studentWithPlusPoints = new ArrayList<>();
    static final Logger CUSTOM_LOGGER = Logger.getLogger(Principal.class.getName());


    private final Map<Integer, List<Pair<Teacher, Boolean>>> allYearsTeachers = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry<>(
                    2020,
                    List.of(
                            new Pair<>(new Teacher(1, "Josefina"), true),
                            new Pair<>(new Teacher(1, "Edonisio"), true),
                            new Pair<>(new Teacher(1, "Edufasio"), false)
                    )
            ),
            new AbstractMap.SimpleImmutableEntry<>(
                    2019,
                    List.of(
                            new Pair<>(new Teacher(1, "Eduarda"), false),
                            new Pair<>(new Teacher(1, "Abelardo"), false),
                            new Pair<>(new Teacher(1, "Francisca"), false)
                    )
            )
    );

    public void teachersAvailableToAddPoints() {
        for (Map.Entry<Integer, List<Pair<Teacher, Boolean>>> allTeachers : allYearsTeachers.entrySet()) {
                List<Pair<Teacher, Boolean>> teachers = allTeachers.getValue();
                for (Pair<Teacher, Boolean> eachTeacher : teachers) {
                    Teacher teacher =  eachTeacher.first();
                    CUSTOM_LOGGER.info(teacher.getTeacherName());
                }
        }
    }

    public void studentsWhoGetExtraPoints() {
        for(String student: this.studentWithPlusPoints){
            CUSTOM_LOGGER.info(student);
        }
    }

    public Principal(int yearToCalculate) {
        this.yearToCalculate = yearToCalculate;
    }

    public float calculateGrades(final List<Pair<Integer, Float>> examsStudents, final boolean hasReachedMinimumClasses,final String studentName) {
        if (examsStudents.isEmpty() || !hasReachedMinimumClasses) {
            return 0f;
        }

        float gradesSum = 0f;
        int gradesWeightSum = 0;

        for (Pair<Integer, Float> examGrade : examsStudents) {
            gradesSum += (examGrade.first() * examGrade.second() / 100);
            gradesWeightSum += examGrade.first();
        }


        if (gradesWeightSum == 100) {
            if (this.availableToAddPoints()) {
                this.studentWithPlusPoints.add(studentName);
                return Float.min(10f, gradesSum + 1);
            } else {
                return gradesSum;
            }
        }

        if (gradesWeightSum > 100) {
            return -1f;
        }

        return -2f;
    }

    private boolean availableToAddPoints() {
        for (Map.Entry<Integer, List<Pair<Teacher, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            if (this.yearToCalculate == yearlyTeachers.getKey()) {
                List<Pair<Teacher, Boolean>> teachers = yearlyTeachers.getValue();
                for (Pair<Teacher, Boolean> teacher : teachers) {
                    if (Boolean.FALSE.equals(teacher.second())) {
                        continue;
                    }
                    return true;
                }
            }
        }
        return false;
    }

}
