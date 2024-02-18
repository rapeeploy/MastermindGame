package gameFolder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GameFrame extends JFrame {

    private JLabel header = new JLabel("MASTERMINDCAT");
    private JPanel hPanel;

    private JPanel ansPanel;
    private JPanel checkAnsPanel;
    private JPanel inputAnsPanel;
    private JPanel btnPanel;
    private JPanel scorePanel;

    protected JButton b0Button;
    protected JButton b1Button;
    protected JButton b2Button;
    protected JButton b3Button;
    protected JButton b4Button;
    protected JButton b5Button;
    protected JButton submitButton;

    protected groupOfBoxes ansGrp = new groupOfBoxes(80, 80, 40);

    protected JButton newGameButton;
    private JLabel scoreLabel;
    protected JTextField scoreTextField;

    private JPanel infoPanel;
    protected JLabel infoLabel;

    // * ช่องบอกว่าถูกกี่สี/กี่ตำแหน่ง */
    protected JTextField positionCheckField;
    protected JTextField elementCheckField;

    JPanel[] youransBoxes = new groupOfBoxes[7];
    JTextField[] positionTf = new CheckAnsField[7];
    JTextField[] elementTf = new CheckAnsField[7];

    
    Icon tmp60 = new ImageIcon("gameImage\\Rectangle6060.png");
    Icon tmp80 = new ImageIcon("gameImage\\whiteBox80.png");
    
    GameFrame(String s) {
        this.setTitle(s);
        this.getContentPane().setBackground(new Color(59,70,100));

        // *set Panels bounds */
        hPanel = new JPanel();
        hPanel.setLayout(new GridBagLayout());
        hPanel.setBounds(0, 0, 1440, 120);
        hPanel.setBackground(new Color(30, 38, 60));

        header.setFont(new Font(null, 1, 50));
        header.setForeground(new Color(246, 251, 69));
        hPanel.add(header);

        ansPanel = new JPanel();
        ansPanel.setBounds(0, 120, 255, 690);
        ansPanel.setBackground(null);

        checkAnsPanel = new JPanel();
        checkAnsPanel.setBounds(255, 120, 930, 100);
        checkAnsPanel.setBackground(null);

        inputAnsPanel = new JPanel();
        inputAnsPanel.setBounds(255, 220, 930, 400);
        inputAnsPanel.setBackground(null);

        btnPanel = new JPanel();
        // btnPanel.setBounds(255, 619, 930, 191);
        btnPanel.setBounds(255, 640, 930, 191);
        btnPanel.setBackground(null);

        scorePanel = new JPanel();
        scorePanel.setBounds(255 + 930, 120, 255, 810 - 120);
        scorePanel.setBackground(null);

        // *add all panels to frame */
        this.add(hPanel);
        this.add(ansPanel);
        this.add(checkAnsPanel);
        this.add(inputAnsPanel);
        this.add(btnPanel);
        this.add(scorePanel);

        setDefaltAnsPanel();
        setInputAnsPanel();
        setCheckAnsPanel();
        setBtnPanels();
        setScorePanels();
    }

    protected void setDefaltAnsPanel() {
        ansPanel.setLayout(new BoxLayout(ansPanel, BoxLayout.Y_AXIS));

        ansGrp.setBoxIcon(0, tmp80);
        ansGrp.setBoxIcon(1, tmp80);
        ansGrp.setBoxIcon(2, tmp80);
        ansGrp.setBoxIcon(3, tmp80);
        ansGrp.setBoxIcon(4, tmp80);

        ansPanel.add(ansGrp);
    }

    protected void showAns(int i, Icon img) {
        ansGrp.setBoxIcon(i, img);
    }

    protected void showScore(int i) {
        scoreTextField.setText(i+"");
    }
    
    // protected JLabel get_yourAnsBox (int r, int index) {
    //     return ((groupOfBoxes)youransBoxes[r]).getBoxLabel(index);
    // }

    // *create "group of Boxes" | "check tf" in array */
    {
        for (int i = 0; i < 7; i++) {
            youransBoxes[i] = new groupOfBoxes(60, 60, 10);
            positionTf[i] = new CheckAnsField();
            elementTf[i] = new CheckAnsField();
        }

    }

    protected void setInputAnsPanel() {
        inputAnsPanel.setLayout(new BoxLayout(inputAnsPanel, BoxLayout.X_AXIS));
        // *set icon */

        System.out.println(youransBoxes[0]);
        for (JPanel t : youransBoxes) {
            for (int i = 0; i < 5; i++) {
                ((groupOfBoxes) t).setBoxIcon(i, tmp60);
                // ((groupOfBoxes) t).setForeground(Color.WHITE);
            }
        }

        
    }

    private void setCheckAnsPanel() {
        checkAnsPanel.setLayout(new BoxLayout(checkAnsPanel, BoxLayout.X_AXIS));
        checkAnsPanel.setBorder(new EmptyBorder(25, 0, 0, 0));

        // *add grp of boxes to panel */
        for (int i = 0; i < 7; i++) {
            JPanel ch = new JPanel();
            ch.setSize(70, 50);
            ch.setBackground(null);
            ch.add(positionTf[i]);
            ch.add(elementTf[i]);

            checkAnsPanel.add(ch);
            inputAnsPanel.add(youransBoxes[i]);
        }
    }

    private void setBtnPanels() {
        myIcon ic = new myIcon();
        submitButton = new JButton();
        submitButton.setPreferredSize(new Dimension(150, 90));
        submitButton.setText("Submit");
        submitButton.setBackground(new Color(255,149,181));

        b0Button = new JButton();
        // b0Button.addActionListener(this);
        b0Button.setPreferredSize(new Dimension(90, 90));
        b0Button.setIcon(ic.getIcon(0, 90));
        // b0Button.setText("1");

        b1Button = new JButton();
        b1Button.setPreferredSize(new Dimension(90, 90));
        b1Button.setIcon(ic.getIcon(1, 90));
        // b1Button.setText("2");

        b2Button = new JButton();
        b2Button.setPreferredSize(new Dimension(90, 90));
        // b2Button.setIcon(ic.getIcon(3, 90));
        b2Button.setIcon(ic.getIcon(2, 90));
        // b2Button.setText("3");

        b3Button = new JButton();
        b3Button.setPreferredSize(new Dimension(90, 90));
        b3Button.setIcon(ic.getIcon(3, 90));
        // b3Button.setText("4");

        b4Button = new JButton();
        b4Button.setPreferredSize(new Dimension(90, 90));
        b4Button.setIcon(ic.getIcon(4, 90));
        // b4Button.setText("5");

        b5Button = new JButton();
        b5Button.setPreferredSize(new Dimension(90, 90));
        b5Button.setIcon(ic.getIcon(5, 90));
        // b5Button.setText("6");

        btnPanel.add(b0Button);
        btnPanel.add(b1Button);
        btnPanel.add(b2Button);
        btnPanel.add(b3Button);
        btnPanel.add(b4Button);
        btnPanel.add(b5Button);

        btnPanel.add(submitButton);

    }

    protected void setScorePanels() {

        scorePanel.setBorder(new EmptyBorder(90, 10, 10, 10));

        newGameButton = new JButton("new game", null);
        newGameButton.setPreferredSize(new Dimension(150, 70));
        newGameButton.setBackground(new Color(156, 198, 122));

        scoreLabel = new JLabel(); 
        scoreLabel.setText("TOTAL SCORE");
        //TODO 
        JPanel totalScorePanel = new JPanel();
        totalScorePanel.setLayout(new FlowLayout());
        totalScorePanel.setPreferredSize(new Dimension(150,100));
        totalScorePanel.setBackground(Color.WHITE);

        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
        scoreLabel.setPreferredSize(new Dimension(150, 20));

        scoreTextField = new JTextField();
        scoreTextField.setText("0");
        scoreTextField.setFont(new Font(null, 0, 50));
        scoreTextField.setBackground(null);
        scoreTextField.setHorizontalAlignment(JTextField.CENTER);
        scoreTextField.setPreferredSize(new Dimension(150, 80));
        scoreTextField.setEditable(false);

        totalScorePanel.add(scoreLabel);
        totalScorePanel.add(scoreTextField);

        infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(150, 100));
        infoPanel.setBackground(new Color(254,202,49 ));

        elementCheckField = new CheckAnsField();
        positionCheckField = new CheckAnsField();

        infoLabel = new JLabel();
        infoLabel.setSize(150, 200);
        infoLabel.setText("<html>1st : Exact Match<br/> 2nd : Element Match</html>");

        infoPanel.add(positionCheckField);
        infoPanel.add(elementCheckField);
        infoPanel.add(infoLabel);

        scorePanel.add(newGameButton);
        // scorePanel.add(scoreLabel);
        // scorePanel.add(scoreTextField);
        scorePanel.add(totalScorePanel);
        scorePanel.add(infoPanel);

    }

}

