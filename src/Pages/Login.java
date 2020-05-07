package Pages;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {
	
	WebDriver driver=null;

	@FindBy(id="username")
	private  WebElement txt_username;
	
	@FindBy(id="password")	
	private WebElement txt_password;
	
	@FindBy(name="login")
	private WebElement btn_login;
	
	@FindBy(xpath="//*[@id=\"noo-site\"]/div[2]/div[1]/div/div/div/div/div/div/div[2]/nav/ul/li[6]/a")
	public WebElement lnk_logout;
	
	@FindBy(xpath="//*[@id=\\\"noo-site\\\"]/div[2]/div[1]/div/div/div/div/div/div/div[2]/ul/li")
	private WebElement error_msg;
	
	public void performLogin(String usrname,String pwd)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		txt_username.sendKeys(usrname);
		txt_password.sendKeys(pwd);
		btn_login.click();
		try{
	           String text=lnk_logout.getText();
	           System.out.println("The text is  : "+text);
	           }
	           catch(Exception e)
	           {
	            System.out.println("The text is  : "+e.getMessage());
	           driver.quit();
	           }
}
	


	public Login(WebDriver driver)
	{
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
	}
	
}
