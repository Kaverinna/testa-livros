package teste;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class livros {
	static WebDriver driversub;
	static WebDriver driverame;
	static WebDriver driverama;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/user/chromedriver");
		driversub = new ChromeDriver();
		driversub.get("http://www.subimarino.com.br");

		
	}

	@Test
	public void test() throws InterruptedException {
				
		WebElement categorial = driversub.findElement(By.xpath("//*[@id=\"main-top\"]/div[3]/div/div/div/div[3]/div/div/div/section/div/div/div/ul/li[1]/a/img"));
		categorial.click();
		
		WebElement livro = driversub.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div[1]/div/div[2]/div[1]/div/div/section/div/div/div/div[2]/div/div/div/div/div/div[1]/div/div/section/a/div[2]/h1"));
		livro.click();

		WebElement livro1 = driversub.findElement(By.xpath("//*[@id=\"info-section\"]/div[2]/section/div/div[3]/table/tbody/tr[4]/td[2]/span"));
		String isbn = livro1.getText(); 
		System.out.println(isbn);
		
		driversub.close();
				
		Thread.sleep(5000);
		
		System.setProperty("webdriver.chrome.driver", "/home/user/chromedriver");
		driverame = new ChromeDriver();
		driverame.get("https://www.americanas.com.br/");
		
		//WebElement busca = driverame.findElement(By.xpath("//*[@id=\"h_search-input\"]"));
		//busca.click();
		
		WebElement busca2 = driverame.findElement(By.xpath("//*[@id=\"h_search-input\"]"));
		busca2.click();
		busca2.sendKeys(isbn);
		busca2.sendKeys(Keys.RETURN);
		driverame.close();
		
		Thread.sleep(5000);
		
		System.setProperty("webdriver.chrome.driver", "/home/user/chromedriver");
		driverama = new ChromeDriver();
		driverama.get("https://www.amazon.com.br/");
		
		WebElement procura = driverama.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		procura.click();
		procura.sendKeys(isbn);
		procura.sendKeys(Keys.RETURN);
		

		fail("Not yet implemented");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driverama.close();
	}
}
