package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	
		@FindBy(className = "inventory_item_name")
		private WebElement itemInfo;
		
		@FindBy(xpath = "//button[.='Remove']")
		private WebElement removeBtn;
		
		public CartPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getItemInfo() {
			return itemInfo;
		}

		public WebElement getRemoveBtn() {
			return removeBtn;
		}
		
		//Business library
		
		/**
		 * This method will capture the Product Name
		 * @return
		 */
		public String getProductName()
		{
			return itemInfo.getText();
		}
		
		

	}


