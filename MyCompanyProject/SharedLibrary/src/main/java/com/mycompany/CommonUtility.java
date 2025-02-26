package com.mycompany;

import javax.swing.*;
import java.awt.*;

public class CommonUtility {
    public static String getAppName() {
        return "My Company Project Ultimate Version";
    }

    public static JPanel createHomePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea("This is the Most Crucial and Important part of the Project TASKS " +
                "And these are done by following Professionals:\n" +
                "TALIM,\nMAWIEN,\nANTIPAS,\nPACH,\nJOSEPH,\nJIEL,\nNICOLAS Respectively.\n" +
                "The Company Project includes the following Tasks:\n1. LOGIC BUILDING\n2. JIRA\n3. TESTING\n" +
                "4. JENKINS\n5. DOCUMENTATION");

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        panel.add(textArea, BorderLayout.CENTER);
        return panel;
    }
}