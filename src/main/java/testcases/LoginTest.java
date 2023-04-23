package testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void ValidLogin(Method method) throws FilloException {

		Recordset recordset = connection.executeQuery("select * from data where TestName='"+method.getName()+"'");
		recordset.next();

		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");

		LoginPage login = new LoginPage(driver);
		login.LoginFunction(UserName, Password);

		String ActPageURL = driver.getCurrentUrl();
		String ExpPageURL = recordset.getField("Expected");

		Assert.assertEquals(ActPageURL, ExpPageURL);
	}

	@Test(enabled = true)
	public void InvalidLogin(Method method) throws FilloException {

		Recordset recordset = connection.executeQuery("select * from data where TestName='"+method.getName()+"'");
		recordset.next();

		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");

		LoginPage login = new LoginPage(driver);
		login.LoginFunction(UserName, Password);
		WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));

		String ActError = error.getText();
		String ExpError = recordset.getField("Expected");

		Assert.assertEquals(ActError, ExpError);
	}

}
