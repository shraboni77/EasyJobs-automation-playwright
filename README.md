# EasyJobs Automation – Playwright (Java)

## 📌 Project Overview

This repository contains an end-to-end automation framework built using **Playwright with Java**, designed to test the **EasyJobs** application. The framework follows the **Page Object Model (POM)** and **Page Factory** approach to ensure maintainability, reusability, and scalability.

A key highlight of this project is **session (auth) reuse**, where login authentication is stored once and reused across multiple test classes to optimize execution time and avoid redundant logins.

---

## 🛠 Tech Stack

* **Language:** Java
* **Automation Tool:** Playwright
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **IDE:** Eclipse
* **Design Pattern:** Page Object Model + Page Factory

---

## 📂 Project Structure

```
EasyJobs-automation-playwright
│
├── src/main/java
│   ├── com.easyjobs.factory
│   │   └── PlaywrightFactory.java
│   ├── com.easyjobs.pages
│   │   ├── LoginPage.java
│   │   ├── DashboardPage.java
│   │   └── JobPage.java
│   └── com.easyjobs.utils
│       └── AppConstants.java
│
├── src/test/java
│   ├── com.easyjobs.base
│   │   └── BaseTest.java
│   ├── com.easyjobs.tests
│   │   ├── LoginPageTest.java
│   │   ├── DashboardPageTest.java
│   │   └── JobPageTest.java
│
├── pom.xml
└── README.md
```

---

## 🔐 Authentication & Session Management (Key Feature)

To improve test efficiency, authentication is handled **once** and reused across tests.

### How It Works

* Login is performed only in `LoginPageTest`
* Authentication state (session) is stored using Playwright
* The stored session is loaded in other test classes (Dashboard, Job Page)
* Prevents repeated login for each test class

### Why This Approach

* Faster test execution
* More stable tests
* Mimics real user behavior
* Ideal for large regression suites

---

## 🧱 Page Factory Usage

Each page class:

* Stores locators as private members
* Uses Playwright’s `Page` instance
* Exposes clean action methods (no test logic inside pages)

Example responsibilities:

* `LoginPage` → login actions
* `DashboardPage` → dashboard validations
* `JobPage` → job-related flows

---

## ▶️ How to Run the Tests (Using Eclipse)

1. Clone the repository
2. Open **Eclipse**
3. Import as **Existing Maven Project**
4. Run `mvn clean install` to install dependencies
5. Right-click on any test class → **Run as TestNG Test**

---

## 📌 Key Scenarios Covered

* User login and session persistence
* Dashboard validation without re-login
* Job page navigation and validations
* Multi-page flow testing using shared session

---

## 🚀 Future Improvements

* CI/CD integration (GitHub Actions)
* Parallel execution
* Environment-based config support
* Test data externalization

---

## 👩‍💻 Author

**Shraboni Shaila Shormin**
Senior QA Engineer
Specialized in WordPress, SaaS, and Automation Testing

---

⭐ If you find this project helpful, feel free to star the repository!
