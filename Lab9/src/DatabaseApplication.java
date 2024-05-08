import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DatabaseApplication extends JFrame {
    private JTable table;
    private JButton addButton;
    private JButton deleteButton;

    public DatabaseApplication() {
        setTitle("Database Application");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create components
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddUserDialog();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedRow();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        connectToDatabase();
        loadData();
    }

    private void connectToDatabase() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/vladmaslianko/Desktop/labs/AOP/Lab9/src/User.db");
            Statement statement = connection.createStatement();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/vladmaslianko/Desktop/labs/AOP/Lab9/src/User.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");


            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("id");
            model.addColumn("name");
            model.addColumn("surname");
            model.addColumn("position");
            model.addColumn("salary");
            model.addColumn("email");

            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("surname"),
                        resultSet.getString("position"), resultSet.getString("salary"), resultSet.getString("email")});
            }
            table.setModel(model);

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteSelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int id = (int) model.getValueAt(selectedRow, 0); // Assuming the ID is in the first column
            model.removeRow(selectedRow);

            // Delete the user from the database
            try (Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/vladmaslianko/Desktop/labs/AOP/Lab9/src/User.db")) {
                String sql = "DELETE FROM Users WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showAddUserDialog() {
        // Create a dialog for adding a new user
        JDialog dialog = new JDialog(this, "Add User", true);
        dialog.setLayout(new GridLayout(7, 2));

        // Add labels and text fields for each field
        JTextField nameField = new JTextField();
        JTextField surnameField = new JTextField();
        JTextField positionField = new JTextField();
        JTextField salaryField = new JTextField();
        JTextField emailField = new JTextField();

        dialog.add(new JLabel("Name:"));
        dialog.add(nameField);
        dialog.add(new JLabel("Surname:"));
        dialog.add(surnameField);
        dialog.add(new JLabel("Position:"));
        dialog.add(positionField);
        dialog.add(new JLabel("Salary:"));
        dialog.add(salaryField);
        dialog.add(new JLabel("Email:"));
        dialog.add(emailField);

        // Add button to submit the form
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve values from text fields
                String name = nameField.getText();
                String surname = surnameField.getText();
                String position = positionField.getText();
                double salary = Double.parseDouble(salaryField.getText());
                String email = emailField.getText();

                // Insert new user into the database
                insertUser(name, surname, position, salary, email);

                // Refresh table data
                loadData();

                // Close the dialog
                dialog.dispose();
            }
        });

        dialog.add(submitButton);

        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void insertUser(String name, String surname, String position, double salary, String email) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/vladmaslianko/Desktop/labs/AOP/Lab9/src/User.db")) {
            String sql = "INSERT INTO Users (name, surname, position, salary, email) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, surname);
                preparedStatement.setString(3, position);
                preparedStatement.setDouble(4, salary);
                preparedStatement.setString(5, email);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create and display the main frame
        SwingUtilities.invokeLater(() -> {
            DatabaseApplication app = new DatabaseApplication();
            app.setVisible(true);
        });
    }
}
