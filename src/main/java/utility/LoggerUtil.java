package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public  class LoggerUtil {
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    static private FileHandler fileHTML;
    static private Formatter formatterHTML;

    public static void setLogger() throws IOException {

        // get the global logger to configure it
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        // suppress the logging output to the console
        Logger rootLogger = Logger.getLogger  ("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }

        //FileInputStream fis= new FileInputStream("./LogsInText.txt");
        logger.setLevel(Level.INFO);
        fileTxt = new FileHandler("./Logs/LogsInText.txt");
        fileHTML = new FileHandler("./Logs/LogsInHtml.html");

        // create a TXT formatter
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);

        // create an HTML formatter
        formatterHTML = new HtmlFormatter();
        fileHTML.setFormatter(formatterHTML);
        logger.addHandler(fileHTML);

    }

    public void doSomeThingAndLog() {
        // ... more code
        Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        // now we demo the logging

        // set the LogLevel to Severe, only severe Messages will be written
        LOGGER.setLevel(Level.SEVERE);
        LOGGER.severe("Info Log 1111");
        LOGGER.warning("Info Log 1111");
        LOGGER.info("Info Log 112221");
        LOGGER.finest("Really not important 223");

        // set the LogLevel to Info, severe, warning and info will be written
        // finest is still not written
        LOGGER.setLevel(Level.INFO);
        LOGGER.severe("Severe damaged");
        LOGGER.warning("Warning log");
        LOGGER.info("Info Log");
        LOGGER.finest("Really not important");
    }

    public static void main(String[] args) {
        LoggerUtil tester = new LoggerUtil();
        try {
            LoggerUtil.setLogger();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
        tester.doSomeThingAndLog();

    }

}
