package com.mycompany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class DesktopAppTest {
    private DesktopApp desktopApp;

    @BeforeEach
    void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> desktopApp = new DesktopApp());
    }

    @Test
    void testAppInitialization() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            assertNotNull(desktopApp);
            assertEquals(JFrame.EXIT_ON_CLOSE, desktopApp.getDefaultCloseOperation());
            assertEquals(600, desktopApp.getWidth());
            assertEquals(400, desktopApp.getHeight());
        });
    }

    @Test
    void testFilePanelCreation() throws Exception {
        JPanel[] panelHolder = new JPanel[1]; // Workaround to capture the panel inside invokeAndWait
        SwingUtilities.invokeAndWait(() -> panelHolder[0] = desktopApp.createFilePanel());
        assertNotNull(panelHolder[0]);
        assertTrue(panelHolder[0].getComponentCount() > 0);
    }

    @Test
    void testEditPanelCreation() throws Exception {
        JPanel[] panelHolder = new JPanel[1];
        SwingUtilities.invokeAndWait(() -> panelHolder[0] = desktopApp.createEditPanel());
        assertNotNull(panelHolder[0]);
        assertTrue(panelHolder[0].getComponentCount() > 0);
    }

    @Test
    void testHomePanelCreation() throws Exception {
        JPanel[] panelHolder = new JPanel[1];
        SwingUtilities.invokeAndWait(() -> panelHolder[0] = desktopApp.createHomePanel());
        assertNotNull(panelHolder[0]);
        assertTrue(panelHolder[0].getComponentCount() > 0);
    }

    @Test
    void testViewPanelCreation() throws Exception {
        JPanel[] panelHolder = new JPanel[1];
        SwingUtilities.invokeAndWait(() -> panelHolder[0] = desktopApp.createViewPanel());
        assertNotNull(panelHolder[0]);
        assertTrue(panelHolder[0].getComponentCount() > 0);
    }

    @Test
    void testAboutPanelCreation() throws Exception {
        JPanel[] panelHolder = new JPanel[1];
        SwingUtilities.invokeAndWait(() -> panelHolder[0] = desktopApp.createAboutPanel());
        assertNotNull(panelHolder[0]);
        assertTrue(panelHolder[0].getComponentCount() > 0);
    }
}
