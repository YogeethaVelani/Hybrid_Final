package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	WebDriver driver=null;
	
	@FindBy(xpath="//*[@id=\"menu-item-2021\"]")
	private WebElement lnk_myacclink;
	
	public Login linkclick()
	{
		lnk_myacclink.click();
		Login l=new Login(driver);
		return l;
	}
	
	public Home(WebDriver driver)
	{
	 this.driver=driver;
	 PageFactory.initElements(driver,this);

	}
	

}
