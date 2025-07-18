# FileHandlingUtility

**COMPANY**: CODTECH IT SOLUTIONS
**NAME**:SAKSHI SWAMI
**INTERN ID**: CT04DH328
**DOMAIN**:JAVA PROGRAMMING
**DURATION**: 4 WEEKS
**MENTOR**: NEELA SANTOSH

#DESCRIPTION OF TASK 

UniversalFileHandler.java – Java File Handling Utility
# Overview
UniversalFileHandler.java is a simple yet powerful Java-based command-line utility that demonstrates core file handling operations including reading, writing, and modifying text files. This utility is useful for beginners learning Java I/O as well as developers needing a lightweight tool to manipulate plain text files.

This project is created as part of a file-handling assignment or internship task and focuses on implementing basic file operations using Java's standard I/O classes like FileReader, FileWriter, and BufferedReader.

# Objectives
-To demonstrate the usage of Java file I/O classes.
-To provide a real-world utility that interacts with the filesystem.
-To allow users to dynamically input file content and make modifications via console input.
-To build a reusable, interactive, and menu-driven Java application

# Features

1. Read from File
The user can specify the full path of any existing text file. The program then reads the content using BufferedReader and displays it in the console. Proper error handling is implemented in case the file doesn't exist or is unreadable.

2. Write to File
The utility allows users to enter multiline text, which is then written to a specified file. It uses FileWriter to create or overwrite the file. The user can type "END" on a new line to stop entering content.

3. Modify File Content
The program reads the entire content of a file, replaces all occurrences of a specified old string with a new one, and then writes the modified content back to the same file. This demonstrates reading, string manipulation, and writing operations in one combined function.

4. Menu-Driven Interface
The program runs in a loop and presents the user with a menu:
--Read a file
--Write to a file
--Modify a file
--Exit
Each option is handled using a switch statement, and user input is taken via Java's Scanner class.

# Code Structure

The program is organized into three main methods:
-writeToFile(String filePath, String content)
-readFromFile(String filePath)
-modifyFile(String filePath, String oldContent, String newContent)

Each method is self-contained and handles exceptions appropriately to ensure a smooth user experience.
The main() method serves as the user interface loop, where users choose operations and input paths and content interactively.

# Use Cases
-Beginners learning file handling in Java.
-CLI-based note editors or log writers.
-Modify simple configuration files or templates.
-Read and manipulate textual data files.

# Conclusion
This project offers a practical way to understand and implement file operations in Java. It reinforces the importance of exception handling, string manipulation, and user interaction in building functional console-based applications.








