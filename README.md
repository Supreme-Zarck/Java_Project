### Rapport de Conception - Application de Gestion Financière

#### Introduction :
L'application de gestion financière a pour objectif d'offrir aux utilisateurs un moyen convivial de suivre leurs dépenses, de définir des budgets et de générer des rapports financiers. L'authentification des utilisateurs sera gérée via une base de données MySQL pour garantir la sécurité des informations. La conception comprend l'utilisation de Swift pour le développement de l'interface utilisateur.

#### Classes Principales :

1. *GestionFinanceApp :*
   - *Méthodes :*
     - main(): Point d'entrée de l'application.
     - initialiserApplication(): Initialise les composants, y compris la connexion à la base de données MySQL.
     - afficherGraphiqueMouvementDepenses(): Affiche un graphique du mouvement des dépenses par mois.

2. *AuthentificationManager :*
   - *Méthodes :*
     - verifierAuthentification(nomUtilisateur: String, motDePasse: String): Vérifie l'authentification dans la base de données MySQL.

3. *ConnexionMySQL :*
   - *Méthodes :*
     - obtenirConnexion(): Établit une connexion à la base de données MySQL.

4. *InterfaceUtilisateurSwift (à la place de JavaFX) :*
   - *Méthodes :*
     - afficherFenetreSaisieDepenses(): Affiche la fenêtre pour saisir les dépenses.
     - afficherFenetreDefinirBudget(): Affiche la fenêtre pour définir les budgets.
     - afficherRapportsFinanciers(): Affiche la fenêtre des rapports financiers.

#### Base de Données MySQL :

- *Table "utilisateurs" :*
  - *Colonnes :*
    - id INT PRIMARY KEY AUTO_INCREMENT: Identifiant unique de l'utilisateur.
    - nom_utilisateur VARCHAR(50) UNIQUE: Nom d'utilisateur unique.
    - mot_de_passe VARCHAR(50): Mot de passe de l'utilisateur.

#### Outils Utilisés :

1. *Swift :* Langage de programmation principal utilisé pour le développement de l'interface utilisateur.
2. *MySQL :* Système de gestion de base de données relationnelle pour l'authentification des utilisateurs.
3. *SwiftUI (en remplacement de JavaFX) :* Framework pour la création d'interfaces utilisateur en Swift.
4. *Core Data (en option) :* Framework pour le stockage local de données persistantes en Swift.
5. *JDBC (Java Database Connectivity) :* API Java (pour la connexion à la base de données depuis Swift).

#### Flux de Fonctionnement :

1. L'application démarre avec la classe GestionFinanceApp.
2. La méthode initialiserApplication() est appelée pour établir une connexion à la base de données MySQL.
3. L'authentification des utilisateurs est gérée par la classe AuthentificationManager.
4. Les données de dépenses, budgets, et rapports financiers peuvent être stockées et récupérées depuis la base de données MySQL.
5. L'interface utilisateur Swift utilise SwiftUI pour une expérience utilisateur moderne et réactive.
6. Les fenêtres d'interface utilisateur, telles que la saisie des dépenses et la définition des budgets, sont gérées par InterfaceUtilisateurSwift.
7. La méthode afficherGraphiqueMouvementDepenses() utilise des bibliothèques graphiques Swift pour générer un graphique du mouvement des dépenses par mois.

#### Conclusion :

Cette conception offre une solution complète pour une application de gestion financière en utilisant Swift pour l'interface utilisateur et MySQL pour la gestion sécurisée de l'authentification des utilisateurs. SwiftUI garantit une expérience utilisateur moderne et réactive. L'utilisation de Core Data (en option) peut être envisagée pour le stockage local des données persistantes en Swift. La conception flexible permet une adaptation facile aux exigences spécifiques de l'application et aux retours des utilisateurs.
