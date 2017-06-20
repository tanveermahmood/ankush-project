package com.perfecto.sample.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class HeaderBar extends QAFWebComponent {

	public HeaderBar(String locator) {
		super(locator);
	}

	public HeaderBar() {
		super("headerbar.container");
	}

	@FindBy(locator = "headerbar.btn.logout")
	private QAFWebElement btnLogoutHeader;
	@FindBy(locator = "headerbar.btn.scan")
	private QAFWebElement btnScanHeader;
	@FindBy(locator = "headerbar.txt.screen")
	private QAFWebElement txtScreenHeader;
	@FindBy(locator = "headerbar.btn.back")
	private QAFWebElement btnBackHeader;

	public QAFWebElement getBtnLogoutHeader() {
		return btnLogoutHeader;
	}

	public QAFWebElement getBtnScanHeader() {
		return btnScanHeader;
	}

	public QAFWebElement getTxtScreenHeader() {
		return txtScreenHeader;
	}

	public QAFWebElement getBtnBackHeader() {
		return btnBackHeader;
	}

	public boolean isLoggedIn() {
		return btnBackHeader.isPresent() || btnLogoutHeader.isPresent();
	}

	public void doLogout() {
		if (isLoggedIn()) {
			if (btnBackHeader.isPresent())
				btnBackHeader.click();
			btnLogoutHeader.click();
		}
	}

}
