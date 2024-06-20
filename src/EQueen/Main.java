/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EQueen;

import EQueen.Controller.TrangChuController;
import EQueen.View.TrangChuView;

/**
 *
 * @author ADMIN
 */
public class Main {
    
    public static void main(String[] args){
        // Mở trang chủ 
        TrangChuView trangChuView = new TrangChuView();
        TrangChuController trangChuController = new TrangChuController(trangChuView);
        trangChuView.setVisible(true);
    }
    
}