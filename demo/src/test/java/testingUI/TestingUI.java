//package testingUI;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.List;
//
//public class TestingUI {
//    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.20.0");
//        driver.manage().window().maximize();
//
//        WebElement table = driver.findElement(By.className("grid"));
//        List<WebElement> rows = table.findElements(By.tagName("tr"));
//
//
//        for(int rowIndex = 1; rowIndex < rows.size(); rowIndex++) {
//            WebElement row = rows.get(rowIndex);
//            List<WebElement> cols = row.findElements(By.tagName("td"));
//            for (int colIndex = 0; colIndex < cols.size(); colIndex++) {
//                WebElement cell = cols.get(colIndex);
//                System.out.println("Checking "+ cell.getText());
//                if (cell.getText().equals("HomePage")) {
//                    WebElement link = cell.findElement(By.tagName("a"));
//                    link.click();
//                    System.out.println(driver.getCurrentUrl());
//                    break;
//                }
//            }
//        }
//        driver.quit();
//
//
//    }
//
//}
