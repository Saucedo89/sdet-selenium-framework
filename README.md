# Selenium Roadmap

---

# 1. Project Setup & Maven

## Java Environment

- JDK
- JRE
- JVM
- Java 17 LTS
- java
- javac
- JAVA_HOME
- PATH

## IntelliJ IDEA

- Project SDK
- Maven Project
- Packages
- Resources
- Run Configurations

## Maven Fundamentals

- ¿Qué es Maven?
- pom.xml
- Maven Central
- Repositorio local `.m2`
- Dependencias
- groupId
- artifactId
- version
- SNAPSHOT
- Dependency Scope básico

## Project Structure

```text
src
├── main
│   ├── java
│   └── resources
│
└── test
    ├── java
    └── resources
```

### Conceptos

- src/main/java
- src/main/resources
- src/test/java
- src/test/resources
- Packages
- Código del framework
- Código de pruebas

## Git & GitHub

- Repository
- Clone
- git status
- git add
- git commit
- git push
- git pull
- Branches
- checkout
- switch
- Feature Branches
- develop
- main
- Pull Requests
- Merge
- .gitignore

---

# 2. Framework Infrastructure

## config.properties

Configuración actual:

```properties
execution=local
browser=chrome
base.url=https://www.google.com
implicit.wait=10
grid.url=http://localhost:4444
```

---

## ConfigReader

### Conceptos

- ConfigReader
- Properties
- FileInputStream
- InputStream
- load()
- getProperty()
- Static Variables
- Static Block
- IOException
- RuntimeException
- Integer.parseInt()

### Métodos actuales

```java
ConfigReader.getProperty(...)
```

```java
ConfigReader.getIntProperty(...)
```

### Mejoras posteriores

- try-with-resources
- Validación de propiedades
- Valores por defecto
- Environment Management
- DEV
- QA
- UAT
- PROD

---

## BaseTest

### Responsabilidades

- Inicialización de WebDriver
- Configuración del navegador
- Window Management
- Implicit Wait
- Test Setup
- Test Teardown

### TestNG Lifecycle

- @BeforeMethod
- @AfterMethod

### Conceptos Java aplicados

- Inheritance
- extends
- protected
- Reutilización de código

---

## DriverFactory

### Responsabilidad

Crear el WebDriver correspondiente sin que los tests conozcan la implementación concreta.

### Local Execution

```properties
execution=local
browser=chrome
```

### Browsers

- ChromeDriver
- EdgeDriver
- FirefoxDriver

### Conceptos

- WebDriver Interface
- Polymorphism
- Factory Responsibility
- switch
- toLowerCase()
- IllegalArgumentException
- Separation of Responsibilities
- Low Coupling

### Arquitectura local

```text
BaseTest
    ↓
DriverFactory
    ↓
createDriver()
    ↓
createLocalDriver()
    ↓
Chrome / Edge / Firefox
```

---

## RemoteWebDriver

### Remote Execution

```properties
execution=remote
browser=chrome
grid.url=http://localhost:4444
```

### Conceptos

- RemoteWebDriver
- Local vs Remote Execution
- Browser Options
- ChromeOptions
- FirefoxOptions
- EdgeOptions
- Remote Sessions
- Selenium Server

### Arquitectura

```text
BaseTest
    ↓
DriverFactory
    ↓
createDriver()
    ↓
createRemoteDriver()
    ↓
RemoteWebDriver
    ↓
Selenium Grid
```

---

# 3. Execution Infrastructure

## Docker Fundamentals

### Conceptos

- ¿Qué es Docker?
- Docker Engine
- Docker Desktop
- Images
- Containers
- Docker Hub
- Ports
- Networks
- Volumes

### Comandos básicos

```bash
docker --version
```

```bash
docker pull
```

```bash
docker run
```

```bash
docker ps
```

```bash
docker ps -a
```

```bash
docker stop
```

```bash
docker rm
```

```bash
docker images
```

```bash
docker logs
```

