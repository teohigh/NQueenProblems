/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EQueen.Controller;

import EQueen.Model.Move;
import EQueen.Utility.ConnectDB;
import EQueen.View.KnightTourView;
import EQueen.View.NhatKyView;
import EQueen.View.TrangChuView;
import EQueen.View.TroChoiMoiView;
import java.awt.Color;
import java.awt.Font;
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
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

/**
 *
 * @author ADMIN
 */
public class KnightTourController {

    private KnightTourView knightTourView;

    private static int N = 10;
    private static int[][] chessboard; // Bàn cờ
    private static int step = 1;
    public static int x = 0, y = 0;
    private static int sizeIcon;
    private static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2}; // Các hướng di chuyển của quân mã
    private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    JButton bt[][] = new JButton[200][200];
    Stack<Move> moveHistory = new Stack<>();
    float time = 0;

    public KnightTourController(KnightTourView knightTourView) {
        this.knightTourView = knightTourView;
        khoiTao(Integer.valueOf(knightTourView.getN().getText()));
        initController();
    }

    public void initController() {
        // Chức năng chính: bắt sự kiện khi nhấn nút Chơi, tìm ra giải pháp cho bàn cờ 
        knightTourView.getBTNChoi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choi();
            }
        });

        // Gọi hàm quay lại bước đi trước đó 
        knightTourView.getBTNQuayLai().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quayLai();
            }
        });

        knightTourView.getBTNGoiY().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goiY();
            }
        });

        knightTourView.getBTNLamMoi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lamMoi();
            }
        });

        // Gọi hàm mở file đã lưu 
        knightTourView.getBTNMo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mo();
            }
        });

        // Gọi hàm lưu file 
        knightTourView.getBTNLuu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                luu();
            }
        });

        // Gọi hàm lưu file 
        knightTourView.getBTNThoat().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thoatTrang();
            }
        });

        knightTourView.getN().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                banCoMoi();
            }
        });

        // Bắt sự kiện click chuột để đặt cờ 
        knightTourView.getChessBoard().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                datCo();
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

        knightTourView.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                moWindow();
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
                dongWindow();
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

    void moTrangChu() {
        TrangChuView trangChuView = new TrangChuView();
        TrangChuController trangChuController = new TrangChuController(trangChuView);
        trangChuView.setVisible(true);
        knightTourView.dispose();
    }

    void moTroChoiMoi() {
        TroChoiMoiView troChoiMoiView = new TroChoiMoiView();
        TroChoiMoiController troChoiMoiController = new TroChoiMoiController(troChoiMoiView);
        troChoiMoiView.setVisible(true);
        knightTourView.dispose();
    }

    void moNhatKy() {
        NhatKyView nhatKyView = new NhatKyView();
        NhatKyController nhatKyController = new NhatKyController(nhatKyView);
        nhatKyView.setVisible(true);
        knightTourView.dispose();
    }

    void thoat() {
        System.exit(0);
    }

    void moTroGiup() {

    }

    void moGioiThieu() {

    }

    void quayLai() {
        if (!moveHistory.empty()) {
            Move lastMove = moveHistory.pop();
            step--;
            bt[lastMove.row][lastMove.col].setText("");
            chessboard[lastMove.row][lastMove.col] = -1;
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
                chessboard[i][j] = -1;
                moveHistory.clear();
                step = 1;
                bt[i][j].setIcon(null);
                bt[i][j].setText(null);
                if ((i + j) % 2 != 0) {
                    bt[i][j].setBackground(new java.awt.Color(30, 144, 255)); //(251, 236, 211));
                } else {
                    bt[i][j].setBackground(new java.awt.Color(240, 248, 255)); //(250, 157, 90));
                }
            }
        }
        knightTourView.getTF().setText(null);
        knightTourView.getBTNMo().setEnabled(true);
    }

    //  Hàm mở browser để chọn file muốn mở 
    void mo() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this.knightTourView);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fileChooser.getSelectedFile();
                this.chessboard = openFile(selectedFile.getAbsolutePath());

                // Hiện thị các nước đi trên bàn cờ, nước đi cuối cùng đặt icon quân mã 
                int max = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(chessboard[i][j] == 0){
                            JOptionPane.showMessageDialog(fileChooser, "File không đúng định dạng!");
                            this.chessboard = setMatrixOne(chessboard);
                        }
                        if (chessboard[i][j] == N * N) {
                            setIcon(i, j);
                        } else if (chessboard[i][j] != -1) {
                            bt[i][j].setBackground(Color.red);
                            setNumber(i, j);
                            if (chessboard[i][j] > max) {
                                max = chessboard[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            } catch (IOException ex) {

            }
        }

        // Xuất ra hành trình của quân mã trên JTextArea
        for (int i = 1; i <= N * N; i++) {
            printTour(i);
        }
    }

    // Hàm xuất file pdf từ dữ liệu trên JTextArea 
    void luu() {
        // Chuyển nội dung trên JTextArea sang dạng ma trận N x N 
        knightTourView.getTF().setText(null);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                knightTourView.getTF().setText(knightTourView.getTF().getText() + chessboard[i][j] + " ");
            }
            knightTourView.getTF().setText(knightTourView.getTF().getText() + "\n");
        }

        // Thực hiện xuất file pdf 
        boolean complete;
        try {
            complete = knightTourView.getTF().print(null, null);
            if (complete) {
                JOptionPane.showMessageDialog(knightTourView, "Done printing", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(knightTourView, "Printing!", "Printer", JOptionPane.ERROR_MESSAGE);
            }
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    void thoatTrang() {
        saveMatrixToFile(chessboard, filePath);
        this.knightTourView.hide();
    }

    // Mở bàn cờ mới khi nhập vào JTextField kích thước N  
    void banCoMoi() {
        setMatrixOne(chessboard);
        KnightTourView knightTourView1 = new KnightTourView(knightTourView.getN().getText());
        KnightTourController knightTourController = new KnightTourController(knightTourView1);
        knightTourView1.setVisible(true);
        this.knightTourView.dispose();
    }

    void datCo() {

    }

    // Hàm tìm ra các nước đi tiếp theo của quân mã 
    void choi() {
        // Tắt chức năng của nút Quay lại, Gợi ý 
        knightTourView.getBTNQuayLai().setEnabled(false);
        knightTourView.getBTNGoiY().setEnabled(false);

        // Bắt đầu tính thời gian chạy chương trình 
        long start, end;
        start = System.nanoTime(); // Lấy thời gian theo nanosecond

        // Nếu chưa đặt cờ thì chọn quân đầu tiên đi trước 
        try {
            if (!moveHistory.empty()) {
                Move lastMove = moveHistory.pop();
                x = lastMove.row;
                y = lastMove.col;
            }
            if (chessboard[x][y] == -1) {
                chessboard[x][y] = 1;
            }
            if (solveKnightTour(chessboard, x, y, chessboard[x][y])) {
                knightTourView.getLBMessenger().setText("             Excellent job!             ");
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (chessboard[i][j] == N * N) {
                            setIcon(i, j);
                        } else {
                            setNumber(i, j);
                        }
                    }
                }

                // Xuất ra hành trình của quân mã trên JTextArea
                for (int i = 1; i <= N * N; i++) {
                    printTour(i);
                }

                // Kết thúc tính thời gian 
                end = System.nanoTime();
                time = (float) (end - start) / 1000000000;
                knightTourView.getTF().setText(knightTourView.getTF().getText() + "Thời gian chạy chương trình: " + time + " giây");
                saveSQL("Mã đi tuần", N, time + " giây");

            } else {
                knightTourView.getLBMessenger().setText("             Không sao, làm lại nhé!             ");

                JOptionPane.showMessageDialog(knightTourView, "Không tìm thấy giải pháp cho bàn cờ này!");
                saveSQL("Mã đi tuần", N, "No solution found!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(knightTourView, ex);
        }

    }

    // Hàm khởi tạo các giá trị ban đầu cho bàn cờ 
    void khoiTao(int N) {
        this.step = 1;
        this.N = N;
        this.sizeIcon = 750 / N;
        init(N);     // Khởi tạo giao diện bàn cờ 

        // Khởi tạo mảng bàn cờ 
        this.chessboard = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                chessboard[i][j] = -1;
            }
        }

        knightTourView.getLBMessenger().setText("             Bàn cờ đã sẵn sàng, đặt cờ thôi nào!             ");
        knightTourView.getBTNQuayLai().setEnabled(false);
        addAction();
    }

    void init(int N) {
        knightTourView.getChessBoard().setLayout(new GridLayout(N, N));
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
                knightTourView.getChessBoard().add(bt[i][j]);
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
                            JOptionPane.showMessageDialog(knightTourView, "Ôi, vị trí bạn đặt không đúng!", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            knightTourView.getLBMessenger().setText("             Sẵn sàng rồi, Chơi thôi!             ");
                            knightTourView.getBTNQuayLai().setEnabled(true);
                            knightTourView.getBTNMo().setEnabled(false);
                            moveHistory.push(new Move(row, col, 0));
                            chessboard[row][col] = step;
                            step++;
                            setNumber(row, col);
                            bt[row][col].setBackground(new java.awt.Color(255, 0, 0));
                            suggest(1000);
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

    // Hàm kiểm tra hợp lệ của quân mã 
    boolean isSafe(int x, int y) {
        // Thử xét quân mã theo các hướng khác nhau
        if (step == 1 && chessboard[x][y] == -1) {
            return true;
        } else {
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // Nếu ô vuông tiếp theo hợp lệ và đã được đi qua
                if (0 <= nx && nx < N && 0 <= ny && ny < N && chessboard[nx][ny] == step - 1 && chessboard[x][y] == -1) {
                    return true;
                }
            }
        }
        return false;
    }

    void setIcon(int i, int j) {
        //new ImageIcon(getClass().getResource("/Icons/knight.png"))
        //new ImageIcon("C:\\Users\\ADMIN\\Documents\\Java\\NQueensProblem\\src\\Icons\\knight.png", "Lock");
        ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/knight.png")); //C:\\Users\\ADMIN\\Documents\\Java\\NQueensProblem\\src\\EQueen\\Queen.png
        bt[i][j].setIcon(icon);
        bt[i][j].setIcon(new ImageIcon(icon.getImage().getScaledInstance(sizeIcon, sizeIcon, Image.SCALE_SMOOTH)));
    }

    void setNumber(int i, int j) {
        bt[i][j].setText(Integer.toString(chessboard[i][j]));
        bt[i][j].setFont(new Font("Arial ", Font.PLAIN, 300 / (N)));
    }

    // Hàm đề xuất gợi ý các nước tiếp theo có thể đi cho quân mã lên bàn cờ 
    void suggest(int delay) {
        Move lastMove = moveHistory.pop();
        List<Move> nextMoves = getNextMoves(lastMove.row, lastMove.col);
        for (Move move : nextMoves) {
            bt[move.row][move.col].setBorder(new LineBorder(Color.GREEN, 6));
        }

        // Tạo hiệu ứng đổi màu trong n giây
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Đặt lại màu nền ban đầu
                for (Move move : nextMoves) {
                    bt[move.row][move.col].setBorder(new LineBorder(Color.BLACK, 1));
                }
            }
        });
        timer.start();
        moveHistory.push(lastMove);
    }

    List<Move> getNextMoves(int row, int col) {
        List<Move> moves = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (isValidMove(newRow, newCol)) {
                moves.add(new Move(newRow, newCol, getDegree(newRow, newCol)));
            }
        }
        return moves;
    }

    boolean isValidMove(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N && chessboard[row][col] == -1;
    }

    int getDegree(int row, int col) { // Warnsdorff's heuristic
        int degree = 0;
        for (int i = 0; i < 8; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (isValidMove(newRow, newCol)) {
                degree++;
            }
        }
        return degree;
    }

    boolean solveKnightTour(int[][] chessboard, int row, int col, int moveCount) {
        // Start from a corner square (usually a good starting point)
        this.chessboard = chessboard;
        return tryMove(row, col, moveCount);
    }

    boolean tryMove(int row, int col, int moveCount) {
        chessboard[row][col] = moveCount;

        // Check if we've reached the final move
        if (moveCount == N * N) {
            return true;
        }

        // Get a list of potential next moves sorted by Warnsdorff's heuristic
        List<Move> nextMoves = getNextMoves(row, col);
        Collections.sort(nextMoves);

        // No valid moves found, backtracking won't lead to a solution
        if (nextMoves.isEmpty()) {
            return false;
        }

        // Try each potential move in order of heuristic priority
        for (Move move : nextMoves) {
            if (tryMove(move.row, move.col, moveCount + 1)) {
                return true;
            }
        }

        // Backtrack if none of the moves lead to a solution
        chessboard[row][col] = -1;
        return false;
    }

    void saveSQL(String name, int size, String state) {
        int n = moveHistory.size();
        try {
            ConnectDB.saveData(name, N, n, state);
            return;
        } catch (SQLException ex) {

        }
    }

    void printTour(int step) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (chessboard[i][j] == step) {
                    knightTourView.getTF().setText(knightTourView.getTF().getText() + step + ". " + "(" + (i + 1) + ", " + (j + 1) + ") " + "\n");
                }
            }
        }
    }

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
            JOptionPane.showMessageDialog(knightTourView, "Kích thước không phù hợp!", "Opening...", JOptionPane.ERROR_MESSAGE);
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

    String filePath = "C:\\Users\\ADMIN\\Documents\\Java\\NQueensProblem\\src\\EQueen\\Utility\\quanMa.txt";

    void moWindow() {
        if (openTextFile(filePath).length == N) {
            chessboard = openTextFile(filePath);
            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (chessboard[i][j] == N * N) {
                        setIcon(i, j);
                    } else if (chessboard[i][j] != -1 && chessboard[i][j] != 0) {
                        setNumber(i, j);
                        bt[i][j].setBackground(Color.red);
                        if (chessboard[i][j] > max) {
                            max = chessboard[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }
            step = max + 1;

            // Xuất ra hành trình của quân mã trên JTextArea
            for (int i = 1; i <= N * N; i++) {
                printTour(i);
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

    int[][] setMatrixOne(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = -1;
            }
        }
        return matrix;
    }

}
