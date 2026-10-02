# Courses Sales

Application Java en mode console réalisée dans le cadre d'une évaluation de formation.

## Fonctionnalités

### Branche `main`

La branche `main` contient la première version fonctionnelle de l'application :

- afficher toutes les formations ;
- rechercher des formations par mot-clé ;
- filtrer les formations par format (présentiel / distanciel).

### Branche `dev`

La branche `dev` contient les fonctionnalités supplémentaires en cours de développement :

- ajout d'une formation au panier ;
- modification des quantités d'une formation déjà présente ;
- retrait d'une formation du panier ;
- affichage du contenu du panier ;
- calcul du montant total ;
- sous-menu dédié à la gestion du panier.

Le passage de commande, la connexion utilisateur et la création du client sont encore en cours de développement.

## Technologies

- Java
- JDBC
- MariaDB
- Eclipse
- Git

## Prérequis

- JDK installé
- MariaDB installé
- Eclipse ou un autre IDE Java
- Driver JDBC MariaDB

Le driver JDBC utilisé est présent dans le dossier `appli/lib`.

## Installation

1. Cloner le dépôt.
2. Exécuter le script SQL présent dans le dossier `bdd`.
3. Vérifier les paramètres de connexion à la base de données.
4. Importer le projet `appli` dans Eclipse.
5. Vérifier que le driver MariaDB est présent dans le Build Path.
6. Lancer la classe `Main`.

## Base de données

La branche `main` utilise la base :

`courses_sales`

La branche `dev` utilise la version étendue :

`courses_sales_v2`

L'application utilise un utilisateur MariaDB dédié avec des droits restreints.

Les identifiants de connexion doivent être adaptés à l'environnement local.

## Structure du projet

- `appli/` : application Java
- `bdd/` : scripts SQL
- `doc/` : documents de conception UML et spécifications fonctionnelles