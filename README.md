# Sale-Management

## Hướng dẫn chạy project

Thực hiện các bước sau:

1. Truy cập vào **Git Bash** và chạy lệnh:
   ```bash
   cd ./docker
   ```
   sau đó chạy file script
    ```bash
   ./run.sh
   ```
2. Đợi các container chạy xong, kiểm tra server bằng cách gọi API sau:
   ```bash
   curl -X GET http://localhost:8180/health-check
   ```