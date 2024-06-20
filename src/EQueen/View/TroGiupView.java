package EQueen.View;

import EQueen.View.noticeboard.ModelNoticeBoard;
import EQueen.View.noticeboard.ScrollBarCustom;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class TroGiupView extends javax.swing.JFrame {

    public TroGiupView() {
        initComponents();
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        panel.setLayout(new MigLayout("nogrid, fillx"));
        initNoticeBoard();
    }

    private void initNoticeBoard() {
        //addTitle("Giới thiệu về trò chơi ");
        addNoticeBoard(new ModelNoticeBoard(new Color(94, 49, 238), "Chơi ngay", "Chức năng chính", "     Khi người chơi đặt trước một số quân cờ, chức năng này sẽ tìm ra số nước cờ còn lại. Đối với bài toán ”8 quân hậu”, sau khi đặt trước một số a quân hậu, chức năng ”Chơi ngay” sẽ tìm thấy N - a số quân hậu còn lại đặt đúng vị trí trên bàn cờ. Đối với ”Mã đi tuần”, chức năng này sẽ tìm ra các bước đi còn lại của quân mã để đi được hết bàn cờ."));
        addNoticeBoard(new ModelNoticeBoard(new Color(218, 49, 238), "Quay lại", " ", "     Chức năng này cho phép người chơi quay lại nước đi trước đó. Chức năng này không hoạt động khi không còn quân nào được đặt trên bàn cờ."));
        //addTitle("                                                 ");
        //addTitle("Thời gian hoàn thành");
        addNoticeBoard(new ModelNoticeBoard(new Color(32, 171, 43), "Gợi ý", "", "     Chức năng này gợi ý cho người chơi những nước đi tiếp theo hợp lệ có thể đặt cờ."));
        //addDate("07/01/2024");
        addNoticeBoard(new ModelNoticeBoard(new Color(50, 93, 215), "Làm mới", "", "     Chức năng làm mới bàn cờ, khởi tạo lại các giá trị, xóa các quân cờ đã đặt trước đó và khôi phục lại màu sắc cho bàn cờ."));
        //addDate("22/02/2024");
        addNoticeBoard(new ModelNoticeBoard(new Color(153, 153, 0), "Mở file ", " ", "     Chức năng mở lại các file bàn cờ đã lưu. File sẽ không mở được nếu không đúng định dạng."));
        //addDate("14/03/2024");
        addNoticeBoard(new ModelNoticeBoard(new Color(255, 128,0 ), "Lưu file", "", "     Chức năng này lưu lại bàn cờ đang chơi. Có hai cách lưu bàn cờ: một là lưu bàn cờ đã chơi xong, hai là lưu bàn cờ chưa chơi xong lại để sau này mở lại chơi tiếp."));
        //addDate("26/04/2024");
        addNoticeBoard(new ModelNoticeBoard(new Color(153, 0, 76), "Thoát", "", "     Thoát khỏi trò chơi đang chơi."));

        addNoticeBoard(new ModelNoticeBoard(new Color(153, 0, 76), "Ô kích thước", "Chức năng chính", "Khi người chơi nhập vào một số dương N khác 0 vào ô, bàn cờ sẽ thay đổi để tương thích với kích thước đó."));
        scrollToTop();
    }

    public void addNoticeBoard(ModelNoticeBoard data) {
        JLabel title = new JLabel(data.getTitle());
        title.setFont(new Font("sansserif", 1, 17));
        title.setForeground(data.getTitleColor());
        panel.add(title);
        JLabel time = new JLabel(data.getTime());
        time.setForeground(new Color(180, 180, 180));
        panel.add(time, "gap 10, wrap");
        JTextPane txt = new JTextPane();
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setForeground(new Color(120, 120, 120));
        txt.setSelectionColor(new Color(150, 150, 150));
        txt.setFont(new Font("time new roman", 0, 15));
        txt.setBorder(new EmptyBorder(5, 5, 5, 5));
        txt.setOpaque(false);
        txt.setEditable(false);
        txt.setText(data.getDescription());
        panel.add(txt, "w 100::90%, wrap");
    }

    public void addDate(String date) {
        JLabel lbDate = new JLabel(date);
        lbDate.setBorder(new EmptyBorder(5, 5, 5, 5));
        lbDate.setFont(new Font("sansserif", 1, 14));
        lbDate.setForeground(new Color(128, 128, 128));
        panel.add(lbDate, "wrap");
    }

    public void addTitle(String title) {
        JLabel lbDate = new JLabel(title);
        lbDate.setBorder(new EmptyBorder(5, 5, 5, 5));
        lbDate.setFont(new Font("time new roman", 1, 16));
        lbDate.setForeground(new Color(80, 80, 80));
        panel.add(lbDate, "wrap");
    }

    public void scrollToTop() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jScrollPane1.getVerticalScrollBar().setValue(0);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        pnMenu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbTroChoiMoi = new javax.swing.JLabel();
        lbNhatKy = new javax.swing.JLabel();
        lbX = new javax.swing.JLabel();
        lbTrangChu = new javax.swing.JLabel();
        lbTroGiup = new javax.swing.JLabel();
        lbGioiThieu = new javax.swing.JLabel();
        lbThoat = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();
        lbMenu = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbMenu1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        btnChoi = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        btnGoiY = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnMo = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        txtN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trợ giúp");
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(1200, 700));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnMenu.setBackground(new java.awt.Color(255, 255, 255));
        pnMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnMenu.setMinimumSize(new java.awt.Dimension(250, 100));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setMinimumSize(new java.awt.Dimension(249, 100));

        lbTroChoiMoi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbTroChoiMoi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTroChoiMoi.setText(" Trò chơi mới ");

        lbNhatKy.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbNhatKy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNhatKy.setText(" Nhật Ký ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNhatKy, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTroChoiMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lbTroChoiMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lbNhatKy, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        lbX.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbX.setText(" X ");

        lbTrangChu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTrangChu.setText("#ChessChalenge");

        lbTroGiup.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbTroGiup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTroGiup.setText(" Trợ giúp ");

        lbGioiThieu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbGioiThieu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGioiThieu.setText(" Giới thiệu ");

        lbThoat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbThoat.setText(" Thoát ");

        lbIcon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/chess.png"))); // NOI18N

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbX, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnMenuLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lbIcon))
                    .addComponent(lbGioiThieu, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTroGiup, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbX)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbIcon)
                .addGap(18, 18, 18)
                .addComponent(lbTrangChu)
                .addGap(35, 35, 35)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(lbTroGiup, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lbGioiThieu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lbThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        jPanel3.add(pnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, -1));

        lbMenu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Menu Bar icon.jpg"))); // NOI18N
        jPanel3.add(lbMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 24, 64, 60));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ỨNG DỤNG TRÒ CHƠI 8 QUÂN HẬU VÀ MÃ ĐI TUẦN");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 940, 94));

        lbMenu1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMenu1.setText("(Build 1.0)");
        jPanel3.add(lbMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 250, 27));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Bảng hướng dẫn sử dụng các chức năng trong trò chơi");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Mô tả sơ lược về chương trình:");

        jLabel9.setOpaque(true);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        panel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addGap(9, 9, 9)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(599, 230, 600, 460));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setOpaque(false);

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        btnChoi.setBackground(new java.awt.Color(255, 255, 255));
        btnChoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnChoi.setForeground(new java.awt.Color(102, 102, 102));
        btnChoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_send_hot_list_16px.png"))); // NOI18N
        btnChoi.setText("Chơi ngay");
        btnChoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChoi.setFocusPainted(false);
        btnChoi.setPreferredSize(new java.awt.Dimension(87, 25));

        btnQuayLai.setBackground(new java.awt.Color(255, 255, 255));
        btnQuayLai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnQuayLai.setForeground(new java.awt.Color(102, 102, 102));
        btnQuayLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_assignment_return_16px.png"))); // NOI18N
        btnQuayLai.setText("Quay lại");
        btnQuayLai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuayLai.setFocusPainted(false);
        btnQuayLai.setPreferredSize(new java.awt.Dimension(111, 25));

        btnGoiY.setBackground(new java.awt.Color(255, 255, 255));
        btnGoiY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGoiY.setForeground(new java.awt.Color(102, 102, 102));
        btnGoiY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_add_16px.png"))); // NOI18N
        btnGoiY.setText("Gợi ý");
        btnGoiY.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGoiY.setFocusPainted(false);
        btnGoiY.setPreferredSize(new java.awt.Dimension(87, 25));

        btnLamMoi.setBackground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(102, 102, 102));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_reset_16px.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.setFocusPainted(false);
        btnLamMoi.setPreferredSize(new java.awt.Dimension(109, 25));

        btnMo.setBackground(new java.awt.Color(255, 255, 255));
        btnMo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMo.setForeground(new java.awt.Color(102, 102, 102));
        btnMo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_browse_folder_16px.png"))); // NOI18N
        btnMo.setText("Mở file");
        btnMo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMo.setFocusPainted(false);
        btnMo.setPreferredSize(new java.awt.Dimension(77, 25));
        btnMo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(255, 255, 255));
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(102, 102, 102));
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_edit_16px.png"))); // NOI18N
        btnLuu.setText("Lưu file");
        btnLuu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLuu.setFocusPainted(false);

        btnThoat.setBackground(new java.awt.Color(255, 255, 255));
        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(102, 102, 102));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_close_window_16px.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThoat.setFocusPainted(false);
        btnThoat.setPreferredSize(new java.awt.Dimension(97, 25));

        txtN.setFont(new java.awt.Font("Arial", 1, 65)); // NOI18N
        txtN.setForeground(new java.awt.Color(153, 0, 0));
        txtN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtN.setText("0");
        txtN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGoiY, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChoi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtN, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnThoat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnChoi, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuayLai, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnGoiY, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMo, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtN, javax.swing.GroupLayout.PREFERRED_SIZE, 73, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        jScrollPane2.setViewportView(jPanel4);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 300, 460));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Game Assets - Game Background for Sidescroller Game.jpg"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 740));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1421, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoActionPerformed

    private void txtNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(TroGiupView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TroGiupView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TroGiupView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TroGiupView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TroGiupView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoi;
    private javax.swing.JButton btnGoiY;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnMo;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbGioiThieu;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbMenu;
    private javax.swing.JLabel lbMenu1;
    private javax.swing.JLabel lbNhatKy;
    private javax.swing.JLabel lbThoat;
    private javax.swing.JLabel lbTrangChu;
    private javax.swing.JLabel lbTroChoiMoi;
    private javax.swing.JLabel lbTroGiup;
    private javax.swing.JLabel lbX;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JTextField txtN;
    // End of variables declaration//GEN-END:variables

    public JLabel getLBMenu() {
        return lbMenu;
    }

    public JPanel getPNMenu() {
        return pnMenu;
    }

    public JLabel getPNClose() {
        return lbX;
    }

    public JLabel getLBTrangChu() {
        return lbTrangChu;
    }

    public JLabel getLBIcon() {
        return lbIcon;
    }

    public JLabel getLBTroChoiMoi() {
        return lbTroChoiMoi;
    }

    public JLabel getLBNhatKy() {
        return lbNhatKy;
    }

    public JLabel getLBTroGiup() {
        return lbTroGiup;
    }

    public JLabel getLBGioiThieu() {
        return lbGioiThieu;
    }

    public JLabel getLBThoat() {
        return lbThoat;
    }

}
