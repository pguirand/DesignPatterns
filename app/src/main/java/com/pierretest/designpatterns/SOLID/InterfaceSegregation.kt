package com.pierretest.designpatterns.SOLID

interface Print {
    fun print(content: String)
}

interface Scan {
    fun scan()
}

interface Fax {
    fun fax()
}

class LaserPrinter : Print, Scan, Fax {
    override fun print(content: String) {
        // Implementation of printing using a laser printer
    }

    override fun scan() {
        // Implementation of scanning using a laser printer
    }

    override fun fax() {
        // Implementation of faxing using a laser printer
    }
}

class InkjetPrinter : Print {
    override fun print(content: String) {
        // Implementation of printing using an inkjet printer
    }
}

/*

The Interface Segregation Principle advises breaking down large interfaces
into smaller, more specialized interfaces to avoid forcing classes
to implement methods they don't need. This leads to more cohesive and focused
interfaces and promotes better separation of concerns in your codebase.

*/


