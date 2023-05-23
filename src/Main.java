import core.logging.DatabaseLogger;
import core.logging.FileLogger;
import core.logging.Logger;
import core.logging.MailLogger;
import dataAccess.HibernateProductDao;
import entities.*;

public class Main {
    public static void main(String[] args) {
        Logger[] loggers = {new DatabaseLogger(), new FileLogger(), new MailLogger()};

        CategoryProcess categoryProcess = new CategoryProcess();
        categoryProcess.setProductDao(new HibernateProductDao());
        categoryProcess.setLoggers(loggers);
        categoryProcess.processCategories();

        InstructorProcess instructorProcess;
        instructorProcess = new InstructorProcess();
        InstructorProcess.setProductDao(new HibernateProductDao());
        InstructorProcess.setLoggers(loggers);
        InstructorProcess.processInstructors();

        CourseProcess courseProcess = new CourseProcess();
        courseProcess.setProductDao(new HibernateProductDao());
        courseProcess.setLoggers(loggers);
        courseProcess.processCourses();
    }
}
