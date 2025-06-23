# 🚗 Garaaz UI Automation Suite – Selenium + Java + TestNG

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Selenium](https://img.shields.io/badge/Selenium-Automation-brightgreen.svg)
![TestNG](https://img.shields.io/badge/TestNG-Test%20Framework-orange.svg)
![Status](https://img.shields.io/badge/Status-Active-success.svg)

Welcome to the official **UI Automation Suite for Garaaz**, a B2B spare parts ordering platform. This test suite simulates critical user actions—like logging in, verifying OTP, and placing an order—using direct Selenium WebDriver scripts written in Java.

Whether you're a QA engineer validating builds, or a developer running regression before deploying, this suite makes testing fast and reliable!

---

## 🎯 Why This Project?

🧪 Manual testing takes time and misses edge cases.  
⚡ This suite automates the **real user journey** to catch bugs before customers do.  
✅ Built to ensure every release of Garaaz is **stable, scalable, and bug-free**.

---

## 🚀 Tech Stack

| Tool              | Purpose                          |
|-------------------|----------------------------------|
| Java              | Core automation language         |
| Selenium WebDriver| Browser automation               |
| TestNG            | Test execution and assertions    |
| Maven             | Dependency and build management  |
| ChromeDriver      | Automates Chrome browser         |
| Spring Tool Suite | Java IDE for development         |

---

🟢 All test logic is implemented in a **single Java class** without using Page Object Model (for simplicity and learning purposes).

---

## ✅ What’s Covered

- Launching the Garaaz UAT site
- Mobile number input and OTP submission
- Simulating the order placement flow
- Use of implicit waits and direct element interactions
- Debug-friendly structure and comments for each step

---

## 🧪 Sample Test Logic

```java
driver.get("https://uat.orca.garaaz.com/login");
driver.findElement(By.xpath("//input[@type='text']")).sendKeys("7030067700");
driver.findElement(By.xpath("//button[@type='submit']")).click();
Thread.sleep(2000);
driver.findElement(By.cssSelector("input[name='otp']")).sendKeys("8888");
driver.findElement(By.cssSelector("button[type='submit']")).click();


