package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PdgFlowPage {

	@FindBy(xpath = "//a[contains(text(),'Continue to booking')]")
	WebElement continue_to_book_button;

	public WebElement getcontinue_to_book_button() {
		return continue_to_book_button;
	}

}
