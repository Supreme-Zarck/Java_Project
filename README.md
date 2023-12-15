# Introduction à l'Application de Gestion d'Aéroport :

L'application de gestion d'aéroport est une plateforme complète conçue pour simplifier et optimiser les opérations au sein d'un aéroport moderne. En combinant une interface utilisateur intuitive avec des fonctionnalités robustes, cette application vise à faciliter la gestion quotidienne pour les administrateurs, les employés et les passagers.

## **Fonctionnalités Principales :**

1. **Administration Centralisée :**
   - L'administrateur, grâce à son accès privilégié, peut gérer l'ensemble de l'aéroport. Cela inclut l'ajout d'employés avec leurs détails spécifiques, la création et l'affectation de vols, l'ajout d'avions avec leurs caractéristiques, ainsi que la génération de rapports exhaustifs sur l'état de l'aéroport.

2. **Gestion des Employés et des Rôles :**
   - La plateforme offre un module de gestion des employés permettant d'affecter des emplois du temps, de définir des blocs de travail, et d'associer les employés aux avions en fonction de leurs compétences.

3. **Planification et Suivi des Vols :**
   - Les administrateurs peuvent planifier des vols en spécifiant leur destination, origine, pilote, avion, et d'autres détails pertinents. Un suivi en temps réel des vols est également disponible.

4. **Gestion des Avions :**
   - Les caractéristiques de chaque avion, telles que le modèle et la capacité maximale de passagers, peuvent être gérées et mises à jour facilement.

5. **Authentification Multiple :**
   - L'application prend en charge une authentification multiple, permettant à chaque utilisateur, qu'il soit administrateur, employé ou passager, d'accéder uniquement aux fonctionnalités qui lui sont assignées.

6. **Consultation pour les Employés :**
   - Les employés peuvent consulter leurs informations personnelles, leur emploi du temps, le bloc de travail auquel ils sont affectés, et l'avion auquel ils sont assignés.

7. **Réservation pour les Passagers :**
   - Les passagers ont la possibilité de consulter les vols disponibles, de choisir leur destination, d'effectuer des réservations et de générer un reçu pour leur vol.





## Les classes

**Classe Admin :**

1. **Attributs :**
   - `username` : Nom d'utilisateur de l'administrateur.
   - `password` : Mot de passe de l'administrateur (à stocker de manière sécurisée, par exemple, avec le hachage).
   - `nom` : Nom de l'administrateur.
   - `prenom` : Prénom de l'administrateur.

2. **Méthodes :**
   - `ajouterEmploye(nom, prenom, role, ...)`: Ajoute un nouvel employé à la base de données avec les détails fournis.
   - `ajouterVol(destination, origine, pilote, ...)`: Ajoute un nouveau vol avec les détails associés.
   - `ajouterAvion(modele, capaciteMax, ...)`: Ajoute un nouvel avion avec les informations requises.
   - `affecterEmployeAvion(employe, avion)`: Affecte un employé à un avion en fonction de son métier.
   - `affecterEmploiDuTemps(employe, horaires)`: Affecte un emploi du temps à un employé.
   - `affecterBlocTravail(employe, blocTravail)`: Affecte un bloc de travail à un employé.
   - `genererRapportAeroport()`: Génère un rapport complet sur l'état de l'aéroport, y compris les employés, les vols, les avions, etc.
   - `authentifier(username, password)`: Authentifie l'administrateur avant l'accès aux fonctionnalités d'administration.

**Classe Employe :**

1. **Attributs :**
   - `username` : Nom d'utilisateur de l'employé.
   - `password` : Mot de passe de l'employé (stocké de manière sécurisée).
   - `nom` : Nom de l'employé.
   - `prenom` : Prénom de l'employé.
   - `role` : Rôle de l'employé (pilote, attendance, technicien, etc.).

2. **Méthodes :**
   - `consulterInformations()`: Permet à l'employé de consulter ses informations personnelles.
   - `consulterEmploiDuTemps()`: Affiche l'emploi du temps de travail de l'employé.
   - `consulterBlocTravail()`: Affiche le bloc de travail assigné à l'employé.
   - `consulterAvionAffecte()`: Affiche l'avion auquel l'employé est affecté.
   - `authentifier(username, password)`: Authentifie l'employé avant d'accéder à ses informations.

**Classe Passager :**

1. **Attributs :**
   - `username` : Nom d'utilisateur du passager.
   - `password` : Mot de passe du passager (stocké de manière sécurisée).
   - `nom` : Nom du passager.
   - `prenom` : Prénom du passager.

