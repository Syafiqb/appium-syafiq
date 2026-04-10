# SwagLabs Mobile Test Automation

Automasi pengujian mobile untuk aplikasi SwagLabs menggunakan Java, Appium, dan TestNG.
SIT : https://docs.google.com/spreadsheets/d/15LjypSYKoH_bP95lHQcg-hQS3Ft6oYDy5BFBnTpfoA4/edit?usp=sharing

## Ringkasan Proyek

- Bahasa: Java 17
- Build tool: Maven
- Framework pengujian: TestNG
- Otomasi mobile: Appium Java Client
- Pola desain: Page Object Model

## Struktur Proyek

- `pom.xml` - konfigurasi Maven dan dependensi
- `testng.xml` - suite TestNG untuk menjalankan test
- `src/main/java/com/syafiq/appium/drivers` - singleton driver dan strategi driver
- `src/main/java/com/syafiq/appium/pages` - page object untuk halaman aplikasi
- `src/test/java/com/syafiq/appium` - kelas test untuk login, produk, dan checkout

## Persyaratan

Sebelum menjalankan test, pastikan:

1. Java 17 terinstal dan `JAVA_HOME` sudah diatur.
2. Maven tersedia di PATH.
3. Appium server berjalan.
4. Emulator/perangkat Android atau iOS tersedia dan terkoneksi.
5. Aplikasi SwagLabs sudah terpasang pada perangkat/emulator target.

## Menjalankan Test

1. Buka terminal di folder proyek:
   ```bash
   cd /Users/syafiqbasmallah/Documents/tugas-minggu-4/swaglabs-mobile
   ```

2. Mulai Appium server.

3. Jalankan test dengan Maven:
   ```bash
   mvn clean test
   ```

4. TestNG akan menggunakan konfigurasi di `testng.xml` untuk menjalankan:
   - `com.syafiq.appium.LoginTest`
   - `com.syafiq.appium.ProductPageTest`
   - `com.syafiq.appium.CheckoutTest`

## Detail Implementasi

- `DriverSingleton` menginisialisasi `AppiumDriver` sebagai singleton dan mengelola lifecycle driver.
- Folder `drivers/strategies` berisi strategi pemilihan driver untuk Android dan iOS.
- Kelas page object di `pages` mengenkapsulasi elemen dan tindakan halaman aplikasi.
- Test mengeksekusi alur end-to-end: login, menambahkan produk ke keranjang, checkout, dan verifikasi pesan sukses.

## Catatan

- `testng.xml` mengontrol urutan dan suite test.
- Jika ingin menjalankan test tertentu, bisa jalankan kelas test langsung dari IDE atau dengan TestNG suite.
- Sesuaikan konfigurasi Appium dan perangkat jika diperlukan.
