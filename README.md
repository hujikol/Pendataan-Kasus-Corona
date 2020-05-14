# Responsi-PBO
Responsi Praktikum PBO berupa program dengan menerapkan konsep MVC dan Object Oriented dimana program dapat menambahkan daftar daerah kemudian menyimpan, mengedit, dan menampilkan statistik dari status ODP, PDP, maupun positif dari suatu daerah dan dapat menampilkan status suatu daerah (apakah zona merah atau zona hijau) berdasarkan ketentuan.
Koneksi ke database MySQL menggunakkan JDBC.

## Status yang Disematkan
- **ODP** (orang dalam pemantauan)
- **PDP** (pasien dalam pemantauan)
- Pasien positif.
 
## Ketentuan Keterangan Status
- Apabila dalam suatu daerah terdapat pasien positif, meskipun hanya satu, maka daerah tersebut dianggap sebagai **zona merah**.
- Sedangkan apabila suatu daerah terdapat ODP maupun PDP berapapun jumlahnya sedangkan pasien positif tidak ada, maka daerah tersebut masih dianggap sebagai **zona hijau**.

## Tampilan Program
![tampilan ketika program dijalankan](https://github.com/hujikol/Responsi-PBO/blob/master/SSResponsi.jpg)

## Struktur Database
Dengan **ID_daerah** pada **tabel daerah** sebagai **Primary_Key** dan
**ID_daerah** pada **tabel statistik** sebagai **Foreign_Key**
![tampilan struktur database](https://github.com/hujikol/Responsi-PBO/blob/master/RAT%20responsi.jpg)
