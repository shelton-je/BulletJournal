[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/x6ckGcN8)
# 3500 PA05 Project Repo

[PA Write Up](https://markefontenot.notion.site/PA-05-8263d28a81a7473d8372c6579abd6481)

## Project Write Up
Welcome to our Bullet Journal Week Application 
in this app you will be able to create weeks and save them to a .bujo file and load them on the fly
you can create events and tasks and track and edit them on the fly. You can also open multiple 
weeks/.bujo files seamlessly to track multiple weeks at one time.

## Solid Princlple Write Up

# S
For Single Responsibility we made each class with that in mind whether in the model for carrying data or the controller
to handle user interaction and the viewer for handling loading JavaFX and create JavaFx containers to display.
# O 
For the Open-Closed Principle we made are classes so that when / if we want to expand on this you can easily extend a 
controller if you want to though the risk of coding yourself in a corner is possible but with our controller
interface if you want to make a controller that the view will take and load just have your class implement it
# L
as above if you extend any of the classes everything will still work as you would either implement the correct interface
and any method calls will still be provided or required by the parent class
# I
With interface segregation in mind you can easily have a class IE. a controller implement multiple interfaces if you 
want to extend this application as long as it implements the controller interface it will work with the view.
# D
in line with O and I because of this our current layout promotes the fact that you need to dependency inject if you 
want to expand either through composition or aggregation which inherently promotes dependency inversion

## Running the Application

To run the application, follow these steps:

1) You will need to have Java installed on your computer. If not installed already, 
download and install Java from here: https://www.java.com/en/download/.

2) Download the JAR file of the application. The JAR file is located in the root 
   directory of this repository.You can also download it directly using this link:
   https://github.com/CS-3500-OOD/pa05-badesign/raw/main/pa05_template_jar3/pa05-template.jar.

3) After downloading the JAR file, navigate to the location where you saved it.

4) You can run the application by either double-clicking on the JAR file or by using
   the terminal (or command prompt):

- To run using double-click, simply double-click on the JAR file. The application should 
  start running if your system is set up to run JAR files with the Java Runtime Environment.

- If you wish to use the terminal (or command prompt), first open it.

- Change the directory to where the JAR file is located. For instance, if you saved 
  the file in your Downloads folder, type cd Downloads.

- Once you're in the correct directory, type java -jar pa05-template.jar to start 
  the application.

## Enjoy using the application!

Please note that the specific commands for the terminal or command prompt may vary 
based on your operating system.If you encounter any issues, refer to your operating 
system's documentation or look for resources online that pertain to navigating files 
and running programs from a terminal or command prompt on your specific operating system.