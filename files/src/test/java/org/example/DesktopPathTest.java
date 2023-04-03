package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DesktopPathTest {
    private final String pathPattern = "/Users/.*/Desktop";

    @Test
    void getDesktopPathFromPropsTest() {
        assertTrue(new DesktopPath().getDesktopPathFromProps().matches(pathPattern));
    }

    @Test
    void getDesktopPathFromSysViewTest() {
        assertTrue(new DesktopPath().getDesktopPathFromSysView().matches(pathPattern));
    }
}