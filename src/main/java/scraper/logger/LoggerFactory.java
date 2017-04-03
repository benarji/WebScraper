package scraper.logger;

import scraper.config.ApplicationPropertiesConfiguration;
import scraper.domain.Property;

import java.io.PrintStream;
import java.time.LocalDateTime;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 *
 * Logger factory. {@code Class<?> clazz}
 */
public class LoggerFactory {
    private static PrintStream printStream = System.out;

    public static void setPrintStream(PrintStream printStream) {
        LoggerFactory.printStream = printStream;
    }

    public static Logger obtain(Class<?> clazz){
        return new SimpleLogger(clazz, printStream);
    }

    public static Logger obtain(Class<?> clazz, PrintStream printStream){
        return new SimpleLogger(clazz, printStream);
    }

    private LoggerFactory() {
    }

    /**
     * Nested class that is returned by {@link LoggerFactory}
     * and implements {@link Logger}
     */
    private static class SimpleLogger implements Logger{

        private String className;
        private PrintStream printStream;

        SimpleLogger(Class<?> clazz, PrintStream printStream) {
            this.className = clazz.getName();
            this.printStream = printStream;
        }

        public void error(String msg) {
            printStream.println(LocalDateTime.now() + " " + className+ " error: " + msg);
        }

        public void info(String msg) {
            printStream.println(LocalDateTime.now() + " " + className + " info: " + msg);
        }


        /**
         *  Prints in {@link LoggerFactory#printStream}
         *  then {@link Property#VERBOSE} in enable
         *  in {@link scraper.config.PropertiesConfiguration}
         */
        public void debug(String msg) {
            if (Debug.isEnable()) {
                printStream.println(LocalDateTime.now()  + " " + className + " debug: " + msg);
            }
        }
    }

    /**
     * Lazy debug initialization
     */
    private static class Debug {
        private static Boolean enable = null;

        static boolean isEnable() {
            if (enable == null) {
                enable = ApplicationPropertiesConfiguration
                        .configuration()
                        .getValue(Property.VERBOSE);
            }
            return enable;
        }
    }

}
