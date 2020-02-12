import javax.swing.JButton;

public class Player {
    public JButton[][] playerGrid = new JButton[5][5];
    Pieces piece = new Pieces();

    public void showPieceGrid(int row, int col){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                playerGrid[i][j] = new JButton();
            }
        }
        playerGrid[row][col].setEnabled(false);
    }
}