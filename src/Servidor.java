import java.io.*;
import java.net.*;

public class Servidor extends Thread{

    private Socket socket;

    public Servidor(Socket conexao) {
        this.socket = conexao;
    }

    @Override
    public void run() {
        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            String mensagem = entrada.readUTF();
            System.out.println(mensagem);
            socket.close();
        } catch (IOException e) {
            System.out.println("problema no processamento dos dados...");
        }
    }

    public static void main(String[] args) {
        int ordemConexao = 1;
        try {
            ServerSocket server = new ServerSocket(54660);
            System.out.println("Server em pé na porta 54660...");

            while (true){
                Socket conexao = server.accept();
                Servidor sThread = new Servidor(conexao);
                System.out.println("CONEXAO: " + ordemConexao ++);
                sThread.start();
            }
        } catch (IOException e) {
            System.out.println("Erro ao conectar com o servidor...");
        }
    }
}
