<h1>Event CRUD</h1>
<p><strong>Developed by Gabriel Dario</strong></p>
<br>
<img align="center" alt="event crud home screen" src="https://github.com/user-attachments/assets/dbf95278-b330-416d-b87a-616e5a746dec">
<p><strong>"Welcome to the Event System"</strong></p>
<br>
<br>

<h2>Technologies Used</h2>

 <h3><strong>Frontend</strong></h3>
        <ul>
            <li><strong>HTML</strong>: Used to structure the application pages, creating elements such as registration forms, lists, and interaction buttons.</li>
            <li><strong>CSS</strong>: Used to style the HTML pages, defining the visual appearance of the application, including layout and colors.</li>
            <li><strong>Thymeleaf</strong>: A templating engine used in the backend to render HTML pages dynamically, filling forms and lists with data from the system.</li>
        </ul>

 <h3><strong>Backend</strong></h3>
        <ul>
            <li><strong>Java</strong>: Programming language used to develop the backend logic, such as data processing and route management.</li>
            <li><strong>Spring Boot</strong>: A framework used to simplify backend development, providing easy database integration and route creation.</li>
            <li><strong>H2 Database</strong>: An in-memory relational database used to store data about cities and events.</li>
        </ul>
<br>
<br>

        

<h2>Features</h2>

 <h3>City Registration</h3>
        <ul>
            <li><strong>Fields</strong>: City name and state are required for registration.</li>
            <li><strong>Edit Cities</strong>: Ability to edit the name and state of previously registered cities.</li>
            <li><strong>Delete Cities</strong>: Allows the deletion of cities, with confirmation if there are any events associated with them.</li>
            <li><strong>List Cities</strong>: Displays all registered cities with options to edit or delete.</li>
        </ul>
        <br>
        <img align="center" alt="event crud home screen" src="https://github.com/user-attachments/assets/16f317c8-3603-4c0b-9e15-6a0eafd31422">
        <br>
        <br>
        <img align="center" alt="event crud home screen" src="https://github.com/user-attachments/assets/9b3e376e-28b8-4c81-ba4e-a591a703c775">
        <br>
        <br>

 <h3>Event Registration</h3>
        <ul>
            <li><strong>Fields</strong>: Event name, date, and URL are required, along with selecting a city.</li>
            <li><strong>Edit Events</strong>: Allows editing event details, including the associated city.</li>
            <li><strong>Delete Events</strong>: Allows deleting events with confirmation.</li>
            <li><strong>List Events</strong>: Displays all registered events, including name, date, and associated city.</li>
        </ul>  
        <br>
         <img align="center" alt="event crud home screen" src="https://github.com/user-attachments/assets/70a2a858-cc50-458c-b958-7f9689d0e65f">
        <br>
        <br>
    
  <img align="center" alt="event crud home screen" src="https://github.com/user-attachments/assets/f851e8ab-93ee-4a04-bd81-11ff162163d5">
        <br>
        <br>



  <h3>Validations</h3>
        <ul>
            <li><strong>Required Fields</strong>: Validation to ensure all required fields are filled correctly.</li>
            <li><strong>Date Format</strong>: The event date is validated to ensure it is in the correct format.</li>
            <li><strong>City Selection</strong>: Validation to ensure that the event is linked to an existing city.</li>
        </ul>
<br>
<br>

<h2>How to Run the Project</h2>

   <pre>
1. Clone this repository:
  git clone https://github.com/dxosen/eventos_mvc

2. Navigate to the project directory:
  cd eventos_mvc

3. Compile and run the project with Maven:
  mvn spring-boot:run

4. Access the application in your browser:
  http://localhost:8080
        </pre>
<br>
<br>

<h2>What I Learned from This Project</h2>
        <ul>
            <li><strong>CRUD System Development</strong>: Learned to create and manage functionality for adding, editing, and deleting data efficiently.</li>
            <li><strong>Integrating Spring Boot with Thymeleaf</strong>: How to use Thymeleaf to dynamically render HTML pages with backend data.</li>
            <li><strong>Working with H2 Database</strong>: Learned how to configure and manipulate an H2 in-memory database for data persistence.</li>
            <li><strong>Project Structuring with Spring Boot</strong>: How to organize the code in layers, ensuring maintainability and scalability.</li>
            <li><strong>User Interface with HTML and CSS</strong>: How to create a functional and simple interface for users to interact with the system.</li>
        </ul>
