```md
# Design Notes – LearnTrack Project

## Why ArrayList Instead of Array
Arrays in Java have a fixed size, which makes them unsuitable for applications where
data grows dynamically.

`ArrayList` was used because:
- It supports dynamic resizing
- It provides useful methods like add(), remove(), and iteration
- It is well-suited for in-memory storage of students, courses, and enrollments

---

## Use of Static Members and Why
Static members were used in the `IdGenerator` utility class.

Examples:
- Static counters for student, course, and enrollment IDs
- Static methods like `getNextStudentId()`

Reasons:
- ID generation is global and does not depend on object state
- Static ensures uniqueness and shared access across the application
- Avoids creating unnecessary objects

---

## Use of Inheritance and Its Benefits
Inheritance was implemented using a base class `Person`.

Structure:
- `Person`  Base class (id, name, email)
- `Student` extends `Person`

Benefits:
- Avoids code duplication
- Common fields and methods are reused
- Enables polymorphism using method overriding (e.g., `getDisplayName()`)

This design improves readability and maintainability of the code.