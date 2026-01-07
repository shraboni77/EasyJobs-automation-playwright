# EasyJobs Automation with Playwright

## 📌 Project Overview

This repository contains an end-to-end automation framework built using **Playwright** to test the **EasyJobs** application. The goal of this project is to ensure core user flows are stable, reusable, and scalable while following industry best practices for QA automation.

The framework is designed with **maintainability**, **reusability**, and **real-world QA scenarios** in mind and reflects how automation is implemented in a professional product-based environment.

---

## 🛠 Tech Stack

* **Automation Tool:** Playwright
* **Language:** Java
* **Test Design Pattern:** Page Object Model (POM)
* **Test Runner:** Playwright Test
* **Environment:** Local & CI-ready

---

## 📂 Project Structure

```
EasyJobs-automation-playwright
│
├── pages/
│   ├── LoginPage.java
│   ├── DashboardPage.java
│   ├── JobPage.java
│
├── tests/
│   ├── login.spec.java
│   ├── dashboard.spec.java
│   ├── job.spec.java
│
├── utils/
│   ├── auth.setup.java
│   ├── constants.java
│
├── playwright.config.java
├── package.json
└── README.md
```

---

## ✅ Key Features

* **Page Object Model (POM)** for clean separation of logic
* **Session reuse (storageState)** to avoid repeated logins
* **Multi-page & popup handling**
* **Explicit waits for stability**
* **Reusable utility methods**
* **Scalable structure** suitable for large applications

---

## 🔐 Authentication Handling

Login is executed **once**, and the authenticated session is stored using Playwright’s `storageState`. This stored session is reused across Dashboard and Job-related tests to improve execution speed and reliability.

---

## 🧪 Test Coverage

* Login flow validation
* Dashboard navigation & verification
* Job page interactions
* Apply flow with new window handling
* UI validations and assertions

---

## ▶️ How to Run the Tests

```bash
npm install
npx playwright install
npx playwright test
```

To run a specific test:

```bash
npx playwright test tests/login.spec.java
```

---

## 📊 Reporting

Playwright’s built-in HTML report is enabled.

```bash
npx playwright show-report
```

---

## 🚀 Why This Project Matters

This project demonstrates:

* Real-world QA automation architecture
* Strong understanding of Playwright capabilities
* Practical handling of authentication, windows, and state
  

It is intended to showcase **professional QA automation skills** rather than just basic test scripts.

---

## 👩‍💻 Author

**Shraboni Shaila Shormin**
Senior QA Engineer
Automation | WordPress | SaaS | Playwright

---

## 📌 Future Improvements

* CI/CD pipeline integration (GitHub Actions)
* Visual regression testing
* API + UI hybrid tests
* Cross-browser & mobile viewport coverage
