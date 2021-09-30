package process.control;

/**
 * @author : zhduan
 * @version : 1.0
 * @date: 2021/9/9 20:42
 * @Description : 流程控制-递归
 *
 *
 * <p>
 * 1 --> 代表障碍
 * 2 --> 代表当前位置可通行
 * 3 --> 代表无法移动
 * <p>
 * 1 1 1 1 1 1
 * 1 0 0 0 0 1
 * 1 0 0 0 0 1
 * 1 1 1 0 0 1
 * 1 0 0 0 0 1
 * 1 0 0 0 0 1
 * 1 1 1 1 1 1
 */
public class MiGong {
    //定义迷宫大小
    private static int[][] map = new int[10][10];
    private static int[][] rep = new int[10][10];

    public static void main(String[] args) {
        MiGong miGong = new MiGong();
        initMap(map);

        int x = 1;
        int y = 8;

        printMap(map);
        boolean flag = miGong.findWay(map, x, y);
        printMap(map);
        printMap(rep);
        if (flag) {
            System.out.println("找到出口了！");
        }
    }


    //寻路 下左上右
    private boolean findWay(int[][] map, int x, int y) {

        int var = map[x][y];
        if (map[1][1] == 2) {
            return true;
        }
        if (map[x][y] == 0) {
            map[x][y] = 2;
            rep[x][y]++;

            if (findWay(map, x + 1, y)) {
              return true;
            } else if (findWay(map,  x, y - 1)) {
                return true;
            } else if (findWay(map,  x - 1, y)) {
                return true;
            } else if (findWay(map,  x, y + 1)) {
                return true;
            } else {
                map[x][y] = 3;
                return false;
            }
        } else {
            return false;
        }
    }

    //初始化迷宫地图
    private static void initMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == 0 || i == map.length - 1 || j == 0 || j == map[i].length - 1) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
                map[7][1] = 1;
                map[7][2] = 1;
                map[7][3] = 1;
                map[7][4] = 1;
            }
        }
    }

    /**
     * 打印 地图
     */
    private static void printMap(int[][] agrs) {
        System.out.println("----------------------");
        for (int i = 0; i < agrs.length; i++) {
            for (int j = 0; j < agrs[i].length; j++) {
                System.out.print(agrs[i][j] + " ");
            }
            System.out.println();
        }
    }




}