### Primer contenedor

```bash
docker run hello-world
```

---

## Selenium Grid

### Selenium Grid Fundamentals

- ¿Qué es Selenium Grid?
- ¿Para qué sirve?
- Remote Execution
- Cross Browser Testing
- Cross Platform Testing
- Portability Testing

### Execution Modes

- Standalone
- Hub / Node Concepts
- Distributed Grid

### Standalone

```text
Framework
    ↓
RemoteWebDriver
    ↓
Selenium Grid Standalone
    ↓
Browser
```

### Distributed Grid

```text
Framework
    ↓
RemoteWebDriver
    ↓
Selenium Grid
    │
    ├── Chrome Node
    ├── Firefox Node
    └── Edge Node
```

---

## Docker Selenium Grid

### Selenium Docker Images

- selenium/standalone-chrome
- selenium/standalone-firefox
- selenium/standalone-edge

### Docker Grid

- Selenium Hub
- Selenium Nodes
- Chrome Node
- Firefox Node
- Edge Node
- Port 4444
- Grid UI
- Remote Sessions

---

## Docker Compose

- Docker Compose
- compose.yaml
- Services
- Networks
- Ports
- Environment Variables

### Commands

```bash
docker compose up
```

```bash
docker compose down
```

---

## Parallel Execution

### Concepts

- Multiple Browser Sessions
- Cross Browser Execution
- Grid Capacity
- Driver Isolation
- Thread Safety

### TestNG Parallel Execution

- methods
- classes
- tests
- instances

---

## Jenkins

### Jenkins Fundamentals

- ¿Qué es Jenkins?
- Jenkins Controller
- Jenkins Agent
- Nodes
- Executors
- Workspace
- Jobs
- Builds
- Plugins
- Credentials
- Parameters

### Jenkins + GitHub

- Repository Checkout
- Credentials
- Webhooks
- Build Triggers

### Jenkins + Maven

```bash
mvn clean test
```

### Jenkins Pipeline

- Pipeline
- Jenkinsfile
- Stages
- Steps
- Environment Variables

### Pipeline Flow

```text
GitHub
   ↓
Jenkins
   ↓
Maven
   ↓
TestNG
   ↓
Selenium Framework
   ↓
Selenium Grid
```

---

## CI/CD Integration

### Continuous Integration

- Git Push
- Build
- Automated Tests
- Reports
- Artifacts
- Failure Handling

### Tools

- Jenkins
- GitHub Actions
- Azure DevOps

---

## Headless Execution

- Chrome Headless
- Firefox Headless
- Edge Headless
- ChromeOptions
- FirefoxOptions
- EdgeOptions
- Jenkins Execution
- Docker Execution
- CI/CD Execution

---

# 4. Fundamentos Web

## HTML Básico

- Estructura HTML
- Tags comunes
- Formularios
- Tablas
- Inputs
- Buttons
- Links
- Images

### DOM (Document Object Model)

- Qué es el DOM
- Árbol DOM
- Nodos
- Relaciones padre e hijo
- Relaciones entre hermanos (siblings)

### Atributos HTML

- id
- class
- name
- value
- type
- href
- src
- title
- aria-label
- data-testid
- data-*

### Herramientas de Inspección

- Chrome DevTools
- Inspect Element
- Copy XPath
- Copy Selector
- Network Tab
- Console

---

# 5. Selenium Fundamentals

## WebDriver

### Implementaciones

- ChromeDriver
- EdgeDriver
- FirefoxDriver
- RemoteWebDriver

### WebDriver Methods

- get()
- getTitle()
- getCurrentUrl()
- getPageSource()
- navigate()
- manage()
- switchTo()
- close()
- quit()

### Navigation

- navigate().to()
- navigate().back()
- navigate().forward()
- navigate().refresh()

---

## Locators

- id
- name
- className
- tagName
- linkText
- partialLinkText
- cssSelector
- xpath

### Locator Strategy

