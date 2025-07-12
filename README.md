# Appium Cucumber Test Automation Project - Mobile App

This repository contains a **mobile test automation framework** developed using **Appium**, **Cucumber**, **TestNG**, and **Java** for the mobile application. The framework supports BDD (Behavior Driven Development), modular structure, parallel execution, dynamic configuration, and reusable utilities for robust and maintainable test automation.

---

## ✨ Features

* **Mobile App Automation**: Automates native mobile tests using Appium.
* **Cucumber BDD**: Defines scenarios using Gherkin syntax for clear behavior-driven workflows.
* **TestNG Integration**: Manages parallel execution and test reporting.
* **Parallel Execution**: Executes scenarios concurrently across threads.
* **Hooks & Tags**: Supports @LoginRequired, @SearchProduct, and other tags for scenario filtering and setup.
* **Dynamic Configuration**: Utilizes `config.properties` and `Constants` class for managing credentials, timeouts, and URLs.
* **Login Test Coverage**: Covers empty, invalid, and successful login scenarios.
* **Product Search**: Validates product listing based on user input.
* **Screenshot on Failure**: Captures and attaches screenshots to reports when scenarios fail.
* **Page Object Model**: Structured POM approach for all pages (Login, Search, Notifications).
* **Cross-Platform Ready**: Scalable for iOS with minimal modifications.

---

## 🚀 Getting Started

### Prerequisites

* Java 11+
* Maven
* Appium Server (running on 127.0.0.1:4723)
* Android Emulator or physical device
* Node.js and npm

### Install Appium CLI

```bash
npm install -g appium
appium driver install uiautomator2
```

### Clone and Build

```bash
git clone https://github.com/Yusufdmrc/appium-project.git
cd appium-project
mvn clean install
```

### Update Configuration

Modify `src/test/resources/config.properties`:

---

## 🌐 Test Execution

### Run with Maven:

```bash
mvn test -DplatformName=Android
```

### Run Specific Tag:

```bash
mvn test -DplatformName=Android -Dcucumber.filter.tags="@SearchProduct"
```

---

## ⚖️ Technologies Used

* **Appium** (Java Client)
* **Cucumber** (Gherkin)
* **TestNG**
* **Java**
* **Maven**
* **AppiumFieldDecorator**
* **PageFactory**

---

## 🔄 Key Techniques

* **POM Architecture**: Pages organized for reusability.
* **Hooks & Tags**: `@Before`, `@After`, `@LoginRequired`, `@SearchProduct` to control flows.
* **Utility Driven**: `ElementHelper`, `DriverFactory`, `ConfigReader` to encapsulate logic.
* **Screenshot on Failure**: Automatically captured via `@AfterStep` hook.
* **Scenario Outlines**: Used for login test cases with parameterized inputs.

---