/**
 * Icon
 */
class myIcon{
    Icon icon;
    Icon[] icon_60 = new Icon[6];
    Icon[] icon_80 = new Icon[6];
    Icon[] icon_90 = new Icon[6];
    Icon[] tmp = new Icon[2];

    {
        tmp[0] = new ImageIcon("gameImage\\Rectangle6060.png");
        tmp[0] = new ImageIcon("gameImage\\whiteBox80.png");

        icon_60[0] = new ImageIcon("gameImage\\icon0_60.png");
        icon_60[1] = new ImageIcon("gameImage\\icon1_60.png");
        icon_60[2] = new ImageIcon("gameImage\\icon2_60.png");
        icon_60[3] = new ImageIcon("gameImage\\icon3_60.png");
        icon_60[4] = new ImageIcon("gameImage\\icon4_60.png");
        icon_60[5] = new ImageIcon("gameImage\\icon5_60.png");

        icon_80[0] = new ImageIcon("gameImage\\icon0_80.png");
        icon_80[1] = new ImageIcon("gameImage\\icon1_80.png");
        icon_80[2] = new ImageIcon("gameImage\\icon2_80.png");
        icon_80[3] = new ImageIcon("gameImage\\icon3_80.png");
        icon_80[4] = new ImageIcon("gameImage\\icon4_80.png");
        icon_80[5] = new ImageIcon("gameImage\\icon5_80.png");

        icon_90[0] = new ImageIcon("gameImage\\icon0_90.png");
        icon_90[1] = new ImageIcon("gameImage\\icon1_90.png");
        icon_90[2] = new ImageIcon("gameImage\\icon2_90.png");
        icon_90[3] = new ImageIcon("gameImage\\icon3_90.png");
        icon_90[4] = new ImageIcon("gameImage\\icon4_90.png");
        icon_90[5] = new ImageIcon("gameImage\\icon5_90.png");
    }

    myIcon() {

    }

    public Icon getIcon(int i, int size) {
        if (size == 60) {
            return this.icon = icon_60[i];
        } else if (size == 80) {
            return this.icon = icon_80[i];
        } else if (size == 90){
            return this.icon = icon_90[i];
        }
        return this.icon;
    }

    public Icon getTmpIcon(int size) {
        if (size == 60) {
            return tmp[0];
        } else if (size == 80) {
            return tmp[1];
        }

        return icon;
    }
}

class CheckAnsField extends JTextField{
    CheckAnsField() {
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setPreferredSize(new Dimension(35,50));
        this.setFont(new Font(null, 0, 30));
        this.setText("0");
        this.setEditable(false);
    }
}