# Courses Sales

Application Java en mode console réalisée dans le cadre d'une évaluation de formation.

L'application permet actuellement de :
- afficher toutes les formations ;
- rechercher des formations par mot-clé ;
- filtrer les formations par format (présentiel / distanciel).

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

Base utilisée : `courses_sales`

L'application utilise un utilisateur MariaDB dédié avec des droits restreints.

Les identifiants de connexion doivent être adaptés à l'environnement local.

## Structure du projet

- `appli/` : application Java
- `bdd/` : scripts SQL
- `doc/` : documents de conception UML et spécifications fonctionnelles