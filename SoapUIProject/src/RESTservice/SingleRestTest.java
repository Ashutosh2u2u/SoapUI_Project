package RESTservice;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;


public class SingleRestTest {
	@Test
	public void SoapUItestrun() throws XmlException, IOException, SoapUIException {
		//Grab the Soap Project	
		WsdlProject project=new WsdlProject("D:\\Study Related\\Udemy API testing\\SoapUI Automation\\LibraryAPI.xml");
		//Grab the TestSuite from project
		WsdlTestSuite testSuite=project.getTestSuiteByName("Testing");
		//iterate all available test under test suite
		//Grab the testcases from TestSuite
		//	WsdlTestCase testCase=testSuite.getTestCaseByName("TestCase 1");

		WsdlTestCase testCase1=testSuite.getTestCaseByName("AddBookTestCase");
		//Run the test case
		TestRunner runner1=testCase1.run(new PropertiesMap(), false);
		Assert.assertEquals(Status.FINISHED, runner1.getStatus());
		WsdlTestCase testCase2=testSuite.getTestCaseByName("DeleteBook.php TestCase");
		//Run the test case
		TestRunner runner2=testCase2.run(new PropertiesMap(), false);
		Assert.assertEquals(Status.FINISHED, runner2.getStatus());


	}
}
