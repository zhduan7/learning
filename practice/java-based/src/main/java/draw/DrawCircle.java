package draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author : zhduan
 * @version : 1.0
 * @date: 2021/9/11 0:36
 * @Description : draw
 */
public class DrawCircle extends JFrame {
    //定义一个画板
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        //初始化面板
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(50, 50, 100, 150);
        System.out.println("==调用==");
    }
}
