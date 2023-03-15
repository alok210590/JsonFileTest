package tests;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest {

	/**
	 * This method will read the JSON file from given location
	 * @return JSON object
	 * @throws IOException
	 * @throws ParseException
	 */
	public JSONObject getJsonData() throws IOException, ParseException {

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = null;
		String filePath = "json\\rcb.json";
		// Parsing contents of json file
		if (!filePath.equals("")) {
			jsonObject = (JSONObject) jsonParser.parse(new FileReader(filePath));
		} else
			System.out.println("Please provide correct json file path and try again.");

		return jsonObject;
	}

	/**
	 * This method get the number of foreign players in the team
	 * @param jsonObject
	 * @return foreignPlayerCount
	 * @throws IOException
	 * @throws ParseException
	 */
	public int getForeignPlayers(JSONObject jsonObject) throws IOException, ParseException {
		int foreignPlayerCount = 0;
		JSONArray jsonData = (JSONArray) jsonObject.get("player");
		for (int i = 0; i < jsonData.size(); i++) {
			JSONObject player = (JSONObject) jsonData.get(i);
			if (!player.get("country").equals("India")) {
				foreignPlayerCount = foreignPlayerCount + 1;
			}
		}
		System.out.println("Number of foreign players present in the team: " + foreignPlayerCount);
		return foreignPlayerCount;
	}

	/**
	 * This method will get the number of wicket keepers in the team
	 * @param jsonObject
	 * @return wicketKeeperCount
	 * @throws IOException
	 * @throws ParseException
	 */
	public int getNoOfWicketKeepers(JSONObject jsonObject) throws IOException, ParseException {
		int wicketKeeperCount = 0;
		JSONArray jsonData = (JSONArray) jsonObject.get("player");
		for (int i = 0; i < jsonData.size(); i++) {
			JSONObject player = (JSONObject) jsonData.get(i);
			if (player.get("role").equals("Wicket-keeper")) {
				wicketKeeperCount = wicketKeeperCount + 1;
			}
		}
		System.out.println("Number of wiketkeeper in the team: " + wicketKeeperCount);
		return wicketKeeperCount;
	}
}
