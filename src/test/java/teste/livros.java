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
		
		WebElement autor = driversub.findElement(By.xpath("/html/body/div[4]/div/div/section/div/div[2]/div[2]/section/div[3]/div[1]/div/div/a/span"));
		String nome = autor.getText(); 
		
		driversub.close();
				
		Thread.sleep(5000);
		
		System.setProperty("webdriver.chrome.driver", "/home/user/chromedriver");
		driverame = new ChromeDriver();
		driverame.get("https://www.americanas.com.br/");
		
		WebElement busca2 = driverame.findElement(By.xpath("//*[@id=\"h_search-input\"]"));
		busca2.click();
		busca2.sendKeys(isbn);
		busca2.sendKeys(Keys.RETURN);
				
		WebElement livro2 = driverame.findElement(By.xpath("//*[@id=\"content-middle\"]/div[5]/div/div/div/div[1]/div/div/div[2]/a/section/div[1]/div/div/picture/img"));
		livro2.click();
		
		WebElement autor2 = driverame.findElement(By.xpath("//*[@id=\"info-section\"]/div[2]/section/div/div[3]/table/tbody/tr[13]/td[2]/span"));
		String nome2 = autor2.getText();
		
		
		if (!nome.equals(nome2)){
			System.out.println("Erro: Autores diferentes");
			driverame.close();
			fail("Erro: Autores diferentes");
			
		}
		
		driverame.close();
		
		Thread.sleep(5000);
		
		System.setProperty("webdriver.chrome.driver", "/home/user/chromedriver");
		driverama = new ChromeDriver();
		driverama.get("https://www.amazon.com.br/");
		
		WebElement procura = driverama.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		procura.click();
		procura.sendKeys(isbn);
		procura.sendKeys(Keys.RETURN);
		
		WebElement livro3 = driverama.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div[2]/div[1]/div/div/span/a/div/img"));
		livro3.click();
		
		WebElement autor3 = driverama.findElement(By.xpath("/html/body/div[2]/div[2]/div[4]/div[5]/div[1]/div[2]/span[1]/a"));
		String nome3 = autor3.getText(); 

		if (!nome.equals(nome3)){
			System.out.println("Erro: Autores diferentes");
			driverama.close();
			fail("Erro: autores diferentes");
		}
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driverama.close();
	}
}
