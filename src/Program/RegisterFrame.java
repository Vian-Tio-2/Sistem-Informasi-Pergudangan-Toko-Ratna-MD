package Program;

/**
 * Nama : Vian Azis Tio Riwanto 
 * Nim : E31191848
 *
 */

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Register Frame merupakan tampilan User Interface. Dimana hanya user
 * (Admin/Manager) yang dapat mengakses form ini, untuk memasuki form ini user
 * harus memasukkan password dari admin. Form ini berguna untuk membuat user
 * (karyawan) baru ke database, namun tidak bisa membuat user (Admin/Manager).
 *
 */
public class RegisterFrame extends javax.swing.JFrame {

    private final Connection con;
    private final Statement stat;
    private ResultSet rs;
    private String sql;
    private javax.swing.JPanel PanelFormRegister;
    private javax.swing.JButton btnClickHereLogin;
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JCheckBox chkAcceptTerms;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblAlreadyHaveAccount;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblJudulRegister;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNoTelp;
    private javax.swing.JLabel lblPassword;
    public static javax.swing.JTextField txtAlamat;
    public static javax.swing.JTextField txtID;
    public static javax.swing.JTextField txtName;
    public static javax.swing.JTextField txtNoTelp;
    public static javax.swing.JPasswordField txtPassword;

