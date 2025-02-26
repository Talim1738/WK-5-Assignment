package com.mycompany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DesktopAppIntegrationTest {
    private DesktopApp desktopApp;

    @BeforeEach
    void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> desktopApp = new DesktopApp());
    }

    @Test
    void testFullApplicationFlow() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            assertNotNull(desktopApp, "DesktopApp instance should not be null");
            assertEquals(JFrame.EXIT_ON_CLOSE, desktopApp.getDefaultCloseOperation(), "Incorrect default close operation");
            assertEquals(600, desktopApp.getWidth(), "Incorrect window width");
            assertEquals(400, desktopApp.getHeight(), "Incorrect window height");

            Container contentPane = desktopApp.getContentPane();
            assertNotNull(contentPane, "Content pane should not be null");
        });
    }

    @Test
    void testAllPanelsExistInApplication() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            JPanel filePanel = desktopApp.createFilePanel();
            JPanel editPanel = desktopApp.createEditPanel();
            JPanel homePanel = desktopApp.createHomePanel();
            JPanel viewPanel = desktopApp.createViewPanel();
            JPanel aboutPanel = desktopApp.createAboutPanel();

            assertNotNull(filePanel, "File panel should not be null");
            assertTrue(filePanel.getComponentCount() > 0, "File panel should have components");

            assertNotNull(editPanel, "Edit panel should not be null");
            assertTrue(editPanel.getComponentCount() > 0, "Edit panel should have components");

            assertNotNull(homePanel, "Home panel should not be null");
            assertTrue(homePanel.getComponentCount() > 0, "Home panel should have components");

            assertNotNull(viewPanel, "View panel should not be null");
            assertTrue(viewPanel.getComponentCount() > 0, "View panel should have components");

            assertNotNull(aboutPanel, "About panel should not be null");
            assertTrue(aboutPanel.getComponentCount() > 0, "About panel should have components");
        });
    }
}
