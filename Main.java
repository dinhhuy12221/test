/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg10_dns_client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddr = InetAddress.getByName("localhost");
            int serverPort = 1000;
            
            Scanner sc = new Scanner(System.in);
            
            while (true) {
                System.out.print("Nhap ten mien can tim: ");
                String request = sc.nextLine();
                
                // Gui truy van
                byte[] requestData = request.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(requestData, requestData.length, serverAddr, serverPort);
                socket.send(sendPacket);
                
                // Nhan phan hoi
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                
                String ip = new String(receivePacket.getData(), 0, receivePacket.getLength());
                
                System.out.println("IP: " + ip);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
