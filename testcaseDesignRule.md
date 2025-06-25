Goal of a design automation script
- Can run anywhere, anytime
- Scalable, easy to maintenance
- Action base testing (Base on actual action of Manual test)

## Naming Convention Rules

### Variable Naming
- Use camelCase for variable names: `userName`, `passwordField`, `loginButton`
- Use descriptive names that clearly indicate purpose: `emailInputField` instead of `input1`
- Boolean variables should start with `is`, `has`, `can`: `isLoggedIn`, `hasError`, `canSubmit`
- Constants should be in UPPER_SNAKE_CASE: `MAX_WAIT_TIME`, `DEFAULT_PASSWORD`

### Method Naming
- Use verbs that describe the action: `clickLoginButton()`, `enterUsername()`, `verifyErrorMessage()`
- Test methods should start with `test` or use descriptive names: `testLoginWithValidCredentials()`
- Page Object methods should be action-oriented: `login()`, `selectTicket()`, `fillRegistrationForm()`

### Class Naming
- Use PascalCase for class names: `LoginPage`, `BookTicketPage`, `TestBase`
- Test classes should end with `Test`: `LoginTest`, `RegisterTest`
- Page classes should end with `Page`: `HomePage`, `LoginPage`
- Utility classes should be descriptive: `DriverManager`, `TestDataHelper`

### File Naming
- Test case files: `TC01_LoginWithValidCredentials.java`
- Page object files: `LoginPage.java`, `BookTicketPage.java`
- Utility files: `Constants.java`, `DriverManager.java`

## Code Organization Principles

### Package Structure
```
src/main/java/com/example/
├── pages/          // Page Object Model classes
├── utilities/      // Helper and utility classes
├── driver/         // WebDriver management
├── constant/       // Constants and configuration
└── thirdPartyPage/ // External page objects

src/test/java/com/tests/
├── Login/          // Login related test cases
├── Register/       // Registration test cases
├── BookTicket/     // Booking related test cases
└── TestBase.java   // Base test class
```

### Page Object Model Guidelines
- Each page should have its own class
- Locate elements using Page Factory annotations
- Implement page actions as methods
- Return page objects for method chaining where applicable
- Keep page-specific logic within page classes

### Test Case Structure
```java
// Arrange - Setup test data and preconditions
// Act - Perform the test action
// Assert - Verify the expected outcome
```

## Test Data Management

### Test Data Rules
- Store test data in external files (JSON, Excel, Properties)
- Use data providers for parameterized tests
- Avoid hardcoded values in test methods
- Create test data factories for complex objects
- Use meaningful test data that reflects real scenarios

### Environment Configuration
- Use configuration files for different environments (dev, staging, prod)
- Store URLs, credentials, and timeouts in properties files
- Use environment variables for sensitive data

## Error Handling and Reporting

### Exception Handling
- Use try-catch blocks for recoverable errors
- Implement custom exceptions for specific scenarios
- Log errors with sufficient context information
- Fail fast for critical errors that cannot be recovered

### Logging Guidelines
- Log test execution steps for debugging
- Use different log levels (INFO, DEBUG, ERROR)
- Include timestamps and thread information
- Log before and after critical actions

### Screenshot and Evidence
- Capture screenshots on test failures
- Save test evidence with meaningful names
- Include browser console logs when applicable
- Store evidence in organized folder structures

## Synchronization and Waits

### Wait Strategies
- Use explicit waits over implicit waits
- Implement custom wait conditions when needed
- Avoid Thread.sleep() - use WebDriverWait instead
- Set reasonable timeout values based on application behavior

### Element Interaction Rules
- Always wait for element visibility before interaction
- Verify element state before performing actions
- Handle stale element exceptions gracefully
- Use proper element locating strategies

## Maintenance and Scalability

### Code Reusability
- Create utility methods for common actions
- Implement base classes for shared functionality
- Use inheritance and composition appropriately
- Avoid code duplication across test classes

### Maintainability Rules
- Keep methods short and focused (single responsibility)
- Use meaningful comments for complex logic
- Regular code reviews and refactoring
- Update locators when UI changes

### Cross-browser Compatibility
- Use CSS selectors over XPath when possible
- Test critical flows on multiple browsers
- Handle browser-specific behaviors appropriately
- Use responsive design testing approaches

## Test Execution Guidelines

### Test Independence
- Each test should be independent and isolated
- Tests should not depend on execution order
- Clean up test data after execution
- Reset application state between tests

### Parallel Execution
- Design tests to run in parallel safely
- Avoid shared test data conflicts
- Use thread-safe utilities and drivers
- Implement proper test isolation

### Continuous Integration
- Tests should run reliably in CI/CD pipelines
- Use headless browser modes for faster execution
- Implement retry mechanisms for flaky tests
- Generate comprehensive test reports

## Best Practices Summary

1. **Readability**: Write self-documenting code with clear naming
2. **Reliability**: Implement robust waits and error handling
3. **Maintainability**: Use modular design and avoid code duplication
4. **Scalability**: Design for parallel execution and multiple environments
5. **Efficiency**: Optimize execution time without compromising reliability
6. **Documentation**: Maintain clear documentation and comments
7. **Standards**: Follow consistent coding standards across the project
8. **Testing**: Include unit tests for utility methods and complex logic

//Naming variable rule

//