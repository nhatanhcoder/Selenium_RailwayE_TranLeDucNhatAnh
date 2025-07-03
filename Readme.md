# 🚆 Railway Automation Testing Framework

## 📖 Giới thiệu

Framework tự động hóa kiểm thử cho hệ thống đặt vé tàu hỏa SafeRailway, được xây dựng bằng **Selenium WebDriver**, **TestNG** và **Java**. Framework thiết kế theo mô hình **Page Object Model (POM)**, hỗ trợ **data-driven testing** thông qua JSON và tích hợp **ExtentReports** để tạo báo cáo chi tiết.

**🌐 Website under test:** [http://saferailway.somee.com/](http://saferailway.somee.com/)

---

## 🛠️ Công nghệ sử dụng

| Công nghệ               | Phiên bản | Mục đích                                  |
|-------------------------|-----------|-------------------------------------------|
| **Java**                | 11+       | Ngôn ngữ lập trình chính                  |
| **Selenium WebDriver**  | 4.27.0    | Tự động hóa trình duyệt web               |
| **TestNG**              | 7.10.0    | Framework testing và quản lý test suite   |
| **ExtentReports**       | 5.1.2     | Tạo báo cáo HTML đẹp mắt                  |
| **Log4j**               | 2.20.0    | Ghi log hệ thống                          |
| **Gson**                | 2.10.1    | Xử lý dữ liệu JSON                        |
| **Commons-IO**          | 2.11.0    | Thao tác file (screenshot)                |
| **Rest Assured**        | 5.4.0     | Kiểm thử API                              |
| **MailSlurp**           | 15.18.2   | Lấy data từ mail và tạo mail mới          |
|-------------------------|-----------| ----------------------------------------- |


## 📂 Cấu trúc dự án

```bash
Selenium_RailwayE_TranLeDucNhatAnh/
├── src/
│   ├── main/
│   │   ├── java/com/Railway/
│   │   │   ├── constant/           # Hằng số và cấu hình
│   │   │   ├── dataObject/         # Data models và enums
│   │   │   ├── driver/             # WebDriver management
│   │   │   ├── pages/              # Page Object classes
│   │   │   ├── reports/            # Extent Report configs
│   │   │   ├── utilities/          # Helper classes
│   │   │   └── WrapElement/        # Element wrappers
│   │   └── resources/
│   │       └── testSuites/        # TestNG XML files
│   └── test/
│       └── java/com/tests/        # Test case theo module
├── Result/                         # Test results
│   ├── log/
│   ├── report/
│   └── screenshots/
├── pom.xml                         # Maven dependencies
└── README.md                       # Tài liệu dự án
```

---

## 🚀 Hướng dẫn sử dụng

### 🔧 Yêu cầu hệ thống

* Java JDK 11+
* Maven 3.6+
* Chrome/Firefox + Driver tương ứng

### 📅 Cài đặt

```bash
git clone <repository-url>
cd Selenium_RailwayE_TranLeDucNhatAnh
mvn clean install
```

### ▶️ Chạy test

* Chạy tất cả:

```bash
mvn test
```

* Chạy suite:

```bash
mvn test -Dsurefire.suiteXmlFiles=src/main/resources/testSuites/test.xml
```

* Chạy test case cụ thể:

```bash
mvn test -Dtest=TC01
```

* Chạy theo group:

```bash
mvn test -Dgroups=login
```

---

## 📊 Data-Driven Testing

* Dữ liệu test trong file `data.json`
* Dòng bốc tự động theo tên class trong `TestBase.java`

```json
{
  "TC01": {
    "username": "nhatanhkof@gmail.com",
    "password": "Password "
  },
  "TC14": [
    {
      "departStation": "Sài Gòn",
      "arriveStation": "Phan Thiết",
      "days": 4,
      "seatType": "Soft bed with air conditioner",
      "amount": 1
    }
  ]
}
```

---

## 🎯 Test Cases Overview

| Module          | Test Cases                         | Mô tả              |
| --------------- | ---------------------------------- | ------------------ |
| Login           | TC01, TC02, TC03, TC05, TC06, TC08 | Đăng nhập          |
| Register        | TC07, TC10, TC11                   | Đăng ký            |
| Book Ticket     | TC04, TC14                         | Đặt vé             |
| Change Password | TC09                               | Đổi mật khẩu       |
| Reset Password  | TC12, TC13                         | Khôi phục mật khẩu |
| My Ticket       | TC16                               | Quản lý vé         |
| Timetable       | TC15                               | Lịch trình         |

---

## 🔧 Tính năng nâng cao

* 📸 Screenshot khi fail: Lưu với timestamp
* 📊 ExtentReports: UI thân thiện, embed logs/screenshots
* ⏳ Smart wait: Dynamic wait, retry mechanism
* 📁 POM: Mỗi page extend `BasePage`
* 📂 Logging: Log4j2, INFO/WARN/ERROR
* 💡 API test: Tích hợp Rest Assured để test API REST 
* 📧 Email Testing: Sử dụng MailSlurp data từ mail và tạo mail mới

---

## 📊 Reporting & Kết quả

* `Result/report/`: ExtentReports
* `Result/log/`: File log chi tiết
* `Result/screenshots/`: Ảnh chụp lỗi

---

## 😛 Troubleshooting

* **TimeoutException**: Kiểm tra selector, tăng timeout
* **StaleElementException**: Refetch element sau khi DOM thay đổi
* **Driver compatibility**: Kiểm tra Chrome/ChromeDriver version

---

## 🔮 Future Enhancements

* [ ] Parallel test execution
* [ ] CI/CD integration
* [ ] Cross-browser
* [ ] API test layer
* [ ] DB validation
* [ ] Mobile support (Appium)
* [ ] Performance testing

---

## 👨‍💼 Tác giả

**Tran Le Duc Nhat Anh**

* Framework: Selenium Java with TestNG
* Pattern: Page Object Model
* Data-driven architecture

---

## 📞 Hỗ trợ

1. Check `Result/log/App.log`
2. Xem `Result/screenshots/`
3. Mở ExtentReport HTML
4. Contact: \[Email/contact]

---

> **Note:** Dễ dàng mở rộng. Chỉ cần:
>
> 1. Tạo class trong package
> 2. Thêm data vào JSON
> 3. Kết hợp @DataProvider
> 4. Framework lo toàn bộ report & screenshot!
