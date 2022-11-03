package com.wallet.app.dao;

import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;

public class WalletDaoImpl implements WalletDao {

	// Create collection to store the Wallet information.
	Map<Integer, Wallet> wallets = new HashMap<>();
	private Connection connection;

	public WalletDaoImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	public Wallet addWallet(Wallet newWallet) throws WalletException {

		String sql = "INSERT INTO wallet (id, name, balance, password) VALUES(?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, newWallet.getId());
			preparedStatement.setString(2, newWallet.getName());
			preparedStatement.setDouble(3, newWallet.getBalance());
			preparedStatement.setString(4, newWallet.getPassword());
			Integer count = preparedStatement.executeUpdate();
			if (count == 1)
				System.out.println("Wallet added successfully to DB.");
			else
				System.out.println("Wallet could not be added to DB.");

		} catch (SQLException e) {
			System.out.println("Could not add wallet to DB. " + e);
		}
		 return newWallet;

	}

	public Wallet getWalletById(Integer walletId) throws WalletException {
		String sql = "SELECT * FROM wallet WHERE id = ?";
		Wallet newWallet = null; //return null if wallet with id does not exist
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, walletId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				// if wallet exists for given id

				// Employee(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3));
				newWallet = new Wallet(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getDouble("balance"), resultSet.getString("password"));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return newWallet;
	}

	public Wallet updateWallet(Wallet updateWallet) throws WalletException {
		// TODO Auto-generated method stub
		return null;
	}

	public Wallet deleteWalletById(Integer walletID) throws WalletException {
		// TODO Auto-generated method stub
		return null;
	}

}
