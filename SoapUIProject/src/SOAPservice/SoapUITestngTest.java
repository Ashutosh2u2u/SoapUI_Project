package SOAPservice;

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


public class SoapUITestngTest {
	@Test
	public void SoapUItestrun() throws XmlException, IOException, SoapUIException {
		//Grab the Soap Project	
		WsdlProject project=new WsdlProject("D:\\Study Related\\Udemy API testing\\SoapUI Automation\\Employee.xml");
		//Grab the TestSuite from project
		WsdlTestSuite testSuite=project.getTestSuiteByName("Testing");
        //iterate all available test under test suite
		for(int i=0;i<testSuite.getTestCaseCount();i++)
		{
			//Grab the testcases from TestSuite
			WsdlTestCase testCase=testSuite.getTestCaseAt(i);
			//Run the test case
			TestRunner runner=testCase.run(new PropertiesMap(), false);
			Assert.assertEquals(Status.FINISHED, runner.getStatus());
		}

	}
}
