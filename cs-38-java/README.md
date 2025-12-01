# Java Course Projects (CS-38)
Collection of Java programming exercises and assignments from chapters 1-7, originally developed in BlueJ.

## Quick Start

### Prerequisites
- **Java JDK 8+** ([Download here](https://adoptium.net/))
- **VS Code** with [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

### Running Programs

**Option 1: VS Code Play Button** (Recommended)
1. Open any `.java` file with a `main` method
2. Click the **▶️ Run** button in the top-right corner

**Option 2: Terminal**
```bash
# For programs with graphics (Ch01, Ch03, Ch04, Ch06)
javac -cp ".:Libs/draw.jar" Ch01/HW_Fundamentals_VincentNguyen.java
java -cp ".:Libs/draw.jar:Ch01" HW_Fundamentals_VincentNguyen

# For programs without graphics (Ch02, Ch05, Ch07)
javac Ch02/Puzzles2VincentNguyen.java
java -cp ".:Ch02" Puzzles2VincentNguyen
```

**Option 3: VS Code Tasks**
- **Cmd+Shift+B** to compile
- **Cmd+Shift+P** → "Run Task" → "Run Current Java File"

## 📂 Project Structure

```
├── Ch01/          # Fundamentals & Drawing Basics
├── Ch02/          # Variables & Calculations
├── Ch03/          # Decision Structures
├── Ch04/          # Loops & File I/O
├── Ch05/          # Methods
├── Ch06/          # Classes & Objects (OOP)
├── Ch07/          # Arrays
├── Libs/          # External libraries (draw.jar)
├── .vscode/       # VS Code configuration (pre-configured)
├── INDEX.md       # Complete catalog of all programs
└── README.md      # This file
```

## 📖 Documentation

- **[INDEX.md](INDEX.md)** - Complete list of all runnable programs and their dependencies
- **[README_RUN.md](README_RUN.md)** - Detailed compilation and running instructions

## 🎯 Finding What to Run

See **[INDEX.md](INDEX.md)** for:
- Which files are runnable (have `main` methods)
- Which files are helper classes
- Dependencies between files
- Quick examples for each chapter

## 🛠️ Development Setup

This project is pre-configured for VS Code:
- ✅ Classpath includes `Libs/draw.jar` automatically
- ✅ All source paths (Ch01-Ch07) are recognized
- ✅ Launch configuration for running files with the play button
- ✅ Build tasks for compiling

Just open the project in VS Code and start coding!

## 📝 Notes

- Programs in **Ch01, Ch03, Ch04, Ch06** use the `draw.jar` graphics library
- Most files are in the **default package** (no package declaration)
- `.ctxt` and `package.bluej` files are BlueJ metadata (can be ignored in VS Code)
- Ch06 and Ch07 have some programs with **helper class dependencies** - see INDEX.md

## 🤝 Collaboration

To use this project:
1. Clone the repository
2. Open in VS Code
3. Install "Extension Pack for Java" if prompted
4. Open any `.java` file and click Run!

All paths are workspace-relative, so it works on any machine without configuration changes.

## 📧 Author

Vincent Nguyen - CS-38 Java Programming Course

---

**Last Updated:** December 1, 2025
