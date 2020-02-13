import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

public class GUI{

    private int redpieceIndex = 20;
    private int greenpieceIndex = 20;
    private int bluepieceIndex = 20;
    private int yellowpieceIndex = 20;
    MainGrid redGrid = new MainGrid();
    MainGrid blueGrid = new MainGrid();
    MainGrid greenGrid = new MainGrid();
    MainGrid yellowGrid = new MainGrid();
    MainGrid maingrid = new MainGrid();
    Pieces pieces = new Pieces();

    public GUI(){ //Full
        JFrame blokusFrame = new JFrame();
        BorderLayout frameLayout = new BorderLayout();
        blokusFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        blokusFrame.setTitle("Blokus");
        blokusFrame.setSize(700,400);
        blokusFrame.setLayout(frameLayout);
        blokusFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        blokusFrame.setLocationRelativeTo(null);
        blokusFrame.setVisible(true);

        GridLayout gridLayout = new GridLayout(20,20);
        GridLayout pieceGrid = new GridLayout(5,5);
        JPanel playerOnePanel = new JPanel();
        JPanel playerTwoPanel = new JPanel();
        JPanel playerThreePanel = new JPanel();
        JPanel playerFourPanel = new JPanel();
        JPanel playerOneTwoPanel = new JPanel();
        JPanel playerThreeFourPanel = new JPanel();
        JPanel piecePanelRed = new JPanel();
        JPanel piecePanelBlue = new JPanel();
        JPanel piecePanelGreen = new JPanel();
        JPanel piecePanelYellow = new JPanel();
        JPanel boardPanel = new JPanel();

        //Buat Main Panel yang 20 X 20
        boardPanel.setPreferredSize(new Dimension(350,300));
        boardPanel.setBackground(Color.white);
        boardPanel.setLayout(gridLayout);
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                maingrid.createGrid(i, j, true);
                maingrid.mousehandler(i, j, pieces.piece, 3);
                boardPanel.add(maingrid.mainGrid[i][j]);
                maingrid.gridColor(i, j);
            }
        }
        //=================================================================================

        //BUAT YANG RED
        piecePanelRed.setPreferredSize(new Dimension(200,200));
        piecePanelRed.setBackground(Color.white);
        piecePanelRed.setLayout(pieceGrid);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                redGrid.createGrid(i, j, false);
                piecePanelRed.add(redGrid.mainGrid[i][j]);
                redGrid.gridColor(i, j);
            }
        }

        JButton RightRed = new JButton("Rotate Right");
        JButton FlipRed = new JButton("flip");
        JButton LeftRed = new JButton("Rotate Left");
        JButton NextRed = new JButton("Next");
        JButton PreviousRed = new JButton("Previous");

        NextRed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                redpieceIndex++;
                if (redpieceIndex > 20){
                    redpieceIndex = 0;
                } 
                pieces.pieceClear();
                pieces.switchPieces(redpieceIndex);
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                            if (pieces.piece[i][j] >= 1){
                            redGrid.setCellColor(i, j, Color.RED);
                        }
                        else{
                            redGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        PreviousRed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                redpieceIndex--;
                if(redpieceIndex < 0)
                    redpieceIndex = 20;
                pieces.pieceClear();
                pieces.switchPieces(redpieceIndex);
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            redGrid.setCellColor(i, j, Color.RED);
                        }
                        else{
                            redGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        LeftRed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5 ; j++){
                        redGrid.setCellColor(i, j, Color.WHITE);
                    }
                }
                pieces.rotateLeft();
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            redGrid.setCellColor(i, j, Color.RED);
                        }
                        else{
                            redGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        RightRed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5 ; j++){
                        redGrid.setCellColor(i, j, Color.WHITE);
                    }
                }
                pieces.rotateRight();
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            redGrid.setCellColor(i, j, Color.RED);
                        }
                        else{
                            redGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        FlipRed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5 ; j++){
                        redGrid.setCellColor(i, j, Color.WHITE);
                    }
                }
                pieces.flipVertical();
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            redGrid.setCellColor(i, j, Color.RED);
                            }
                        else{
                            redGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        playerOnePanel.setPreferredSize(new Dimension(300,300));
        playerOnePanel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        playerOnePanel.add(piecePanelRed);

        //DISPLAY BUTTON
        playerOnePanel.add(RightRed);
        playerOnePanel.add(FlipRed);
        playerOnePanel.add(LeftRed);
        playerOnePanel.add(PreviousRed);
        playerOnePanel.add(NextRed);
        //==============================================================================

        //BUAT YANG GREEN
        piecePanelGreen.setPreferredSize(new Dimension(200,200));
        piecePanelGreen.setBackground(Color.white);
        piecePanelGreen.setLayout(pieceGrid);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                greenGrid.createGrid(i, j, false);
                piecePanelGreen.add(greenGrid.mainGrid[i][j]);
                greenGrid.gridColor(i, j);
            }
        }

        JButton RightGreen = new JButton("Rotate Right");
        JButton FlipGreen = new JButton("flip");
        JButton LeftGreen = new JButton("Rotate Left");
        JButton NextGreen = new JButton("Next");
        JButton PreviousGreen = new JButton("Previous");

        NextGreen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                greenpieceIndex++;
                if (greenpieceIndex > 20){
                    greenpieceIndex = 0;
                } 
                pieces.pieceClear();
                pieces.switchPieces(greenpieceIndex);
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            greenGrid.setCellColor(i, j, Color.GREEN);
                        }
                        else{
                            greenGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        PreviousGreen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                greenpieceIndex--;
                if(greenpieceIndex < 0)
                    greenpieceIndex = 20;
                pieces.pieceClear();
                pieces.switchPieces(greenpieceIndex);
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            greenGrid.setCellColor(i, j, Color.green);
                        }
                        else{
                            greenGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        LeftGreen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5 ; j++){
                        greenGrid.setCellColor(i, j, Color.WHITE);
                    }
                }
                pieces.rotateLeft();
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            greenGrid.setCellColor(i, j, Color.GREEN);
                        }
                        else{
                            greenGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        RightGreen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5 ; j++){
                        greenGrid.setCellColor(i, j, Color.WHITE);
                    }
                }
                pieces.rotateRight();
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            greenGrid.setCellColor(i, j, Color.green);
                        }
                        else{
                            greenGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        FlipGreen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5 ; j++){
                        greenGrid.setCellColor(i, j, Color.WHITE);
                    }
                }
                pieces.flipVertical();
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            greenGrid.setCellColor(i, j, Color.GREEN);
                        }
                        else{
                            greenGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        playerTwoPanel.setPreferredSize(new Dimension(300,300));
        playerTwoPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
        playerTwoPanel.add(piecePanelGreen);

        //DISPLAY BUTTON
        playerTwoPanel.add(RightGreen);
        playerTwoPanel.add(FlipGreen);
        playerTwoPanel.add(LeftGreen);
        playerTwoPanel.add(PreviousGreen);
        playerTwoPanel.add(NextGreen);
        //===========================================================================

        //BUAT YANG BLUE
        piecePanelBlue.setPreferredSize(new Dimension(200,200));
        piecePanelBlue.setBackground(Color.white);
        piecePanelBlue.setLayout(pieceGrid);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                blueGrid.createGrid(i, j, false);
                piecePanelBlue.add(blueGrid.mainGrid[i][j]);
                blueGrid.gridColor(i, j);
            }
        }

        JButton RightBlue = new JButton("Rotate Right");
        JButton FlipBlue = new JButton("flip");
        JButton LeftBlue = new JButton("Rotate Left");
        JButton NextBlue = new JButton("Next");
        JButton PreviousBlue = new JButton("Previous");

        NextBlue.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bluepieceIndex++;
                if (bluepieceIndex > 20){
                    bluepieceIndex = 0;
                } 
                pieces.pieceClear();
                pieces.switchPieces(bluepieceIndex);
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            blueGrid.setCellColor(i, j, Color.BLUE);
                        }
                        else{
                            blueGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        PreviousBlue.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bluepieceIndex--;
                if(bluepieceIndex < 0)
                    bluepieceIndex = 20;
                pieces.pieceClear();
                pieces.switchPieces(bluepieceIndex);
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            blueGrid.setCellColor(i, j, Color.BLUE);
                        }
                        else{
                            blueGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        LeftBlue.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5 ; j++){
                        blueGrid.setCellColor(i, j, Color.WHITE);
                    }
                }
                pieces.rotateLeft();
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            blueGrid.setCellColor(i, j, Color.BLUE);
                        }
                        else{
                            blueGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        RightBlue.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5 ; j++){
                        blueGrid.setCellColor(i, j, Color.WHITE);
                    }
                }
                pieces.rotateRight();
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            blueGrid.setCellColor(i, j, Color.BLUE);
                        }
                        else{
                            blueGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        FlipBlue.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5 ; j++){
                        blueGrid.setCellColor(i, j, Color.WHITE);
                    }
                }
                pieces.flipVertical();
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            blueGrid.setCellColor(i, j, Color.BLUE);
                        }
                        else{
                            blueGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });


        playerThreePanel.setPreferredSize(new Dimension(300,300));
        playerThreePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        playerThreePanel.add(piecePanelBlue);

        //DISPLAY BUTTON
        playerThreePanel.add(RightBlue);
        playerThreePanel.add(FlipBlue);
        playerThreePanel.add(LeftBlue);
        playerThreePanel.add(PreviousBlue);
        playerThreePanel.add(NextBlue);
        //============================================================================

        //BUAT YANG Yellow
        piecePanelYellow.setPreferredSize(new Dimension(200,200));
        piecePanelYellow.setBackground(Color.white);
        piecePanelYellow.setLayout(pieceGrid);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                yellowGrid.createGrid(i, j, false);
                piecePanelYellow.add(yellowGrid.mainGrid[i][j]);
                yellowGrid.gridColor(i, j);
            }
        }

        JButton RightYellow = new JButton("Rotate Right");
        JButton FlipYellow = new JButton("flip");
        JButton LeftYellow = new JButton("Rotate Left");
        JButton NextYellow = new JButton("Next");
        JButton PreviousYellow = new JButton("Previous");

        NextYellow.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                yellowpieceIndex++;
                if (yellowpieceIndex > 20){
                    yellowpieceIndex = 0;
                } 
                pieces.pieceClear();
                pieces.switchPieces(yellowpieceIndex);
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            yellowGrid.setCellColor(i, j, Color.YELLOW);
                        }
                        else{
                            yellowGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        PreviousYellow.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                yellowpieceIndex--;
                if(yellowpieceIndex < 0)
                    yellowpieceIndex = 20;
                pieces.pieceClear();
                pieces.switchPieces(yellowpieceIndex);
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            yellowGrid.setCellColor(i, j, Color.YELLOW);
                        }
                        else{
                            yellowGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        LeftYellow.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5 ; j++){
                        yellowGrid.setCellColor(i, j, Color.WHITE);
                    }
                }
                pieces.rotateLeft();
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            yellowGrid.setCellColor(i, j, Color.YELLOW);
                        }
                        else{
                            yellowGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        RightYellow.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5 ; j++){
                        yellowGrid.setCellColor(i, j, Color.WHITE);
                    }
                }
                pieces.rotateRight();
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            yellowGrid.setCellColor(i, j, Color.YELLOW);
                        }
                        else{
                            yellowGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        FlipYellow.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5 ; j++){
                        yellowGrid.setCellColor(i, j, Color.WHITE);
                    }
                }
                pieces.flipVertical();
                for (int i=0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (pieces.piece[i][j] >= 1){
                            yellowGrid.setCellColor(i, j, Color.YELLOW);
                        }
                        else{
                            yellowGrid.setCellColor(i, j, Color.WHITE);
                        }
                    }
                }
            }
        });

        playerFourPanel.setPreferredSize(new Dimension(300,300));
        playerFourPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
        playerFourPanel.add(piecePanelYellow);

        //DISPLAY BUTTON
        playerFourPanel.add(RightYellow);
        playerFourPanel.add(FlipYellow);
        playerFourPanel.add(LeftYellow);
        playerFourPanel.add(PreviousYellow);
        playerFourPanel.add(NextYellow);
        //============================================================================

        BorderLayout PanelLayoutEast = new BorderLayout();
        BorderLayout PanelLayoutWest = new BorderLayout();

        //playerOneTwoPanel
        playerOneTwoPanel.setLayout(PanelLayoutEast);
        playerOneTwoPanel.setPreferredSize(new Dimension(300,300));
        playerOneTwoPanel.setBackground(Color.WHITE);
        playerOneTwoPanel.add(playerOnePanel, BorderLayout.NORTH);
        playerOneTwoPanel.add(playerTwoPanel, BorderLayout.SOUTH);

        //playerThreeFourPanel
        playerThreeFourPanel.setLayout(PanelLayoutWest);
        playerThreeFourPanel.setPreferredSize(new Dimension(300, 300));
        playerThreeFourPanel.setBackground(Color.WHITE);
        playerThreeFourPanel.add(playerThreePanel, BorderLayout.NORTH);
        playerThreeFourPanel.add(playerFourPanel, BorderLayout.SOUTH);

        blokusFrame.add(playerOneTwoPanel, BorderLayout.WEST);
        blokusFrame.add(playerThreeFourPanel, BorderLayout.EAST);
        blokusFrame.add(boardPanel, BorderLayout.CENTER);
        blokusFrame.revalidate();
        blokusFrame.repaint();
    }

    public static void main(String[] args) {
        new GUI();
    }
}