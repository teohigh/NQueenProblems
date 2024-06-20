package EQueen.View;

import EQueen.View.noticeboard.ModelNoticeBoard;
import EQueen.View.noticeboard.ScrollBarCustom;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class GioiThieuView extends javax.swing.JFrame {

    public GioiThieuView() {
        initComponents();
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        panel.setLayout(new MigLayout("nogrid, fillx"));
        initNoticeBoard();
    }

    private void initNoticeBoard() {
        addTitle("Giới thiệu về trò chơi ");
        addNoticeBoard(new ModelNoticeBoard(new Color(94, 49, 238), "8 quân Hậu", "Now", "Bài toán “8 quân hậu” được đưa ra vào năm 1848 bởi kỳ thủ Max Bezzel, nhiều nhà toán học (trong đó có Gauss và Georg Cantor) đã có các công trình nghiên cứu về bài toán này và tổng quát nó thành bài toán xếp hậu. Các lời giải đầu tiên được đưa ra bởi Franz Nauck năm 1850, ông cũng đã tổng quát hóa bài toán này thành bài toán “N quân hậu”."));
        addNoticeBoard(new ModelNoticeBoard(new Color(218, 49, 238), "Mã đi tuần", "2h ago", "Bài toán “Mã đi tuần” hay “Hành trình của quân mã” là bài toán về việc di chuyển một quân mã trên bàn cờ vua. Giải thuật đầu tiên đầy đủ cho bài toán về hành trình của quân mã là Giải thuật Warnsdorff, công bố lần đầu năm 1823 bởi H. C. Warnsdorff. Bài toán này sau đã được mở rộng trên bàn cờ kích thước NxN."));
        addTitle("                                                 ");
        addTitle("Thời gian hoàn thành");
        addDate("26/02/2023");
        addNoticeBoard(new ModelNoticeBoard(new Color(32, 171, 43), "Tìm hiểu đề tài", "12:30 PM", " "));
        addDate("07/01/2024");
        addNoticeBoard(new ModelNoticeBoard(new Color(50, 93, 215), "Viết tài liệu đặc tả yêu cầu chi tiết bài toán", "10:30 AM", " "));
        addDate("22/02/2024");
        addNoticeBoard(new ModelNoticeBoard(new Color(27, 188, 204), "Thiết kế giải thuật và dữ liệu sử dụng ", "9:00 AM", " "));
        addDate("14/03/2024");
        addNoticeBoard(new ModelNoticeBoard(new Color(80, 80, 80), "Viết chương trình", "7:15 AM", " "));
        addDate("26/04/2024");
        addNoticeBoard(new ModelNoticeBoard(new Color(153, 0, 76), "Kiểm thử sản phẩm", "4:00 AM", " "));
        addDate("10/05/2024");
        addNoticeBoard(new ModelNoticeBoard(new Color(238, 46, 57), "Hoàn chỉnh chương trình ", "5d ago", " "));
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
        txt.setBorder(null);
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
        card = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pic = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Giới thiệu");
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
        jLabel4.setText("Bảng giới thiệu");
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

        card.setBackground(new java.awt.Color(255, 255, 255));
        card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Tác giả");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("NGUYỄN NHẤT TÀI");

        pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/AnhThe-removebg-preview.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Java developer");

        javax.swing.GroupLayout cardLayout = new javax.swing.GroupLayout(card);
        card.setLayout(cardLayout);
        cardLayout.setHorizontalGroup(
            cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardLayout.createSequentialGroup()
                .addGroup(cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addGroup(cardLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)))
                .addComponent(pic)
                .addContainerGap())
        );
        cardLayout.setVerticalGroup(
            cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(card, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 350, 150));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Game Assets - Game Background for Sidescroller Game.jpg"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 740));

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
            java.util.logging.Logger.getLogger(GioiThieuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GioiThieuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GioiThieuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GioiThieuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GioiThieuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JLabel pic;
    private javax.swing.JPanel pnMenu;
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
