package process.control;

/**
 * @author : zhduan
 * @version : 1.0
 * @date: 2021/9/10 2:21
 * @Description : 流程控制-递归
 * 八皇后问题
 */
public class EightQueen {

    public static void main(String[] args) {
        int[][] map = new int[8][8];

        printMap(map);


    }


    /**
     * 打印
     */
    private static void printMap(int[][] agrs) {
        System.out.println("----------------------");
        for (int i = 0; i < agrs.length; i++) {
            for (int j = 0; j < agrs[i].length; j++) {
                System.out.print(agrs[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
