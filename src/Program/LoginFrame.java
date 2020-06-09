package Program;

/**
 * Nama : Vian Azis Tio Riwanto 
 * Nim : E31191848
 *
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Login Frame merupakan tampilan User Interface, dimana nantinya user akan dibedakan 
 * + Jika admin maka dapat mengakses semua fitur yang ada pada Main Frame
 * + Jika user biasa maka beberapa fitur tidak akan bisa diakses
 *
 */
public class LoginFrame extends javax.swing.JFrame {

    private final javax.swing.JPanel PanelFormLogin;
    private final javax.swing.JButton btnClickHereRegister;
    private final javax.swing.JButton btnLogin;
    private final javax.swing.JCheckBox cbLoginAsAdmin;
    private final javax.swing.JLabel lblID;
    private final javax.swing.JLabel lblJudulLogin;
    private final javax.swing.JLabel lblPassword;
    private final javax.swing.JLabel lblRegisterNewMember;
    private final javax.swing.JPanel panelHeader;
    private static javax.swing.JTextField txtID;
    private static javax.swing.JPasswordField txtPassword;
    private final Connection con;
    private final Statement stat;
    private ResultSet rs;
    private String sql;
    static boolean admin = false;
    static String id_user = "";
    static String id_admin = "";

    public LoginFrame() throws SQLException {

        setResizable(false);
        
        PanelFormLogin = new javax.swing.JPanel();
        cbLoginAsAdmin = new javax.swing.JCheckBox();
        lblID = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtID = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        lblRegisterNewMember = new javax.swing.JLabel();
        btnClickHereRegister = new javax.swing.JButton();
        panelHeader = new javax.swing.JPanel();
        lblJudulLogin = new javax.swing.JLabel();

        Koneksi DB = new Koneksi();
        DB.bukaKoneksi();
        con = DB.con;
        stat = DB.stm;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Informasi Toko Ratna MD");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(700, 650));
        setPreferredSize(new java.awt.Dimension(700, 650));
        setResizable(false);

        PanelFormLogin.setBackground(new java.awt.Color(255, 255, 255));

        cbLoginAsAdmin.setSelected(admin);
        cbLoginAsAdmin.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbLoginAsAdmin.setForeground(new java.awt.Color(102, 204, 255));
        cbLoginAsAdmin.setText("Login as Admin");
        cbLoginAsAdmin.setFocusPainted(false);
        cbLoginAsAdmin.setOpaque(false);
        cbLoginAsAdmin.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLoginAsAdminActionPerformed(evt);
            }
        });

        lblID.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        lblID.setForeground(new java.awt.Color(102, 204, 255));
        lblID.setText("User ID");

        lblPassword.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(102, 204, 255));
        lblPassword.setText("User Password");

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(51, 51, 51));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        txtID.requestFocus();
        txtID.setBackground(new java.awt.Color(255, 255, 255));
        txtID.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtID.setForeground(new java.awt.Color(51, 51, 51));
        txtID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDKeyPressed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(204, 204, 204));
        btnLogin.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnLogin.setText("LOGIN");
        btnLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLogin.setFocusPainted(false);
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblRegisterNewMember.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblRegisterNewMember.setForeground(new java.awt.Color(102, 204, 255));
        lblRegisterNewMember.setText("Register a new member");

        btnClickHereRegister.setBackground(new java.awt.Color(255, 255, 255));
        btnClickHereRegister.setFont(new java.awt.Font("Dubai Light", 2, 14)); // NOI18N
        btnClickHereRegister.setForeground(new java.awt.Color(0, 0, 0));
        btnClickHereRegister.setText("Click Here");
        btnClickHereRegister.setBorder(null);
        btnClickHereRegister.setFocusPainted(false);
        btnClickHereRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClickHereRegisterActionPerformed(evt);
            }
        });

        panelHeader.setBackground(new java.awt.Color(102, 204, 255));

        lblJudulLogin.setFont(new java.awt.Font("Dubai Light", 1, 36)); // NOI18N
        lblJudulLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblJudulLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJudulLogin.setText("FORM LOGIN");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
                panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblJudulLogin)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHeaderLayout.setVerticalGroup(
                panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(lblJudulLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout PanelFormLoginLayout = new javax.swing.GroupLayout(PanelFormLogin);
        PanelFormLogin.setLayout(PanelFormLoginLayout);
        PanelFormLoginLayout.setHorizontalGroup(
                PanelFormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelFormLoginLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelFormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelFormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblID, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(PanelFormLoginLayout.createSequentialGroup()
                                                        .addComponent(cbLoginAsAdmin)
                                                        .addGap(18, 18, Short.MAX_VALUE)
                                                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(PanelFormLoginLayout.createSequentialGroup()
                                                .addComponent(lblRegisterNewMember)
                                                .addGap(20, 20, 20)
                                                .addComponent(btnClickHereRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelFormLoginLayout.setVerticalGroup(
                PanelFormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelFormLoginLayout.createSequentialGroup()
                                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(lblID)
                                .addGap(20, 20, 20)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lblPassword)
                                .addGap(20, 20, 20)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(PanelFormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbLoginAsAdmin))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(PanelFormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnClickHereRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblRegisterNewMember, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PanelFormLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PanelFormLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PanelFormLogin.getAccessibleContext().setAccessibleName("");
        PanelFormLogin.getAccessibleContext().setAccessibleDescription("");

        getAccessibleContext().setAccessibleDescription("Sistem Informasi Toko Ratna MD");

        pack();
        setLocationRelativeTo(null);

    }

    public void setAdmin(boolean admin) {
        LoginFrame.admin = admin;
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        if (admin == false) {
            try {
                sql = "SELECT * FROM tb_user WHERE id_user='" + txtID.getText() + "' AND password='" + txtPassword.getText() + "'";
                rs = stat.executeQuery(sql);
                if (rs.next()) {
                    if (txtID.getText().equals(rs.getString("id_user")) && txtPassword.getText().equals(rs.getString("password"))) {
                        MainFrame.lblName.setText(rs.getString(2));
                        id_user = rs.getString(1);
                        JOptionPane.showMessageDialog(null, "Berhasil Login");
                        this.dispose();
                        new MainFrame().setVisible(true);
                    }
                } else {
                    txtID.setText("");
                    txtID.requestFocus();
                    txtPassword.setText("");
                    JOptionPane.showMessageDialog(null, "ID atau Password Salah", "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else if (admin == true) {
            try {
                sql = "SELECT * FROM tb_admin WHERE id_admin='" + txtID.getText() + "' AND password='" + txtPassword.getText() + "'";
                rs = stat.executeQuery(sql);
                if (rs.next()) {
                    if (txtID.getText().equals(rs.getString("id_admin")) && txtPassword.getText().equals(rs.getString("password"))) {
                        MainFrame.lblName.setText(rs.getString(2) + " (admin)");
                        id_admin = rs.getString(1);
                        JOptionPane.showMessageDialog(null, "Berhasil Login Sebagai Admin");
                        this.dispose();
                        new MainFrame().setVisible(true);
                    }
                } else {
                    txtID.setText("");
                    txtID.requestFocus();
                    txtPassword.setText("");
                    JOptionPane.showMessageDialog(null, "ID atau Password Salah", "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

    }

    private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPassword.requestFocus();
        }
    }

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnLogin.doClick();
        }
    }

    private void btnClickHereRegisterActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Anda Akan Menambahkan User Baru, Silahkan Masukkan Passoword Admin", "Infomasi", JOptionPane.INFORMATION_MESSAGE);
        String Password = JOptionPane.showInputDialog(this, "Masukkan Password", "Infomasi", JOptionPane.INFORMATION_MESSAGE);
        try {
            sql = "SELECT password FROM tb_admin WHERE password='" + Password + "'";
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                if (Password.equals(rs.getString("password"))) {
                    this.setVisible(false);
                    try {
                        new RegisterFrame().setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                txtID.setText("");
                txtID.requestFocus();
                txtPassword.setText("");
                JOptionPane.showMessageDialog(null, "Password Salah", "Infomasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void cbLoginAsAdminActionPerformed(java.awt.event.ActionEvent evt) {
        if (cbLoginAsAdmin.isSelected()) {
            setAdmin(true);
        } else {
            setAdmin(false);
        }
    }

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {
        btnLogin.setBackground(Color.LIGHT_GRAY.darker());
    }

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {
        btnLogin.setBackground(Color.LIGHT_GRAY);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new LoginFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
