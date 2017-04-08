package com.fyelci.leaderelection;

import spock.lang.Specification

/**
 * Base class for tests.
 *
 * @author Fatih Yelci
 * @since 27.02.2017
 */
abstract class AbstractTest extends Specification {

    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    void setup() {
        System.setOut(new PrintStream(outContent));
    }

    void cleanup() {
        System.setOut(null);
    }
}
