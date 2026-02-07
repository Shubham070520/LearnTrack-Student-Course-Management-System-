
---

## 📄 `docs/JVM_Basics.md`

```md
# JVM Basics

## What is JDK, JRE, and JVM?

### JVM (Java Virtual Machine)
JVM is a virtual machine that runs Java programs.  
It does not understand Java code directly — it executes **bytecode**.

Each operating system has its own JVM implementation.

---

### JRE (Java Runtime Environment)
JRE contains:
- JVM
- Core libraries (like java.lang, java.util)

It is used to **run** Java applications but cannot compile them.

---

### JDK (Java Development Kit)
JDK contains:
- JRE
- Compiler (`javac`)
- Developer tools

JDK is required to **develop and compile** Java programs.

---

## What is Bytecode?
When Java code is compiled, it is converted into **bytecode** (`.class` file).

Bytecode is:
- Not machine-specific
- Executed by the JVM

This makes Java platform-independent.

---

## What does “Write Once, Run Anywhere” mean?
Java programs are compiled into bytecode, not machine code.  
The same bytecode can run on any system that has a compatible JVM.

This allows developers to write the code once and run it on:
- Windows
- Linux
- macOS

without changing the code.
