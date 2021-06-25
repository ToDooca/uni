CREATE TABLE Zaposleni (
    Ime VARCHAR(16) NOT NULL,
    Prezime VARCHAR(16) NOT NULL,
    JMBG VARCHAR(16) NOT NULL,
    adresa VARCHAR(32) NOT NULL,
    telefon INT NOT NULL
    );

CREATE TABLE Korisnik (
    Ime VARCHAR(16) NOT NULL,
    Prezime VARCHAR(16) NOT NULL,
    JMBG VARCHAR(16) NOT NULL,
    adresa VARCHAR(32) NOT NULL,
    telefon INT NOT NULL
    );
	
CREATE TABLE Odeljenje (
    Ime VARCHAR(16) NOT NULL,
    Mesto VARCHAR(16) NOT NULL
    );

CREATE TABLE Knjiga (
    Naziv VARCHAR(32) NOT NULL,
    Opis VARCHAR(256) NOT NULL,
	Slika BINARY NOT NULL
    );
	
CREATE TABLE Autor (
    Ime VARCHAR(16) NOT NULL,
    Prezime VARCHAR(16) NOT NULL,
    JMBG VARCHAR(16) NOT NULL,
    adresa VARCHAR(32) NOT NULL,
    telefon INT NOT NULL
    );
	
CREATE TABLE Iznajmljivanje (
    datum_izd DATE NOT NULL
    );

ALTER TABLE autor
ADD UNIQUE (JMBG);

ALTER TABLE autor
ADD UNIQUE (telefon);

ALTER TABLE iznajmljivanje
ADD CONSTRAINT FK_KorisnikIme FOREIGN KEY (KorisnikIme) REFERENCES korisnik(Ime);
	