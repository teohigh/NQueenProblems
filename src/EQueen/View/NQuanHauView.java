/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package EQueen.View;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class NQuanHauView extends javax.swing.JFrame {

    /**
     * Creates new form TrangChuView
     */
    public NQuanHauView(String N) {
        initComponents();
        txtN.setText(N);
        init();
    }

    public NQuanHauView(int[][] chessboard) {
        init();
    }

    void init() {
//        Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.DONE_ALL, 10, new Color(255, 255, 255, 100), new Color(255, 255, 255, 10));
//        btnChoi.setIcon(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pn = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf = new javax.swing.JTextArea();
        txtN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnChoi = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        btnGoiY = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnMo = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        lbMessenger = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trò chơi N quân hậu");
        setMinimumSize(new java.awt.Dimension(1400, 900));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(1400, 900));
        jPanel3.setPreferredSize(new java.awt.Dimension(1400, 900));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        pn.setBackground(new java.awt.Color(255, 255, 255));
        pn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 6));
        pn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnLayout = new javax.swing.GroupLayout(pn);
        pn.setLayout(pnLayout);
        pnLayout.setHorizontalGroup(
            pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 888, Short.MAX_VALUE)
        );
        pnLayout.setVerticalGroup(
            pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 54, 930, 840));

        tf.setEditable(false);
        tf.setColumns(20);
        tf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tf.setRows(5);
        tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jScrollPane1.setViewportView(tf);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 180, 440, 710));

        txtN.setFont(new java.awt.Font("Arial", 1, 65)); // NOI18N
        txtN.setForeground(new java.awt.Color(153, 0, 0));
        txtN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtN.setText("0");
        txtN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNActionPerformed(evt);
            }
        });
        jPanel3.add(txtN, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 80, 112, 73));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Kích thước bàn cờ:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 80, 158, 37));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("(*) Click để thay đổi");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 130, 158, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);

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

        lbMessenger.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbMessenger.setForeground(new java.awt.Color(102, 102, 102));
        lbMessenger.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessenger.setText("lbMessenger");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnChoi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGoiY, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMessenger, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbMessenger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGoiY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuayLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void txtNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNActionPerformed

    private void pnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pnMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btnMoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoActionPerformed

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
            java.util.logging.Logger.getLogger(NQuanHauView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NQuanHauView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NQuanHauView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NQuanHauView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NQuanHauView("").setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMessenger;
    private javax.swing.JPanel pn;
    private javax.swing.JTextArea tf;
    private javax.swing.JTextField txtN;
    // End of variables declaration//GEN-END:variables

    public JButton getBTNChoi() {
        return btnChoi;
    }

    public JButton getBTNQuayLai() {
        return btnQuayLai;
    }

    public JButton getBTNGoiY() {
        return btnGoiY;
    }

    public JButton getBTNLamMoi() {
        return btnLamMoi;
    }

    public JButton getBTNMo() {
        return btnMo;
    }

    public JButton getBTNLuu() {
        return btnLuu;
    }

    public JButton getBTNThoat() {
        return btnThoat;
    }

    public JLabel getLBMessenger() {
        return lbMessenger;
    }

    // Thiết lập hàm cho ô kích thước 
    public JTextField getN() {
        return txtN;
    }

    //  Thiết lập hàm cho bàn cờ 
    public JPanel getChessBoard() {
        return pn;
    }

    // Thiết lập hàm cho JTextArea 
    public JTextArea getTF() {
        return tf;
    }
}
