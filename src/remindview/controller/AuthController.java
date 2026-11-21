package remindview.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import remindview.view.MainFrame;

public class AuthController {

    public AuthController(remindview.view.MainFrame mainFrame) {

        // 로그인 화면의 '회원가입' 버튼
        mainFrame.getLoginPanel()
                 .getOpenSignupButton()
                 .addActionListener(new ActionListener() {

                     @Override
                     public void actionPerformed(ActionEvent e) {
                         mainFrame.showSignup();
                     }
                 });

        // 회원가입 화면의 '로그인으로 돌아가기' 버튼
        mainFrame.getSignupPanel()
                 .getBackToLoginButton()
                 .addActionListener(new ActionListener() {

                     @Override
                     public void actionPerformed(ActionEvent e) {
                         mainFrame.showLogin();
                     }
                 });
    }
}