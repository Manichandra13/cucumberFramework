package gluecode;

import cucumber.api.java.en.Then;
import utils.Kernel;

public class CostingFlow extends Kernel {

	// Validate the costing time period for 100 seconds

	@Then("^user validates the costing time period for \"([^\"]*)\"$")
	public void user_validates_the_costing_time_period_for(String arg1) throws Throwable {

		pollingWaitForCostingFlow("inclusions",30);
		validate_String_Contains(getCurrentUrl(), "inclusions");
		}

}
