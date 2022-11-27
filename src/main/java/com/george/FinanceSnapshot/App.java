package com.george.FinanceSnapshot;

import java.io.IOException;

import com.george.GnuCashAccess.InterestIncome;
import com.george.GnuCashAccess.USAssetsTotal;
import com.george.ValuesFromWeb.CallLinuxCommands;

/**
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		double usTotal = new USAssetsTotal().getUSAssetsTotalData();
		double interest_gain = new InterestIncome().getInterestIncomeSinceDate();
		String eagles = CallLinuxCommands.getGoldCoinsValue();
		String silver_coins = CallLinuxCommands.getSilverCoinsValue();
		double g = Double.valueOf(eagles);
		double s = Double.valueOf(silver_coins);
		System.out.printf("Net Worth USD                                          : %, 12.2f%n", usTotal);
		System.out.printf("Interst & dividend income since the beginning of 2022  : %, 12.2f%n", interest_gain);
		System.out.printf("Gold coins value (5299.57 * 2)                         : %, 12.2f: %, 12.2f: %, 12.2f%n", 5299.57 * 2, g, (g - (5299.57 * 2)));
		System.out.printf("Silver coins value (74.61 * 126)                       : %, 12.2f: %, 12.2f: %, 12.2f%n", 74.61 * 126, s, (s - (74.61 * 126)));
		System.exit(0);
	}
}
