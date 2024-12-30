package htt.projects.google.tests;


import htt.projects.BaseTest;
import htt.projects.google.pages.GooglePage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

	private final GooglePage googlePage = new GooglePage();

	@Description("Verify search functionality with a valid query")
	@Test(description = "Verify search functionality with a valid query")
	public void testSearchWithValidQuery() {
		googlePage.openPage()
				.search("Selenide");

		Assert.assertTrue(googlePage.isFirstResultContains("Selenide"), "The first search result does not contain 'Selenide'");
	}

	@Description("Verify search functionality with an invalid query")
	@Test(description = "Verify search functionality with an invalid query")
	public void testSearchWithInvalidQuery() {
		googlePage.openPage()
				.search("nonexistentqueryxyz");

		Assert.assertTrue(googlePage.isFirstResultContains("Selenide"), "The first search result should not contain " +
				"'Selenide'");
	}
}
