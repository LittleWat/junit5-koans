package org.codecop;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;
import java.util.IllformedLocaleException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.Test;

/**
 * Session 4: WordCounterFailureTest - Exceptions and ignoring tests. <br />
 * @see "http://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions"
 * @see "https://junit.org/junit5/docs/current/user-guide/#writing-tests-disabling"
 */
class Session4_WordCounterFailureTest {

    // TODO Add the needed code/annotations to test for an expected exception.

    @Test
    void shouldThrowIOExceptionOnMissingFile() {
        Executable wordCountOfMissingFile = () -> new WordCounter(new File("IamSureThisDoesNotExist.txt"));
        // TODO Check that IOException.class, wordCountOfMissingFile is thrown.
        assertThrows(IOException.class, wordCountOfMissingFile);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWithMessageOnUnknownWord() {
        WordCounter counter = new WordCounter("green bar green");
        Executable ratioOfMissingWord = () -> counter.ratioOf("missingWord");
        // TODO Expect IllegalArgumentException exception is thrown from IllegalArgumentException.class, ratioOfMissingWord.
        // TODO Check that "missingWord not in sentence", exception.getMessage().

        Exception exception = assertThrows(Exception.class, ratioOfMissingWord);
        assertThrows(IllegalArgumentException.class, ratioOfMissingWord);
        assertThat(exception.getMessage()).isEqualTo("missingWord not in sentence");
    }

    // TODO The next test does not work, we need to change the code,


    // TODO Mark this test as ignored with "work in progress, will continue tomorrow".
    @Test
    @Disabled("work in progress, will continue tomorrow")
    void shouldCountUniqueWordsCaseInsensitive() {
        WordCounter counter = new WordCounter("green bar Green hat");
        assertArrayEquals(new String[] { "bar", "green", "hat" }, counter.uniqueWords());
    }
    // but we will do that tomorrow. For today let's ignore it.
}
