This is a Spring Boot web application that allows users to upload, view, and delete photos. The project includes a frontend built with HTML and JavaScript that interacts with a backend RESTful API. Uploaded photos are stored in a database, and users can retrieve them via image endpoints.

🔧 Features:
Upload image files using a file input form.
View photo details as JSON or directly as an image.
Delete photos by ID.
Images are stored as binary data in an embedded H2 database.
Frontend uses fetch() API to communicate with the backend.

⚙️ Technologies Used:
Spring Boot (REST API)
Spring Web & Multipart File Upload
Spring Data JPA
H2 Database (file-based for persistence)
HTML + JavaScript for the frontend

📝 Notes:
This project is based on an online tutorial but has been modified for:

Better styling and layout in the frontend.
Improved image rendering and data persistence using a file-based H2 setup.
Clean error handling and separation of concerns via a service layer.
