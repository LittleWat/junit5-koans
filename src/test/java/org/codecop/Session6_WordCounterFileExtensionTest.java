package org.codecop;

import org.codecop.Session6_TempFile.Temp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Session 6: WordCounterFileExtensionTest - Reuse fixtures in Extensions. <br />
 *
 * @see "http://junit.org/junit5/docs/current/user-guide/#extensions"
 */
// TODO Use the TempFile extension to create a temporary words file for each test.
@ExtendWith(Session6_TempFile.class)
class Session6_WordCounterFileExtensionTest {

    @Test
    void shouldReturnCountOfWordsBetter(@Temp File wordsFile) throws IOException {
        WordCounter counter = new WordCounter(wordsFile);
        assertEquals(9, counter.numberOfWords());
    }

    @Test
    void shouldVerifyContainmentOfWord(@Temp File wordsFile) throws IOException {
        WordCounter counter = new WordCounter(wordsFile);
        assertTrue(counter.containsWord("bar"));
    }
}
