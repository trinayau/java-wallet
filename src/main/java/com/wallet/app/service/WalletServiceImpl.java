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
		// TODO Auto-generated method stub

		Wallet foundWallet = this.walletRepository.getWalletById(walletId);
		if(foundWallet.getPassword().equals(password)){
			System.out.println("You have logged in successfully: " + foundWallet);
			return true;
		} else {
			return false;
		}
	}

	public Double addFundsToWallet(Integer walletId, Double amount) throws WalletException {
		// TODO Auto-generated method stub

		return null;
	}

	public Double showWalletBalance(Integer walletId) throws WalletException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean fundTransfer(Integer fromId, Integer toId, Double amount) throws WalletException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double withdrawFunds(Integer WalletID, Double amount) throws WalletException {
		return null;
	}

	public Wallet unRegisterWallet(Integer walletId, String password) throws WalletException {
		// TODO Auto-generated method stub
		return null;
	}

}
