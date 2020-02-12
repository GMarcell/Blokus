import java.awt.Color; 
import java.awt.event.MouseAdapter;
import javax.swing.JButton;

public class MainGrid {
    public JButton[][] mainGrid = new JButton[20][20];
    Pieces piece = new Pieces();

    public void createGrid(int row, int col, boolean isMainBoard){
        mainGrid[row][col] = new JButton();
        mainGrid[row][col].setEnabled(false);
    }

    // public void mouseHandler(int row, int col, int[][] map, int player){
    //     mainGrid[row][col].addMouseListener(new MouseAdapter(){
    //         @Override
    //         public void mouseEntered(MouseEvent evt){
    //             for(int i = 0; i < 5; i++){
    //                 for(int j = 0; j < 5; j++){
    //                     if(map[row][col] >= 1){
    //                         if(player == 1){
    //                             mainGrid[row-i][col-j].setBackground(Color.BLUE);
    //                         }
    //                         if(player == 2){
    //                             mainGrid[row-i][col-j].setBackground(Color.GREEN);
    //                         }
    //                         if(player == 3){
    //                             mainGrid[row-i][col-j].setBackground(Color.RED);
    //                         }
    //                         if(player == 4){
    //                             mainGrid[row-i][col-j].setBackground(Color.YELLOW);
    //                         }
    //                     }
    //                 }
    //             }
    //         }
            
    //         @Override
    //         public void mouseExited(MouseEvent evt){
    //             for(int i = 0; i < 5; i++){
    //                 for(int j = 0; j < 5; j++){
    //                     if(map[i][j] >= 1){
    //                         if(player == 1){
    //                             mainGrid[row-i][col-j].setBackground(Color.WHITE);
    //                         }
    //                         if(player == 2){
    //                             mainGrid[row-i][col-j].setBackground(Color.GREEN);
    //                         }
    //                         if(player == 3){
    //                             mainGrid[row-i][col-j].setBackground(Color.RED);
    //                         }
    //                         if(player == 4){
    //                             mainGrid[row-i][col-j].setBackground(Color.YELLOW);
    //                         }
    //                     }
    //                 }
    //             }
    //         }
    //     });
    // }

    public void mousehandler(int x,int y, int[][]map, int player){
        mainGrid[x][y].addMouseListener(new MouseAdapter(){

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {

                for (int i = 0 ; i < 5 ; i++){
                    for (int j = 0 ; j < 5 ; j++){
                        if (map[i][j] >= 1){
                            if (player == 1){
                                mainGrid[x-i][y-j].setBackground(Color.BLUE);
                            }
                            else if (player == 2){
                                mainGrid[x-i][y-j].setBackground(Color.GREEN);
                            }
                            else if (player == 3){
                                mainGrid[x-i][y-j].setBackground(Color.RED);
                            }
                            else {
                                mainGrid[x-i][y-j].setBackground(Color.YELLOW);
                            }
                        }
                    }
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                for (int i = 0 ; i < 5 ; i++){
                    for (int j = 0 ; j < 5 ; j++){
                        if (map[i][j] >= 1){
                            mainGrid[x-i][y-j].setBackground(Color.WHITE);
                        }
                    }
                }
            }
        });
    }

    public void gridColor(int row, int col){
        mainGrid[row][col].setBackground(Color.WHITE);
    }

    public void setCellColor(int row, int col, Color color){
        mainGrid[row][col].setBackground(color);
    }
}