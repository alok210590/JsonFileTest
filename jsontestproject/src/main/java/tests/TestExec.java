package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExec {

	private JsonTest jsonTest = new JsonTest();
	
	/**
	 * This test will validate RCB team should have 4 foreign player count.
	 * @throws IOException
	 * @throws ParseException
	 */
	@Test
	public void validateForeignPlayers() throws IOException, ParseException {
		Assert.assertEquals(jsonTest.getForeignPlayers(jsonTest.getJsonData()), 4);
		System.out.println("RCB team has 4 foreign players as expected.");
	}

	/**
	 * This test will validate RCB team should have only one wicket keeper
	 * @throws IOException
	 * @throws ParseException
	 */
	@Test
	public void validateWeeketKeeper() throws IOException, ParseException {
		Assert.assertEquals(jsonTest.getNoOfWicketKeepers(jsonTest.getJsonData()), 1);
		System.out.println("RCB team has 1 wicket keeper player as expected.");
	}
}
