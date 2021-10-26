package cucumberOptions;

@RuWith(Cucumber.class)
@CucumverOptions(
		features = "src/test/java/features",
		glue = "stepDefination")

public class TestRunner {

}
