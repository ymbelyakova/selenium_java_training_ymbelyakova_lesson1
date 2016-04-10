package selenium_java_training_PO;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import selenium_java_training.applogic.ApplicationManager;

/**
 * Base class for all the TestNG-based test classes
 */
public class TestBase {

	protected final ApplicationManager app = new ApplicationManager();

	@BeforeClass
	public void init() {
		app.setUp();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		app.Stop();
	}

}
