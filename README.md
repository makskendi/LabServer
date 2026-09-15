##Lab 1
Local URL: http://localhost:8080/

//A short paragraph (five to eight sentences) explaining the client-server model and one full request/response
cycle for GET / .

*The client-server model is a system where a client sends a request to a server, and the server processes the request and sends back a response.
* In my lab, I used curl.exe as the client and my Java program as the server. 
*The Java server listens for requests on port 8080. When I send a GET request to /, the server gets the requested path and checks whether it is exactly /.
* If the path is /, the server sends aThe client-server model is a system where a client sends a request to a server, and the server processes the request and sends back a response. 
*The Java server listens for requests on port 8080. When I send a GET request to /, the server gets the requested path and checks whether it is exactly /. If the path is /, the server sends a 200 OK response with the message Hello from Lab 1.
 *The response also contains headers such as Content-Type and Content-Length.
 *Curl receives the response from the server and displays it in the terminal.
NB/curl → GET / → Java server → checks / → sends 200 OK + Hello from Lab 1 → curl displays it

//A paragraph explaining why Content-Length uses responseBytes.length and never
response.length() , including that Hello from Lab 1 is 16 UTF-8 bytes.

*The Content-Length header must use responseBytes.length because HTTP sends the response body as bytes, not Java characters.
*The response text is first converted to UTF-8 bytes using StandardCharsets.UTF_8. respons eBytes.length gives the actual number of bytes that will be sent to the client.
 *Using response.length() could give a different value when the response contains characters that use more than one UTF-8 byte. For example, Hello from Lab 1 contains 16 characters and is also 16 UTF-8 bytes, so the Content-Length is 16.

//A paragraph explaining F6 versus Shift+F6.
*I use F6 to run the whole project because it runs the project's configured main class, which in this lab is labserver.LabServer. 
*Shift+F6 runs the currently focused Java file instead.

//The DevTools facts you recorded in class (method, path, status, headers) for the public-site request.
*I used Chrome DevTools Network tab to inspect a request to example.com.
 *The request method was GET and the path was /. The status code was 304 Not Modified. 
*Two request headers were Accept-Encoding: gzip, deflate, br, zstd and Accept-Language: en-KE,en-US;q=0.9,en;q=0.8.
 *Two response headers were Age: 9695 and Allow: GET, HEAD.

I USED AI
- I used AI to help me understand the client-server model and the purpose of the Java HTTP server.
- I used AI to understand the difference between F6 and Shift+F6 in NetBeans.
- I used AI to understand why Content-Length must use responseBytes.length instead of response.length().
- I used AI to troubleshoot my NetBeans project setup and understand the HTTP server test results.


LAB 2
The server uses the longest matching prefix when choosing a route.
The `createContext()` method does not  separate GET and
POST requests.
The root `/` handler also needs to check the exact request path using
`path.equals("/")`. 
\`/about` accepts GET requests.
 `/time` accepts GET requests and returns the current timestamp.
 `/echo` accepts POST requests and returns the request body.
`/greet` accepts GET requests and supports the `name` query parameter.
`/info` accepts GET requests and returns information about the server.
Unknown paths return HTTP 404.

AI Disclosure

used to help me understand the Lab 2 requirements,
review the Java code, and explain routing and HTTP methods. 