package com.pierretest.designpatterns.morePatterns

// Component: FileSystemComponent
interface FileSystemComponent {
    fun showDetails()
}

// Leaf: File
class File(private val name: String, private val size: Int) : FileSystemComponent {
    override fun showDetails() {
        println("File: $name, Size: $size KB")
    }
}

// Composite: Directory
class Directory(private val name: String) : FileSystemComponent {
    private val children: MutableList<FileSystemComponent> = mutableListOf()

    fun addComponent(component: FileSystemComponent) {
        children.add(component)
    }

    fun removeComponent(component: FileSystemComponent) {
        children.remove(component)
    }

    override fun showDetails() {
        println("Directory: $name")
        for (component in children) {
            component.showDetails()
        }
    }
}

fun main() {
    val root = Directory("Root")
    val documents = Directory("Documents")
    val music = Directory("Music")

    val file1 = File("notes.txt", 10)
    val file2 = File("song.mp3", 5120)
    val file3 = File("report.docx", 35)

    documents.addComponent(file1)
    documents.addComponent(file3)
    music.addComponent(file2)

    root.addComponent(documents)
    root.addComponent(music)

    root.showDetails()
}



/*


In this example, we created a hierarchical file system representation using
the Composite Pattern. The root directory contains two subdirectories
(documents and music), and the documents directory contains two files
(file1 and file3), while the music directory contains one file (file2).

When we call root.showDetails(), it recursively displays the details of
all components, whether they are files or directories, effectively treating
them all as FileSystemComponent.

The Composite Pattern allows us to represent complex tree structures and
treat individual objects and compositions uniformly. It simplifies the client
code by enabling a consistent way of interacting with objects at different
levels of the hierarchy. It also promotes code reusability and flexibility by
allowing us to add new components or modify existing ones without affecting
the client code.

*/