- Estabilidad
- Mantenibilidad
- IDs únicos
- data-testid
- Atributos dinámicos
- Evitar locators frágiles

---

## WebElement

- click()
- sendKeys()
- clear()
- submit()
- getText()
- getAttribute()
- getDomAttribute()
- getDomProperty()
- isDisplayed()
- isEnabled()
- isSelected()
- getTagName()
- getCssValue()

---

## findElement vs findElements

### findElement()

```java
driver.findElement(...)
```

- WebElement
- NoSuchElementException

### findElements()

```java
driver.findElements(...)
```

- List<WebElement>
- Empty List
- Tablas
- Listas
- Elementos dinámicos

---

# 6. XPath

## Fundamentos XPath

- ¿Qué es XPath?
- XPath vs CSS Selector
- Cuándo utilizar XPath
- Ventajas y desventajas

### Tipos de XPath

- XPath Absoluto
- XPath Relativo

### Estructura XPath

- Nodos
- Relaciones
- Navegación en el DOM

### Funciones XPath

- contains()
- starts-with()
- text()
- last()
- position()
- normalize-space()

### Operadores

- and
- or

### Estrategias de Localización

- XPath basado en atributos
- XPath basado en texto
- XPath basado en múltiples atributos
- XPath dinámico
- XPath parametrizado

### XPath para Elementos Dinámicos

- IDs dinámicos
- Clases dinámicas
- Elementos AJAX
- Elementos renderizados dinámicamente

### XPath Axes

- parent
- child
- ancestor
- descendant
- following
- preceding
- following-sibling
- preceding-sibling
- self

### Relaciones DOM

- Padre
- Hijo
- Hermano
- Ancestro
- Descendiente

### XPath Best Practices

- XPath robustos
- XPath mantenibles
- XPath reutilizables
- Cómo evitar XPath frágiles

### XPath Debugging

- Validación en DevTools
- Diagnóstico de localizadores
- Errores comunes

### Interview Topics

- XPath Absoluto vs Relativo
- contains() vs starts-with()
- XPath vs CSS Selector
- Manejo de atributos dinámicos
- XPath Axes

---

# 7. CSS Selectors

## Básicos

```css
#username
```

```css
.login
```

```css
input[type='text']
```

### Combinadores

#### Descendant

```css
form input
```

#### Child

```css
form > input
```

#### Adjacent Sibling

```css
label + input
```

#### General Sibling

```css
label ~ input
```

### Pseudo Clases

```css
:first-child
```

```css
:last-child
```

```css
:nth-child()
```

### XPath vs CSS

- Ventajas
- Desventajas
- Cuándo usar cada uno

---

# 8. Synchronization

## Waits

- Thread.sleep()
- Implicit Wait
- Explicit Wait
- Fluent Wait
- WebDriverWait

### ExpectedConditions

- visibilityOf
- visibilityOfElementLocated
- elementToBeClickable
- presenceOfElementLocated
- invisibilityOfElementLocated
- alertIsPresent

### Problemas comunes

- Timing Issues
- AJAX
- Dynamic Loading
- Animations
- Flaky Tests

### Interview Topics

- Implicit vs Explicit Wait
- Explicit vs Fluent Wait
- Thread.sleep()
- Mixing Wait Strategies

---

# 9. Assertions

## Hard Assertions

- assertEquals()
- assertNotEquals()
- assertTrue()
- assertFalse()
- assertNull()
- assertNotNull()
- assertSame()
- assertNotSame()
- fail()

### Soft Assertions

- SoftAssert
- softAssert.assertEquals()
- softAssert.assertNotEquals()
- softAssert.assertTrue()
- softAssert.assertFalse()
- softAssert.assertNull()
- softAssert.assertNotNull()
- softAssert.assertAll()

### Assertion Strategy

- Cuándo usar Hard Assert
- Cuándo usar Soft Assert
- Assertion Chaining
- Fail Fast Principle
- Validation Patterns

### UI Assertions

