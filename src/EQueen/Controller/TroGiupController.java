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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class TroGiupController {

    private TroGiupView troGiupView;

    public TroGiupController(TroGiupView troGiupView) {
        this.troGiupView = troGiupView;
        initController();
    }

    public void initController() {
        // Bắt sự kiện click chuột mở MenuBar 
        this.troGiupView.getLBMenu().addMouseListener(new MouseListener() {
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

        // Bắt sự kiện click chuột đóng MenuBar 
        this.troGiupView.getPNClose().addMouseListener(new MouseListener() {
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

        // Mở trang chủ khi nhấn vào hashtag  
        this.troGiupView.getLBTrangChu().addMouseListener(new MouseListener() {
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

        // Mở trang chủ khi nhấn vào icon  
        this.troGiupView.getLBIcon().addMouseListener(new MouseListener() {
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

        // Mở trò chơi mới  
        this.troGiupView.getLBTroChoiMoi().addMouseListener(new MouseListener() {
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

        // Mở nhật ký 
        this.troGiupView.getLBNhatKy().addMouseListener(new MouseListener() {
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

        // Thoát ứng dụng 
        this.troGiupView.getLBThoat().addMouseListener(new MouseListener() {
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

        // Mở trợ giúp  
        this.troGiupView.getLBTroGiup().addMouseListener(new MouseListener() {
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

        // Mở giới thiệu   
        this.troGiupView.getLBGioiThieu().addMouseListener(new MouseListener() {
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
    }

    int width = 251;
    int height = 1200;

    void openMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < width; i++) {
                    try {
                        troGiupView.getPNMenu().setSize(i, height);
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
                    troGiupView.getPNMenu().setSize(i, height);
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TrangChuView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    void moTrangChu() {
        TrangChuView trangChuView1 = new TrangChuView();
        TrangChuController trangChuController = new TrangChuController(trangChuView1);
        trangChuView1.setVisible(true);
        troGiupView.dispose();
    }

    void moTroChoiMoi() {
        TroChoiMoiView troChoiMoiView = new TroChoiMoiView();
        TroChoiMoiController troChoiMoiController = new TroChoiMoiController(troChoiMoiView);
        troChoiMoiView.setVisible(true);
        troGiupView.dispose();
    }

    void moNhatKy() {
        NhatKyView nhatKyView = new NhatKyView();
        NhatKyController nhatKyController = new NhatKyController(nhatKyView);
        nhatKyView.setVisible(true);
        troGiupView.dispose();
    }

    void thoat() {
        System.exit(0);
    }

    void moTroGiup() {
        TroGiupView troGiupView = new TroGiupView();
        TroGiupController troGiupController = new TroGiupController(troGiupView);
        troGiupView.setVisible(true);
        this.troGiupView.dispose();
    }

    void moGioiThieu() {
        GioiThieuView gioiThieuView = new GioiThieuView();
        GioiThieuController gioiThieuController = new GioiThieuController(gioiThieuView);
        gioiThieuView.setVisible(true);
        troGiupView.dispose();
    }

}
