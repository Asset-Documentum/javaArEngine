# JavaArEngine
*A Maven Project for Seamless Integration of Sakhr OCR*

## Overview
JavaArEngine is a **Maven-based project** designed to build a **JAR file** that can be easily imported into any Java application. It simplifies the usage of **Sakhr OCR** by eliminating the need for extra configurations.

---

## Features
✔️ Pre-configured Sakhr OCR integration  
✔️ Easy-to-use JAR file  
✔️ No additional setup required  
✔️ Compatible with any Java project  

---

## Building the JAR File with Maven

Follow these steps to build the JAR file:

## 1. Ensure Maven is Installed
Check if Maven is installed:

```
mvn -version
```
If not installed, download and install it from Maven’s official site.

## 2. Build the JAR File
Run the following command to build the project:

```sh

mvn clean package
```
After the build is complete, you will find the JAR file inside the target folder.
## 3. Register the dll
Before registering the DLL, ensure that the SDK is installed. The default installation path is:
C:\Program Files (x86)\Sakhr\Automatic Reader\SDK11.2
## Steps to Register the DLL
3.1. Open the Command Prompt as Administrator.  
3.2. Navigate to the DLL folder:
 ```sh
   cd "C:\Program Files (x86)\Sakhr\Automatic Reader\SDK11.2"
 ```
3.3.  Run the following command to register the DLL
```sh

regsvr32 ar_sdkcom.dll
```
## 4. Import the JAR in Your Project
To use the JAR file in another Java project, add it to your classpath or include it as a dependency in your project.

Usage
Once imported, you can utilize Sakhr OCR functionality in your Java code without additional setup.
