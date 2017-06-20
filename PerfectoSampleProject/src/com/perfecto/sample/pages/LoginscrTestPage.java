package com.perfecto.sample.pages;

import com.perfecto.sample.components.HeaderBar;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class LoginscrTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "loginscr.email.login")
	private QAFWebElement inputEmailLogin;
	@FindBy(locator = "loginscr.password.login")
	private QAFWebElement inputPasswordLogin;
	@FindBy(locator = "loginscr.btn.login")
	private QAFWebElement btnSigninLogin;

	public LoginscrTestPage() {
		new WebDriverTestBase().getDriver();
	}

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getInputEmailLogin() {
		return inputEmailLogin;
	}

	public QAFWebElement getInputPasswordLogin() {
		return inputPasswordLogin;
	}

	public QAFWebElement getBtnSigninLogin() {
		return btnSigninLogin;
	}

	public void doLogin(String email, String pass) {
		HeaderBar hbtp = new HeaderBar();
		hbtp.doLogout();
		inputEmailLogin.clear();
		inputEmailLogin.sendKeys("test@test.com");
		inputPasswordLogin.clear();
		inputPasswordLogin.sendKeys("test");
		btnSigninLogin.click();
	}

}
