# Banking Application:

## Project Structure

- This project follows the "by service" structure as recommended in the Spring Boot documentation.
- Instead of separating components like Controller, Service, and Repository into different packages, we group them by feature or service. This approach differs from the traditional structure but aligns with Spring Boot's best practices for scalability and maintainability.

If you're more familiar with the traditional structure, please note this design choice to avoid confusion while navigating the codebase.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [API Endpoints](#api-endpoints)

## Introduction
This banking application project serves as a small-scale training exercise, designed to demonstrate and enhance my skills in managing banking operations through software development. It employs modern technology to provide a straightforward and efficient interface, reflecting both learning and practical application in the world of fintech.

## Features
- Account & Transactions

## Prerequisites
- Java JDK (JDK 17 or higher)
- Maven
- Database (H2 Database)

## API Endpoints

### Account (Transaction Handling)
- GET `/api/accounts/{id}`: Fetch accounts by id
- POST `/api/accounts/{id}/deposit`: Deposit
- POST `/api/accounts/{id}/withdraw`: Withdraw
