package com.wallet.app.controller;
import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;
import com.wallet.app.service.WalletService;
import com.wallet.app.service.WalletServiceImpl;
import com.wallet.app.dao.WalletUtility;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws WalletException {

        WalletService walletService = new WalletServiceImpl();
        Scanner scanner = new Scanner(System.in);
        //Add new wallets
        try {
//            System.out.println("What is your first name?");
//            String newName = scanner.nextLine();
//            System.out.println("Enter your password");
//            String newPassword = scanner.nextLine().toString();
//            System.out.println("What is your current account balance?");
//            Double newBalance = scanner.nextDouble();
//
//            Wallet wallet = walletService.registerWallet(new Wallet(newName, newBalance, newPassword));
            Wallet wallet2 = walletService.registerWallet(new Wallet("ford", 300.0, "lol"));
//            System.out.println(wallet);
            System.out.println(wallet2);
        } catch (WalletException e) {
            System.out.println("Failed to create wallet: " + e);
        }

        //Login
        System.out.println(walletService.login(1, "lol"));

        //Add funds


    }

}
