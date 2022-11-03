package com.wallet.app.service;

import com.wallet.app.dao.WalletDao;
import com.wallet.app.dao.WalletDaoImpl;
import com.wallet.app.dao.WalletUtility;
import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;

import java.sql.Connection;

public class WalletServiceImpl implements WalletService {

	private Connection connection;
	private WalletDao walletRepository = new WalletDaoImpl(WalletUtility.getConnectionToMySQL());

	public Wallet registerWallet(Wallet newWallet) throws WalletException {
		
		return this.walletRepository.addWallet(newWallet);
		
	}

	public Boolean login(Integer walletId, String password) throws WalletException {

		Wallet foundWallet = this.walletRepository.getWalletById(walletId);
		Boolean loggedIn = false;
		if(foundWallet != null && foundWallet.getPassword().equals(password)){
			System.out.println("You have logged in successfully: " + foundWallet);
			loggedIn = true;
		} else if(foundWallet != null && !foundWallet.getPassword().equals(password)){
			System.out.println("Password is incorrect for wallet with id " + walletId + ", please check password and try again.");
		} else if(foundWallet == null){
			System.out.println("Wallet with id " + walletId + " could not be found. Please enter a valid wallet id.");
		}
		return loggedIn;
	}

	public Double addFundsToWallet(Integer walletId, Double amount) throws WalletException {
		Wallet foundWallet = this.walletRepository.getWalletById(walletId);
		Double newBalance = foundWallet.getBalance() + amount;
		this.walletRepository.addFunds(foundWallet.getId(), newBalance);

		return null;
	}

	public Double showWalletBalance(Integer walletId) throws WalletException {
		// TODO Auto-generated method stub
		Wallet foundWallet = this.walletRepository.getWalletById(walletId);
		return foundWallet.getBalance();
	}

	public Boolean fundTransfer(Integer fromId, Integer toId, Double amount) throws WalletException {
		// TODO Auto-generated method stub
		Boolean walletValidation = false;
		Boolean success = false;
		//Check if fromId and toId exist:
		Wallet fromWallet = this.walletRepository.getWalletById(fromId);
		Wallet toWallet = this.walletRepository.getWalletById(toId);
		if(!fromWallet.equals(null) && !toWallet.equals(null)){
			walletValidation = true;
		}

		//Check if fromId has enough funds if validated
		if(walletValidation){
			if(fromWallet.getBalance() - amount < 0){
				System.out.println("You do not have enough funds to make the transfer");
			} else {
				Double fromNewBalance = fromWallet.getBalance() - amount;
				this.walletRepository.withdrawFunds(fromId, fromNewBalance);
				Double toNewBalance = toWallet.getBalance() + amount;
				this.walletRepository.addFunds(toId, toNewBalance);
				System.out.println("£"+amount + " successfully transferred from wallet " + fromId + " to wallet " + toId);
				success = true;
			}
		}
		return success;
	}

	@Override
	public Double withdrawFunds(Integer walletId, Double amount) throws WalletException {
		//check wallet balance
		Wallet foundWallet = this.walletRepository.getWalletById(walletId);
		if((foundWallet.getBalance() - amount) < 0){
			System.out.println("You don't have enough in your wallet to withdraw! Your current balance: " + foundWallet.getBalance());
		} else {
			Double newBalance = foundWallet.getBalance() - amount;
			this.walletRepository.withdrawFunds(walletId, newBalance);
		}
		return null;
	}

	public Wallet unRegisterWallet(Integer walletId, String password) throws WalletException {
		// TODO Auto-generated method stub
		//Check wallet exists and password is correct
		


		return null;
	}

}
