import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import game.TicTacToe;
import ui.GameWindow;

public class EventHandlers {
    private TicTacToe game;
    private GameWindow gameWindow;

    public EventHandlers(TicTacToe game, GameWindow gameWindow) {
        this.game = game;
        this.gameWindow = gameWindow;
        initializeEventHandlers();
    }

    private void initializeEventHandlers() {
        JButton[][] buttons = gameWindow.getButtons();

        for (int row = 0; row < buttons.length; row++) {
            for (int col = 0; col < buttons[row].length; col++) {
                final int r = row;
                final int c = col;
                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(r, c);
                    }
                });
            }
        }

        gameWindow.getResetButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
    }

    private void handleButtonClick(int row, int col) {
        if (game.makeMove(row, col)) {
            gameWindow.updateButton(row, col, game.getCurrentPlayer());
            if (game.checkWin()) {
                JOptionPane.showMessageDialog(gameWindow, "Player " + game.getCurrentPlayer() + " wins!");
                game.resetGame();
                gameWindow.resetButtons();
            } else if (game.isBoardFull()) {
                JOptionPane.showMessageDialog(gameWindow, "It's a draw!");
                game.resetGame();
                gameWindow.resetButtons();
            }
        }
    }

    private void resetGame() {
        game.resetGame();
        gameWindow.resetButtons();
    }
}