/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EQueen.Controller;

import EQueen.View.GioiThieuView;
import EQueen.View.NhatKyView;
import EQueen.View.TrangChuView;
import EQueen.View.TroChoiMoiView;
import EQueen.View.TroGiupView;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class NhatKyController {

    private NhatKyView nhatKyView;

    public NhatKyController(NhatKyView nhatKyView) {
        this.nhatKyView = nhatKyView;
        initController();
    }

    public void initController() {
        this.nhatKyView.getLBMenu().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openMenuBar();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        this.nhatKyView.getPNClose().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                closeMenuBar();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        this.nhatKyView.getLBTrangChu().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moTrangChu();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        this.nhatKyView.getLBIcon().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moTrangChu();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        this.nhatKyView.getLBTroChoiMoi().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moTroChoiMoi();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        this.nhatKyView.getLBNhatKy().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moNhatKy();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        this.nhatKyView.getLBThoat().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thoat();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        this.nhatKyView.getLBTroGiup().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moTroGiup();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        this.nhatKyView.getLBGioiThieu().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moGioiThieu();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        // Gọi hàm hiển thị lên JTable 
        tableView();
    }

    int width = 251;
    int height = 1200;

    void openMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < width; i++) {
                    try {
                        nhatKyView.getPNMenu().setSize(i, height);
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TrangChuView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }).start();
    }

    void closeMenuBar() {
        new Thread(() -> {
            for (int i = width; i >= 0; i--) {
                try {
                    nhatKyView.getPNMenu().setSize(i, height);
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TrangChuView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    void moTrangChu() {
        TrangChuView trangChuView = new TrangChuView();
        TrangChuController trangChuController = new TrangChuController(trangChuView);
        trangChuView.setVisible(true);
        nhatKyView.dispose();
    }

    void moTroChoiMoi() {
        TroChoiMoiView troChoiMoiView = new TroChoiMoiView();
        TroChoiMoiController troChoiMoiController = new TroChoiMoiController(troChoiMoiView);
        troChoiMoiView.setVisible(true);
        nhatKyView.dispose();
    }

    void moNhatKy() {
        NhatKyView nhatKyView1 = new NhatKyView();
        NhatKyController nhatKyController = new NhatKyController(nhatKyView1);
        nhatKyView1.setVisible(true);
        nhatKyView.dispose();
    }

    void thoat() {
        System.exit(0);
    }

    void moTroGiup() {
        TroGiupView troGiupView = new TroGiupView();
        TroGiupController troGiupController = new TroGiupController(troGiupView);
        troGiupView.setVisible(true);
        nhatKyView.dispose();
    }

    void moGioiThieu() {
        GioiThieuView gioiThieuView = new GioiThieuView();
        GioiThieuController nhatKyController = new GioiThieuController(gioiThieuView);
        gioiThieuView.setVisible(true);
        nhatKyView.dispose();
    }

    // Kết nối CSDL để mở nhật kí 
    Connection conn = EQueen.Utility.ConnectDB.getJDBCConnection();

    public void getTable(JTable table) {
        try {
            java.sql.Statement stmt = conn.createStatement();
            String query = "SELECT * FROM chess.table";
            ResultSet rs = stmt.executeQuery(query);
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            Object[] row;
            while (rs.next()) {
                row = new Object[6];
                row[0] = rs.getInt("id");
                row[1] = rs.getString("name");
                row[2] = rs.getInt("size");
                row[3] = rs.getInt("number");
                row[4] = rs.getString("state");
                row[5] = rs.getString("date");
                model.addRow(row);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            //
        }
    }

    private void tableView() {
        getTable(nhatKyView.getJTable());
        DefaultTableModel model = (DefaultTableModel) nhatKyView.getJTable().getModel();
        nhatKyView.getJTable().setShowGrid(true);
        nhatKyView.getJTable().setGridColor(Color.black);
        nhatKyView.getJTable().setBackground(Color.white);
        nhatKyView.getJTable().setAutoCreateRowSorter(true);
    }

}
