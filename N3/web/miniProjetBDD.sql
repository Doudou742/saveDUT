Drop table Enseignant;
Drop table Etudiant;
Drop table Secretaire;
Drop table Absence;

CREATE TABLE Enseignant(
    eno Serial NOT NULL,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    matiere VARCHAR(100),
    CONSTRAINT eno PRIMARY KEY (eno)
);


CREATE TABLE Etudiant
(
    etuno Serial NOT NULL,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    telephone VARCHAR(100),
    semestre int,
    CONSTRAINT etuno PRIMARY KEY (etuno)
);

CREATE TABLE Secretaire
(
    sno Serial NOT NULL,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    CONSTRAINT sno PRIMARY KEY (sno) 
);

CREATE TABLE Absence
(
    ano Serial NOT NULL,
	eno Serial NOT NULL, 
	etuno Serial NOT NULL, 
	sno Serial NOT NULL, 
    dateAbs Date,
    heureDeb Time,
    heureFin Time,
    CONSTRAINT pk_ano PRIMARY KEY (ano), 
	CONSTRAINT fk_eno FOREIGN KEY (eno) REFERENCES Enseignant(eno),
	CONSTRAINT fk_etuno FOREIGN KEY (etuno) REFERENCES Etudiant(etuno),
	CONSTRAINT fk_sno FOREIGN KEY (sno) REFERENCES Secretaire(sno)
); 