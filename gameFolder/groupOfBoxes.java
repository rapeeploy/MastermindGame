package gameFolder;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class groupOfBoxes extends JPanel {
    int w;
    int h;

    JLabel[] b = new BoxObj[5];
    {
        b[0] = new BoxObj(w, h);
        b[1] = new BoxObj(w, h);
        b[2] = new BoxObj(w, h);
        b[3] = new BoxObj(w, h);
        b[4] = new BoxObj(w, h);

    }

    groupOfBoxes(int w, int h, int gap) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(null);
        this.setSize(w, h * 5);
        for (JLabel boxObj : b) {
            this.add(Box.createVerticalStrut(gap));
            this.add(boxObj);
        }
    }

    protected void setBoxIcon(int index, Icon icon) {
        b[index].setIcon(icon);
    }

    protected JLabel getBoxLabel (int index) {
        return this.b[index];
    }

}

class BoxObj extends JLabel {
    int width;
    int height;

    BoxObj(int w, int h) {
        this.setPreferredSize(new Dimension(w, h));
        this.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    }



}
