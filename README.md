# Weather App

A simple weather app that allows users to check the weather information for a specific location. The project demonstrates how to consume RESTful APIs and display data in a web application using Spring Boot and JavaScript.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [API Key](#api-key)
- [Contributing](#contributing)
- [License](#license)

## Features

- Input form to enter the location for weather information.
- Fetches weather data from a weather API using Spring Boot's backend.
- Displays the temperature, humidity, and weather condition for the specified location.
- Simple and user-friendly interface.

## Technologies Used

- Java
- Spring Boot
- RESTful API

## Getting Started
To get started with the Weather App project, follow the steps below:

## Prerequisites

Before setting up and running the Weather App project, ensure you have the following prerequisites installed on your system:

- **Java Development Kit (JDK):** The project is built using Java, so you need to have JDK installed. You can download the latest JDK version from the official Oracle or OpenJDK website.

- **API Key from Weather API Provider:** The Weather App fetches weather data from a weather API. Before running the project, you need to obtain an API key from a weather API provider like OpenWeatherMap or WeatherAPI. Follow the API provider's documentation to get your API key.

- **Environment Variables (Optional):** If you prefer to use environment variables for the API key and API base URL, you should have a way to set environment variables on your operating system or development environment.

Note: The Java versions used during development are specified in the project's `pom.xml` files, respectively. Ensure that you have compatible versions installed.


### Installation

1. Clone the repository:

```bash
git clone https://github.com/your-username/weather-app.git
```

2. Set up the API key:

   - Obtain an API key from a weather API provider (e.g., OpenWeatherMap, WeatherAPI).
   - Export the API key as an environment variable:
   ```bash
   export WEATHER_API_KEY=your_weather_api_key_here
   ```

   Optionally, you can set the API base URL as an environment variable:
   ```bash
   export WEATHER_API_BASE_URL=https://api.example.com
    ```
Alternatively, you can set these environment variables in your preferred way for your development environment.

3. Build and run the Spring Boot backend:
```bash
 cd weather-app
./mvnw spring-boot:run
```


## Usage

1. Enter the location (e.g., city name) for which you want to check the weather in the input field.
2. Get Request: http://localhost:8080/weather?location="Enter City Name".
3. The weather data (temperature, humidity, and weather condition) for the specified location will be displayed below the form.

## API Key

Before running the project, make sure to set up your API key for the weather API provider. Follow the instructions in the **Installation** section to configure the API key as an environment variable.

## Contributing

Contributions are welcome! Please feel free to open a pull request or submit an issue for bug fixes, improvements, or new features.


## License

This project is licensed under the MIT License. You can view the full license text in the [LICENSE](LICENSE) file.































### How can I support the developer ?
    Star my Github repo ⭐
    Create pull requests, submit bugs, suggest new features or documentation updates 🛠

### Somethings wrong!!
    If you find that something's wrong with this package, you can let me know by raising an issue on the GitHub issue tracker



### Here is Collection Documentation of Postman

[Collection Documentation of Postman](https://documenter.getpostman.com/view/19629540/2s9XxtxFaW)

