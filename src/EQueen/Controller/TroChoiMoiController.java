/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EQueen.Controller;

import EQueen.View.GioiThieuView;
import EQueen.View.KnightTourView;
import EQueen.View.NQuanHauView;
import EQueen.View.NhatKyView;
import EQueen.View.TrangChuView;
import EQueen.View.TroChoiMoiView;
import EQueen.View.TroGiupView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class TroChoiMoiController {

    private TroChoiMoiView troChoiMoiView;

    public TroChoiMoiController(TroChoiMoiView troChoiMoiView) {
        this.troChoiMoiView = troChoiMoiView;
        initController();
    }

    public void initController() {
        // Mở thanh Menu Bar 
        this.troChoiMoiView.getLBMenu().addMouseListener(new MouseListener() {
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

        // Đóng thanh Menu Bar 
        this.troChoiMoiView.getPNClose().addMouseListener(new MouseListener() {
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

        // Mở Trang chủ khi click hashtag  
        this.troChoiMoiView.getLBTrangChu().addMouseListener(new MouseListener() {
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

        // Mở Trang chủ khi click icon  
        this.troChoiMoiView.getLBIcon().addMouseListener(new MouseListener() {
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

        // Mở trang Trò chơi mới 
        this.troChoiMoiView.getLBTroChoiMoi().addMouseListener(new MouseListener() {
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

        // Mở trang Nhật ký 
        this.troChoiMoiView.getLBNhatKy().addMouseListener(new MouseListener() {
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

        //  Đóng ứng dụng 
        this.troChoiMoiView.getLBThoat().addMouseListener(new MouseListener() {
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

        //  Mở trang Trợ giúp  
        this.troChoiMoiView.getLBTroGiup().addMouseListener(new MouseListener() {
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

        //  Mở trang Giới thiệu   
        this.troChoiMoiView.getLBGioiThieu().addMouseListener(new MouseListener() {
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

        // Mở sang giao diện bàn cờ 
        this.troChoiMoiView.getLBChoiNgay().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                choiNgay();
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
                        troChoiMoiView.getPNMenu().setSize(i, height);
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
                    troChoiMoiView.getPNMenu().setSize(i, height);
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
        troChoiMoiView.dispose();
    }

    void moTroChoiMoi() {
        TroChoiMoiView troChoiMoiView1 = new TroChoiMoiView();
        TroChoiMoiController troChoiMoiController = new TroChoiMoiController(troChoiMoiView1);
        troChoiMoiView1.setVisible(true);
        troChoiMoiView.dispose();
    }

    void moNhatKy() {
        NhatKyView nhatKyView = new NhatKyView();
        NhatKyController nhatKyController = new NhatKyController(nhatKyView);
        nhatKyView.setVisible(true);
        troChoiMoiView.dispose();
    }

    void thoat() {
        System.exit(0);
    }

    void moTroGiup() {
        TroGiupView troGiupView = new TroGiupView();
        TroGiupController troGiupController = new TroGiupController(troGiupView);
        troGiupView.setVisible(true);
        troChoiMoiView.dispose();
    }

    void moGioiThieu() {
        GioiThieuView gioiThieuView = new GioiThieuView();
        GioiThieuController nhatKyController = new GioiThieuController(gioiThieuView);
        gioiThieuView.setVisible(true);
        troChoiMoiView.dispose();
    }

    String fileHau = "C:\\Users\\ADMIN\\Documents\\Java\\NQueensProblem\\src\\EQueen\\Utility\\quanHau.txt";
    String fileMa = "C:\\Users\\ADMIN\\Documents\\Java\\NQueensProblem\\src\\EQueen\\Utility\\quanMa.txt";

    void choiNgay() {
        String N;
        N = troChoiMoiView.getTXTNumber().getText();

        // Nếu trò chơi N quân hậu được chọn thì mở trò chơi N quân hậu 
        if (troChoiMoiView.getButtonGroup().getSelection().equals(troChoiMoiView.getRBTQueen().getModel())) {
            // Mở bàn cờ đã mở gần đây nhất 
            int n = JOptionPane.showConfirmDialog(troChoiMoiView, "Mở bàn cờ gần đây?");
            if (n == 0) {
                int[][] array = openTextFile(fileHau);
                if (array.length != Integer.valueOf(N)) {
                    moTroChoiHau(String.valueOf(array.length));
                } // Mở bàn cờ trống 
                else {
                    moTroChoiHau(N);
                }
                // Clear file txt và mở bàn cờ mới 
            } else if (n == 1) {
                int[][] matrix = new int[Integer.valueOf(N)][Integer.valueOf(N)];
                saveMatrixToFile(setMatrixZero(matrix), fileHau);
                moTroChoiHau(N);
            }

            // Nếu trò chơi Mã đi tuần được chọn thì mở trò chơi Mã đi tuần 
        } else {
            // Mở bàn cờ đã mở gần đây nhất 
            int n = JOptionPane.showConfirmDialog(troChoiMoiView, "Mở bàn cờ gần đây?");
            if (n == 0) {
                int[][] array = openTextFile(fileMa);
                if (array.length != Integer.valueOf(N)) {
                    moTroChoiMa(String.valueOf(array.length));
                } // Mở bàn cờ trống 
                else {
                    moTroChoiMa(N);
                }
                // Clear file txt và mở bàn cờ mới 
            } else if (n == 1) {
                int[][] matrix = new int[Integer.valueOf(N)][Integer.valueOf(N)];
                saveMatrixToFile(setMatrixOne(matrix), fileMa);
                moTroChoiMa(N);
            }
        }
    }

    void moTroChoiHau(String N) {
        NQuanHauView nQuanHauView = new NQuanHauView(N);
        NQuanHauController nQuanHauController = new NQuanHauController(nQuanHauView);
        nQuanHauView.setVisible(true);
    }

    void moTroChoiMa(String N) {
        KnightTourView knightTourView = new KnightTourView(N);
        KnightTourController knightTourController = new KnightTourController(knightTourView);
        knightTourView.setVisible(true);
    }

    // Lưu ma trận vào file txt 
    void saveMatrixToFile(int[][] matrix, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int[] row : matrix) {
                for (int num : row) {
                    writer.write(num + " ");
                }
                writer.write("\n");
            }
            System.out.println("Matrix saved to the file: " + filePath);
        } catch (IOException e) {
            System.err.println("An error occurred while saving the matrix to the file: " + e.getMessage());
        }
    }

    // Mở file txt trả về ma trận 
    int[][] openTextFile(String filePath) {
        List<int[]> rows = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.trim().split("\\s+");
                int[] row = new int[numbers.length];

                for (int i = 0; i < numbers.length; i++) {
                    row[i] = Integer.parseInt(numbers[i]);
                }

                rows.add(row);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while opening the text file: " + e.getMessage());
        }

        int[][] result = new int[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            result[i] = rows.get(i);
        }

        return result;
    }

    int[][] setMatrixZero(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    int[][] setMatrixOne(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = -1;
            }
        }
        return matrix;
    }
}
