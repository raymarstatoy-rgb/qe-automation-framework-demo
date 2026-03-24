# Test Automation Framework (UI + API)
## 1. Purpose

This repository contains a scalable, enterprise-style test automation framework designed to demonstrate quality engineering best practices, not just individual automated tests.

The framework is built to:
Validate end-to-end user workflows (UI)
Validate backend services (API)
Provide clear, leadership-friendly execution reports
Serve as a reusable automation template for future projects

This project reflects how automation is structured in real production environments, not just demos or proof-of-concepts.

## 2. High-Level Architecture

The framework follows a layered architecture to ensure maintainability, readability, and scalability.

- Tests Layer
  Contains UI and API test cases
  Focuses on what is being tested, not how it is implemented
- Page / Client Layer
  Implements Page Object Model (POM)
  Encapsulates UI interactions
  Keeps test logic clean and easy to understand
- Base & Utilities Layer
  Manages driver setup, configuration, and shared utilities
  Eliminates duplication and centralizes reusable logic
- Reporting Layer
  Centralized Extent Reports integration
  Provides clear execution visibility for both technical and non-technical stakeholders
- Design Benefits
  Minimal impact when UI/API changes
  Improved test stability and maintainability
  Scalable test development
  Clean separation of concerns
## 3. Project Structure

src/test/java/com.demo.automation
│
├── base        # Base test setup and shared behavior
├── pages       # Page Object Model (UI interactions)
├── tests
│   ├── ui      # UI automation tests
│   └── api     # API automation tests
├── utils       # Driver factory and reporting utilities
├── config      # Configuration management
└── listeners   # TestNG listeners for reporting

## 4. Technology Stack
Category	Tool
Language	Java
Build Tool	Maven
UI Automation	Selenium WebDriver
API Automation	Rest Assured
Test Runner	TestNG
Reporting	Extent Reports

These tools represent a commonly used enterprise automation stack.

## 5. How to Run Tests

### Prerequisites
Java 11 or higher
Maven installed
Internet connection (for dependency download)
### Run all tests
mvn clean test
### Run using TestNG suite
mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml
📊 Test Output
HTML execution reports are generated after execution
Reports clearly show passed and failed tests with detailed logs
## 6. Scalability & Reusability

This framework is intentionally designed to scale:

### Key Capabilities
Add new UI pages without modifying existing tests
API tests evolve independently of UI tests
Supports multiple environments via configuration
Centralized and consistent reporting
### As a Result, It Can Be:
Reused across teams
Integrated into CI/CD pipelines
Used as a starter template for new automation initiatives
## 7. Intended Audience
QA Engineers building automated tests
Test Leads reviewing automation design
Engineering Managers evaluating automation maturity

This repository demonstrates how automation is structured and scaled, not just how tests are executed.