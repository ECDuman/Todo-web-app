# Todo-web-app

CHECK-LIST

✓ Java 8+
✓ Spring Boot
✓ Spring Data JPA
✓ H2 Database
✓ Swagger
✓ Maven
✓ Docker
✓ (Optional) JUnit and Mockito
✓ (Optional) Angular frontend


Step-by-Step User Guide by using Docker ( Assuming that docker is installed )

• open cmd  
• run: docker pull ecduman/ngtodoapp:latest 
• run: docker pull ecduman/todoapp:latest 
• run: docker images (to check if images are installed successfully)  
• run: docker run -e DATABASE_SERVER=jdbc:h2:mem:tododb -dp 8080:8080 ecduman/todoapp 
• run: docker run -p 4201:4200 ecduman/ngtodoapp  
• press windows button + R  
• execute: chrome.exe --user-data-dir="C://Chrome dev session" --disable-web-security (Here we need to open chrome in this way to overcome CORS problems.
                                                                                       If you don't want to do that, you can use source code to run the app.
                                                                                       There will be no CORS problems in both ways. The path of running the app
                                                                                       by using source code is straight forward which is below.)  
• The app is ready to use.  
• SWAGGER: http://localhost:8080/swagger-ui.html  
• H2 DATABASE: http://localhost:8080/h2-console  (Don't forget to make JDBC url as following: jdbc:h2:mem:tododb) 
• Front-end: http://localhost:4201/ 
• http://localhost:4201/login 
• http://localhost:4201/registeruser  
• http://localhost:4201/todos 

Step-by-Step User Guide by using Source code (Eclipse & VSCode)

• Open eclipse  
• File tab /import /existing maven project /select the directory path 
• Run TodoApplication.java as java application  
• Open VSCode 
• File tab /Open folder /select the directory path  
• From the terminal of VSCode go to ngtodo path 
• run: ng serve 
• The app is ready to use.  
• SWAGGER: http://localhost:8080/swagger-ui.html  
• H2 DATABASE: http://localhost:8080/h2-console  (Don't forget to make JDBC url as following: jdbc:h2:mem:tododb) 
• Front-end: http://localhost:4200/ 
• http://localhost:4200/login 
• http://localhost:4200/registeruser  
• http://localhost:4200/todos 
• There are also Unit Test that should run as JUnit test in folder: todo\src\test\java\com\app\todo



