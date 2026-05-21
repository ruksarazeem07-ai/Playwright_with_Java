# 🎭 Playwright Java Automation Framework

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Playwright](https://img.shields.io/badge/Playwright-1.28.1-green?logo=playwright)
![Cucumber](https://img.shields.io/badge/Cucumber-7.15.0-brightgreen?logo=cucumber)
![Maven](https://img.shields.io/badge/Maven-3.9.15-red?logo=apachemaven)
![Jenkins](https://img.shields.io/badge/Jenkins-CI%2FCD-blue?logo=jenkins)
![Allure](https://img.shields.io/badge/Allure-2.25.0-orange?logo=qameta)
![License](https://img.shields.io/badge/License-MIT-yellow)

---

## 📌 About This Project

A **beginner-friendly** end-to-end test automation framework built with **Playwright + Java + Cucumber BDD**.

This framework is designed to help anyone who is **new to automation testing** get started quickly.
Just clone, configure, and run — no complex setup needed!

> 🛒 **Application Under Test:** [AutomationExercise.com](https://automationexercise.com/) — A free e-commerce practice website perfect for automation learning.

---

## 🧰 Tech Stack

| Tool | Version | Purpose |
|---|---|---|
| Java | 21 | Programming Language |
| Playwright | 1.28.1 | Browser Automation |
| Cucumber | 7.15.0 | BDD Framework |
| JUnit | 4.13.2 | Test Runner |
| Maven | 3.9.15 | Build Tool |
| Extent Reports | 1.14.0 | HTML Test Reporting |
| Allure Reports | 2.25.0 | Advanced Test Reporting |
| Jenkins | 2.555.2 | CI/CD Pipeline |

---

## 📁 Project Structure

```
PlaywrightJava/
├── src/
│   └── test/
│       ├── java/
│       │   ├── Base/                          # Base classes
│       │   │   ├── BasePage.java
│       │   │   └── CommonMethods.java
│       │   ├── com.actionPages/               # Page action methods
│       │   │   └── HomePage.java
│       │   ├── com.dataManager/               # Test data management
│       │   │   ├── CommonMethods.java
│       │   │   └── JsonDataManager.java
│       │   ├── com.pageLocators/              # Element locators
│       │   │   └── HomePageElementsLocators.java
│       │   ├── com.stepDefinitions/           # Cucumber step definitions
│       │   │   └── HomePageStepDefs.java
│       │   ├── com.testRunner/                # Test runner configuration
│       │   │   └── JunitTestRunner.java
│       │   └── utils/                         # Utility classes
│       │       ├── ConfigConstants.java
│       │       ├── Hooks.java
│       │       └── PlaywrightDriver.java
│       └── resources/
│           ├── Feature/                       # Cucumber feature files
│           │   └── Login.feature
│           ├── allure.properties              # Allure report configuration
│           ├── config.properties              # Framework configuration
│           ├── extent.properties              # Extent report configuration
│           ├── extent-config.xml              # Extent report theme settings
│           └── FeatureFilesJsonData.json      # Test data (JSON format)
├── screenshot/                                # Screenshots captured during test runs
├── target/                                    # Build output — auto-generated, not committed
│   ├── allure-results/                        # Allure raw results (JSON)
│   └── Reports/                               # Extent HTML report
├── pom.xml
└── README.md
```

---

## ✅ Test Scenarios Covered

### 🔐 User Authentication
| # | Scenario | Status |
|---|---|---|
| 001 | Register new user successfully | ✅ |
| 002 | Login with correct email and password | ✅ |
| 003 | Login with incorrect email and password | ✅ |

---

## 🚀 Getting Started

### Prerequisites

Make sure you have the following installed on your machine:

| Tool | Download Link |
|---|---|
| Java JDK 21 | [Download](https://www.oracle.com/java/technologies/downloads/) |
| Maven 3.x | [Download](https://maven.apache.org/download.cgi) |
| Git | [Download](https://git-scm.com/downloads) |
| Eclipse IDE | [Download](https://www.eclipse.org/downloads/) |

---

### Step 1 — Clone the Repository

```bash
git clone https://github.com/ruksarazeem07-ai/Playwright_with_Java.git
```

### Step 2 — Navigate to Project Folder

```bash
cd Playwright_with_Java/PlaywrightJava
```

### Step 3 — Open in Eclipse

```
File → Import → Git → Projects from Git → Existing local repository
→ Select cloned folder → Import as Maven Project → Finish
```

### Step 4 — Update Maven Dependencies

```
Right-click project → Maven → Update Project → OK
```

Or via terminal:
```bash
mvn dependency:resolve
```

### Step 5 — Install Playwright Browsers (First Time Only)

```bash
mvn test -P install-playwright
```

> ⚠️ Run this only once after cloning. It downloads Chromium, Firefox, and WebKit browsers.

### Step 6 — Run Tests

**Option A — From Eclipse:**
```
Right-click JunitTestRunner.java → Run As → JUnit Test
```

**Option B — From Terminal (Windows):**
```bash
cd PlaywrightJava
mvn clean test
```

---

## 📊 Test Reports

This framework generates **two types** of reports after every test run:

### 🟢 Extent Report (HTML)
```bash
# Report generated automatically after mvn clean test
# Open this file in your browser:
target/Reports/index.html
```

Shows:
- ✅ Pass / ❌ Fail status per scenario
- Step-by-step execution details
- Execution time per test
- Environment and browser info
- Charts and pie graphs

---

### 🟠 Allure Report (Interactive)

```bash
# Step 1 — Run tests (generates allure-results folder)
mvn clean test

# Step 2 — Open Allure report in browser
mvn allure:serve
```

> 💡 `mvn allure:serve` automatically launches the report in your default browser at `localhost`. No manual file opening needed!

Shows:
- 📈 Trend graphs across multiple runs
- 🧪 Test suites, behaviours, packages view
- 📸 Screenshots on failure
- ⏱️ Timeline of test execution
- 🌍 Environment info

**Allure results folder location:**
```
target/allure-results/
```

---

## ⚙️ Configuration

Edit `src/test/resources/config.properties`:

```properties
# Browser (chromium / firefox / webkit)
browser=chromium

# Base URL
baseUrl=https://automationexercise.com/

# Run without visible browser window
headless=false
```

Edit `src/test/resources/allure.properties`:
```properties
allure.results.directory=target/allure-results
```

---

## 🌐 Supported Browsers

| Browser | Engine | Config Value |
|---|---|---|
| Chrome / Edge | Chromium | `chromium` |
| Firefox | Gecko | `firefox` |
| Safari | WebKit | `webkit` |

---

## 🔄 CI/CD Pipeline — Jenkins

This framework is fully integrated with **Jenkins CI/CD**:

```
Push code to GitHub
      ↓
Jenkins detects change (every 5 mins)
      ↓
Pulls latest code automatically
      ↓
Runs: mvn clean test
      ↓
Generates Allure Report + Extent Report
      ↓
Shows Pass / Fail results in Jenkins dashboard
```

**Jenkins Allure Report path configured at:**
```
PlaywrightJava/target/allure-results
```

🔗 **Live Jenkins Server:** [Click to View](https://parrot-false-unclip.ngrok-free.app)

---

## 🏗️ Framework Architecture

```
Feature Files  →  Step Definitions  →  Action Pages
                                            ↓
                                      Page Locators
                                            ↓
                                    Playwright Driver
                                            ↓
                              Extent Report + Allure Report
```

### Design Patterns Used
- **Page Object Model (POM)** — separates locators from actions
- **BDD (Behaviour Driven Development)** — human-readable test scenarios
- **Data Driven Testing** — test data managed via JSON files

---

## 🖥️ All Terminal Commands — Quick Reference

```bash
# Clone the repo
git clone https://github.com/ruksarazeem07-ai/Playwright_with_Java.git

# Navigate into project
cd Playwright_with_Java/PlaywrightJava

# Install browsers (first time only)
mvn test -P install-playwright

# Run all tests
mvn clean test

# View Allure report in browser
mvn allure:serve

# Run tests + open Allure report (one-liner)
mvn clean test && mvn allure:serve

# Resolve dependencies only (no tests)
mvn dependency:resolve

# Skip tests and just build
mvn clean install -DskipTests

# Run a specific feature tag
mvn clean test -Dcucumber.filter.tags="@Login"

# Push changes to GitHub
git add .
git commit -m "your commit message"
git push origin main
```

---

## 📚 Perfect For Beginners

If you are new to automation, this framework teaches you:

- ✅ How to set up Playwright with Java
- ✅ How to write BDD scenarios with Cucumber
- ✅ How to implement Page Object Model
- ✅ How to manage test data with JSON
- ✅ How to generate Extent Reports (HTML)
- ✅ How to generate Allure Reports (Interactive)
- ✅ How to integrate with Jenkins CI/CD
- ✅ How to push your framework to GitHub

---

## 👩‍💻 Author

**Ruksar Azeem**  
Quality Assurance Engineer

[![GitHub](https://img.shields.io/badge/GitHub-ruksarazeem07--ai-black?logo=github)](https://github.com/ruksarazeem07-ai)
[![Email](https://img.shields.io/badge/Email-ruksarazeem07%40gmail.com-red?logo=gmail)](mailto:ruksarazeem07@gmail.com)

---

## 🤝 Contributing

This project is **open for contributions** — especially from beginners!

1. Fork the repository
2. Create your feature branch
   ```bash
   git checkout -b feature/NewTestScenario
   ```
3. Commit your changes
   ```bash
   git commit -m "Add new test scenario for cart functionality"
   ```
4. Push to GitHub
   ```bash
   git push origin feature/NewTestScenario
   ```
5. Open a Pull Request

---

## 📄 License

This project is licensed under the **MIT License** — free to use for learning and portfolio!

---

⭐ **If this project helped you learn automation, please give it a star!**

> Built with ❤️ to help beginners get started with test automation
