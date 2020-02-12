import java.util.*;

public class Pieces {
    public int num = 0;
    // piece 1 = [1,0,0,0,0,0,0]
    public int pieceNum = 2;
    public int [][] piece = {{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
    
    
    public void switchPieces(int x){
        switch (x) {
            case 0:
                piece[0][0] = 2;
                break;
            case 1:
                piece[0][0] = 2;
                piece[0][1] = 1;
                break;
            case 2:
                piece[0][0] = 1;
                piece[0][1] = 1;
                piece[1][0] = 1;
                break;
            case 3:
                piece[0][0] = 1;
                piece[0][1] = 1;
                piece[0][2] = 1;
                break;
            case 4:
                piece[0][0] = 1;
                piece[0][1] = 1;
                piece[1][0] = 1;
                piece[1][1] = 1;
                break;
            case 5:
                piece[0][0] = 1;
                piece[0][1] = 1;
                piece[1][0] = 1;
                piece[2][0] = 1;
                break;
            case 6:
                piece[0][1] = 1;
                piece[1][0] = 1;
                piece[1][1] = 1;
                piece[1][2] = 1;
                break;
            case 7:
                piece[0][0] = 1;
                piece[0][1] = 1;
                piece[1][1] = 1;
                piece[1][2] = 1;
                break;
            case 8:
                piece[0][0] = 1;
                piece[0][1] = 1;
                piece[0][2] = 1;
                piece[0][3] = 1;
                break;
            case 9:
                piece[0][0] = 1;
                piece[0][1] = 1;
                piece[1][0] = 1;
                piece[1][1] = 1;
                piece[2][0] = 1;
                break;
            case 10:
                piece[0][0] = 1;
                piece[0][1] = 1;
                piece[1][0] = 1;
                piece[2][0] = 1;
                piece[2][1] = 1;
                break;
            case 11:
                piece[0][0] = 1;
                piece[0][1] = 1;
                piece[0][2] = 1;
                piece[1][2] = 1;
                piece[2][2] = 1;
                break;
            case 12:
                piece[0][0] = 1;
                piece[1][0] = 1;
                piece[1][1] = 1;
                piece[1][2] = 1;
                piece[2][2] = 1;
                break;
            case 13:
                piece[0][0] = 1;
                piece[1][0] = 1;
                piece[2][0] = 1;
                piece[1][1] = 1;
                piece[1][2] = 1;
                break;
            case 14:
                piece[0][0] = 1;
                piece[0][1] = 1;
                piece[1][1] = 1;
                piece[1][2] = 1;
                piece[2][2] = 1;
                break;
            case 15:
                piece[0][1] = 1;
                piece[1][0] = 1;
                piece[1][1] = 1;
                piece[2][1] = 1;
                piece[2][2] = 1;
                break;
            case 16:
                piece[0][1] = 1;
                piece[1][0] = 1;
                piece[1][1] = 1;
                piece[2][1] = 1;
                piece[1][2] = 1;
                break;
            case 17:
                piece[0][0] = 1;
                piece[1][0] = 1;
                piece[0][1] = 1;
                piece[0][2] = 1;
                piece[0][3] = 1;
                break;
            case 18:
                piece[1][0] = 1;
                piece[1][1] = 1;
                piece[0][1] = 1;
                piece[0][2] = 1;
                piece[0][3] = 1;
                break;
            case 19:
                piece[0][1] = 1;
                piece[0][2] = 1;
                piece[1][3] = 1;
                piece[0][3] = 1;
                piece[0][4] = 1;
                break;
            case 20:
                piece[0][0] = 1;
                piece[0][1] = 1;
                piece[0][2] = 1;
                piece[0][3] = 1;
                piece[0][4] = 1;
                break;
            default:
                break;
        }
    }
    
    public void pieceClear(){
        for (int i =0 ; i < 5 ; i++){
            for (int j = 0 ; j < 5 ; j++){
                piece[i][j]=0;
            }
        }
    }
    
    public void rotateRight(){
        int[][] rotatedMatrix = new int[5][5];
        for (int i = 0; i < 5; i++){
            for (int j = 0 ; j < 5 ; j++){
                rotatedMatrix[j][(5-1)-i]=piece[i][j];
            }
        }
        for (int i = 0; i < 5; i++){
            for (int j = 0 ; j < 5 ; j++){
                piece[i][j] = rotatedMatrix[i][j];
            }
        }
    }
    public void rotateLeft(){
        int[][] rotatedMatrix = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                rotatedMatrix[(5-1)-j][i] = piece[i][j]; 
            }
        }
        for (int i = 0; i < 5; i++){
            for (int j = 0 ; j < 5 ; j++){
                piece[i][j] = rotatedMatrix[i][j];
            }
        }
    }
    
    public void flipVertical(){
        Collections.reverse(Arrays.asList(piece));
    }
    
    public void flipHorizontal(){
        int[][]flip = new int [5][5];
        int j = 5;
        for (int i = 0; i < 5;i++){
            flip[j-1] = piece[i];
            j = j - 1;
        }
    }

    public void placePiece(){
        
    }
}
    