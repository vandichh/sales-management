# Sale-Management

## Hướng dẫn chạy project

Thực hiện các bước sau:

1. Truy cập vào **Git Bash** và chạy lệnh:
   ```bash
   cd ./docker
   ```
   sau đó chạy file script để khởi tạo tất cả container cần thiết
    ```bash
   ./run-all-container.sh
   ```
2. Đợi các container chạy xong, kiểm tra server bằng cách gọi API sau:
   ```bash
   curl -X GET http://localhost:8180/health-check
   ```

## Hướng dẫn tạo dashboard trên grafana

>⚠️ **Note:** Đây chỉ là một dashboard example, có thể phải sửa lại metrics của prometheus và add thêm các panel nếu cần.

1. Truy cập [grafana](http://localhost:3000/) và login với account **admin/admin** 

2. Truy cập Dashboards và chọn import
   <img title="a title" alt="Alt text" src="sale-config/grafana/images/Screenshot 2024-11-29 112103.png">

3. Import file template [sale-config/grafana/dashboard_example_template.json](sale-config/grafana/dashboard_example_template.json) này vào dashboard.
