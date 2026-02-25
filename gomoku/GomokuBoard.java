import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 五子棋棋盘实现
 * 使用 Swing 图形界面绘制棋盘，支持点击落子
 */
public class GomokuBoard extends JPanel {
    
    // 棋盘配置
    private static final int BOARD_SIZE = 15;      // 15x15 棋盘
    private static final int CELL_SIZE = 40;       // 每个格子的大小（像素）
    private static final int MARGIN = 30;          // 棋盘边缘留白
    private static final int PIECE_RADIUS = 18;    // 棋子半径
    
    // 棋盘状态：0=空，1=黑棋，2=白棋
    private int[][] board;
    
    // 当前执子方：true=黑棋，false=白棋
    private boolean blackTurn = true;
    
    // 游戏是否结束
    private boolean gameOver = false;
    
    // 最后一步的位置
    private int lastRow = -1;
    private int lastCol = -1;
    
    public GomokuBoard() {
        setPreferredSize(new Dimension(
            BOARD_SIZE * CELL_SIZE + 2 * MARGIN,
            BOARD_SIZE * CELL_SIZE + 2 * MARGIN
        ));
        setBackground(new Color(220, 179, 92)); // 木质颜色
        
        // 初始化棋盘
        resetBoard();
        
        // 添加鼠标监听器
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (gameOver) return;
                
                int x = e.getX();
                int y = e.getY();
                
                // 计算点击位置对应的棋盘坐标
                int col = (x - MARGIN + CELL_SIZE / 2) / CELL_SIZE;
                int row = (y - MARGIN + CELL_SIZE / 2) / CELL_SIZE;
                
                // 检查是否在棋盘范围内且该位置为空
                if (row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE) {
                    if (board[row][col] == 0) {
                        placePiece(row, col);
                    }
                }
            }
        });
    }
    
    /**
     * 重置棋盘
     */
    public void resetBoard() {
        board = new int[BOARD_SIZE][BOARD_SIZE];
        blackTurn = true;
        gameOver = false;
        lastRow = -1;
        lastCol = -1;
        repaint();
    }
    
    /**
     * 落子
     */
    private void placePiece(int row, int col) {
        board[row][col] = blackTurn ? 1 : 2;
        lastRow = row;
        lastCol = col;
        
        // 检查是否获胜
        if (checkWin(row, col)) {
            gameOver = true;
            String winner = blackTurn ? "黑棋" : "白棋";
            JOptionPane.showMessageDialog(this, 
                winner + "获胜！", 
                "游戏结束", 
                JOptionPane.INFORMATION_MESSAGE);
        }
        
        // 切换执子方
        blackTurn = !blackTurn;
        repaint();
    }
    
    /**
     * 检查是否获胜
     */
    private boolean checkWin(int row, int col) {
        int player = board[row][col];
        
        // 四个方向：水平、垂直、左斜、右斜
        int[][] directions = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};
        
        for (int[] dir : directions) {
            int count = 1; // 包含当前落子
            
            // 正方向计数
            count += countInDirection(row, col, dir[0], dir[1], player);
            // 反方向计数
            count += countInDirection(row, col, -dir[0], -dir[1], player);
            
            if (count >= 5) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 在指定方向上连续计数
     */
    private int countInDirection(int row, int col, int dRow, int dCol, int player) {
        int count = 0;
        int r = row + dRow;
        int c = col + dCol;
        
        while (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE && board[r][c] == player) {
            count++;
            r += dRow;
            c += dCol;
        }
        
        return count;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // 抗锯齿
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // 绘制棋盘线
        g.setColor(Color.BLACK);
        for (int i = 0; i < BOARD_SIZE; i++) {
            // 横线
            int y = MARGIN + i * CELL_SIZE;
            g.drawLine(MARGIN, y, MARGIN + (BOARD_SIZE - 1) * CELL_SIZE, y);
            
            // 竖线
            int x = MARGIN + i * CELL_SIZE;
            g.drawLine(x, MARGIN, x, MARGIN + (BOARD_SIZE - 1) * CELL_SIZE);
        }
        
        // 绘制天元和星位（标准15路棋盘的星位）
        int[] starPoints = {3, 7, 11};
        for (int r : starPoints) {
            for (int c : starPoints) {
                int x = MARGIN + c * CELL_SIZE;
                int y = MARGIN + r * CELL_SIZE;
                g.fillOval(x - 4, y - 4, 8, 8);
            }
        }
        
        // 绘制棋子
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] != 0) {
                    int x = MARGIN + j * CELL_SIZE;
                    int y = MARGIN + i * CELL_SIZE;
                    
                    // 设置棋子颜色
                    if (board[i][j] == 1) {
                        g.setColor(Color.BLACK);
                    } else {
                        g.setColor(Color.WHITE);
                    }
                    
                    // 绘制棋子
                    g.fillOval(x - PIECE_RADIUS, y - PIECE_RADIUS, 
                               PIECE_RADIUS * 2, PIECE_RADIUS * 2);
                    
                    // 绘制棋子边框
                    g.setColor(Color.GRAY);
                    g.drawOval(x - PIECE_RADIUS, y - PIECE_RADIUS, 
                               PIECE_RADIUS * 2, PIECE_RADIUS * 2);
                    
                    // 标记最后一步
                    if (i == lastRow && j == lastCol) {
                        g.setColor(Color.RED);
                        g.fillOval(x - 3, y - 3, 6, 6);
                    }
                }
            }
        }
        
        // 显示游戏状态
        if (!gameOver) {
            String turn = blackTurn ? "黑棋" : "白棋";
            g.setColor(Color.BLACK);
            g.setFont(new Font("宋体", Font.BOLD, 16));
            g.drawString("当前：" + turn + " 执子", MARGIN, MARGIN - 10);
        }
    }
    
    /**
     * 创建并显示游戏窗口
     */
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("五子棋");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GomokuBoard board = new GomokuBoard();
        frame.add(board, BorderLayout.CENTER);
        
        // 添加控制按钮
        JPanel buttonPanel = new JPanel();
        JButton resetButton = new JButton("重新开始");
        resetButton.addActionListener(e -> board.resetBoard());
        buttonPanel.add(resetButton);
        
        frame.add(buttonPanel, BorderLayout.SOUTH);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        // 在事件调度线程中运行
        SwingUtilities.invokeLater(GomokuBoard::createAndShowGUI);
    }
}
