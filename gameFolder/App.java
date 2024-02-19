package gameFolder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class App extends GameLogic {
    GameFrame frame = new GameFrame("Mastermindcat");
    myIcon ic = new myIcon();

    public App() {
        frame.setIconImage(new ImageIcon("gameImage\\gameLogo.PNG").getImage());
        frame.setSize(1440, 810);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        addActionListenerToBtn();
        frame.setVisible(true);
    }

    private void addActionListenerToBtn() {

        frame.closeIntro.addActionListener(new ActionListener() {
            int i = 1;
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.introducLabel.setIcon(new ImageIcon("gameImage\\introduce.png"));
                if (i == 2) {
                    frame.setVisibleAllPanel(true);
                }
                i++;
            }
            
        });

        ActionListener btnAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (codeInputArr.size() >= 5) {
                    return;
                }

                if (e.getSource() == frame.b0Button) {
                    codeInputArr.add(0);
                    ((groupOfBoxes) frame.youransBoxes[numGuesses]).setBoxIcon(codeInputArr.size() - 1,
                            ic.getIcon(0, 60));
                } else if (e.getSource() == frame.b1Button) {
                    codeInputArr.add(1);
                    ((groupOfBoxes) frame.youransBoxes[numGuesses]).setBoxIcon(codeInputArr.size() - 1,
                            ic.getIcon(1, 60));
                } else if (e.getSource() == frame.b2Button) {
                    codeInputArr.add(2);
                    ((groupOfBoxes) frame.youransBoxes[numGuesses]).setBoxIcon(codeInputArr.size() - 1,
                            ic.getIcon(2, 60));
                } else if (e.getSource() == frame.b3Button) {
                    codeInputArr.add(3);
                    ((groupOfBoxes) frame.youransBoxes[numGuesses]).setBoxIcon(codeInputArr.size() - 1,
                            ic.getIcon(3, 60));
                } else if (e.getSource() == frame.b4Button) {
                    codeInputArr.add(4);
                    ((groupOfBoxes) frame.youransBoxes[numGuesses]).setBoxIcon(codeInputArr.size() - 1,
                            ic.getIcon(4, 60));
                } else if (e.getSource() == frame.b5Button) {
                    codeInputArr.add(5);
                    ((groupOfBoxes) frame.youransBoxes[numGuesses]).setBoxIcon(codeInputArr.size() - 1,
                            ic.getIcon(5, 60));
                }
            }
        };

        frame.b0Button.addActionListener(btnAction);
        frame.b1Button.addActionListener(btnAction);
        frame.b2Button.addActionListener(btnAction);
        frame.b3Button.addActionListener(btnAction);
        frame.b4Button.addActionListener(btnAction);
        frame.b5Button.addActionListener(btnAction);

        frame.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == frame.submitButton) {
                    if (codeInputArr.size() < 5) {
                        return;
                    }
                    System.out.println("submited");
                    playGame();
                }

                /* when game is over */
                if (guessedCorrectly || numGuesses == MAX_GUESSES) {
                    for (int i = 0; i < 5; i++) {
                        frame.showAns(i, ic.getIcon(secretCode[i], 80));
                    }
                    frame.showScore(calculatePoints(numGuesses, guessedCorrectly, feedback[0], feedback[1]));
                }
                showCheckedTf();
                codeInputArr.clear();
            }
        });

        frame.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (codeInputArr.size() < 1) {
                    return;
                }

                codeInputArr.remove(codeInputArr.size()-1);
                ((groupOfBoxes) frame.youransBoxes[numGuesses]).setBoxIcon(codeInputArr.size(),ic.getTmpIcon(60));
            }
        });


        frame.newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codeInputArr.clear();
                numGuesses = 0;
                secretCode = generateSecretCode();
                guessedCorrectly = false;
                for (int i = 0; i < 7; i++) {
                    frame.positionTf[i].setText("0");
                    frame.elementTf[i].setText("0");
                }
                frame.setInputAnsPanel();
                frame.setDefaltAnsPanel();
                frame.scoreTextField.setText("0");
            }
        });
    }

    private void showCheckedTf() {
        frame.positionTf[numGuesses - 1].setText("" + feedback[0]);
        frame.elementTf[numGuesses - 1].setText("" + feedback[1]);
    }

}
