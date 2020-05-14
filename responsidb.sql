-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 14 Bulan Mei 2020 pada 11.46
-- Versi server: 10.4.6-MariaDB
-- Versi PHP: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `responsidb`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `daerah`
--

CREATE TABLE `daerah` (
  `ID_daerah` int(11) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `daerah`
--

INSERT INTO `daerah` (`ID_daerah`, `Nama`, `Status`) VALUES
(1, 'jogja', 'Zona Merah'),
(3, 'sleman', 'Zona Merah'),
(4, 'tidak tau', 'Zona Hijau'),
(6, 'jadi jelas', 'Zona Merah');

-- --------------------------------------------------------

--
-- Struktur dari tabel `statistik`
--

CREATE TABLE `statistik` (
  `ID_daerah` int(11) NOT NULL,
  `Positif` int(11) NOT NULL,
  `ODP` int(11) NOT NULL,
  `PDP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `statistik`
--

INSERT INTO `statistik` (`ID_daerah`, `Positif`, `ODP`, `PDP`) VALUES
(1, 1, 2, 1),
(3, 6, 50, 2),
(4, 0, 50, 20),
(6, 2, 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `daerah`
--
ALTER TABLE `daerah`
  ADD PRIMARY KEY (`ID_daerah`);

--
-- Indeks untuk tabel `statistik`
--
ALTER TABLE `statistik`
  ADD KEY `FOREIGN KEY` (`ID_daerah`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `daerah`
--
ALTER TABLE `daerah`
  MODIFY `ID_daerah` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `statistik`
--
ALTER TABLE `statistik`
  ADD CONSTRAINT `FOREIGN KEY` FOREIGN KEY (`ID_daerah`) REFERENCES `daerah` (`ID_daerah`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
