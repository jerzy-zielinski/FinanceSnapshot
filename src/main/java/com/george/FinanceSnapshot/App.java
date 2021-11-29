package com.george.FinanceSnapshot;

import java.io.IOException;

import com.george.GeogleConvert.FX_RATE;
import com.george.GnuCashAccess.InterestIncome;
import com.george.GnuCashAccess.USAssetsTotal;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
	double usd_pln_rate = 4.00;
	try {
	    usd_pln_rate = new FX_RATE().get_rate("USD_PLN");
	} catch (IOException e) {
	    System.out.println(e);
	    //		e.printStackTrace();
	    System.out.printf("Assuming USD_PLN = %10.5f%n", usd_pln_rate);
	}
	// 1,787.13 02-02-2021
	double initial_gold_price = 1787.13;
	double xau_usd_rate = initial_gold_price;
	try {
	    xau_usd_rate = new FX_RATE().get_rate("XAU_USD");
	} catch (IOException e) {
	    System.out.println(e);
	    //		e.printStackTrace();
	    System.out.printf("Assuming XAU_USD = %10.5f%n", xau_usd_rate);
	}
	double gold_price_change = 100.00 * (xau_usd_rate - initial_gold_price) / initial_gold_price;
	// 28.5624 02-02-2021
	double initial_silver_price = 28.5624;
	double xag_usd_rate = initial_silver_price;
	try {
	    xag_usd_rate = new FX_RATE().get_rate("XAG_USD");
	} catch (Exception e) {
	    System.out.println(e);
	    //		e.printStackTrace();
	    System.out.printf("Assuming XAG_USD = %10.5f%n", xag_usd_rate);
	}
	double silver_price_change = 100.00 * (xag_usd_rate - initial_silver_price) / initial_silver_price;
	double usd_zar_rate = 15.00;
	try {
	    usd_zar_rate = new FX_RATE().get_rate("USD_ZAR");
	} catch (IOException e) {
	    System.out.println(e);
	    //		e.printStackTrace();
	    System.out.printf("Assuming USD_ZAR = %10.5f%n", usd_zar_rate);
	}
	double usTotal = new USAssetsTotal().getUSAssetsTotalData();
	double interest_gain = new InterestIncome().getInterestIncomeSinceDate();
	double plnTotal = usTotal * usd_pln_rate;
	double value_of_gold = 3.7 * xau_usd_rate;
	double value_of_silver = 252.0 * xag_usd_rate;
	System.out.printf("Interst income since the beginning of 2021: %, 6.2f%n%n", interest_gain);
	System.out.printf("XAU_USD exchange rate                 : %10.5f%n", xau_usd_rate);
	System.out.printf("GOLD price change since the purchase  : %10.5f%% %10.5f%n", gold_price_change,
			  value_of_gold);
	System.out.printf("5299.57 * 2                           : %10.5f%n%n", 5299.57 * 2);
	System.out.printf("XAG_USD exchange rate                 : %10.5f%n", xag_usd_rate);
	System.out.printf("SILVER price change since the purchase: %10.5f%% %10.5f%n", silver_price_change,
			  value_of_silver);
	System.out.printf("74.61 * 126                           : %10.5f%n%n", 74.61 * 126);
	System.out.printf("USD_PLN exchange rate                 : %10.5f%n", usd_pln_rate);
	System.out.printf("USD_ZAR exchange rate                 : %10.5f%n%n", usd_zar_rate);
	System.out.printf("Net Worth PLN                         : %, 13.2f%n", plnTotal);
	System.out.printf("Net Worth USD                         : %, 13.2f%n", usTotal);
	System.exit(0);

    }
}
