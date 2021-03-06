package scraper.config;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 *
 * Central interfaces for configuration
 * Exists for further extensions
 */
public interface Configuration {
    void setProperty(String property, String value);

    String getValue(String property);

    boolean hasProperty(String property);
}