2. **Méthodes :**
   - `consulterVolsDisponibles()`: Permet au passager de consulter les vols disponibles.
   - `choisirVol(destination, origine)`: Permet au passager de choisir son vol.
   - `effectuerPaiement()`: Gère le processus de paiement.
   - `genererRecu()`: Génère une copie du reçu ou du ticket du vol.
   - `authentifier(username, password)`: Authentifie le passager avant d'accéder aux fonctionnalités.

**Classe Avion :**

1. **Attributs :**
   - `modele` : Modèle de l'avion.
   - `capaciteMax` : Capacité maximale de passagers de l'avion.
   - Autres attributs nécessaires pour décrire l'avion.

**Classe Vol :**

1. **Attributs :**
   - `destination` : Destination du vol.
   - `origine` : Lieu d'origine du vol.
   - `pilote` : Pilote assigné au vol.
   - Autres attributs nécessaires pour décrire le vol.

2. **Méthodes :**
   - Méthodes pour gérer les opérations liées au vol, telles que l'attribution du pilote, la gestion des passagers, etc.

**Système d'Authentification :**

1. **Méthodes :**
   - `authentifier(username, password, role)`: Méthode générale d'authentification utilisée par toutes les classes d'utilisateurs.

2. **Contrôle d'Accès :**
   - S'assurer que chaque classe vérifie les droits d'accès de l'utilisateur avant d'exécuter des opérations sensibles.

3. **Sécurité :**
   - Implémenter des mécanismes de sécurité appropriés pour stocker et gérer les mots de passe de manière sécurisée.

4. **Services Transversaux :**
   - Intégrer des services pour des fonctionnalités transversales, par exemple, la gestion des horaires, la génération de rapports, etc.

5. **Interfaces Utilisateur :**
   - Concevoir des interfaces utilisateur adaptées à chaque type d'utilisateur pour une expérience utilisateur optimale.

6. **Documentation :**
   - Documenter en détail chaque attribut et méthode pour permettre une compréhension claire de chaque classe.






## **Base de Données pour l'Application de Gestion d'Aéroport avec MySQL :**

1. **Schéma de la Base de Données :**
   - Créer une base de données nommée "GestionAeroportDB".
   - Définir les tables principales :
     - `Admins`: Stocke les informations des administrateurs.
     - `Employes`: Contient les détails des employés.
     - `Passagers`: Enregistre les données des passagers.
     - `Avions`: Stocke les informations sur les avions.
     - `Vols`: Enregistre les détails des vols.
     - Ajouter d'autres tables si nécessaire pour les emplois du temps, les blocs de travail, etc.

2. **Relations entre les Tables :**
   - Établir des relations appropriées entre les tables, par exemple :
     - Une relation entre `Admins` et `Employes` pour les administrateurs qui sont également des employés.
     - Une relation entre `Vols` et `Avions` pour associer chaque vol à un avion.

3. **Attributs des Tables :**

   - **Table Admins :**
     - `admin_id` (clé primaire), `username`, `password`, `nom`, `prenom`.

   - **Table Employes :**
     - `employe_id` (clé primaire), `username`, `password`, `nom`, `prenom`, `role`, `avion_id` (clé étrangère), `emploi_du_temps_id` (clé étrangère), etc.

   - **Table Passagers :**
     - `passager_id` (clé primaire), `username`, `password`, `nom`, `prenom`.

   - **Table Avions :**
     - `avion_id` (clé primaire), `modele`, `capacite_max`, ...

   - **Table Vols :**
     - `vol_id` (clé primaire), `destination`, `origine`, `pilote_id` (clé étrangère), `avion_id` (clé étrangère), ...
    





# UML Diagram 

![UML_App](https://github.com/Supreme-Zarck/Java_Project/assets/148917149/981ccc6b-3e1f-45ae-9356-0d81cab69db4)


# Class Diagram
![AdminClass](https://github.com/Supreme-Zarck/Java_Project/assets/148917149/5f12335f-cca6-424d-bd5f-94e4d5933503)
![EmployeeClass](https://github.com/Supreme-Zarck/Java_Project/assets/148917149/5c2f1dc1-c47a-466a-952d-ccbb65645d5d)
![PassengerClass](https://github.com/Supreme-Zarck/Java_Project/assets/148917149/9ec3b47d-4a8e-4696-98cb-2bb5b07a2423)