- Validación de texto
- Validación de visibilidad
- Validación de habilitación
- Validación de selección
- Validación de atributos
- Validación de URL
- Validación de títulos

### Functional Assertions

- Validación de reglas de negocio
- Validación de cálculos
- Validación de respuestas API
- Validación de base de datos
- Validación de archivos

### Interview Topics

- Hard Assert vs Soft Assert
- ¿Qué pasa si no ejecutas assertAll()?
- ¿Cuándo NO usar Soft Assert?
- Buenas prácticas de validación

---

# 10. Interacciones Web

## Dropdowns

- Select
- MultiSelect
- Custom Dropdowns

## Checkboxes

## Radio Buttons

## Alerts

- accept()
- dismiss()
- getText()
- sendKeys()

## Frames

- frame()
- parentFrame()
- defaultContent()

## Windows

- getWindowHandle()
- getWindowHandles()
- switchTo().window()

## Tabs

## Actions Class

- Hover
- Double Click
- Right Click
- Drag and Drop
- Keyboard Actions

## JavaScriptExecutor

- Scroll
- Click JS
- Execute Script
- Obtener atributos

---

# 11. Manejo de Archivos

## Upload

- sendKeys()
- File Input

## Download

- Browser Preferences
- Download Validation

## Screenshots

- Manual
- Automáticos
- Screenshots on Failure
- WebElement Screenshots

---

# 12. Selenium Avanzado

## Shadow DOM

## Dynamic Elements

## StaleElementReferenceException

## ElementClickInterceptedException

## NoSuchElementException

## TimeoutException

## Cookies

## Logs

## Browser Capabilities

## Browser Options

## Headless Execution

---

# 13. Data Driven Testing

## Excel

## CSV

## JSON

## Properties Files

## DataProvider

- @DataProvider
- Parameterized Tests
- Multiple Data Sets

---

# 14. Page Object Model

## POM Fundamentals

## Page Classes

## Page Methods

## Locators

## Encapsulación

## Reutilización

## BasePage

## Page Components

- Header
- Menu
- Modal
- Table
- Navigation

---

# 15. Page Factory

## @FindBy

## initElements()

## Lazy Loading

## Ventajas y Desventajas

## Modern Alternatives

---

# 16. Framework Design Avanzado

> La infraestructura básica ya se construyó al inicio.
> En este bloque evolucionamos el framework.

## BasePage

## Utilities

## WaitUtils

## ScreenshotUtils

## Environment Management

### Environments

- DEV
- QA
- UAT
- PROD

### Configuración por ambiente

```text
config-dev.properties
config-qa.properties
config-uat.properties
config-prod.properties
```

## Reporting

## Retry Mechanism

## Listeners

## Logging

## Custom Exceptions

---

# 17. TestNG Advanced

## TestNG Lifecycle

- @BeforeSuite
- @AfterSuite
- @BeforeClass
- @AfterClass
- @BeforeMethod
- @AfterMethod

## Suites

- testng.xml

## Groups

## Parameters

## DataProvider

## Listeners

## RetryAnalyzer

## Parallel Execution

- methods
- classes
- tests
- instances

## Thread Safety

- Driver Isolation
- ThreadLocal<WebDriver>
- Shared State

---

# 18. Reporting & Logging

## Reporting

- TestNG Reports
- Allure Reports
- Extent Reports

## Evidence

- Screenshots
- Logs
- Stack Traces
- Test Artifacts

## Logging

- SLF4J
- Log4j2

### Log Levels

- TRACE
- DEBUG
- INFO
- WARN
- ERROR

## Jenkins Integration

- Publish Reports
- Archive Artifacts

---

# 19. Selenium Modern (Selenium 4+)

## Driver Management Evolution

- System.setProperty()
- WebDriverManager
- Selenium Manager

## Selenium 4 Architecture

- W3C WebDriver Standard
- Selenium Client Architecture
- Browser Drivers
- Selenium Server
- RemoteWebDriver

## Relative Locators

