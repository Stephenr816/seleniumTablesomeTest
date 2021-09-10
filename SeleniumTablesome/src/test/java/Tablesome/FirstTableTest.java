package Tablesome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTableTest {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		// Navigate to a website
		
		driver.get("https://tablesomedemo.helpiewp.com/wp-admin/");
		
		//Mazimize current window
		
		driver.manage().window().maximize();
		
		//Enter username, Password and Press Submit
		
		WebElement username = driver.findElement(By.id("user_login"));
		username.sendKeys("helpie");
		
		WebElement password = driver.findElement(By.id("user_pass"));
		password.sendKeys("Helpiesuppor@123");
		
		WebElement submit = driver.findElement(By.id("wp-submit"));
		submit.click();
		
		//Create new table
		
		WebElement TablesomeCPT = driver.findElement(By.xpath("//li[@id='menu-posts-tablesome_cpt']/a"));
		TablesomeCPT.click();
		
		WebElement createNewTable = driver.findElement(By.xpath("//li[@id='menu-posts-tablesome_cpt']/ul/li/a[text()='Create New Table']"));
		createNewTable.click();
		
		WebElement tableNameInputBox = driver.findElement(By.id("title"));
		tableNameInputBox.sendKeys("First Table");
		
		WebElement ColumnHeader = driver.findElement(By.xpath("//th[contains(@class,'tablesome__column')]/span[text()='Column Name']"));
		ColumnHeader.click();
		
		WebElement inputText = driver.findElement(By.xpath("//input[@class='tablesome__input tablesome__input--text']"));
		inputText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		inputText.sendKeys("Text");
		inputText.sendKeys(Keys.chord(Keys.ENTER));
		
		WebElement AddColumn2 = driver.findElement(By.xpath("//div[@class='tablesome__column--add']/span"));
		AddColumn2.click();
		
		
		//Create rows
		
		Actions actions = new Actions(driver);
		WebElement row1 = driver.findElement(By.xpath("//tr[@data-state-record-id='1' and contains(@class,'tablesome__row')]"));
		actions.moveToElement(row1).perform();
		
		WebElement addRow = driver.findElement(By.xpath("//div[@class='tablesome__rowControl']/span[@class='dashicons dashicons-plus-alt2 tablesome__icon tablesome__rowControl--add']"));
		addRow.click();
		addRow.click();
		
		WebElement saveTable = driver.findElement(By.xpath("//div[@class='tablesome_cpt__footer']/div[@class='tablesome__button--wrapper']/input[@value='Save Table']"));
		saveTable.click();
		
		driver.close();
	}

}
