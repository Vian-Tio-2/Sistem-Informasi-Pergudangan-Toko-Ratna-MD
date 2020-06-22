package Program;

/**
 * Nama : Vian Azis Tio Riwanto 
 * Nim : E31191848
 *
 */
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.time.LocalDate;

/**
 * Main Frame merupakan tampilan User Interface Utama pada program ini. Disini
 * terdapat 4 sub menu yaitu : + menu Home + Info Barang + Catat Barang +
 * Manajemen Jika user adalah user (karyawan) maka, hanya akan dapat mengakses
 * menu + Home + Catat Barang + Info Barang
 *
 */
public final class MainFrame extends javax.swing.JFrame implements ActionListener {

    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCatatInput;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageCari;
    private javax.swing.JButton btnManageReset;
    private javax.swing.JButton btnManageSet;
    private javax.swing.JButton btnMasukkanPengumuman;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cboSearchBy;
    private javax.swing.JComboBox<String> cboSearchByManage;
    private javax.swing.JComboBox<String> cboTipePencatatan;
    private javax.swing.JPopupMenu jPopupManage;
    private javax.swing.JScrollPane jScrollPaneAktifitas;
    private javax.swing.JScrollPane jScrollPaneCari;
    private javax.swing.JScrollPane jScrollPaneManage;
    private javax.swing.JScrollPane jScrollPanePengumuman;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTable jTableCari;
    private javax.swing.JTable jTableManage;
    private javax.swing.JLabel lblAktifitas;
    private javax.swing.JLabel lblAturHarga;
    private javax.swing.JLabel lblCatat;
    private javax.swing.JLabel lblCatatJumlah;
    private javax.swing.JLabel lblCatatKodeOrder;
    private javax.swing.JLabel lblCatatMerek;
    private javax.swing.JLabel lblCatatNama;
    private javax.swing.JLabel lblCatatTanggal;
    private javax.swing.JLabel lblCatatTanggalKadaluarsa;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblJudulCari;
    private javax.swing.JLabel lblJudulCatat;
    private javax.swing.JLabel lblJudulHome;
    private javax.swing.JLabel lblJudulManage;
    private javax.swing.JLabel lblManage;
    public static final javax.swing.JLabel lblName = new javax.swing.JLabel();
    private javax.swing.JLabel lblPengumuman;
    private javax.swing.JLabel lblTipePencatatan;
    private javax.swing.JMenuItem menuHapus;
    private javax.swing.JMenuItem menuHarga;
    private javax.swing.JMenuItem menuRefresh;
    private javax.swing.JLayeredPane panelLayer;
    private javax.swing.JLayeredPane panelLayerCari;
    private javax.swing.JLayeredPane panelLayerCatat;
    private javax.swing.JLayeredPane panelLayerHome;
    private javax.swing.JLayeredPane panelLayerManage;
    private javax.swing.JPanel panelMenu;
    public static final javax.swing.JTextArea txtAreaAktifitas = new javax.swing.JTextArea();
    public static final javax.swing.JTextArea txtAreaPengumuman = new javax.swing.JTextArea();
    private javax.swing.JTextField txtCariSearchBy;
    private javax.swing.JTextField txtCatatKodeOrder;
    private javax.swing.JTextField txtCatatMerek;
    private javax.swing.JTextField txtCatatNama;
    private com.toedter.calendar.JDateChooser txtCatatTglKadaluarsa;
    private com.toedter.calendar.JDateChooser txtCatatTglMasuk;
    private javax.swing.JSpinner txtJumlah;
    private javax.swing.JTextField txtManageCari;
    private javax.swing.JTextField txtManageHarga;
    private javax.swing.JTextPane txtPaneTanggal;
    private javax.swing.JTextPane txtPaneWaktu;
    private final Calendar calendar = Calendar.getInstance(); //Get calendar using this machine's current local
    private final Connection con;
    private final Statement stat;
    private ResultSet rs;
    private String sql;
    static int DbJmlBrgKel = 0;
    static int DbJmlBrgMas = 0;
    Date date = java.sql.Date.valueOf(LocalDate.now());
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    /**
     * Creates new form MainFrame
     *
     * @throws java.sql.SQLException
     */
    public MainFrame() throws SQLException {
        
        jPopupManage = new javax.swing.JPopupMenu();
        menuHarga = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuHapus = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuRefresh = new javax.swing.JMenuItem();
        panelMenu = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        lblHome = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        lblCatat = new javax.swing.JLabel();
        lblManage = new javax.swing.JLabel();
        panelLayer = new javax.swing.JLayeredPane();
        panelLayerHome = new javax.swing.JLayeredPane();
        lblAktifitas = new javax.swing.JLabel();
        lblPengumuman = new javax.swing.JLabel();
        lblJudulHome = new javax.swing.JLabel();
        txtPaneTanggal = new javax.swing.JTextPane();
        txtPaneWaktu = new javax.swing.JTextPane();
        btnMasukkanPengumuman = new javax.swing.JButton();
        jScrollPanePengumuman = new javax.swing.JScrollPane();
        jScrollPaneAktifitas = new javax.swing.JScrollPane();
        panelLayerManage = new javax.swing.JLayeredPane();
        lblJudulManage = new javax.swing.JLabel();
        cboSearchByManage = new javax.swing.JComboBox<>();
        txtManageCari = new javax.swing.JTextField();
        btnManageCari = new javax.swing.JButton();
        jScrollPaneManage = new javax.swing.JScrollPane();
        jTableManage = new javax.swing.JTable();
        btnManageSet = new javax.swing.JButton();
        txtManageHarga = new javax.swing.JTextField();
        lblAturHarga = new javax.swing.JLabel();
        btnManageReset = new javax.swing.JButton();
        panelLayerCatat = new javax.swing.JLayeredPane();
        lblJudulCatat = new javax.swing.JLabel();
        txtCatatKodeOrder = new javax.swing.JTextField();
        txtCatatNama = new javax.swing.JTextField();
        txtCatatMerek = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JSpinner();
        lblCatatKodeOrder = new javax.swing.JLabel();
        lblCatatNama = new javax.swing.JLabel();
        lblCatatMerek = new javax.swing.JLabel();
        lblCatatTanggalKadaluarsa = new javax.swing.JLabel();
        lblCatatJumlah = new javax.swing.JLabel();
        lblCatatTanggal = new javax.swing.JLabel();
        btnCatatInput = new javax.swing.JButton();
        cboTipePencatatan = new javax.swing.JComboBox<>();
        lblTipePencatatan = new javax.swing.JLabel();
        txtCatatTglKadaluarsa = new com.toedter.calendar.JDateChooser();
        txtCatatTglMasuk = new com.toedter.calendar.JDateChooser();
        panelLayerCari = new javax.swing.JLayeredPane();
        lblJudulCari = new javax.swing.JLabel();
        cboSearchBy = new javax.swing.JComboBox<>();
        txtCariSearchBy = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPaneCari = new javax.swing.JScrollPane();
        jTableCari = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();

        jPopupManage.setBackground(new java.awt.Color(255, 255, 255));
        jPopupManage.setForeground(new java.awt.Color(51, 51, 51));

        menuHarga.setBackground(new java.awt.Color(255, 255, 255));
        menuHarga.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuHarga.setForeground(new java.awt.Color(51, 51, 51));
        menuHarga.setText("Ubah Harga");
        menuHarga.setBorderPainted(false);
        menuHarga.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHargaActionPerformed(evt);
            }
        });
        jPopupManage.add(menuHarga);
        jPopupManage.add(jSeparator1);

        menuHapus.setBackground(new java.awt.Color(255, 255, 255));
        menuHapus.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuHapus.setForeground(new java.awt.Color(51, 51, 51));
        menuHapus.setText("Hapus Data");
        menuHapus.setBorderPainted(false);
        menuHapus.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHapusActionPerformed(evt);
            }
        });
        jPopupManage.add(menuHapus);
        jPopupManage.add(jSeparator2);

        menuRefresh.setBackground(new java.awt.Color(255, 255, 255));
        menuRefresh.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuRefresh.setForeground(new java.awt.Color(51, 51, 51));
        menuRefresh.setText("Refresh");
        menuRefresh.setBorderPainted(false);
        menuRefresh.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRefreshActionPerformed(evt);
            }
        });
        jPopupManage.add(menuRefresh);

        jPopupManage.getAccessibleContext().setAccessibleParent(jTableManage);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Informasi Toko Ratna MD");
        setBackground(new java.awt.Color(102, 204, 255));
        setName("frameMain"); // NOI18N

        panelMenu.setBackground(new java.awt.Color(102, 204, 255));
        panelMenu.setForeground(new java.awt.Color(0, 0, 0));
        panelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelMenu.setDoubleBuffered(false);

        btnLogout.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(102, 102, 102));
        btnLogout.setText("LOGOUT");
        btnLogout.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnLogout.setBorderPainted(false);
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLogout.setFocusPainted(false);
        btnLogout.setRequestFocusEnabled(false);
        btnLogout.setVerifyInputWhenFocusTarget(false);
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lblHome.setBackground(new java.awt.Color(102, 204, 255));
        lblHome.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblHome.setForeground(new java.awt.Color(0, 0, 0));
        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Home.png"))); // NOI18N
        lblHome.setText("Home");
        lblHome.setVerticalAlignment(lblHome.CENTER);
        lblHome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblHome.setOpaque(true);
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHomeMouseEntered(evt);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHomeMouseExited(evt);
            }
        });

        lblInfo.setBackground(new java.awt.Color(102, 204, 255));
        lblInfo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(0, 0, 0));
        lblInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Search.png"))); // NOI18N
        lblInfo.setText("Info Barang");
        lblInfo.setVerticalAlignment(lblInfo.CENTER);
        lblInfo.setOpaque(true);
        lblInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInfoMouseClicked(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblInfoMouseEntered(evt);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblInfoMouseExited(evt);
            }
        });

        lblCatat.setBackground(new java.awt.Color(102, 204, 255));
        lblCatat.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblCatat.setForeground(new java.awt.Color(0, 0, 0));
        lblCatat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCatat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit.png"))); // NOI18N
        lblCatat.setText("Catat Barang");
        lblCatat.setVerticalAlignment(lblCatat.CENTER);
        lblCatat.setOpaque(true);
        lblCatat.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCatatMouseClicked(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCatatMouseEntered(evt);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCatatMouseExited(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(0, 0, 0));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/userIcon.png"))); // NOI18N
        lblName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblName.setMinimumSize(new java.awt.Dimension(16, 16));
        lblName.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblManage.setBackground(new java.awt.Color(102, 204, 255));
        lblManage.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblManage.setForeground(new java.awt.Color(0, 0, 0));
        lblManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Manage.png"))); // NOI18N
        lblManage.setText("Manajemen");
        lblManage.setVerticalAlignment(lblHome.CENTER);
        lblManage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblManage.setOpaque(true);
        lblManage.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManageMouseClicked(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblManageMouseEntered(evt);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblManageMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblManage, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCatat)
                    .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        panelMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblCatat, lblHome, lblInfo, lblManage});

        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHome)
                .addGap(50, 50, 50)
                .addComponent(lblInfo)
                .addGap(50, 50, 50)
                .addComponent(lblCatat)
                .addGap(50, 50, 50)
                .addComponent(lblManage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        panelMenuLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblCatat, lblHome, lblInfo, lblManage});

        panelLayer.setBackground(new java.awt.Color(255, 255, 255));
        panelLayer.setMinimumSize(new java.awt.Dimension(641, 612));
        panelLayer.setNextFocusableComponent(panelLayerHome);
        panelLayer.setOpaque(true);
        panelLayer.setLayout(new java.awt.CardLayout());

        panelLayerHome.setBackground(new java.awt.Color(255, 255, 255));
        panelLayerHome.setMinimumSize(new java.awt.Dimension(641, 612));
        panelLayerHome.setOpaque(true);

        lblAktifitas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblAktifitas.setForeground(new java.awt.Color(0, 0, 0));
        lblAktifitas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAktifitas.setText("Aktifitas");

        lblPengumuman.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPengumuman.setForeground(new java.awt.Color(0, 0, 0));
        lblPengumuman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPengumuman.setText("Pengumuman");

        lblJudulHome.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblJudulHome.setForeground(new java.awt.Color(0, 0, 0));
        lblJudulHome.setText("Home");

        txtPaneTanggal.setEditable(false);
        txtPaneTanggal.setBackground(new java.awt.Color(255, 255, 255));
        txtPaneTanggal.setForeground(new java.awt.Color(0, 0, 0));
        txtPaneTanggal.setText("Tanggal\t: "+getTanggal());
        txtPaneTanggal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPaneTanggal.setFocusable(false);
        txtPaneTanggal.setOpaque(false);

        txtPaneWaktu.setEditable(false);
        txtPaneWaktu.setBackground(new java.awt.Color(255, 255, 255));
        txtPaneWaktu.setForeground(new java.awt.Color(0, 0, 0));
        txtPaneWaktu.setText("Waktu\t: "+getWaktu());
        txtPaneWaktu.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPaneWaktu.setFocusable(false);
        txtPaneWaktu.setOpaque(false);

        btnMasukkanPengumuman.setBackground(new java.awt.Color(51, 51, 51));
        btnMasukkanPengumuman.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnMasukkanPengumuman.setForeground(new java.awt.Color(255, 255, 255));
        btnMasukkanPengumuman.setText("Kirim Pengumuman");
        btnMasukkanPengumuman.setFocusPainted(false);
        btnMasukkanPengumuman.setPreferredSize(new java.awt.Dimension(100, 32));
        btnMasukkanPengumuman.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukkanPengumumanActionPerformed(evt);
            }
        });

        txtAreaPengumuman.setEditable(false);
        txtAreaPengumuman.setBackground(new java.awt.Color(255, 255, 255));
        txtAreaPengumuman.setColumns(20);
        txtAreaPengumuman.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtAreaPengumuman.setLineWrap(true);
        txtAreaPengumuman.setRows(5);
        txtAreaPengumuman.setWrapStyleWord(true);
        jScrollPanePengumuman.setViewportView(txtAreaPengumuman);

        txtAreaAktifitas.setEditable(false);
        txtAreaAktifitas.setBackground(new java.awt.Color(255, 255, 255));
        txtAreaAktifitas.setColumns(20);
        txtAreaAktifitas.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtAreaAktifitas.setLineWrap(true);
        txtAreaAktifitas.setRows(5);
        txtAreaAktifitas.setWrapStyleWord(true);
        jScrollPaneAktifitas.setViewportView(txtAreaAktifitas);

        panelLayerHome.setLayer(lblAktifitas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerHome.setLayer(lblPengumuman, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerHome.setLayer(lblJudulHome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerHome.setLayer(txtPaneTanggal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerHome.setLayer(txtPaneWaktu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerHome.setLayer(btnMasukkanPengumuman, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerHome.setLayer(jScrollPanePengumuman, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerHome.setLayer(jScrollPaneAktifitas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelLayerHomeLayout = new javax.swing.GroupLayout(panelLayerHome);
        panelLayerHome.setLayout(panelLayerHomeLayout);
        panelLayerHomeLayout.setHorizontalGroup(
            panelLayerHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayerHomeLayout.createSequentialGroup()
                .addGroup(panelLayerHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPaneTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPaneWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelLayerHomeLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelLayerHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPanePengumuman, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addComponent(lblPengumuman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(panelLayerHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneAktifitas, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addComponent(lblAktifitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
            .addGroup(panelLayerHomeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblJudulHome)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayerHomeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMasukkanPengumuman, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayerHomeLayout.setVerticalGroup(
            panelLayerHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayerHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJudulHome)
                .addGap(18, 18, 18)
                .addComponent(txtPaneTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPaneWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panelLayerHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPengumuman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAktifitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayerHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPanePengumuman, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addComponent(jScrollPaneAktifitas, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(btnMasukkanPengumuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        panelLayer.add(panelLayerHome, "card2");
        panelLayerHome.getAccessibleContext().setAccessibleParent(panelLayerHome);

        panelLayerManage.setMinimumSize(new java.awt.Dimension(641, 612));
        panelLayerManage.setOpaque(true);

        lblJudulManage.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblJudulManage.setForeground(new java.awt.Color(0, 0, 0));
        lblJudulManage.setText("Manajemen");

        cboSearchByManage.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboSearchByManage.setForeground(new java.awt.Color(0, 0, 0));
        cboSearchByManage.setMaximumRowCount(4);
        cboSearchByManage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Order", "Nama" }));
        cboSearchByManage.setOpaque(false);
        cboSearchByManage.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSearchByManageActionPerformed(evt);
            }
        });

        txtManageCari.setForeground(new java.awt.Color(0, 0, 0));
        txtManageCari.setOpaque(false);
        txtManageCari.setPreferredSize(new java.awt.Dimension(14, 26));

        btnManageCari.setBackground(new java.awt.Color(51, 51, 51));
        btnManageCari.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnManageCari.setForeground(new java.awt.Color(255, 255, 255));
        btnManageCari.setText("Cari");
        btnManageCari.setFocusPainted(false);
        btnManageCari.setPreferredSize(new java.awt.Dimension(100, 32));
        btnManageCari.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCariActionPerformed(evt);
            }
        });

        jTableManage.setAutoCreateRowSorter(true);
        jTableManage.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTableManage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No Order", "Nama", "Merek", "Harga", "Tanggal Kadaluarsa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableManage.setCellSelectionEnabled(true);
        jTableManage.setComponentPopupMenu(jPopupManage);
        jTableManage.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableManageMouseClicked(evt);
            }
        });
        jScrollPaneManage.setViewportView(jTableManage);

        btnManageSet.setBackground(new java.awt.Color(51, 51, 51));
        btnManageSet.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnManageSet.setForeground(new java.awt.Color(255, 255, 255));
        btnManageSet.setText("Set");
        btnManageSet.setFocusPainted(false);
        btnManageSet.setPreferredSize(new java.awt.Dimension(100, 32));
        btnManageSet.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageSetActionPerformed(evt);
            }
        });

        txtManageHarga.setForeground(new java.awt.Color(0, 0, 0));
        txtManageHarga.setOpaque(false);
        txtManageHarga.setPreferredSize(new java.awt.Dimension(14, 26));

        lblAturHarga.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblAturHarga.setForeground(new java.awt.Color(0, 0, 0));
        lblAturHarga.setText("Atur/Ubah Harga");

        btnManageReset.setBackground(new java.awt.Color(51, 51, 51));
        btnManageReset.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnManageReset.setForeground(new java.awt.Color(255, 255, 255));
        btnManageReset.setText("Reset");
        btnManageReset.setFocusPainted(false);
        btnManageReset.setPreferredSize(new java.awt.Dimension(100, 32));
        btnManageReset.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageResetActionPerformed(evt);
            }
        });

        panelLayerManage.setLayer(lblJudulManage, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerManage.setLayer(cboSearchByManage, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerManage.setLayer(txtManageCari, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerManage.setLayer(btnManageCari, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerManage.setLayer(jScrollPaneManage, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerManage.setLayer(btnManageSet, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerManage.setLayer(txtManageHarga, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerManage.setLayer(lblAturHarga, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerManage.setLayer(btnManageReset, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelLayerManageLayout = new javax.swing.GroupLayout(panelLayerManage);
        panelLayerManage.setLayout(panelLayerManageLayout);
        panelLayerManageLayout.setHorizontalGroup(
            panelLayerManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayerManageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblJudulManage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelLayerManageLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelLayerManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayerManageLayout.createSequentialGroup()
                        .addComponent(btnManageSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLayerManageLayout.createSequentialGroup()
                        .addGroup(panelLayerManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneManage, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                            .addGroup(panelLayerManageLayout.createSequentialGroup()
                                .addGroup(panelLayerManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblAturHarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboSearchByManage, 0, 109, Short.MAX_VALUE)
                                    .addComponent(btnManageCari, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(panelLayerManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtManageHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnManageReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtManageCari, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(50, 50, 50))))
        );
        panelLayerManageLayout.setVerticalGroup(
            panelLayerManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayerManageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJudulManage)
                .addGap(50, 50, 50)
                .addGroup(panelLayerManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboSearchByManage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtManageCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelLayerManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnManageCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManageReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelLayerManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAturHarga)
                    .addComponent(txtManageHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnManageSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPaneManage, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        panelLayer.add(panelLayerManage, "card3");
        panelLayerManage.getAccessibleContext().setAccessibleName("");
        panelLayerManage.getAccessibleContext().setAccessibleDescription("");
        panelLayerManage.getAccessibleContext().setAccessibleParent(panelLayerManage);

        panelLayerCatat.setBackground(new java.awt.Color(255, 255, 255));
        panelLayerCatat.setMinimumSize(new java.awt.Dimension(641, 612));
        panelLayerCatat.setName(""); // NOI18N
        panelLayerCatat.setOpaque(true);

        lblJudulCatat.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblJudulCatat.setForeground(new java.awt.Color(0, 0, 0));
        lblJudulCatat.setText("Catat Barang");

        txtCatatKodeOrder.setForeground(new java.awt.Color(0, 0, 0));
        txtCatatKodeOrder.setOpaque(false);
        txtCatatKodeOrder.setPreferredSize(new java.awt.Dimension(300, 30));
        txtCatatKodeOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCatatKodeOrderKeyPressed(evt);
            }
        });

        txtCatatNama.setForeground(new java.awt.Color(0, 0, 0));
        txtCatatNama.setOpaque(false);
        txtCatatNama.setPreferredSize(new java.awt.Dimension(300, 30));
        txtCatatNama.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCatatNamaKeyPressed(evt);
            }
        });

        txtCatatMerek.setForeground(new java.awt.Color(0, 0, 0));
        txtCatatMerek.setOpaque(false);
        txtCatatMerek.setPreferredSize(new java.awt.Dimension(300, 30));
        txtCatatMerek.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCatatMerekKeyPressed(evt);
            }
        });

        txtJumlah.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtJumlah.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        lblCatatKodeOrder.setBackground(java.awt.Color.white);
        lblCatatKodeOrder.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblCatatKodeOrder.setForeground(new java.awt.Color(0, 0, 0));
        lblCatatKodeOrder.setText("Kode Order");
        lblCatatKodeOrder.setPreferredSize(new java.awt.Dimension(125, 19));

        lblCatatNama.setBackground(java.awt.Color.white);
        lblCatatNama.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblCatatNama.setForeground(new java.awt.Color(0, 0, 0));
        lblCatatNama.setText("Nama");
        lblCatatNama.setPreferredSize(new java.awt.Dimension(125, 19));

        lblCatatMerek.setBackground(java.awt.Color.white);
        lblCatatMerek.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblCatatMerek.setForeground(new java.awt.Color(0, 0, 0));
        lblCatatMerek.setText("Merek");
        lblCatatMerek.setPreferredSize(new java.awt.Dimension(125, 19));

        lblCatatTanggalKadaluarsa.setBackground(java.awt.Color.white);
        lblCatatTanggalKadaluarsa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblCatatTanggalKadaluarsa.setForeground(new java.awt.Color(0, 0, 0));
        lblCatatTanggalKadaluarsa.setText("Tangal Kadaluarsa");
        lblCatatTanggalKadaluarsa.setPreferredSize(new java.awt.Dimension(125, 19));

        lblCatatJumlah.setBackground(java.awt.Color.white);
        lblCatatJumlah.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblCatatJumlah.setForeground(new java.awt.Color(0, 0, 0));
        lblCatatJumlah.setText("Jumlah Masuk");
        lblCatatJumlah.setPreferredSize(new java.awt.Dimension(125, 19));

        lblCatatTanggal.setBackground(java.awt.Color.white);
        lblCatatTanggal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblCatatTanggal.setForeground(new java.awt.Color(0, 0, 0));
        lblCatatTanggal.setText("Tanggal Masuk");
        lblCatatTanggal.setToolTipText("");
        lblCatatTanggal.setPreferredSize(new java.awt.Dimension(125, 19));

        btnCatatInput.setBackground(new java.awt.Color(51, 51, 51));
        btnCatatInput.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnCatatInput.setForeground(new java.awt.Color(255, 255, 255));
        btnCatatInput.setText("Input Data");
        btnCatatInput.setFocusPainted(false);
        btnCatatInput.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatatInputActionPerformed(evt);
            }
        });

        cboTipePencatatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Catat Masuk", "Catat Keluar" }));
        cboTipePencatatan.setToolTipText("");
        cboTipePencatatan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipePencatatanActionPerformed(evt);
            }
        });

        lblTipePencatatan.setBackground(java.awt.Color.white);
        lblTipePencatatan.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblTipePencatatan.setForeground(new java.awt.Color(0, 0, 0));
        lblTipePencatatan.setText("Tipe Pencatatan");
        lblTipePencatatan.setPreferredSize(new java.awt.Dimension(125, 19));

        txtCatatTglKadaluarsa.setDate(date
        );
        txtCatatTglKadaluarsa.setDateFormatString("yyyy/MM/dd");

        txtCatatTglMasuk.setDate(date
        );
        txtCatatTglMasuk.setDateFormatString("yyyy/MM/dd");

        panelLayerCatat.setLayer(lblJudulCatat, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCatat.setLayer(txtCatatKodeOrder, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCatat.setLayer(txtCatatNama, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCatat.setLayer(txtCatatMerek, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCatat.setLayer(txtJumlah, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCatat.setLayer(lblCatatKodeOrder, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCatat.setLayer(lblCatatNama, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCatat.setLayer(lblCatatMerek, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCatat.setLayer(lblCatatTanggalKadaluarsa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCatat.setLayer(lblCatatJumlah, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCatat.setLayer(lblCatatTanggal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCatat.setLayer(btnCatatInput, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCatat.setLayer(cboTipePencatatan, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCatat.setLayer(lblTipePencatatan, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCatat.setLayer(txtCatatTglKadaluarsa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCatat.setLayer(txtCatatTglMasuk, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelLayerCatatLayout = new javax.swing.GroupLayout(panelLayerCatat);
        panelLayerCatat.setLayout(panelLayerCatatLayout);
        panelLayerCatatLayout.setHorizontalGroup(
            panelLayerCatatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayerCatatLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(panelLayerCatatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayerCatatLayout.createSequentialGroup()
                        .addGroup(panelLayerCatatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCatatKodeOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCatatNama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCatatTanggalKadaluarsa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCatatTanggal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCatatJumlah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipePencatatan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayerCatatLayout.createSequentialGroup()
                        .addComponent(lblCatatMerek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(panelLayerCatatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCatatMerek, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addComponent(txtCatatNama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addComponent(txtCatatKodeOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addGroup(panelLayerCatatLayout.createSequentialGroup()
                        .addGroup(panelLayerCatatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboTipePencatatan, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtCatatTglKadaluarsa, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addComponent(txtCatatTglMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(panelLayerCatatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayerCatatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCatatInput)
                    .addComponent(lblJudulCatat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayerCatatLayout.setVerticalGroup(
            panelLayerCatatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayerCatatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJudulCatat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(panelLayerCatatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTipePencatatan)
                    .addComponent(lblTipePencatatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelLayerCatatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCatatKodeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCatatKodeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelLayerCatatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCatatNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCatatNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelLayerCatatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCatatMerek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCatatMerek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelLayerCatatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCatatJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelLayerCatatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCatatTanggalKadaluarsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCatatTglKadaluarsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelLayerCatatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCatatTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCatatTglMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(btnCatatInput)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        panelLayerCatatLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCatatKodeOrder, txtCatatMerek, txtCatatNama, txtCatatTglKadaluarsa, txtCatatTglMasuk});

        panelLayer.add(panelLayerCatat, "card4");

        panelLayerCari.setBackground(new java.awt.Color(255, 255, 255));
        panelLayerCari.setMinimumSize(new java.awt.Dimension(641, 612));
        panelLayerCari.setOpaque(true);

        lblJudulCari.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblJudulCari.setForeground(new java.awt.Color(0, 0, 0));
        lblJudulCari.setText("Info Barang");

        cboSearchBy.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboSearchBy.setForeground(new java.awt.Color(0, 0, 0));
        cboSearchBy.setMaximumRowCount(4);
        cboSearchBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kode Order", "Nama", "Tanggal Kadaluarsa" }));
        cboSearchBy.setOpaque(false);

        txtCariSearchBy.setForeground(new java.awt.Color(0, 0, 0));
        txtCariSearchBy.setOpaque(false);
        txtCariSearchBy.setPreferredSize(new java.awt.Dimension(14, 26));

        btnCari.setBackground(new java.awt.Color(51, 51, 51));
        btnCari.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnCari.setForeground(new java.awt.Color(255, 255, 255));
        btnCari.setText("Cari");
        btnCari.setFocusPainted(false);
        btnCari.setPreferredSize(new java.awt.Dimension(100, 32));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jTableCari.setAutoCreateRowSorter(true);
        jTableCari.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTableCari.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No Order", "Nama", "Merek", "Jumlah", "Tanggal Kadaluarsa", "Tanggal Masuk"
            }
        ));
        jTableCari.setCellSelectionEnabled(true);
        jTableCari.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableCari.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCariMouseClicked(evt);
            }
        });
        jScrollPaneCari.setViewportView(jTableCari);

        btnReset.setBackground(new java.awt.Color(51, 51, 51));
        btnReset.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.setFocusPainted(false);
        btnReset.setPreferredSize(new java.awt.Dimension(100, 32));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        panelLayerCari.setLayer(lblJudulCari, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCari.setLayer(cboSearchBy, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCari.setLayer(txtCariSearchBy, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCari.setLayer(btnCari, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCari.setLayer(jScrollPaneCari, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelLayerCari.setLayer(btnReset, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelLayerCariLayout = new javax.swing.GroupLayout(panelLayerCari);
        panelLayerCari.setLayout(panelLayerCariLayout);
        panelLayerCariLayout.setHorizontalGroup(
            panelLayerCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayerCariLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelLayerCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayerCariLayout.createSequentialGroup()
                        .addGroup(panelLayerCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPaneCari)
                            .addGroup(panelLayerCariLayout.createSequentialGroup()
                                .addComponent(cboSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtCariSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)))
                        .addGap(50, 50, 50))
                    .addGroup(panelLayerCariLayout.createSequentialGroup()
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panelLayerCariLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblJudulCari)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayerCariLayout.setVerticalGroup(
            panelLayerCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayerCariLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJudulCari)
                .addGap(50, 50, 50)
                .addGroup(panelLayerCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCariSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelLayerCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPaneCari, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        panelLayer.add(panelLayerCari, "card5");
        panelLayerCari.getAccessibleContext().setAccessibleParent(panelLayerCari);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelLayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("Sistem Informasi Toko Ratna MD");

        pack();
        setLocationRelativeTo(null);
        
        Koneksi DB = new Koneksi();
        DB.bukaKoneksi();
        con = DB.con;
        stat = DB.stm;
        
        checkAdmin();
        
        this.panelLayerHome.setVisible(true);
        this.panelLayerCari.setVisible(false);
        this.panelLayerCatat.setVisible(false);
        this.panelLayerManage.setVisible(false);
        
        updateTime();
        pack();
        new Timer(1000, this).start();
        
        showAktifitas();
        
        showPengumuman();
        
        TampilTabelCari();
        
        TampilTabelManage();

    }

    private void TampilTabelCari() {
        try {
            Koneksi ObjKoneksi = new Koneksi();
            Connection con = ObjKoneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT tb_gudang.kode_order as 'Kode Order', nama_brg as 'Nama', merek_brg as 'Merek', jumlah_brg as 'Jumlah Masuk' , tb_gudang.stock as 'Stock Gudang', tgl_kadaluarsa as 'Tanggal Kadaluarsa', tb_gudang.tgl_masuk as 'Tanggal Masuk' \n"
                    + "FROM tb_gudang, tb_barang \n"
                    + "INNER JOIN tb_gudang AS gudang\n"
                    + "   ON tb_barang.kode_order = gudang.kode_order\n"
                    + "WHERE tb_gudang.kode_order=tb_barang.kode_order";
            ResultSet set = st.executeQuery(sql);
            //menampilkan data ke Tabel
            ResultSetTableModel model = new ResultSetTableModel(set);
            jTableCari.setModel(model);

            while (set.next()) {

            }
        } catch (SQLException e) {
            System.out.println("gagal query - " + e);
        }
    }

    private void TampilTabelManage() {
        try {
            Koneksi ObjKoneksi = new Koneksi();
            Connection con = ObjKoneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT tb_harga.kode_order , tb_barang.nama_brg , tb_barang.merek_brg , tb_harga.harga_brg , tb_barang.tgl_kadaluarsa\n"
                    + "FROM tb_barang, tb_harga \n"
                    + "INNER JOIN tb_barang AS barang\n"
                    + "   ON barang.kode_order = tb_harga.kode_order\n"
                    + "WHERE tb_barang.kode_order = tb_harga.kode_order";
            ResultSet set = st.executeQuery(sql);
            //menampilkan data ke Tabel
            ResultSetTableModel model = new ResultSetTableModel(set);
            jTableManage.setModel(model);

            while (set.next()) {

            }
        } catch (SQLException e) {
            System.out.println("gagal query - " + e);
        }
    }

    public void updateTime() {
        calendar.setTimeInMillis(System.currentTimeMillis()); //Update the calendar's time
    }

    public String getTanggal() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getWaktu() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateTime(); //Update time
        txtPaneTanggal.setText("Tanggal\t: " + getTanggal());
        txtPaneWaktu.setText("Waktu\t: " + getWaktu());
        repaint(); //Update gui
    }

    private void showAktifitas() {
        try {
            sql = "SELECT aktifitas FROM tostring WHERE no = '1';";
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                txtAreaAktifitas.setText(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void showPengumuman() {
        try {
            sql = "SELECT pengumuman FROM tostring WHERE no = '2';";
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                txtAreaPengumuman.setText(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void checkAdmin() {

        txtAreaAktifitas.setVisible(LoginFrame.admin);
        jScrollPaneAktifitas.setVisible(LoginFrame.admin);
        lblAktifitas.setVisible(LoginFrame.admin);
        lblManage.setVisible(LoginFrame.admin);
        btnMasukkanPengumuman.setVisible(LoginFrame.admin);
        if (LoginFrame.admin) {
            txtAreaPengumuman.setEditable(LoginFrame.admin);
        }

    }

    public int getNumberRows() {
        try {
            sql = "SELECT * FROM tb_gudang";
            rs = stat.executeQuery(sql);
            if (rs.last()) {
                return rs.getRow();
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("Error getting row count - " + e);
        }
        return 0;
    }                      

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {                                          
        javax.swing.JOptionPane.showMessageDialog(null, "Anda Akan Keluar");
        this.dispose();
        try {
            new LoginFrame().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                         

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {                                     
        this.panelLayerHome.setVisible(true);
        this.panelLayerCari.setVisible(false);
        this.panelLayerCatat.setVisible(false);
        this.panelLayerManage.setVisible(false);
    }                                    

    private void lblInfoMouseClicked(java.awt.event.MouseEvent evt) {                                     
        this.panelLayerHome.setVisible(false);
        this.panelLayerCari.setVisible(true);
        this.panelLayerCatat.setVisible(false);
        this.panelLayerManage.setVisible(false);
    }                                    

    private void lblCatatMouseClicked(java.awt.event.MouseEvent evt) {                                      
        this.panelLayerHome.setVisible(false);
        this.panelLayerCari.setVisible(false);
        this.panelLayerCatat.setVisible(true);
        this.panelLayerManage.setVisible(false);
    }                                     

    private void lblHomeMouseEntered(java.awt.event.MouseEvent evt) {                                     
        lblHome.setBackground(new Color(102, 204, 255).darker());
    }                                    

    private void lblHomeMouseExited(java.awt.event.MouseEvent evt) {                                    
        lblHome.setBackground(new Color(102, 204, 255));
    }                                   

    private void lblInfoMouseEntered(java.awt.event.MouseEvent evt) {                                     
        lblInfo.setBackground(new Color(102, 204, 255).darker());
    }                                    

    private void lblCatatMouseEntered(java.awt.event.MouseEvent evt) {                                      
        lblCatat.setBackground(new Color(102, 204, 255).darker());
    }                                     

    private void lblInfoMouseExited(java.awt.event.MouseEvent evt) {                                    
        lblInfo.setBackground(new Color(102, 204, 255));
    }                                   

    private void lblCatatMouseExited(java.awt.event.MouseEvent evt) {                                     
        lblCatat.setBackground(new Color(102, 204, 255));
    }                                              

    private void lblManageMouseClicked(java.awt.event.MouseEvent evt) {                                       
        this.panelLayerHome.setVisible(false);
        this.panelLayerCari.setVisible(false);
        this.panelLayerCatat.setVisible(false);
        this.panelLayerManage.setVisible(true);
    }                                      

    private void lblManageMouseEntered(java.awt.event.MouseEvent evt) {                                       
        lblManage.setBackground(new Color(102, 204, 255).darker());
    }                                      

    private void lblManageMouseExited(java.awt.event.MouseEvent evt) {                                      
        lblManage.setBackground(new Color(102, 204, 255));
    }                                     

    private void cboSearchByManageActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        if (cboSearchByManage.getSelectedIndex() == 1)
            txtManageCari.setText("Saat ingin merubah harga, Isi hanya dengan kode order");
        else if (cboSearchByManage.getSelectedIndex() == 0)
            txtManageCari.setText("");
    }                                                 

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {                                      
        btnLogout.setBackground(Color.white);
    }                                     

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {                                       
        btnLogout.setBackground(Color.LIGHT_GRAY.darker());
    }                                      

    private void btnMasukkanPengumumanActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        try {
            sql = "UPDATE tostring SET pengumuman ='" + txtAreaPengumuman.getText() + "'" + "WHERE no ='2';";
            int row = stat.executeUpdate(sql);
            if (row == 1) {
                JOptionPane.showMessageDialog(this, "Pengumuman Telah Dikirim",
                        "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                showPengumuman();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Data tidak ditambahkan ke database ( Error - " + e.getMessage() + " )",
                    "Infomasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }                                                     

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (txtCariSearchBy.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Field tidak boleh kosong!!",
                    "Infomasi", JOptionPane.INFORMATION_MESSAGE);
        } else if (cboSearchBy.getSelectedIndex() == 0) {
            try {
                Koneksi ObjKoneksi = new Koneksi();
                Connection con = ObjKoneksi.bukaKoneksi();
                Statement st = con.createStatement();
                String sql = "SELECT tb_gudang.kode_order as 'Kode Order', nama_brg as 'Nama', merek_brg as 'Merek', jumlah_brg as 'Jumlah Masuk' , tb_gudang.stock as 'Stock Gudang', tgl_kadaluarsa as 'Tanggal Kadaluarsa', tb_gudang.tgl_masuk as 'Tanggal Masuk' "
                        + "FROM tb_gudang, tb_barang \n"
                        + "INNER JOIN tb_gudang AS gudang\n"
                        + "   ON tb_barang.kode_order = gudang.kode_order\n"
                        + "WHERE tb_gudang.kode_order=tb_barang.kode_order and tb_gudang.kode_order='" + txtCariSearchBy.getText() + "'";
                ResultSet set = st.executeQuery(sql);
                //menampilkan data ke Tabel
                ResultSetTableModel model = new ResultSetTableModel(set);
                jTableCari.setModel(model);

                while (set.next()) {

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Data tidak ditambahkan ke database ( Error - " + e.getMessage() + " )",
                        "Infomasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (cboSearchBy.getSelectedIndex() == 1) {
            try {
                Koneksi ObjKoneksi = new Koneksi();
                Connection con = ObjKoneksi.bukaKoneksi();
                Statement st = con.createStatement();
                String sql = "SELECT tb_gudang.kode_order as 'Kode Order', nama_brg as 'Nama', merek_brg as 'Merek', jumlah_brg as 'Jumlah Masuk' , tb_gudang.stock as 'Stock Gudang', tgl_kadaluarsa as 'Tanggal Kadaluarsa', tb_gudang.tgl_masuk as 'Tanggal Masuk' "
                        + "FROM tb_gudang, tb_barang \n"
                        + "INNER JOIN tb_gudang AS gudang\n"
                        + "   ON tb_barang.kode_order = gudang.kode_order\n"
                        + "WHERE tb_gudang.kode_order=tb_barang.kode_order and nama_brg='" + txtCariSearchBy.getText() + "'";
                ResultSet set = st.executeQuery(sql);
                //menampilkan data ke Tabel
                ResultSetTableModel model = new ResultSetTableModel(set);
                jTableCari.setModel(model);

                while (set.next()) {

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Data tidak ditambahkan ke database ( Error - " + e.getMessage() + " )",
                        "Infomasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (cboSearchBy.getSelectedIndex() == 2) {
            try {
                Koneksi ObjKoneksi = new Koneksi();
                Connection con = ObjKoneksi.bukaKoneksi();
                Statement st = con.createStatement();
                String sql = "SELECT tb_gudang.kode_order as 'Kode Order', nama_brg as 'Nama', merek_brg as 'Merek', jumlah_brg as 'Jumlah Masuk' , tb_gudang.stock as 'Stock Gudang', tgl_kadaluarsa as 'Tanggal Kadaluarsa', tb_gudang.tgl_masuk as 'Tanggal Masuk' "
                        + "FROM tb_gudang, tb_barang \n"
                        + "INNER JOIN tb_gudang AS gudang\n"
                        + "   ON tb_barang.kode_order = gudang.kode_order\n"
                        + "WHERE tb_gudang.kode_order=tb_barang.kode_order and tgl_kadaluarsa='" + txtCariSearchBy.getText() + "'";
                ResultSet set = st.executeQuery(sql);
                //menampilkan data ke Tabel
                ResultSetTableModel model = new ResultSetTableModel(set);
                jTableCari.setModel(model);

                while (set.next()) {

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Data tidak ditambahkan ke database ( Error - " + e.getMessage() + " )",
                        "Infomasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }                                       

    private void btnManageSetActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if (txtManageCari.getText().equals("") || txtManageHarga.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong",
                    "Infomasi", JOptionPane.INFORMATION_MESSAGE);
        } else if (cboSearchByManage.getSelectedIndex() == 0) {
            try {
                sql = "UPDATE tb_harga SET id_admin = '" + LoginFrame.id_admin + "',harga_brg ='" + txtManageHarga.getText() + "'" + " WHERE kode_order  ='" + txtManageCari.getText() + "';";
                int row = stat.executeUpdate(sql);
                if (row == 1) {
                    JOptionPane.showMessageDialog(this, "Harga Telah Di-Update",
                            "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                    showPengumuman();
                } else {
                    JOptionPane.showMessageDialog(this, "Harga Tidak Di-Update, Mohon memasukkan Kode Order dengan angka",
                            "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Data tidak ditambahkan ke database ( Error - " + e.getMessage() + " )",
                        "Infomasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (cboSearchByManage.getSelectedIndex() == 1) {
            try {
                sql = "UPDATE tb_harga SET id_admin = '" + LoginFrame.id_admin + "' ,harga_brg ='" + txtManageHarga.getText() + "'" + " WHERE kode_order  ='" + txtManageCari.getText() + "';";
                int row = stat.executeUpdate(sql);
                if (row == 1) {
                    JOptionPane.showMessageDialog(this, "Harga Telah Di-Update",
                            "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                    showPengumuman();
                } else {
                    JOptionPane.showMessageDialog(this, "Harga Tidak Di-Update, Mohon memasukkan Kode Order dengan angka",
                            "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Data tidak ditambahkan ke database, Mohon memasukkan Kode Order dengan Benar ( Error - " + e.getMessage() + " )",
                        "Infomasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        TampilTabelManage();
        TampilTabelCari();
    }                                            

    private void btnManageResetActionPerformed(java.awt.event.ActionEvent evt) {                                               
        txtManageCari.setText("");
        txtManageHarga.setText("");
        TampilTabelManage();
    }                                              

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {                                         
        TampilTabelCari();
    }                                        

    private void btnManageCariActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if (txtManageCari.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Field tidak boleh kosong!!",
                    "Infomasi", JOptionPane.INFORMATION_MESSAGE);
        } else if (cboSearchByManage.getSelectedIndex() == 0) {
            try {
                Koneksi ObjKoneksi = new Koneksi();
                Connection con = ObjKoneksi.bukaKoneksi();
                Statement st = con.createStatement();
                String sql = "SELECT tb_harga.kode_order , tb_barang.nama_brg , tb_barang.merek_brg , tb_harga.harga_brg , tb_barang.tgl_kadaluarsa\n"
                        + "FROM tb_barang, tb_harga \n"
                        + "INNER JOIN tb_barang AS barang\n"
                        + "   ON barang.kode_order = tb_harga.kode_order\n"
                        + "WHERE tb_barang.kode_order = tb_harga.kode_order and tb_barang.kode_order='" + txtManageCari.getText() + "'";
                ResultSet set = st.executeQuery(sql);
                //menampilkan data ke Tabel
                ResultSetTableModel model = new ResultSetTableModel(set);
                jTableManage.setModel(model);

                while (set.next()) {

                }
            } catch (SQLException e) {
                System.out.println("gagal query - " + e);
            }
        } else if (cboSearchByManage.getSelectedIndex() == 1) {
            try {
                Koneksi ObjKoneksi = new Koneksi();
                Connection con = ObjKoneksi.bukaKoneksi();
                Statement st = con.createStatement();
                String sql = "SELECT tb_harga.kode_order , tb_barang.nama_brg , tb_barang.merek_brg , tb_harga.harga_brg , tb_barang.tgl_kadaluarsa\n"
                        + "FROM tb_barang, tb_harga \n"
                        + "INNER JOIN tb_barang AS barang\n"
                        + "   ON barang.kode_order = tb_harga.kode_order\n"
                        + "WHERE tb_barang.kode_order = tb_harga.kode_order and tb_barang.nama_brg='" + txtManageCari.getText() + "'";
                ResultSet set = st.executeQuery(sql);
                //menampilkan data ke Tabel
                ResultSetTableModel model = new ResultSetTableModel(set);
                jTableManage.setModel(model);

                while (set.next()) {

                }
            } catch (SQLException e) {
                System.out.println("gagal query - " + e);
            }
        }
    }                                             

    private void jTableManageMouseClicked(java.awt.event.MouseEvent evt) {                                          
        ResultSetTableModel model = (ResultSetTableModel) jTableManage.getModel();
        int selectedRowIdx = jTableManage.getSelectedRow();

        try {
            txtManageCari.setText(model.getValueAt(selectedRowIdx, 0).toString());
            if (model.getValueAt(selectedRowIdx, 3) == null) {
                txtManageHarga.setText("");
            } else {
                txtManageHarga.setText(model.getValueAt(selectedRowIdx, 3).toString());
            }
        } catch (Exception e) {

        }

    }                                         

    private void menuHapusActionPerformed(java.awt.event.ActionEvent evt) {                                          
        ResultSetTableModel model = (ResultSetTableModel) jTableManage.getModel();
        int selectedRowIdx = jTableManage.getSelectedRow();

        if (txtManageCari.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tidak ada data yang dipilih!",
                    "Infomasi", JOptionPane.INFORMATION_MESSAGE);
        } else if (cboSearchByManage.getSelectedIndex() == 0) {
            try {
                sql = "DELETE FROM tb_barang WHERE kode_order = '" + model.getValueAt(selectedRowIdx, 0).toString() + "';";
                int row = stat.executeUpdate(sql);
                if (row == 1) {
                    JOptionPane.showMessageDialog(this, "Barang Telah Di-Hapus",
                            "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                    showPengumuman();
                } else {
                    JOptionPane.showMessageDialog(this, "Barang Tidak Di-Hapus, Mohon memasukkan Kode Order dengan angka",
                            "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Data tidak ditambahkan ke database ( Error - " + e.getMessage() + " )",
                        "Infomasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (cboSearchByManage.getSelectedIndex() == 1) {
            try {
                sql = "DELETE FROM tb_barang WHERE nama_brg = '" + model.getValueAt(selectedRowIdx, 1).toString() + "';";
                int row = stat.executeUpdate(sql);
                if (row == 1) {
                    JOptionPane.showMessageDialog(this, "Harga Telah Di-Update",
                            "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Barang Tidak Di-Hapus, Mohon memasukkan Kode Order dengan nama barang",
                            "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Data tidak ditambahkan ke database, Mohon memasukkan Kode Order dengan Benar ( Error - " + e.getMessage() + " )",
                        "Infomasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        TampilTabelManage();
        TampilTabelCari();
    }                                         

    private void menuRefreshActionPerformed(java.awt.event.ActionEvent evt) {                                            
        txtManageCari.setText("");
        txtManageHarga.setText("");
        TampilTabelManage();
        TampilTabelCari();
        revalidate();
    }                                           

    private void menuHargaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        ResultSetTableModel model = (ResultSetTableModel) jTableManage.getModel();
        int selectedRowIdx = jTableManage.getSelectedRow();

        if (txtManageCari.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tidak ada data yang dipilih!",
                    "Infomasi", JOptionPane.INFORMATION_MESSAGE);
        } else {

            int Harga;
            if (model.getValueAt(selectedRowIdx, 3) == null){
                Harga = 0;
            } else {
                Harga = Integer.parseInt(model.getValueAt(selectedRowIdx, 3).toString());
            }
            boolean Message = false;

            try {
                Harga = Integer.parseInt(JOptionPane.showInputDialog(this, "Masukkan Harga", "Infomasi", JOptionPane.INFORMATION_MESSAGE));
                Message = true;
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Harga Tidak Di-Update, Silahkan Memasukkan Data Angka",
                        "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                Message = false;
            }

            try {
                sql = "UPDATE tb_harga SET id_admin = '" + LoginFrame.id_admin + "',harga_brg ='" + Harga + "'" + " WHERE kode_order  ='" + model.getValueAt(selectedRowIdx, 0).toString() + "';";
                int row = stat.executeUpdate(sql);
                if (row == 1) {
                    if (Message) {
                        JOptionPane.showMessageDialog(this, "Harga Telah Di-Update",
                                "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                    }
                    txtManageHarga.setText(Integer.toString(Harga));
                } else {
                    JOptionPane.showMessageDialog(this, "Harga Tidak Di-Update, Silahkan Memasukkan Data Angka",
                            "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Data tidak ditambahkan ke database ( Error - " + e.getMessage() + " )",
                        "Infomasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        TampilTabelManage();
    }                                         

    private void jTableCariMouseClicked(java.awt.event.MouseEvent evt) {                                        
        ResultSetTableModel model = (ResultSetTableModel) jTableCari.getModel();
        int selectedRowIdx = jTableCari.getSelectedRow();
        int index = 0;
        switch (cboSearchBy.getSelectedIndex()) {
            case 0:
                index = 0;
                break;
            case 1:
                index = 1;
                break;
            case 2:
                index = 5;
                break;
            default:
                break;
        }
        try {
            if (model.getValueAt(selectedRowIdx, index) == null) {
                txtCariSearchBy.setText("");
            } else {
                txtCariSearchBy.setText(model.getValueAt(selectedRowIdx, index).toString());
            }
        } catch (Exception e) {

        }
    }                                       

    private void cboTipePencatatanActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        if (cboTipePencatatan.getSelectedIndex() == 0) {
            lblCatatTanggal.setText("Tanggal Masuk");
            lblCatatJumlah.setText("Jumlah Masuk");
            lblCatatNama.setVisible(true);
            txtCatatNama.setVisible(true);
            lblCatatMerek.setVisible(true);
            txtCatatMerek.setVisible(true);
            lblCatatTanggalKadaluarsa.setVisible(true);
            txtCatatTglKadaluarsa.setVisible(true);
        } else if (cboTipePencatatan.getSelectedIndex() == 1) {
            lblCatatTanggal.setText("Tanggal Keluar");
            lblCatatJumlah.setText("Jumlah Keluar");
            lblCatatNama.setVisible(false);
            txtCatatNama.setVisible(false);
            lblCatatMerek.setVisible(false);
            txtCatatMerek.setVisible(false);
            lblCatatTanggalKadaluarsa.setVisible(false);
            txtCatatTglKadaluarsa.setVisible(false);
        }
    }                                                 

    private void btnCatatInputActionPerformed(java.awt.event.ActionEvent evt) {                                              
        txtCatatKodeOrder.requestFocus();
        if (cboTipePencatatan.getSelectedIndex() == 0) {
            try {
                if (LoginFrame.admin == false) {
                    sql = "INSERT INTO tb_barang (kode_order,nama_brg,merek_brg,jumlah_brg,tgl_kadaluarsa,id_user)"
                            + "VALUES ('" + txtCatatKodeOrder.getText() + "','" + txtCatatNama.getText() + "','" + txtCatatMerek.getText() + "','" + txtJumlah.getValue() + "','" + dateFormat.format(txtCatatTglKadaluarsa.getDate()) + "','" + LoginFrame.id_user + "');";
                    int row = stat.executeUpdate(sql);
                    if (row == 1) {
                        sql = "INSERT INTO tb_aktifitas (id_user,aktifitas,tanggal,waktu)"
                                + "VALUES ('" + LoginFrame.id_user + "','" + "Telah menambahkan barang (" + txtCatatKodeOrder.getText() + " / " + txtCatatNama.getText() + ")','" + getTanggal() + "','" + getWaktu() + "');";
                        int row2 = stat.executeUpdate(sql);
                        if (row2 == 1) {
                            sql = "SELECT * FROM tb_aktifitas ORDER BY no_aktifitas DESC ;";
                            rs = stat.executeQuery(sql);
                            if (rs.next()) {
                                txtAreaAktifitas.append("+ " + rs.getString(4) + " " + rs.getString(5) + " : " + rs.getString(2) + " " + rs.getString(3) + "\n\n");
                                sql = "UPDATE tostring SET aktifitas ='" + txtAreaAktifitas.getText() + "'" + "WHERE no  ='1';";
                                int row4 = stat.executeUpdate(sql);
                                if (row4 == 1) {
                                    showAktifitas();
                                }
                            }
                        }
                        try {
                            sql = "INSERT INTO tb_gudang (kode_order,tgl_masuk,stock)"
                                    + "VALUES ('" + txtCatatKodeOrder.getText() + "','" + dateFormat.format(txtCatatTglMasuk.getDate()) + "','" + txtJumlah.getValue() + "');";
                            int row3 = stat.executeUpdate(sql);
                            if (row3 == 1) {
                                try {
                                    sql = "INSERT INTO tb_harga (kode_order)"
                                            + "VALUES ('" + txtCatatKodeOrder.getText() + "');";
                                    int row4 = stat.executeUpdate(sql);
                                    if (row4 == 1) {
                                        JOptionPane.showMessageDialog(null, "Data sudah ditambahkan ke database",
                                                "infomasi", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    txtCatatKodeOrder.setText("");
                                    txtCatatNama.setText("");
                                    txtCatatMerek.setText("");
                                    txtJumlah.setValue(1);
                                    panelLayerCari.repaint();
                                } catch (HeadlessException | SQLException e) {
                                    JOptionPane.showMessageDialog(this, "Data tidak ditambahkan ke database ( Error - " + e.getMessage() + " )",
                                            "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(this, "Data tidak ditambahkan ke database ( Error - " + e.getMessage() + " )",
                                    "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else if (LoginFrame.admin == true) {
                    sql = "INSERT INTO tb_barang (kode_order,nama_brg,merek_brg,jumlah_brg,tgl_kadaluarsa)"
                            + "VALUES ('" + txtCatatKodeOrder.getText() + "','" + txtCatatNama.getText() + "','" + txtCatatMerek.getText() + "','" + txtJumlah.getValue() + "','" + dateFormat.format(txtCatatTglKadaluarsa.getDate()) + "');";
                    int row = stat.executeUpdate(sql);
                    if (row == 1) {
                        try {
                            sql = "INSERT INTO tb_gudang (kode_order,tgl_masuk,stock)"
                                    + "VALUES ('" + txtCatatKodeOrder.getText() + "','" + dateFormat.format(txtCatatTglMasuk.getDate()) + "','" + txtJumlah.getValue() + "');";
                            int row2 = stat.executeUpdate(sql);
                            if (row2 == 1) {
                                try {
                                    sql = "INSERT INTO tb_harga (kode_order)"
                                            + "VALUES ('" + txtCatatKodeOrder.getText() + "');";
                                    int row4 = stat.executeUpdate(sql);
                                    if (row4 == 1) {
                                        JOptionPane.showMessageDialog(null, "Data sudah ditambahkan ke database",
                                                "infomasi", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    txtCatatKodeOrder.setText("");
                                    txtCatatNama.setText("");
                                    txtCatatMerek.setText("");
                                    txtJumlah.setValue(1);
                                    panelLayerCari.repaint();
                                } catch (HeadlessException | SQLException e) {
                                    JOptionPane.showMessageDialog(this, "Data tidak ditambahkan ke database ( Error - " + e.getMessage() + " )",
                                            "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(this, "Data tidak ditambahkan ke database ( Error - " + e.getMessage() + " )",
                                    "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Data tidak ditambahkan ke database ( Error - " + e.getMessage() + " )",
                        "Infomasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (cboTipePencatatan.getSelectedIndex() == 1) {
            try {
                if (LoginFrame.admin == false) {
                    sql = "INSERT INTO tb_toko (kode_order,jumlah_keluar,tgl_keluar,id_user)"
                            + "VALUES ('" + txtCatatKodeOrder.getText() + "','" + txtJumlah.getValue() + "','" + dateFormat.format(txtCatatTglMasuk.getDate()) + "','" + LoginFrame.id_user + "');";
                    int row = stat.executeUpdate(sql);
                    if (row == 1) {

                    }
                    sql = "SELECT * FROM tb_toko ORDER BY no DESC ;";
                    rs = stat.executeQuery(sql);
                    if (rs.next()) {
                        DbJmlBrgKel = rs.getInt(4);

                        sql = "INSERT INTO tb_aktifitas (id_user,aktifitas,tanggal,waktu)"
                                + "VALUES ('" + LoginFrame.id_user + "','" + "Telah mengeluarkan barang dari Gudang (" + txtCatatKodeOrder.getText() + " , dengan jumlah keluar : " + txtJumlah.getValue() + ")','" + getTanggal() + "','" + getWaktu() + "');";
                        int row2 = stat.executeUpdate(sql);
                        if (row2 == 1) {
                            sql = "SELECT * FROM tb_aktifitas ORDER BY no_aktifitas DESC ;";
                            rs = stat.executeQuery(sql);
                            if (rs.next()) {
                                txtAreaAktifitas.append("- " + rs.getString(4) + " " + rs.getString(5) + " : " + rs.getString(2) + " " + rs.getString(3) + "\n\n");
                                sql = "UPDATE tostring SET aktifitas ='" + txtAreaAktifitas.getText() + "'" + "WHERE no  ='1';";
                                int row4 = stat.executeUpdate(sql);
                                if (row4 == 1) {
                                    showAktifitas();
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Jumlah Salah", "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (LoginFrame.admin == true) {
                    sql = "INSERT INTO tb_toko (kode_order,jumlah_keluar,tgl_keluar)"
                            + "VALUES ('" + txtCatatKodeOrder.getText() + "','" + txtJumlah.getValue() + "','" + dateFormat.format(txtCatatTglMasuk.getDate()) + "');";
                    int row = stat.executeUpdate(sql);
                    if (row == 1) {

                    }
                    sql = "SELECT * FROM tb_toko ORDER BY no DESC ;";
                    rs = stat.executeQuery(sql);
                    if (rs.next()) {
                        DbJmlBrgKel = rs.getInt(4);
                    } else {
                        JOptionPane.showMessageDialog(null, "Jumlah Salah", "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Data tidak ditambahkan ke database ( Error - " + e.getMessage() + " )",
                        "Infomasi", JOptionPane.INFORMATION_MESSAGE);
            }
            try {
                sql = "SELECT * FROM tb_gudang WHERE kode_order ='" + txtCatatKodeOrder.getText() + "' ;";
                rs = stat.executeQuery(sql);
                if (rs.next()) {
                    DbJmlBrgMas = rs.getInt(4);
                } else {
                    JOptionPane.showMessageDialog(null, "Jumlah Salah", "Infomasi", JOptionPane.INFORMATION_MESSAGE);
                }
                sql = "UPDATE tb_gudang SET stock ='" + (DbJmlBrgMas - DbJmlBrgKel) + "'" + "WHERE kode_order ='" + txtCatatKodeOrder.getText() + "';";
                int row = stat.executeUpdate(sql);
                if (row == 1) {
                    JOptionPane.showMessageDialog(null, "Data stock sudah di update ",
                            "infomasi", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Data tidak ditambahkan ke database ( Error - " + e.getMessage() + " )",
                        "Infomasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        TampilTabelCari();
        TampilTabelManage();
    }                                              

    private void txtCatatMerekKeyPressed(java.awt.event.KeyEvent evt) {                                         
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            txtCatatTglKadaluarsa.getCalendarButton().doClick();
    }                                        

    private void txtCatatNamaKeyPressed(java.awt.event.KeyEvent evt) {                                        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            txtCatatMerek.requestFocus();
    }                                       

    private void txtCatatKodeOrderKeyPressed(java.awt.event.KeyEvent evt) {                                             
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            txtCatatNama.requestFocus();
    }                                                         

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String args[]) throws SQLException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }                 
}
