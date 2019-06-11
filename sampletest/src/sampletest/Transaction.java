package sampletest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Transaction {

	Set<Integer> s = new HashSet<>();

	
	
	public static void main(String[] args){
		List<String> transactions = Arrays.asList("John,Doe,john@doe.com,202,TR0001", 
				"Jane,Doe,jane@doe.com,199,TR0002", 
				"Jane,Doe,jane@doe.com,2,TR0003");
		
		
		//System.out.println(transactions.get(0).split(",")[4]);
		List<String> rejectedTransactions = findRejectedTransactions(transactions, 200);
		System.out.println(rejectedTransactions.size() );
	}

	public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
		List<String> rejectedTransaction = new ArrayList<String>();
		
		if (transactions.isEmpty()) {
			return rejectedTransaction;
		}

		if (transactions.size() == 1) {
			if (creditLimit < Integer.valueOf(transactions.get(0).split(",")[3])) {
				rejectedTransaction.add(transactions.get(0).split(",")[4]);
			}
			return rejectedTransaction;
		} else {
			List<TransactionPojo> transactionDetails = new ArrayList<TransactionPojo>();
			for(String s: transactions){
				String[] txArr = s.split(",");
				TransactionPojo tx = new TransactionPojo();
				tx.setFirstName(txArr[0]);
				tx.setLastName(txArr[1]);
				tx.setEmailId(txArr[2]);
				tx.setAmount(Integer.valueOf(txArr[3]));
				tx.setTransactionId(txArr[4]);
				transactionDetails.add(tx);
			}
			Comparator<TransactionPojo> compareByUniqueField = Comparator
											.comparing(TransactionPojo::getFirstName)
											.thenComparing(TransactionPojo::getLastName)
											.thenComparing(TransactionPojo::getEmailId);
			
			Collections.sort(transactionDetails, compareByUniqueField);
			
			List<String> sortedTransactions = transactions.stream().sorted().collect(Collectors.toList());
			int newCreditLimit = creditLimit;
			// first element of the list to calculate the newCredit Limit value.
			if (creditLimit < transactionDetails.get(0).getAmount()) {
				rejectedTransaction.add(transactionDetails.get(0).getTransactionId());
			} else{
				newCreditLimit = creditLimit - transactionDetails.get(0).getAmount();
			}
			// iterate the transaction list now
			for (int i = 1; i < transactionDetails.size(); i++) {
				TransactionPojo tx1 = transactionDetails.get(i);
				TransactionPojo tx2 = transactionDetails.get(i-1);
				// check if current and previous object are same
				if (tx1.getFirstName().equals(tx2.getFirstName()) 
						&& tx1.getLastName().equals(tx2.getLastName())
						&& tx1.getEmailId().equals(tx2.getEmailId())) {
					// check for credit limit
					if (newCreditLimit >= tx1.getAmount()) {
						newCreditLimit = newCreditLimit - tx1.getAmount();
					} else {
						rejectedTransaction.add(tx1.getTransactionId());
					}
				} else {
					if ((creditLimit >= Integer.valueOf(tx1.getAmount()))) {
						newCreditLimit = creditLimit - tx1.getAmount();
					} else {
						rejectedTransaction.add(tx1.getTransactionId());
					}
				}

			}
		}
		return rejectedTransaction;
	}
}

class TransactionPojo{
	String firstName;
	String lastName;
	String emailId;
	int amount;
	String transactionId;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public int getAmount() {
		return amount;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	
}