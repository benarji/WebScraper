package scraper.parser;

import scraper.domain.ConsoleParseData;
import scraper.exceptions.InputWasNotFoundException;
import scraper.exceptions.MissingWordsException;
import scraper.url.URLFileReader;

import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public interface ConsoleParser {

    /**
     * @return  {@link ConsoleParseData} that contains
     * urls list sources {@link ConsoleParseData#urls},
     * configuration {@link scraper.config.Configuration}
     * and searchable words {@link ConsoleParseData#words}
     * Takes list params {@param args}
     * @throws InputWasNotFoundException and
     * @throws MissingWordsException
     * @throws scraper.exceptions.UnknownOptionWasFoundException
     */
    ConsoleParseData parse(List<String> args);

    /**
     * Maybe useful
     * for further extensions.
     * @param URLFileReader
     * using for obtain sources from file
     */
    void setURLFileReader(URLFileReader URLFileReader);
}
