# AndroidApp_Roomdataset
### 模擬使用者權限新增

1. Room dataset：Android原生dataset，將使用者權限資訊存取在本地端。
2. 使用Navigation做頁面管理
3. 架構使用MVVM
### 架構圖總覽

```r
📁 com.example.appwithroom
├── data/
│   ├── AppDatabase.kt
│   ├── User_Authentication.kt
│   ├── UserDao.kt
│   └── UserRepository.kt
├── di/
│   └── DatabaseProvider.kt（如果有）
├── ui/
│   ├── userinput/
│   │   ├── UserInfoInputScreen.kt
│   │   └── UserInputViewModel.kt
│   ├── userlist/
│   │   ├── UserListScreen.kt
│   │   └── UserListViewModel.kt
├── MainActivity.kt

```
