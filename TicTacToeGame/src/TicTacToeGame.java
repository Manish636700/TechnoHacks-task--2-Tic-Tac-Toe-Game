import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame extends JFrame implements ActionListener{
    private JButton[][] buttons;
    private char currentPlayer;

    public TicTacToeGame(){
        setTitle("Tic Tac Toe Game");
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        buttons = new JButton[3][3];
        currentPlayer = 'X';
        initializeButtons();
    }
    private void initializeButtons(){
        setLayout(new GridLayout(3,3));

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial",Font.PLAIN,60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        JButton clickedButton = (JButton) e.getSource();
        if(clickedButton.getText().equals("")){
            clickedButton.setText(String.valueOf(currentPlayer));
            clickedButton.setEnabled(false);
            checkWin();
            togglePlayer();
        }
    }
    private void togglePlayer(){
        currentPlayer = (currentPlayer == 'X')?'O' : 'X';
    }
    private void checkWin(){
        for(int i=0; i<3; i++) {
            if (buttons[i][0].getText().equals(String.valueOf(currentPlayer)) && buttons[i][1].getText().equals(String.valueOf(currentPlayer)) && buttons[i][2].getText().equals(String.valueOf(currentPlayer))) {
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + "Wins!");
                resetBoard();
                return;
            }
            if (buttons[0][i].getText().equals(String.valueOf(currentPlayer)) && buttons[1][i].getText().equals(String.valueOf(currentPlayer)) && buttons[2][i].getText().equals(String.valueOf(currentPlayer))) {
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + "Wins!");
                resetBoard();
                return;
            }
        }

            if(buttons[0][0].getText().equals(String.valueOf(currentPlayer))&&buttons[1][1].getText().equals(String.valueOf(currentPlayer))&&buttons[2][2].getText().equals(String.valueOf(currentPlayer)))
            {
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + "Wins !" );
            }
            if(buttons[0][2].getText().equals(String.valueOf(currentPlayer))&&buttons[1][1].getText().equals(String.valueOf(currentPlayer))&&buttons[2][0].getText().equals(String.valueOf(currentPlayer)))
            {
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + "Wins!");
                resetBoard();
                return;
            }
            boolean isDraw = true;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(buttons[i][j].getText().equals("")){
                        isDraw = false;
                        break;
                    }
                }
            }
            if(isDraw){
                JOptionPane.showMessageDialog(this,"it is a draw !");
                resetBoard();
            }
        }
        private void resetBoard(){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    buttons[i][j].setText("");
                    buttons[i][j].setEnabled(true);
                }
            }
            currentPlayer = 'X';
        }
        public static void main(String[] args){
            SwingUtilities.invokeLater(()-> new TicTacToeGame());
        }
    }