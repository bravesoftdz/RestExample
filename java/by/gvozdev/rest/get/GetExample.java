/**
 * 
 */
package by.gvozdev.rest.get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * @author Gvozdev Alexsander Apr 26, 2018
 */
public class GetExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws JSONException, IOException {

		Map<String, String> listParam = new HashMap<String, String>();

		String url = "http://restcountries.eu/rest/v1/name/belarus";

		URL obj = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

		connection.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		JSONArray jsonResponse = new JSONArray(response.toString());
		String capital = jsonResponse.getJSONObject(0).getString("capital");
		String alpha2Code = jsonResponse.getJSONObject(0).getString("alpha2Code");
		String demonym = jsonResponse.getJSONObject(0).getString("demonym");
		int population = jsonResponse.getJSONObject(0).getInt("population");
		String region = jsonResponse.getJSONObject(0).getString("region");
		int lat = jsonResponse.getJSONObject(0).getJSONArray("latlng").getInt(0);
		int lng = jsonResponse.getJSONObject(0).getJSONArray("latlng").getInt(1);
		String timezones = jsonResponse.getJSONObject(0).getJSONArray("timezones").getString(0);

		listParam.put("capital", capital);
		listParam.put("alpha2Code", alpha2Code);
		listParam.put("demonym", demonym);
		listParam.put("population", String.valueOf(population));
		listParam.put("region", region);
		listParam.put("lat", String.valueOf(lat));
		listParam.put("lng", String.valueOf(lng));
		listParam.put("timezones", timezones);

		int borderCount = jsonResponse.getJSONObject(0).getJSONArray("borders").length();
		for (int i = 0; i < borderCount; i++) {
			String borders = jsonResponse.getJSONObject(0).getJSONArray("borders").getString(i);
			listParam.put("border_" + borders, borders);
		}

		System.out.println(listParam);
	}

}
