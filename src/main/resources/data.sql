-- Insert data into Personne table
INSERT INTO Personne (id, nom, prenom, adresse, code_postal, email) VALUES
(101, 'Dupont', 'Jean', '123 Rue de Paris', '75001', 'jean.dupont@example.com'),
(102, 'Martin', 'Sophie', '456 Avenue de Lyon', '69001', 'sophie.martin@example.com'),
(103, 'Durand', 'Pierre', '789 Boulevard de Marseille', '13001', 'pierre.durand@example.com');

-- Insert data into Voiture table
INSERT INTO Voiture (id, modele, marque, annee, type, chevaux_fiscaux, prix, consommation, couleur, proprietaire_id, locataire_id) VALUES
(101, 'Model S', 'Tesla', 2020, 'BERLINE', 10, 80000, 15, 'Noir', 101, 103),
(102, 'Civic', 'Honda', 2018, 'COMPACTE', 8, 20000, 8, 'Blanc', 101, 103),
(103, 'Mustang', 'Ford', 2019, 'SPORTIVE', 12, 50000, 12, 'Rouge', 102, 101),
(104, 'Clio', 'Renault', 2017, 'CITADINE', 6, 15000, 6, 'Bleu', 102, 101),
(105, 'A3', 'Audi', 2016, 'COMPACTE', 9, 25000, 9, 'Gris', 103, 102),
(106, 'Cayenne', 'Porsche', 2019, 'SUV', 15, 70000, 18, 'Noir', 103, 102);