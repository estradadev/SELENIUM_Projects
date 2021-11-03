package stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefinition {
	/*
    @Given("^User is on NetBanking landing page$")
    public void user_is_on_netbanking_landing_page() throws Throwable {
        //code to navigate to logn url
    	System.out.println("navigated to login url");
    }

    @When("^User login into application with username and password$")
    public void user_login_into_application_with_username_and_password() throws Throwable {
        //code to login
    	System.out.println("Logged in success");
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        //home page validation
    	System.out.println("Validate home page");
    }

    @And("^Cards are displayed$")
    public void cards_are_displayed() throws Throwable {
        //validating the cards
    	System.out.println("Validate cards");
    }*/
    
    @Given("^User is on NetBanking landing page$")
    public void user_is_on_NetBanking_landing_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	System.out.println("navigated to login url");
    }

    @When("^User login into application with username and password$")
    public void user_login_into_application_with_username_and_password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	System.out.println("Logged in success");
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	System.out.println("Validate home page");
    }
    
    @When("^User login into application with \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application_with_something_and_password_something(String strArg1, String strArg2) throws Throwable {
        System.err.println(strArg1);
        System.err.println(strArg2);
    }

    @Then("^Cards display are \"([^\"]*)\"$")
    public void cards_display_are(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	System.out.println("Validate cards");
    }

}