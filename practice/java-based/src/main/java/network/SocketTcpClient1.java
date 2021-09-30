package network;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author : zhduan
 * @version : 1.0
 * @date: 2021/9/11 6:33
 * @Description : network
 */
public class SocketTcpClient1 {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",8888);

        //构建IO
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        //向服务器端发送一条消息
        bw.write("测试客户端和服务器通信，服务器接收到消息返回到客户端\n");
        bw.flush();

        //读取服务器返回的消息
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String mess = br.readLine();

        System.out.println("服务器："+mess);

        System.out.println("客户端退出...");
    }
}
