package InventoryTests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import Genericutility.BaseClass;
import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;



public class AddLowestPriceProductToCartTest extends BaseClass{

	@Test
	public void AddLowestPriceProductTest() throws EncryptedDocumentException, IOException {
		
		// Read Test Data From Excel File
		String SORTOPTION = fUtil.readDataFromExcel("Product", 4, 2);
		String PRODUCTNAME = fUtil.readDataFromExcel("Product", 4, 3);

		// Step 4: Click on a Product
		InventoryPage ip = new InventoryPage(driver);
		String pAddedToCart = ip.clickOnLowestPriceProduct(driver, PRODUCTNAME, SORTOPTION);

		// Step 5: Add the Product To Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();

		// Step 6: Navigate to Cart
		ip.clickOnCartContainer();

		// Step 7: Validate the product in Cart
		CartPage cp = new CartPage(driver);
		String pInCart = cp.getProductName();

		Assert.assertEquals(pInCart, pAddedToCart);

		System.out.println(pInCart);
	}

}
