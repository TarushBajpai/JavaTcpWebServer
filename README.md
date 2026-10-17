# Java TCP Web Server

A Java-based TCP client-server project built to understand the fundamentals of network programming, socket communication, and multithreading in Java.

The project starts with a simple single-threaded server and then extends it into a multithreaded server capable of handling multiple client connections concurrently.

## Features

- TCP client-server communication using Java Sockets
- Server implementation using `ServerSocket`
- Client connections using `Socket`
- Host/address resolution using `InetAddress`
- Sending and receiving data through input/output streams
- Single-threaded server implementation
- Multithreaded server implementation
- Separate thread for handling each connected client
- Multiple concurrent client connections

## Project Structure

```text
java-web-server/
│
├── singleThreaded/
│   ├── Server.java
│   └── Client.java
│
└── multiThreaded/
    ├── Server.java
    └── Client.java
```

## How It Works

### Single-Threaded Server

The server creates a `ServerSocket` and listens on a specific port.

```text
ServerSocket
     │
     ▼
accept()
     │
     ▼
Client Connection
     │
     ▼
Handle Client
     │
     ▼
Wait for Next Client
```

The server handles one client at a time.

### Multithreaded Server

The multithreaded version creates a new thread whenever a client connects.

```text
                  Server
                    │
               ServerSocket
                    │
                 accept()
                    │
          ┌─────────┴─────────┐
          ▼                   ▼
      Client 1             Client 2
      Thread 1             Thread 2
          │                   │
       Handle              Handle
       Client              Client
```

This allows the main server thread to continue accepting new connections while other threads handle existing clients.

## Technologies Used

- Java
- Java Sockets
- TCP/IP
- Java Threads
- Java I/O Streams
- IntelliJ IDEA
- JDK

## Running the Project

### Compile

For the single-threaded version:

```bash
javac singleThreaded/Server.java
javac singleThreaded/Client.java
```

For the multithreaded version:

```bash
javac multiThreaded/Server.java
javac multiThreaded/Client.java
```

### Run the Server

Start the server first:

```bash
java multiThreaded.Server
```

### Run the Client

In another terminal:

```bash
java multiThreaded.Client
```

The client connects to `localhost` on port `8010`.

## What I Learned

This project helped me understand:

- How TCP client-server communication works
- The difference between `ServerSocket` and `Socket`
- How `accept()` waits for incoming connections
- How `InputStream` and `OutputStream` are used for network communication
- How `BufferedReader` and `PrintWriter` simplify text-based communication
- How `InetAddress` resolves a hostname such as `localhost`
- The difference between single-threaded and multithreaded servers
- How Java threads can be used to handle multiple clients concurrently
- Basic concepts of concurrent network programming

## Future Improvements

- HTTP request and response parsing
- HTTP methods such as GET and POST
- URL routing
- Static file serving
- Request logging
- Better connection and resource management
- Thread pool implementation
- Improved error handling
- Configuration support

## Purpose

This project is primarily a hands-on learning project for understanding Java networking, TCP communication, and multithreading before moving toward higher-level Java backend technologies.
