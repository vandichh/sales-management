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

## Hướng dẫn tạo dashboard trên grafana

>⚠️ **Note:** Đây chỉ là một dashboard example cho prometheus, chưa bao gồm loki và tempo.

1. Truy cập [grafana](http://localhost:3000/) và login với account **admin/admin** 

2. Truy cập Dashboards và chọn import
   <img title="a title" alt="Alt text" src="sale-config/grafana/images/Screenshot 2024-11-29 112103.png">

3. Import file sale-config/grafana/dashboard_example_template.json
