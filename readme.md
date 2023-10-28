# Installing
Make sure to download and install Java version 1.8
-- Make sure you configure environment variables

Download Eclipse( Any version should be good)

Download apache version 9.0.80 (Any version 9 should be good)
- Read how to set up apache and catalina
- Brief Description
- - Set up CATALINA home
  - go into environtment variable, create a variable for CATALINAHOME and set path
  - set up JAVA HOME (Optional?)
  - Run apache server
  - stop apache server

Download files and import project into eclipse

Set up eclipse project settings
- In root folder right click and press setting at the very bottom, in the menu that pops up click "project facets" set java version to 1.8.

Add apache server and run jsp files
- If you dont have the server tab in eclipse, goto Windows -> show view -> Other, search for "servers" and add it to views.
- If you cant see servers you need to add JAVA EE packages
- Click on servers and add apache -> tomcat 9.0, click add and search for where you apache directory is and add it to eclipse, then right click on a jsp file and click 1- run on server
