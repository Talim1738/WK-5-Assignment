package com.mycompany;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsoleApp {
    public static String getAppName() {
        String appName = CommonUtility.getAppName();
        System.out.println("Welcome to " + appName);
        return appName;
    }

    public static void main(String[] args) {
        getAppName();
        showEditPanel();
    }

    public static void showEditPanel() {
        JPanel editPanel = new DesktopApp().createEditPanel();
        JFrame frame = new JFrame("Edit Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(editPanel);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
