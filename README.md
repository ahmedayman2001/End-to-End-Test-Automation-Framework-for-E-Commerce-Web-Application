# End-to-End Automation Testing for an E-Commerce Web Application (automationexercise.com)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF6C37?style=for-the-badge&logo=testng&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Allure](https://img.shields.io/badge/Allure_Report-8A2BE2?style=for-the-badge)

A complete **UI test automation framework** built from scratch with **Selenium WebDriver**, **TestNG** and the **Page Object Model (POM)**, used to test the full user journey of the e-commerce website [automationexercise.com](https://www.automationexercise.com/): registration, login, product browsing, cart, checkout and payment.

The project contains **20 automated test cases** based on the site's [official test cases](https://www.automationexercise.com/test_cases), with **data-driven testing** (JSON), **XML test suites** and rich **Allure reports**.

---

## Table of Contents

- [Demo Video](#demo-video)
- [Screenshots](#screenshots)
- [Key Features](#key-features)
- [Tech Stack](#tech-stack)
- [Test Coverage](#test-coverage)
- [Framework Architecture](#framework-architecture)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Allure Report](#allure-report)
- [Test Data](#test-data)
- [Author](#author)

---

<a id="demo-video"></a>

## 🎥 Demo Video

[![Watch the demo](https://img.shields.io/badge/▶_Watch_the_Project_Demo-Google_Drive-red?style=for-the-badge)](https://drive.google.com/file/d/1_4fyXc5E3oVYYxpc1xe4DxZUnMnO4KDi/view?usp=drive_link)

 **[Click here to watch the full project demo](https://drive.google.com/file/d/1_4fyXc5E3oVYYxpc1xe4DxZUnMnO4KDi/view?usp=drive_link)**

---

<a id="screenshots"></a>

##  Screenshots

[![Project screenshot 1](https://i.postimg.cc/13Js5xXN/d1.png)](https://postimg.cc/yDgwvbFV)


[![d2](https://i.postimg.cc/mkR5HD6F/d2.png)](https://postimg.cc/CBP7yF0F)


[![d2](https://i.postimg.cc/Y973XPNX/d2.png)](https://postimg.cc/06tDjcBm)
---

<a id="key-features"></a>

##  Key Features

- **Custom Selenium automation framework** with a reusable `Framework` wrapper around WebDriver (explicit waits, clicks, text input, dropdowns, checkboxes, hover, scrolling, alerts, file upload and screenshots).
- **Page Object Model (POM):** every page of the application has its own class, and each action returns the next page object, so tests read like the user journey.
- **Data-driven testing:** test data is stored in **JSON** files, loaded with **Gson** into typed data classes and fed to tests through TestNG `@DataProvider`s.
- **Unique test data:** a generator creates a fresh email for every run to avoid "email already exists" collisions.
- **XML test suites:** three feature suites plus a **master suite** that runs everything.
- **Parameterized execution:** the target URL and the browser are passed from the TestNG XML files.
- **Custom TestNG listener** that logs test start, success, failure and skip events.
- **Allure reporting** with Epic / Feature / Story, Severity, Owner, Description and TMS links on every test.
- **Ad-blocker support** in the browser setup, so ads don't intercept clicks on the site.

---

<a id="tech-stack"></a>

##  Tech Stack

| Area | Tool |
|---|---|
| Language | Java |
| Browser automation | Selenium WebDriver |
| Test framework | TestNG |
| Design pattern | Page Object Model (POM) |
| Test data | JSON + Gson |
| Test configuration | TestNG XML suites |
| Build tool | Maven |
| Reporting | Allure Report |
| IDE | IntelliJ IDEA |

---

<a id="test-coverage"></a>

##  Test Coverage

📄 **Test Case Documentation:** [https://www.automationexercise.com/test_cases](https://www.automationexercise.com/test_cases)

| Test Class | Test Cases | Area | Suite File |
|---|---|---|---|
| `UserRegistration_ACM_Tests` | TC01 – TC06 | User Registration & Account Management | `testng1.xml` |
| `ProductsNavigationAndPageFeatures_Tests` | TC07 – TC12 | Products, Navigation & Page Features | `testng2.xml` |
| `CartAndProductPlacement_Tests` | TC13 – TC20 | Cart & Product Placement | `testng3.xml` |

| ID | Scenario |
|---|---|
| TC01 | Register a new user and delete the account |
| TC02 | Login with correct email and password |
| TC03 | Login with incorrect email and password |
| TC04 | Logout user |
| TC05 | Register with an existing email |
| TC06 | Contact Us form with file upload |
| TC07 | Verify the Test Cases page |
| TC08 | Verify the All Products page and product detail page |
| TC09 | Search for a product |
| TC10 | Verify subscription on the home page |
| TC11 | Verify subscription on the cart page |
| TC12 | Add products to the cart |
| TC13 | Verify product quantity in the cart |
| TC14 | Place order: register while checking out |
| TC15 | Place order: register before checkout |
| TC16 | Place order: login before checkout |
| TC17 | Remove products from the cart |
| TC18 | View category products |
| TC19 | View and cart brand products |
| TC20 | Search products and verify the cart after login |

---

<a id="framework-architecture"></a>

##  Framework Architecture

```
Test Classes (TestNG + Allure annotations)
        │   data from JSON via @DataProvider
        ▼
Page Objects (POM)  ──►  Framework (Selenium WebDriver wrapper)  ──►  Browser
        │
        └── DataTypes (typed test data)  ◄──  HelperClass (Gson JSON reader)
```

| Layer | Responsibility |
|---|---|
| `Tests` | Test scenarios, assertions and Allure metadata |
| `Pages` | One class per page, with locators and user actions |
| `Utils` | `Framework` (WebDriver wrapper) and `HelperClass` (JSON reader) |
| `DataTypes` | Plain classes that model the test data |
| `TestData` | JSON files and the unique-email generator |
| `MyListeners` | Custom TestNG listener |

---

<a id="project-structure"></a>

## 📁 Project Structure

```
my_project
├── src
│   ├── main/java
│   │   ├── DataTypes        # Test data models (SignupCredentials, ValidPayment, ...)
│   │   ├── Pages            # Page objects (BasePage, LoginPage, Checkout, ...)
│   │   ├── TestData         # JSON test data + TestDataGenerator
│   │   └── Utils            # Framework (WebDriver wrapper) and HelperClass (JSON reader)
│   └── test/java
│       ├── MyListeners      # CustomListener
│       └── Tests            # UserRegistration_ACM_Tests, ProductsNavigationAndPageFeatures_Tests,
│                            # CartAndProductPlacement_Tests
├── master_testng.xml        # Runs all three suites
├── testng1.xml              # TC01 - TC06
├── testng2.xml              # TC07 - TC12
├── testng3.xml              # TC13 - TC20
└── pom.xml
```

---

<a id="getting-started"></a>

##  Getting Started

### Prerequisites

- JDK (the project is configured for the version set in `pom.xml`)
- Maven
- Google Chrome
- [Allure Commandline](https://allurereport.org/docs/install/) (to open the report)

### Clone the project

```bash
git clone https://github.com/ahmedayman2001/<repository-name>.git
cd <repository-name>
```

### Run the tests

**From IntelliJ IDEA:** right-click `master_testng.xml` → **Run**.
To run one feature area only, run `testng1.xml`, `testng2.xml` or `testng3.xml`.

**From the command line:**

```bash
mvn clean test
```

The target URL and browser come from the XML files:

```xml
<parameter name="TargetUrl" value="https://www.automationexercise.com/"/>
<parameter name="BrowserType" value="Chrome"/>
```

---

<a id="allure-report"></a>

## 📊 Allure Report

After the run, generate and open the report:

```bash
allure serve allure-results
```

Every test shows its Epic, Feature, Story, severity, owner and description, so results can be grouped and filtered by feature.

To start from a clean report, delete the `allure-results` folder before the next run.

---

<a id="test-data"></a>

##  Test Data

Test data lives in JSON files and is loaded into typed Java objects:

```json
{
  "nameOnCard": "Ahmed Ayman",
  "cardNumber": "4111111111111111",
  "cvc": "311",
  "expirationMonth": "12",
  "expirationYear": "2030"
}
```

Dynamic values, such as the email address used for registration, are generated at run time by `TestDataGenerator`. The card number is the standard public test number, and all data is fictional.

> **Note:** The tests run against a public demo website built for practicing automation. It is not a real store.

---

<a id="author"></a>

##  Author

**Ahmed Ayman**
Software QA Engineer | Manual, API & Automation Testing | Selenium & Rest Assured



---

