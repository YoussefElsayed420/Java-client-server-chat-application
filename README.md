# 💬 Client-Server Group Chat Application

Welcome! This repository contains a simple, educational Java project that demonstrates how to build a real-time group chat system using client-server architecture. If you're interested in learning about Java networking, sockets, and multithreading, this project is for you. Anyone is welcome to explore, use, or extend this code for their own learning or projects.

---

## 📚 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup & Running](#setup--running)
- [How It Works](#how-it-works)
- [File Descriptions](#file-descriptions)
- [Troubleshooting](#troubleshooting)
- [License](#license)

---

## 📝 Overview
This project is a simple yet powerful group chat system built with Java. It uses socket programming and multithreading to allow multiple clients to connect to a server and chat in real time. Perfect for learning about networking, concurrency, and Java basics!

---

## ✨ Features
- Real-time group chat for multiple users
- Easy-to-use command-line interface
- Broadcasts messages to all connected clients
- Handles client join/leave events
- Clean, modular codebase

---

## 🏗️ Architecture
```
+---------+       +---------+       +---------+
| Client1 | <---> | Server  | <---> | Client2 |
+---------+       +---------+       +---------+
      \                             /
       +---------+       +---------+
       | Client3 |  ...  | ClientN |
       +---------+       +---------+
```
- The **Server** listens for connections and manages all chat traffic.
- Each **Client** connects to the server, sends messages, and receives broadcasts.

---

## 📁 Project Structure
```
client-server-chat-application/
│
├── src/
│   ├── Client.java
│   ├── ClientHandler.java
│   └── Server.java
│
├── bin/           # Compiled .class files (auto-generated after you compile)
│
└── README.md
```

---

## 🛠️ Prerequisites
- Java Development Kit (JDK) 8 or higher
- Terminal/Command Prompt
- Basic Java knowledge

---

## 🚦 Setup & Running
1. **Open a terminal and navigate to the src folder:**
   ```sh
   cd client-server-chat-application/src
   ```
2. **Compile all Java files:**
   ```sh
   javac *.java -d ../bin
   ```
   This will create the `bin` directory (if it doesn't exist) and place the compiled `.class` files inside.
3. **Start the server (from the bin directory):**
   ```sh
   cd ../bin
   java Server
   ```
4. **Open a new terminal for each client and run (from the bin directory):**
   ```sh
   java Client
   ```
5. **Enter your username and start chatting!**

---

## 🕹️ How It Works
- The server listens on port `1234` for incoming client connections.
- Each client provides a username and joins the chat.
- Messages from any client are broadcast to all others.
- When a client leaves, everyone is notified.

---

## 📄 File Descriptions
- **Client.java**: Handles user input, sends messages, and listens for chat updates.
- **Server.java**: Accepts client connections and manages the chatroom.
- **ClientHandler.java**: Manages each client in a separate thread, relays messages.

---

## 🛟 Troubleshooting
- **Port already in use?** Make sure no other app is using port 1234.
- **Can't connect?** Check your firewall and ensure the server is running.
- **Java errors?** Make sure you have the correct JDK installed and are in the right directory.

---

## 📜 License
This project is open source and free to use for learning and personal projects.

---




