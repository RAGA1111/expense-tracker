package com.expense;
import java.sql.Connection;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.expense.gui.ExpenseTrackerGUI;
import com.expense.gui.CategoryGUI;
import com.expense.gui.ExpensesGUI;
import com.expense.util.DatabaseConnection;

public class Main{

    public static void main(String[] args) {
        DatabaseConnection dbConnection = new DatabaseConnection();
        try {
            Connection cn = dbConnection.getDBConnection();
            System.out.println("CONNECTED SUCCESSFULLY");
        }
        catch (Exception e) {
            System.out.println("CONNECTION FAILED");
            System.exit(1);
        }
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){
            System.err.println("Could not set look and feel"+e.getMessage());
        }

        SwingUtilities.invokeLater(
            () ->
            {
                try{
                    new ExpenseTrackerGUI().setVisible(true);

                }
                catch(Exception e){
                    System.out.println("Error Starting the application"+e.getLocalizedMessage());

                }
            }
        );
    }
}