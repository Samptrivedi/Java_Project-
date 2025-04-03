
import javax.swing.*;
import java.awt.*;
import game.TicTacToe;

public class GameWindow extends JFrame {
    private TicTacToe game;
    private JButton[][] buttons;

    public GameWindow() {
        game = new TicTacToe();
        buttons = new JButton[3][3];
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(e -> handleButtonClick(row, col));
                add(buttons[i][j]);
            }
        }
    }

    private void handleButtonClick(int row, int col) {
        if (game.makeMove(row, col)) {
            buttons[row][col].setText(String.valueOf(game.getCurrentPlayer() == 'X' ? 'O' : 'X'));
            if (game.checkWin()) {
                JOptionPane.showMessageDialog(this, "Player " + (game.getCurrentPlayer() == 'X' ? 'O' : 'X') + " wins!");
                resetGame();
            } else if (game.isBoardFull()) {
                JOptionPane.showMessageDialog(this, "It's a draw!");
                resetGame();
            }
        }
    }

    private void resetGame() {
        game = new TicTacToe();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }
}