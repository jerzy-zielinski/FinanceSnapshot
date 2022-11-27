package com.george.ValuesFromWeb;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CallLinuxCommands {
	public static void main(String args[]) {
		String eagles = CallLinuxCommands.getGoldCoinsValue();
		String silver_coins = CallLinuxCommands.getSilverCoinsValue();
		System.out.println("Gold Coins = " + eagles + " : " + "Silver Coins = " + silver_coins);
	}

	public static String getSilverCoinsValue() {
		String s = "";
		String silver_coins = "";
		Process p;
		try {
			p = Runtime.getRuntime().exec("/home/jerzyzielinski/bin/silver_coins");
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((s = br.readLine()) != null)
				silver_coins = s;
			p.waitFor();
			if (p.exitValue() != 0)
				System.err.println("error with silver coins, exitValue: " + p.exitValue());
			p.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return silver_coins;
	}

	public static String getGoldCoinsValue() {
		String s = "";
		String eagles = "";
		Process p;
		
		try {
			p = Runtime.getRuntime().exec("/home/jerzyzielinski/bin/eagles");
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((s = br.readLine()) != null)
				eagles = s;
			p.waitFor();
			if (p.exitValue() != 0)
				System.err.println("error with eagles, exitValue: " + p.exitValue());
			p.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eagles;
	}
}