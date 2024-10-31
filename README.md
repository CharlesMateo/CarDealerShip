# CarDealershipApp
# Dealership Inventory Management System

This Java application is designed to manage the inventory for a used car dealership, allowing users to view, add, and remove vehicles through a command-line interface. It provides various search filters for vehicle attributes such as price range, make/model, year, color, mileage, and type.

## Table of Contents
1. [Features](#features)
2. [Requirements](#requirements)
3. [Installation](#installation)
4. [Usage](#usage)

## Features

- **View All Vehicles**: Displays a list of all vehicles in inventory.
- **Search Filters**: Filter vehicles by price range, make/model, year range, color, mileage range, and type.
- **Add/Remove Vehicles**: Add new vehicles or remove existing ones using the vehicle ID.
- **Data Persistence**: Reads and saves vehicle inventory data from/to a `CSV` file.

## Requirements

- Java 22 or later
- CSV file for vehicle inventory data (`src/inventory.csv`)

## Installation

1. Clone the repository or download the source code.
2. Ensure Java 22 or later is installed on your system.
3. Place an `inventory.csv` file in the `src` folder with the following format:
## Usage

1. Compile the source files:
```bash
javac Main.java
java Main
   
