package process.control;

/**
 * @author : zhduan
 * @version : 1.0
 * @date: 2021/9/10 1:36
 * @Description : 流程控制-递归
 * 汉诺塔
 */
public class HanoiTower {

    public static void main(String[] args) {
        Tower tower = new Tower();
        tower.move(3, 'x', 'y', 'z');

    }


}

class Tower {
    public void move(int num, char a, char b, char c) {
        if (num <= 0) {
            throw new RuntimeException("num数必须大于零");
        }
        if (num == 1) {
            System.out.println(a + " -> " + c);
        } else {
            move(num - 1, a, c, b);
            System.out.println(a + " -> " + c);
            move(num - 1, b, a, c);
        }
    }
}