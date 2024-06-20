/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EQueen.Controller;

import EQueen.Model.Move;
import EQueen.Utility.ConnectDB;
import EQueen.View.NQuanHauView;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.border.LineBorder;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

/**
 *
 * @author ADMIN
 */
public class NQuanHauController {

    private NQuanHauView nQuanHauView;

    private static int N;
    private static int[][] chessboard;
    private static int[] c;
    private static int sizeIcon;
    JButton bt[][] = new JButton[200][200];
    private static int x, y;
    Stack<Move> moveHistory = new Stack<>();
    float time = 0;
    private long startTime;
    private javax.swing.Timer timer;

    public NQuanHauController(NQuanHauView nQuanHauView) {
        this.nQuanHauView = nQuanHauView;
        khoiTao(Integer.valueOf(nQuanHauView.getN().getText()));
        initController();
    }

    public void initController() {
        // Chức năng chính: bắt sự kiện khi nhấn nút Chơi, tìm ra giải pháp cho bàn cờ 
        nQuanHauView.getBTNChoi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choi();
            }
        });

        // Gọi hàm quay lại bước đi trước đó 
        nQuanHauView.getBTNQuayLai().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quayLai();
            }
        });

        nQuanHauView.getBTNGoiY().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goiY();
            }
        });

        nQuanHauView.getBTNLamMoi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lamMoi();
            }
        });

        // Gọi hàm mở file đã lưu 
        nQuanHauView.getBTNMo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mo();
            }
        });

        // Gọi hàm lưu file 
        nQuanHauView.getBTNLuu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                luu();
            }
        });

        // Gọi hàm lưu file 
        nQuanHauView.getBTNThoat().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thoatTrang();
            }
        });

        nQuanHauView.getN().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                banCoMoi();
            }
        });

        // Bắt sự kiện click chuột để đặt cờ 
        nQuanHauView.getChessBoard().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

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

        nQuanHauView.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                moWindow();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                dongWindow();
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
    }

    void quayLai() {
        if (!moveHistory.empty()) {
            Move lastMove = moveHistory.pop();
            bt[lastMove.row][lastMove.col].setIcon(null);
            chessboard[lastMove.row][lastMove.col] = 0;
            c[lastMove.col] = -1;
            if ((lastMove.row + lastMove.col) % 2 != 0) {
                bt[lastMove.row][lastMove.col].setBackground(new java.awt.Color(30, 144, 255)); //(251, 236, 211));
            } else {
                bt[lastMove.row][lastMove.col].setBackground(new java.awt.Color(240, 248, 255)); //(250, 157, 90));
            }
        }
    }

    void goiY() {
        suggest(4000);
    }

    void lamMoi() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                chessboard[i][j] = 0;
                c[i] = -1;
                bt[i][j].setIcon(null);
                if ((i + j) % 2 != 0) {
                    bt[i][j].setBackground(new java.awt.Color(30, 144, 255)); //(251, 236, 211));
                } else {
                    bt[i][j].setBackground(new java.awt.Color(240, 248, 255)); //(250, 157, 90));
                }
            }
        }
        nQuanHauView.getTF().setText(null);
        nQuanHauView.getBTNMo().setEnabled(true);

    }

    //  Hàm mở browser để chọn file muốn mở 
    void mo() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(nQuanHauView);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fileChooser.getSelectedFile();
                this.chessboard = openFile(selectedFile.getAbsolutePath());
                for (int i = 0; i < chessboard.length; i++) {
                    for (int j = 0; j < chessboard.length; j++) {
                        if (chessboard[i][j] == 1) {
                            bt[i][j].setBackground(Color.red);
                            c[j] = j;
                        }
                    }
                }
            } catch (IOException ex) {
                //Logger.getLogger(KnightTour1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Hiển thị các nước đi theo thứ tự hàng trên JTextArea
        printTour();
    }

    // Hàm xuất file pdf từ dữ liệu trên JTextArea 
    void luu() {
        // Chuyển nội dung trên JTextArea sang dạng ma trận N x N 
        nQuanHauView.getTF().setText(null);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nQuanHauView.getTF().setText(nQuanHauView.getTF().getText() + chessboard[i][j] + " ");
            }
            nQuanHauView.getTF().setText(nQuanHauView.getTF().getText() + "\n");
        }

        boolean complete;
        try {
            complete = nQuanHauView.getTF().print(null, null);
            if (complete) {
                JOptionPane.showMessageDialog(nQuanHauView, "Done printing", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(nQuanHauView, "Printing!", "Printer", JOptionPane.ERROR_MESSAGE);
            }
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    void thoatTrang() {
        this.nQuanHauView.hide();
        dongWindow();
    }

    // Mở bàn cờ mới khi nhập vào JTextField kích thước N  
    void banCoMoi() {
        setMatrixZero(chessboard);
        NQuanHauView nQuanHauView1 = new NQuanHauView(nQuanHauView.getN().getText());
        NQuanHauController knightTourController = new NQuanHauController(nQuanHauView1);
        nQuanHauView1.setVisible(true);
        this.nQuanHauView.dispose();
    }

    void datCo() {

    }

    // Hàm tìm ra các nước đi tiếp theo của quân mã 
    void choi() {
        // Giải bài toán bằng phương pháp backtracking
        if (Integer.valueOf(nQuanHauView.getN().getText()) >= 25) {
            nQuanHauView.getLBMessenger().setText("             Bàn cờ quá lớn sẽ tốn nhiều thời gian, bạn đợi chút nhé!             ");
        }

        // Bắt đầu tính thời gian 
        long start, end;
        start = System.nanoTime();

        if (!solve(0)) {
            nQuanHauView.getLBMessenger().setText("             Không sao, làm lại nhé!             ");
            JOptionPane.showMessageDialog(nQuanHauView, "Không tìm thấy giải pháp cho bàn cờ này!");
            saveSQL("N quân Hậu", N, "No solution found!");
            return;
        } else {
            nQuanHauView.getBTNQuayLai().setEnabled(false);
            nQuanHauView.getLBMessenger().setText("             Excellent job!!!             ");

            // Kết thúc tính thời gian 
            end = System.nanoTime();
            time = (float) (end - start) / 1000000000;
            saveSQL("N quân Hậu", N, time + " giây");

            // Hiển thị các nước đi theo thứ tự hàng trên JTextArea
            printTour();
            nQuanHauView.getTF().setText(nQuanHauView.getTF().getText() + "Thời gian chạy chương trình: " + time + " giây");

        }
    }

    void printTour() {
        int count = 1;
        String s = "";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (chessboard[i][j] == 1) {
                    s = s + count + ". ( " + (i + 1) + ", " + (j + 1) + ")\n";
                    count++;
                    setIcon(i, j);
                }
            }
        }
        nQuanHauView.getTF().setText(s);
    }

    // Hàm khởi tạo các giá trị ban đầu cho bàn cờ 
    void khoiTao(int N) {
        this.N = N;
        this.sizeIcon = 750 / N;
        init(N);

        // Khởi tạo bàn cờ
        chessboard = new int[N][N];
        c = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                chessboard[i][j] = 0;
            }
            // Khởi tạo mảng lưu cột các quân cờ đầu tiên 
            c[i] = -1;
        }

        // Truyền thông điệp lên màn hình 
        nQuanHauView.getLBMessenger().setText("             Bàn cờ đã sẵn sàng, đặt cờ thôi nào!             ");

        nQuanHauView.getBTNQuayLai().setEnabled(false);
        addAction();

    }

    void init(int N) {
        nQuanHauView.getChessBoard().setLayout(new GridLayout(N, N));
        for (int i = 0; i < N; i++) {//////////////////////////////////////
            for (int j = 0; j < N; j++) {
                int size = (int) Math.sqrt(750 / (N * N));
                bt[i][j] = new JButton();
                if ((i + j) % 2 != 0) {
                    bt[i][j].setBackground(new java.awt.Color(30, 144, 255)); //(251, 236, 211));
                } else {
                    bt[i][j].setBackground(new java.awt.Color(240, 248, 255)); //(250, 157, 90));
                }
                bt[i][j].setBorder(new LineBorder(Color.BLACK, 1));
                nQuanHauView.getChessBoard().add(bt[i][j]);
            }
        }
    }

    // Bắt sự kiện cho JButton trên bàn cờ để đặt cờ 
    void addAction() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bt[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JButton clickedButton = (JButton) e.getSource();
                        int row = getRowIndex(clickedButton); // Hàm lấy giá trị hàng của JButton 
                        int col = getColumnIndex(clickedButton); // Hàm lấy giá trị cột của JButton 
                        if (!isSafe(row, col)) {
                            JOptionPane.showMessageDialog(nQuanHauView, "Ôi, vị trí bạn đặt không đúng!", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            nQuanHauView.getLBMessenger().setText("             Sẵn sàng để Chơi!             ");
                            nQuanHauView.getBTNMo().setEnabled(false);
                            nQuanHauView.getBTNQuayLai().setEnabled(true);
                            moveHistory.push(new Move(row, col, 0));
                            chessboard[row][col] = 1;
                            c[col] = col;
                            setIcon(row, col);
                            bt[row][col].setBackground(new java.awt.Color(255, 0, 0));

                        }
                    }

                    private int getRowIndex(JButton clickedButton) {
                        // Assuming buttons is a 2D array of JButtons
                        for (int i = 0; i < bt.length; i++) {
                            for (int j = 0; j < bt.length; j++) {
                                if (bt[i][j] == clickedButton) {
                                    return i; // Return row index if button found
                                }
                            }
                        }
                        return -1; // Button not found in the array
                    }

                    private int getColumnIndex(JButton clickedButton) {
                        for (int i = 0; i < bt.length; i++) {
                            for (int j = 0; j < bt.length; j++) {
                                if (bt[i][j] == clickedButton) {
                                    return j; // Return column index if button found
                                }
                            }
                        }
                        return -1; // Button not found in the array
                    }
                });
            }
        }
    }

    // Hàm kiểm tra vị trí đặt quân hậu hợp lệ
    public boolean isSafe(int row, int col) {
        for (int i = 0; i < N; i++) {
            // Kiểm tra các ô trên một hàng 
            if (chessboard[row][i] == 1 && i != col) {
                return false;
            }

            // Kiểm tra các ô trên một cột  
            if (chessboard[i][col] == 1 && i != row) {
                return false;
            }

            for (int j = 0; j < N; j++) {
                // Kiểm tra các ô trên đường chéo  
                if (chessboard[i][j] == 1 && i != row && j != col && Math.abs(row - i) == Math.abs(col - j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Hàm đệ quy để tìm kiếm các vị trí đặt quân hậu
    public boolean solve(int col) {
        if (col >= N) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {
                chessboard[i][col] = 1;

                if (solve(col + 1)) {
                    return true;
                }

                //backtrack if the above condition is false
                if (col == c[col]) {
                    return false;
                }
                chessboard[i][col] = 0;
            }
        }
        return false;
    }

    public void setIcon(int i, int j) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/Queen_1.png"));
                //new ImageIcon("C:\\Users\\ADMIN\\Documents\\Java\\NQueensProblem\\src\\Icons\\Queen_1.png", "Lock");
        bt[i][j].setIcon(icon);
        bt[i][j].setIcon(new ImageIcon(icon.getImage().getScaledInstance(sizeIcon, sizeIcon, Image.SCALE_SMOOTH)));
    }

    // Hàm đề xuất gợi ý các nước tiếp theo có thể đi cho quân hậu lên bàn cờ 
    public void suggest(int delay) {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!isSafe(i, j)) {
                            bt[i][j].setBackground(Color.red);
                        }
                    }
                }
                Thread.sleep(delay);
                return null;
            }

            public void done() {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (chessboard[i][j] != 1) {
                            if ((i + j) % 2 != 0) {
                                bt[i][j].setBackground(new java.awt.Color(30, 144, 255)); //(251, 236, 211));
                            } else {
                                bt[i][j].setBackground(new java.awt.Color(240, 248, 255)); //(250, 157, 90));
                            }
                        }
                    }
                }
            }
        };
        worker.execute();
    }

    void saveSQL(String name, int size, String state) {
        int number = moveHistory.size();
        try {
            ConnectDB.saveData(name, N, number, state);
            return;
        } catch (SQLException ex) {
            //Logger.getLogger(KnightTour1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Hàm mở file pdf 
    int[][] openFile(String filePath) throws IOException {
        PDDocument document = PDDocument.load(new File(filePath));
        PDFTextStripper pdftext = new PDFTextStripper();
        String pdftextdata = pdftext.getText(document);
        document.close();

        // Cắt chuỗi text bởi dấu cách và dấu xuống hàng 
        String[] values = pdftextdata.split("\\s+");

        // Lấy kích thước ma trận từ chuỗi 
        int N = (int) Math.sqrt(values.length);
        if (N != this.N) {
            JOptionPane.showMessageDialog(nQuanHauView, "Kích thước không phù hợp!", "Opening...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (N * N != values.length) {
            throw new IllegalStateException("Invalid matrix dimensions in PDF text");
        }

        // Chuyển từ ma trận 1D sang ma trận 2D 
        int[][] matrix = new int[N][N];
        int j = 0;
        for (int i = 0; i < values.length; i++) {
            matrix[i / N][j] = Integer.parseInt(values[i]);
            j = (j + 1) % N;  // Increment row index for the next value
        }

        return matrix;
    }

    String filePath = "C:\\Users\\ADMIN\\Documents\\Java\\NQueensProblem\\src\\EQueen\\Utility\\quanHau.txt";

    void moWindow() {
        if (openTextFile(filePath).length == N) {
            chessboard = openTextFile(filePath);
            printTour();
            for (int i = 0; i < chessboard.length; i++) {
                for (int j = 0; j < chessboard.length; j++) {
                    if (chessboard[i][j] == 1) {
                        bt[i][j].setBackground(Color.red);
                        c[j] = j;
                    }
                }
            }
        }

    }

    void dongWindow() {
        saveMatrixToFile(chessboard, filePath);
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

}
