package test.java.com.recaptcha.servlet;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.java.com.recaptcha.servlet.VerifyRecaptcha;

public class TestLoginServletTest {
	
	@Test
	public void testVerifyCaptchaApiFalse() throws IOException
	{
		VerifyRecaptcha demo= new VerifyRecaptcha();
		boolean actual = demo.verify("qwertyuk");
		Assert.assertEquals(actual, false);
	}
	
	@Test
	public void testVerifyCaptchaApiTrue() throws IOException
	{
		VerifyRecaptcha demo= new VerifyRecaptcha();
		boolean actual = demo.verify("dfghjk");
		Assert.assertEquals(actual, true);
	}
	
	
}
