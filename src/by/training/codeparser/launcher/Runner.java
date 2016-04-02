package by.training.codeparser.launcher;

import by.training.codeparser.task.TaskSolver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static Logger log = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        log.info("Start main function.");

        TaskSolver.solve();

        log.info("Finish main function.");
    }
}
