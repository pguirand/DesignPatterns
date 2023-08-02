package com.pierretest.designpatterns.SOLID

//Not Best implementation ...
/*

class FileWriter {
    fun writeToFile(logMessage: String) {
        // Code to write the log message to a file
    }
}

class Logger(private val fileWriter: FileWriter) {
    fun log(message: String) {
        fileWriter.writeToFile(message)
    }
}

*/

interface LogWriter {
    fun writeLog(logMessage: String)
}

class FileWriter : LogWriter {
    override fun writeLog(logMessage: String) {
        // Code to write the log message to a file
    }
}

class Logger(private val logWriter: LogWriter) {
    fun log(message: String) {
        logWriter.writeLog(message)
    }
}


/*
Now, the Logger class depends on the LogWriter interface,
which is an abstraction. We have separated the high-level
Logger class from the low-level FileWriter class. This makes
it easier to extend the logging system and swap out the log
writer implementation without modifying the Logger class.
For example, we can create a new class that implements
LogWriter to write logs to a database or send them over
the network, and the Logger class can use it without any changes.

By following the Dependency Inversion Principle, we promote a more
flexible and maintainable design, where high-level modules depend
on abstractions, and low-level modules are built around those
abstractions. This reduces the impact of changes and enhances
the overall modularity and testability of the software.*/