- above
- below
- toLeftOf
- toRightOf
- near

## Chrome DevTools Protocol (CDP)

- Network Monitoring
- Request Interception
- Response Inspection
- Performance Metrics
- Browser Logs

## Selenium Grid 4 Architecture

- Router
- Distributor
- Session Queue
- Session Map
- Event Bus
- Nodes

## Headless Modern Execution

- Chrome Headless
- Edge Headless
- Firefox Headless
- CI/CD Execution

## BiDi (Bidirectional Protocol)

- Conceptos básicos
- Comparativa con CDP
- Casos de uso

## Modern Testing Trends

- Self-Healing Locators
- AI Assisted Testing
- Test Observability
- Browser Automation Evolution

### Interview Topics

- Selenium 3 vs Selenium 4
- Selenium Manager vs WebDriverManager
- Grid 3 vs Grid 4
- CDP vs WebDriver
- CDP vs BiDi
- Relative Locators

---

# 20. Design Patterns for SDET

## Factory Pattern

- DriverFactory
- Factory Responsibility
- Advantages
- Trade-offs

## Singleton

- Concepto
- Cuándo usarlo
- Cuándo NO usarlo

## Strategy Pattern

- Browser Strategy
- Environment Strategy
- Wait Strategy

## Builder Pattern

- Test Data
- Complex Objects

## Dependency Injection

- Conceptos
- Low Coupling
- Testability

---

# 21. DevOps for SDET

> Aquí profundizamos en las herramientas de infraestructura que introdujimos al principio.

## Jenkins Advanced

- Jenkinsfile
- Parameters
- Environment Variables
- Credentials
- Agents
- Parallel Stages
- Reports
- Artifacts

## Docker Advanced

- Dockerfile
- Docker Compose
- Networks
- Volumes
- Troubleshooting

## Selenium Grid Advanced

- Distributed Grid
- Scaling Nodes
- Parallel Sessions
- Capacity
- Grid Troubleshooting

## GitHub Actions

- Workflow
- YAML
- Triggers
- Jobs
- Steps
- Maven Execution
- Test Artifacts

## Azure DevOps

- Pipelines
- Repositories
- Agents
- Variables
- Secrets
- Maven Execution
- Test Reports

---

# 22. Interview Topics

## Selenium Architecture

## WebDriver

## WebElement

## Locator Strategy

## XPath Deep Dive

## CSS Selectors

## Waits

## Assertions

## POM

## Framework Design

## Grid

## RemoteWebDriver

## Docker

## Jenkins

## CI/CD

## Parallel Execution

## Stale Element

## Shadow DOM

## Dynamic Elements

## Git

## Maven

## Java for SDET

## Live Coding

## Real Project Scenarios

- Flaky Tests
- Dynamic Locators
- Parallel Execution Problems
- Environment Configuration
- Browser Compatibility
- Grid Failures
- CI Failures
- Framework Scalability

---

# Current Progress

## Completed

- [x] Java Environment
- [x] Git / GitHub basics
- [x] Maven Project
- [x] pom.xml fundamentals
- [x] Selenium dependency
- [x] TestNG dependency
- [x] Selenium Manager
- [x] Project Structure
- [x] ConfigReader
- [x] Properties
- [x] FileInputStream
- [x] config.properties
- [x] BaseTest
- [x] Implicit Wait configuration
- [x] DriverFactory
- [x] Chrome local execution
- [x] Edge local execution
- [x] Firefox local execution
- [x] Local / Remote execution selection
- [x] RemoteWebDriver basic implementation
- [x] grid.url configuration

## Current Topic

```text
3. Execution Infrastructure
        ↓
Docker Fundamentals  ← WE ARE HERE
```

## Next

```text
Docker Fundamentals
        ↓
Selenium Grid Standalone with Docker
        ↓
Docker Compose
        ↓
Distributed Selenium Grid
        ↓
Jenkins
        ↓
CI/CD
        ↓
Selenium WebDriver
        ↓
Locators
```