    public RegisterFrame() throws SQLException {
        setResizable(false);

        PanelFormRegister = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtID = new javax.swing.JTextField();
        btnCreateAccount = new javax.swing.JButton();
        chkAcceptTerms = new javax.swing.JCheckBox();
        lblAlreadyHaveAccount = new javax.swing.JLabel();
        btnClickHereLogin = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblJudulRegister = new javax.swing.JLabel();
        lblNoTelp = new javax.swing.JLabel();
        txtNoTelp = new javax.swing.JTextField();
        lblAlamat = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();

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

        PanelFormRegister.setBackground(new java.awt.Color(255, 255, 255));
        PanelFormRegister.setToolTipText("");
        PanelFormRegister.setMaximumSize(new java.awt.Dimension(700, 650));
        PanelFormRegister.setMinimumSize(new java.awt.Dimension(700, 650));
        PanelFormRegister.setPreferredSize(new java.awt.Dimension(700, 650));

        lblID.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        lblID.setForeground(new java.awt.Color(102, 204, 255));
        lblID.setText("User ID");

        lblPassword.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(102, 204, 255));
        lblPassword.setText("User Password");

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(51, 51, 51));
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
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDKeyPressed(evt);
            }
        });

        btnCreateAccount.setBackground(new java.awt.Color(204, 204, 204));
        btnCreateAccount.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        btnCreateAccount.setForeground(new java.awt.Color(0, 0, 0));
        btnCreateAccount.setText("Create Account");
        btnCreateAccount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCreateAccount.setEnabled(false);
        btnCreateAccount.setFocusPainted(false);
        btnCreateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCreateAccountMouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCreateAccountMouseExited(evt);
            }
        });
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });

        chkAcceptTerms.setBackground(new java.awt.Color(255, 255, 255));
        chkAcceptTerms.setForeground(new java.awt.Color(102, 204, 255));
        chkAcceptTerms.setText("I accept the Terms of Service.");
        chkAcceptTerms.setFocusPainted(false);
        chkAcceptTerms.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAcceptTermsActionPerformed(evt);
            }
        });

        lblAlreadyHaveAccount.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblAlreadyHaveAccount.setForeground(new java.awt.Color(102, 204, 255));
        lblAlreadyHaveAccount.setText("Already have account?");

        btnClickHereLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnClickHereLogin.setFont(new java.awt.Font("Dubai Light", 2, 14)); // NOI18N
        btnClickHereLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnClickHereLogin.setText("Click Here");
        btnClickHereLogin.setBorder(null);
        btnClickHereLogin.setFocusPainted(false);
        btnClickHereLogin.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClickHereLoginActionPerformed(evt);
            }
        });

        txtName.setBackground(new java.awt.Color(255, 255, 255));
        txtName.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(51, 51, 51));
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(102, 204, 255));
        lblName.setText("Name");

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        lblJudulRegister.setBackground(new java.awt.Color(102, 204, 255));
        lblJudulRegister.setFont(new java.awt.Font("Dubai Light", 1, 36)); // NOI18N
        lblJudulRegister.setForeground(new java.awt.Color(255, 255, 255));
        lblJudulRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJudulRegister.setText("FORM REGISTER");
        lblJudulRegister.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblJudulRegister)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(lblJudulRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
        );

        lblNoTelp.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        lblNoTelp.setForeground(new java.awt.Color(102, 204, 255));
        lblNoTelp.setText("Contact");

        txtNoTelp.setBackground(new java.awt.Color(255, 255, 255));
        txtNoTelp.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtNoTelp.setForeground(new java.awt.Color(51, 51, 51));
        txtNoTelp.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoTelpKeyPressed(evt);
            }
        });

        lblAlamat.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        lblAlamat.setForeground(new java.awt.Color(102, 204, 255));
        lblAlamat.setText("Address");

        txtAlamat.setBackground(new java.awt.Color(255, 255, 255));
        txtAlamat.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtAlamat.setForeground(new java.awt.Color(51, 51, 51));
        txtAlamat.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAlamatKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelFormRegisterLayout = new javax.swing.GroupLayout(PanelFormRegister);
        PanelFormRegister.setLayout(PanelFormRegisterLayout);
        PanelFormRegisterLayout.setHorizontalGroup(
                PanelFormRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelFormRegisterLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(PanelFormRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelFormRegisterLayout.createSequentialGroup()
                                                .addComponent(lblAlreadyHaveAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(btnClickHereLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(PanelFormRegisterLayout.createSequentialGroup()
                                                .addGroup(PanelFormRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(PanelFormRegisterLayout.createSequentialGroup()
                                                                .addComponent(chkAcceptTerms)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(PanelFormRegisterLayout.createSequentialGroup()
                                                                .addGroup(PanelFormRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblNoTelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lblAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(15, 15, 15)
                                                                .addGroup(PanelFormRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtNoTelp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtAlamat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(PanelFormRegisterLayout.createSequentialGroup()
                                                                .addGroup(PanelFormRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lblName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(15, 15, 15)
                                                                .addGroup(PanelFormRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(50, 50, 50))))
        );
        PanelFormRegisterLayout.setVerticalGroup(
                PanelFormRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelFormRegisterLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(PanelFormRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblID)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(PanelFormRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblName)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(PanelFormRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPassword)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(PanelFormRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNoTelp))
                                .addGap(45, 45, 45)
                                .addGroup(PanelFormRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblAlamat))
                                .addGap(30, 30, 30)
                                .addGroup(PanelFormRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(chkAcceptTerms)
                                        .addComponent(btnCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(PanelFormRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnClickHereLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblAlreadyHaveAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(PanelFormRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PanelFormRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        PanelFormRegister.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleDescription("Sistem Informasi Toko Ratna MD");

        pack();
        setLocationRelativeTo(null);
    }

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {
        if (!(txtID.getText().equals("") && txtName.getText().equals("") && txtPassword.getText().equals("") && txtNoTelp.getText().equals("") && txtAlamat.getText().equals(""))) {
            try {
                sql = "INSERT INTO tb_user (id_user, password, name, no_telp, alamat) "
                        + "VALUES ('" + txtID.getText() + "','" + txtPassword.getText() + "','" + txtName.getText() + "','" + txtNoTelp.getText() + "','" + txtAlamat.getText() + "')";
                int row = stat.executeUpdate(sql);

                if (row == 1) {
                    JOptionPane.showMessageDialog(null, "Data sudah ditambahkan ke database", "infomasi", JOptionPane.INFORMATION_MESSAGE);
                    con.close();
                    this.dispose();
                    new LoginFrame().setVisible(true);
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Data tidak ditambahkan ke database : " + e, "infomasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong", "infomasi", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtName.requestFocus();
        }
    }

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNoTelp.requestFocus();
        }
    }

    private void btnClickHereLoginActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        try {
            new LoginFrame().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void chkAcceptTermsActionPerformed(java.awt.event.ActionEvent evt) {
        if (chkAcceptTerms.isSelected()) {
            btnCreateAccount.setEnabled(true);
        } else {
            btnCreateAccount.setEnabled(false);
        }
    }

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPassword.requestFocus();
        }
    }

    private void btnCreateAccountMouseEntered(java.awt.event.MouseEvent evt) {
        if (chkAcceptTerms.isSelected()) {
            btnCreateAccount.setBackground(Color.LIGHT_GRAY.darker());
        }
    }

    private void btnCreateAccountMouseExited(java.awt.event.MouseEvent evt) {
        if (chkAcceptTerms.isSelected()) {
            btnCreateAccount.setBackground(Color.LIGHT_GRAY);
        }
    }

    private void txtNoTelpKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtAlamat.requestFocus();
        }
    }

    private void txtAlamatKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnCreateAccount.doClick();
        }
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new RegisterFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
