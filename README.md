HƯỚNG DẪN CÀI ĐẶT WEB SERVICE Ở LOCAL

Yêu cầu:
Java 21
MySql version 8

Script database : https://drive.google.com/file/d/1XVnFd-cXhV_uIUJ45f3npKUtai4_tM5L/view?usp=sharing

Bước 1: clone code từ github

Bước 2: run script database

Bước 3 : truy cập application-dev.properties trong source code và thay đổi username và password của database hiện tại

Bước 4: run code BE có thể sử dụng manven -> mvn spring-boot:run

Truy cập vào wagger theo link http://localhost:8080/swagger-ui/index.html và nhập /v3/api-docs
![image](https://github.com/user-attachments/assets/edbecd39-5310-48f0-9c1e-abdccb7046a6)
