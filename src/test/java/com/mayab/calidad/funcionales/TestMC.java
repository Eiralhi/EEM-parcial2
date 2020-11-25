package com.mayab.calidad.funcionales;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

public class TestMC {
	
	private WebDriver driver;
	private String baseURL;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\eiral\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		baseURL= "https://mern-crud.herokuapp.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	}

 
  @Test
  public void TestAgregarCuenta() throws Exception {

	    driver.get("https://mern-crud.herokuapp.com/");
	    
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	   
	    // Aquí es por nombre
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("eiralhi");
	    driver.findElement(By.xpath("//form")).click();
	    
	    
	    //aquí es por correo
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("eira20@hotmail.com");
	    driver.findElement(By.xpath("//form/button")).click();
	    
	    //ingresé con correro ya usado
	    /*driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("eira@hotmail.com");*/
	   
	    //Aquí es por edad
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("20");
	    
	    //Aquí es por género
	    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
	    driver.findElement(By.xpath("//div[2]/span")).click();
	    
	    
	    driver.findElement(By.xpath("//form/button")).click();
	    //Comprobar 
	    //Texto que debe salir
	    String expectedtxt = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/div/p")).getText();
	    //se agregó de manera correcta
	    assertEquals("Successfully added!", expectedtxt);
		
  }
  
  @Test
  public void TestElimiarCuenta() throws Exception {

	  
	  	 driver.get("https://mern-crud.herokuapp.com/");
	  	 
	     driver.findElement(By.id("online")).click();
	     driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr[2]/td[5]/button[2]")).click();
	     driver.findElement(By.xpath("//div[3]/button")).click();
	     
	     
	   
	    

	   
		
  }
  
  @Test
  public void TestCorreoInvalido() throws Exception{
	     driver.get("https://mern-crud.herokuapp.com/");
	  
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("eem");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    //se agrega el correo inválido
	    driver.findElement(By.name("email")).sendKeys("1234@ss");
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("20");
	    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
	    driver.findElement(By.xpath("//div[2]/div/div[2]/div")).click();
	    driver.findElement(By.xpath("//form/button")).click();
	    
	  //Texto que debe salir
	    String expectedtxt = driver.findElement(By.xpath(" /html/body/div[2]/div/div[2]/form/div[5]/div/p")).getText();
	    //No se acepta el correo
	    assertEquals("Email must be valid.", expectedtxt);
	    
	   
	  
  }
  
@Test 
public void TestCuentaDuplicada() throws Exception {

	driver.get("https://mern-crud.herokuapp.com/");
    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Eiralhi");
    driver.findElement(By.xpath("//div[3]/div/label")).click();
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("eira@hotmail.com");
    driver.findElement(By.name("age")).click();
    driver.findElement(By.name("age")).clear();
    driver.findElement(By.name("age")).sendKeys("20");
    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
    driver.findElement(By.xpath("//div[2]/div[2]")).click();
    driver.findElement(By.xpath("//form/button")).click();
    
  //Texto que debe salir
    String expectedtxt = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[5]/div/p")).getText();
    //Cuenta duplicada
    assertEquals("That email is already taken.", expectedtxt);
    
  
 
	
}
 
 
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}