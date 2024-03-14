# Packages
The old folder contains legacy Threads approaches

The concurrent api folder contains the recommended way to implement concurrency from java 8-11 and above

# Why Concurrency?
The reason why Concurrency API is introduced is because managing complex, multithreaded applications is quite difficult
for even the most skilled developers.


# What is Thread?
A thread is the smallest unit of execution that can be scheduled by the operating system.

Process: group of associated threads that execute in the same, shared environment.

Shared environment: we mean that the threads in the same process share the same memory
space and can communicate directly with one another.

Task: Is a single unit of work performed by a thread(in java it is common represented by a lambda function). A thread
can complete multiple independent tasks but only one task at a
time.

If one thread updates the value of a static object, then this information is immediately available for other threads within the process to
read.

# THREAD TYPES
System Thread: Created by the JVM and runs in the background of the application. For example, the garbage
collection is managed by a system thread.

User‐Defined Threads: Created by the developer to perform a specific task. Eg the main thread is one of them and
obviously the custom created ones.

# Concurrency
Refers to the execution of multiple threads and processes at the same time, obviously that's not true under the hood
because actually what is happening is that de Operating System is in charge of scheduling them by using something call
Thread Scheduler

# Context Switching
When a Thread does not finish its execution during the assigned time by the operating system then the current 
Thread's state is stored and restored to continue its execution when a new unit of time is assign, that process
is called Context Switch.

The problem with Context Switching is that sometimes is expensive in terms of saving and reloading a Thread's state


# Thread Priority 
An integer value assigned to the Thread that is collected by the scheduler to execute the thread before the ones with
less priority.


# Task definition using  RUNNABLE
Runnable is a functional interface that takes no arguments and returns no data
@FunctionalInterface public interface Runnable {
    void run();
}
