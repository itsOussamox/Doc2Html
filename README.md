<h1>Document to HTML Converter</h1>

<p>This repository implements a RESTful API built with Spring Boot that converts documents (currently supporting DOC/PDF format) into HTML format. It leverages the Aspose.Words library for efficient and accurate conversion.</p>

<h2>Features</h2>

<ul>
  <li><strong>Simple API:</strong>  A single endpoint (`/convert-doc` or -pdf) accepts an uploaded DOC file as a stream and returns the converted HTML content in the response.</li>
  <li><strong>Reliable Conversion:</strong>  Employs Aspose.Words, a renowned library, for high-fidelity document conversion.</li>
  <li><strong>Clean Architecture:</strong>  Adheres to Spring Boot best practices, promoting maintainability and extensibility.</li>
</ul>

<h2>How to Use</h2>

<h3>Prerequisites</h3>

<ul>
  <li>Java Development Kit (JDK)</li>
  <li>Maven (or similar build tool)</li>
  <li>Aspose.Words library with a valid license (obtain from Aspose website)</li>
</ul>

<h3>Run the Application</h3>

<ul>
  <li>Navigate to the project directory.</li>
  <li>Run `mvn spring-boot:run`.</li>
</ul>

<h3>Use the API</h3>

<ul>
  <li>Send a POST request to `http://localhost:8080/convert-doc` with the DOC file content in the request body (e.g., using tools like Postman).</li>
  <li>The API will respond with the converted HTML content in the response body.</li>
</ul>

<h2>Further Considerations</h2>

<ul>
  <li>This project serves as a foundation for document conversion..</li>
  <li>Explore error handling mechanisms to gracefully handle invalid file formats or conversion issues.</li>
  <li>Consider implementing security measures (e.g., file size limits) if you plan to expose the API publicly.</li>
</ul>
