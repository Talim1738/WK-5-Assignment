package com.mycompany;
import javax.swing.*;
import java.awt.*;

public class DesktopApp extends JFrame {

    static  String AppName = CommonUtility.getAppName();
    public DesktopApp(){
       super("My Company Project");

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel filePanel = createFilePanel();
        tabbedPane.addTab("File", filePanel);

        JPanel editPanel = createEditPanel();
        tabbedPane.addTab("Edit", editPanel);

        JPanel homePanel = CommonUtility.createHomePanel();
        tabbedPane.addTab("Home", homePanel);

        JPanel viewPanel = createViewPanel();
        tabbedPane.addTab("View", viewPanel);

        JPanel aboutPanel = createAboutPanel();
        tabbedPane.addTab("About", aboutPanel);
        add(tabbedPane);

        add(new JLabel("Welcome to " + AppName));
       setLayout(new FlowLayout());
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setSize(600,400);
       setLocationRelativeTo(null);
    }

    public JPanel createFilePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenuItem = new JMenuItem("Open");
        fileMenu.add(openMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);
        panel.add(menuBar, BorderLayout.NORTH);
        return panel;
    }

    public JPanel createEditPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(new JButton("Cut"));
        panel.add(new JButton("Copy"));
        panel.add(new JButton("Paste"));
        return panel;
    }
    public JPanel createHomePanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea("This is the Most Crucial and Important part of the Project  TASKS " +
                "And these are done by following Professionals;\n " +
                "TALIM, \nMAWIEN, \nANTIPAS, \nPACH, \nJOSEPH,\n " +
                "JIEL and NICOLAS Respectively.\n" +
                "The Company Project includes the following Tasks which " +
                "Tasks include:\n1. LOGIC BUILDING\n 2.JIRA\n 3.TESTING\n4. JENKINS\n 5.DOCUMENTATION");

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        panel.add(textArea, BorderLayout.NORTH);
        return panel;
    }

    public JPanel createViewPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Optional View of My Company Project"));
        panel.add(new JLabel("Choose Your Most Suitable Display of the Project"));
        panel.add(new JLabel("By Clicking on one of the Check Boxes Below:"));

        panel.add(new JCheckBox("Half Screen"));
        panel.add(new JCheckBox("Full Screen"));
        return panel;
    }


    public JPanel createAboutPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel labelPanel = new JPanel();
        labelPanel.add(new JLabel("WELCOME TO MY COMPANY PROJECT 2025 ULTIMATE VERSION!!!"));
        panel.add(labelPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton("Back"));
        buttonPanel.add(new JButton("Exit"));
        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DesktopApp().setVisible(true);
            }
        });
    }
}

