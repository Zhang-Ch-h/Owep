
# owep

## Introduction
Online Wisdom Education Platform.

## Software Architecture
This system is built using **Maven** and developed based on **Spring Boot**.  
It adopts a **multi-module architecture** following layered software design principles.  
The project is divided into the following modules:

| Module | Description |
|------|-------------|
| owep | Parent project |
| owep-admin-entity | Entity module |
| owep-admin-web-dao | Persistence layer module |
| owep-admin-web-service | Business logic layer module |
| owep-admin-web-dto | Data Transfer Object module |
| owep-admin-web-controller | Web controller module |
| owep-admin-utils | Utility module |
| owep-admin-web-vo | Value Object module |

Architecture diagram:

![Architecture](https://images.gitee.com/uploads/images/2020/0628/224143_15bc2620_1104083.png)

## Main Business Modules

1. System Configuration
2. User Management
3. Permission Management
4. Resource Management
5. Training Program Management
6. Class Management
7. Teaching Management
8. Examination Management
9. Evaluation Management
10. Data Analysis
11. Organization Management
12. Notifications & Announcements
13. Consultation Management
14. Potential Customer Management
15. Operation Logs

## Version: dev_base_v1

Modules included in this version:

1. System Configuration
2. User Management
3. Permission Management
4. Class Management
5. Notifications & Announcements
6. Log Management
7. Organization Management

## Version: dev_base_v2

Modules included in this version:

1. System Configuration
2. User Management
3. Permission Management
4. Class Management
5. Resource Management **(New)**
6. Program Management **(New, including course management)**

## Version: dev_base_v3

Modules included in this version:

1. System Configuration
2. User Management
3. Permission Management
4. Class Management
5. Examination Management **(New)**
6. Teaching Management **(New)**

## Version: dev_base_v4

Modules included in this version:

1. System Configuration
2. User Management
3. Permission Management
4. Class Management
5. Process Management **(New)**
6. Evaluation Management **(New)**

## DTO Purpose, Principles, and Usage

### 1. Purpose

- Assemble data according to page requirements without modifying Entity classes.
- Prevent database structure exposure to external layers.
- Reduce the number of calls through business layer aggregation.

### 2. Design Principles

- Create DTOs for intermediate tables (for example, containing only two foreign keys).
- Create DTOs for report-related data.
- When only part of an Entity's data is required, create a corresponding DTO.
- If multiple pages require similar DTOs, they can be combined. However, if the requirements differ significantly, multiple DTOs are recommended.

### 3. Usage

- In the **service layer**, returned data should be DTO objects or collections of DTOs.
- In the **service layer**, method parameters can continue using Entity types.  
  Note that some attributes must be assigned manually, such as `version`, `createTime`, etc., because these values are not collected from page inputs.

## Usage Instructions

1. Start the Spring Boot application in the **owep-admin-web-controller** module.
2. Open a browser to access the system.
3. Other modules can be tested using unit tests.

## Contribution

1. Clone the repository:

   git clone -b dev_v5 <repository-url>

2. Create a new branch locally:

   Feat_xxx

3. Commit your code.
4. Create a Pull Request.

## Project Team Members

Zhang-Ch-h
