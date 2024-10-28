@echo off
rem Make sure to set the correct directories here
set base_dir="Java Course Files" rem Change to your actual base directory if needed
set build_dir=.\build
set lib_dir=.\lib
set source_files=%base_dir%\src\*.java
set lib_files=%lib_dir%\*.jar

rem Create build directory if it doesn't exist
if not exist %build_dir% (
    mkdir %build_dir%
)

rem Compile all Java files
javac -Xlint:-deprecation -d %build_dir% -cp ".\lib\Draw-1.jar;." %source_files%

rem Check for errors in compilation
if %errorlevel% neq 0 (
    echo Compilation failed.
    exit /b %errorlevel%
)

rem Run the Java program (replace YourMainClass with the actual class name)
rem Assuming you want to run a specific main class, change YourMainClass to the actual name
java -cp "%build_dir%;%lib_files%" MyDrawing.java
