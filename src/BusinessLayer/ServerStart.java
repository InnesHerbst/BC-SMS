/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

/**
 *
 * @author Marline
 */
public class ServerStart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Thread server = new Thread(new ServerSide());
        server.start();
    }

}
