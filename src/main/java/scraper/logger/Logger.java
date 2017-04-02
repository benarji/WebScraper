package scraper.logger;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public interface Logger {

    void error(String msg);

    void info(String msg);

    void debug(String msg);

}