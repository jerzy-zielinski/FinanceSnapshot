package com.george.GeogleConvert;

import java.io.IOException;

import org.json.JSONObject;
import org.jsoup.Jsoup;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FX_RATE {
    public static void main(String[] args) throws  IOException { 
	double rate = new FX_RATE().get_rate("USD_ZAR");
	System.out.println(rate);
    }

    public double get_rate(String currencies) throws IOException {
	OkHttpClient client = new OkHttpClient();
	HttpUrl httpUrl = new HttpUrl.Builder().scheme("https").host("free.currencyconverterapi.com")
	    .addPathSegment("api").addPathSegment("v6").addPathSegment("convert").addQueryParameter("q", currencies)
	    .addQueryParameter("compact", "ultra").addQueryParameter("apiKey", "7d83f005722ea2b93915").build();
	Request requesthttp = new Request.Builder().addHeader("accept", "application/json").url(httpUrl).build();
	Response response = client.newCall(requesthttp).execute();
	String response_string = response.body().string();
	if (response.isSuccessful()) {
	    JSONObject obj = new JSONObject(response_string);
	    String rate_key = currencies;
	    return obj.optDouble(rate_key);
	} else {
	    //			System.out.println(response_string);
	    String plainText= Jsoup.parse(response_string).text();
	    throw new IOException(plainText);
	}
    }
}
