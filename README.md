# Android Activity Tutorial

Repository demo các kiến thức cơ bản và nâng cao về Activity trong Android.

## 📚 Nội dung

### 1. Activity Lifecycle

- **Lifecycle Example**: Demo vòng đời của Activity (onCreate, onStart, onResume, onPause, onStop,
  onDestroy)
- **ViewModel**: Quản lý dữ liệu với ViewModel để tồn tại qua các thay đổi cấu hình

### 2. Launch Modes

Demo 4 chế độ khởi chạy Activity trong Manifest:

- **Standard**: Tạo instance mới mỗi lần khởi chạy
- **SingleTop**: Không tạo mới nếu Activity đang ở đỉnh stack (gọi `onNewIntent()`)
- **SingleTask**: Chỉ có 1 instance trong task, xóa các Activity phía trên nếu đã tồn tại
- **SingleInstance**: Activity chạy trong task riêng biệt, không chia sẻ với Activity khác

### 3. Intent Flags

Demo các cờ Intent để kiểm soát backstack:

- **FLAG_ACTIVITY_CLEAR_TOP**: Xóa các Activity phía trên
- **FLAG_ACTIVITY_NEW_TASK**: Tạo task mới hoặc đưa task hiện có lên foreground
- **FLAG_ACTIVITY_SINGLE_TOP**: Tương tự launchMode singleTop

### 4. Manifest Attributes

- **Task Affinity**: Nhóm các Activity vào các task khác nhau
- **Always Retain Task State**: Giữ trạng thái task kể cả sau thời gian dài
- **Clear Task On Launch**: Xóa toàn bộ Activity trong task khi launch lại

### 5. Data Transfer

- **Send Data**: Truyền dữ liệu giữa các Activity bằng Intent (Parcelable, Serializable)
- **Receive Data**: Nhận và xử lý dữ liệu từ Activity khác

### 6. Activity Result API

- **Register For Activity Result**: API mới thay thế `startActivityForResult()`
- **Request Permissions**: Xin quyền runtime (Storage, Camera, etc.)
- **Pick Image**: Chọn ảnh từ thư viện

### 7. Intent Filter

- Demo nhận Intent từ các ứng dụng khác (ACTION_SEND)
- Chia sẻ text giữa các ứng dụng

## 🚀 Cách chạy

1. Clone repository
2. Mở project bằng Android Studio
3. Sync Gradle
4. Chạy app trên thiết bị hoặc emulator

--- 
**Purpose**: Học tập và thực hành các khái niệm về Activity trong Android

