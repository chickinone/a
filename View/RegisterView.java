package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class RegisterView extends JFrame {
    private JTextField teacherIdField;
    private JTextField teacherNameField;
    private JTextField branchField;
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    public RegisterView() {
        setTitle("Đăng ký");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 350); // Đặt kích thước khung

        // Panel chứa tất cả các thành phần
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label và TextField cho Mã giáo viên
        JLabel teacherIdLabel = new JLabel("Mã giáo viên:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(teacherIdLabel, gbc);

        teacherIdField = new JTextField();
        teacherIdField.setPreferredSize(new Dimension(200, 25)); // Đặt kích thước cho ô nhập liệu
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(teacherIdField, gbc);

        // Label và TextField cho Tên giáo viên
        JLabel teacherNameLabel = new JLabel("Tên giáo viên:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(teacherNameLabel, gbc);

        teacherNameField = new JTextField();
        teacherNameField.setPreferredSize(new Dimension(200, 25)); // Đặt kích thước cho ô nhập liệu
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(teacherNameField, gbc);

        // Label và TextField cho Ngành
        JLabel branchLabel = new JLabel("Ngành:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(branchLabel, gbc);

        branchField = new JTextField();
        branchField.setPreferredSize(new Dimension(200, 25)); // Đặt kích thước cho ô nhập liệu
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(branchField, gbc);

        // Label và TextField cho Tên đăng nhập
        JLabel usernameLabel = new JLabel("Tên đăng nhập:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(usernameLabel, gbc);

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(200, 25)); // Đặt kích thước cho ô nhập liệu
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(usernameField, gbc);

        // Label và TextField cho Email
        JLabel emailLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(emailLabel, gbc);

        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(200, 25)); // Đặt kích thước cho ô nhập liệu
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(emailField, gbc);

        // Label và TextField cho Mật khẩu
        JLabel passwordLabel = new JLabel("Mật khẩu:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 25)); // Đặt kích thước cho ô nhập liệu
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(passwordField, gbc);

        // Label và TextField cho Xác nhận mật khẩu
        JLabel confirmPasswordLabel = new JLabel("Xác nhận mật khẩu:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(confirmPasswordLabel, gbc);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setPreferredSize(new Dimension(200, 25)); // Đặt kích thước cho ô nhập liệu
        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(confirmPasswordField, gbc);

        // Button Đăng ký
        JButton registerButton = new JButton("Đăng ký");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        panel.add(registerButton, gbc);

        // Thêm panel vào frame
        getContentPane().add(panel);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy dữ liệu từ các ô nhập liệu
                String teacherId = teacherIdField.getText();
                String teacherName = teacherNameField.getText();
                String branch = branchField.getText();
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                
                if (teacherId.isEmpty() || teacherName.isEmpty() || branch.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(RegisterView.this, "Vui lòng nhập đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(RegisterView.this, "Mật khẩu xác nhận không khớp.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JOptionPane.showMessageDialog(RegisterView.this, "Đăng ký thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

               
                setVisible(false); 
                new LoginView().setVisible(true); 
            }
        });

    }
}
