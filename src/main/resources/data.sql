-- Insert data into Personne table
INSERT INTO Personne (id, nom, prenom, adresse, code_postal, email) VALUES
(1, 'Dupont', 'Jean', '123 Rue de Paris', '75001', 'jean.dupont@example.com'),
(2, 'Martin', 'Sophie', '456 Avenue de Lyon', '69001', 'sophie.martin@example.com'),
(3, 'Durand', 'Pierre', '789 Boulevard de Marseille', '13001', 'pierre.durand@example.com');

-- Insert data into Voiture table
INSERT INTO Voiture (id, modele, marque, annee, type, chevaux_fiscaux, prix, consommation, couleur, proprietaire_id, locataire_id) VALUES
(1, 'Model S', 'Tesla', 2020, 'BERLINE', 10, 80000, 15, 'Noir', 1, 3),
(2, 'Civic', 'Honda', 2018, 'COMPACTE', 8, 20000, 8, 'Blanc', 1, 3),
(3, 'Mustang', 'Ford', 2019, 'SPORTIVE', 12, 50000, 12, 'Rouge', 2, 1),
(4, 'Clio', 'Renault', 2017, 'CITADINE', 6, 15000, 6, 'Bleu', 2, 1),
(5, 'A3', 'Audi', 2016, 'COMPACTE', 9, 25000, 9, 'Gris', 3, 2),
(6, 'Cayenne', 'Porsche', 2019, 'SUV', 15, 70000, 18, 'Noir', 3, 2);