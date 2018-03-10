# Interface_FB_LN
###### Par Loris Norsic & Franck Boué

[github] (https://github.com/norsicl/Interface_FB_LN "link to github")

L'application est disponible directement en .jar dans le dossier racine appelé : "Interface_FB_LN.jar"

La javadoc est disponible dans le dossier javadoc

# Introduction
Nous avons voulu faire une interface se rapprochant le plus possible de notre prototype. Celui-ci nous semblait clair et compréhensible par des pour tous les utilisateurs.
Le principe que nous avons voulu privilégier c'est l'interaction/action contextuelle. L'utilisateur a donc accès à certaines actions en fonction du contexte d'utilisation dans lequel il se situe à un instant "t".
Ce principe simplifie grandement l'interface, évite les erreurs et augmente la lisibilité.

#### Exemple :
Tant que l'utilisateur n'a pas choisi son répertoire d'image, les différents onglets ne sont pas tous disponibles.


# Partie fonctionnelle :
- le bouton parcourir permettant de choisir un répertoire contenant des images et de visualiser les visualiser (si le les images sont au format JPEG)
- La listView permettant de filtrer les images en fonction du mot clé sélectionné
- Le TexteArea permettant de modifier les mots clés de l'image lors de la sortie de la saisie du champ
- Les 3 langues sont disponibles (français, américain, japonais)

# Utilisation de librairie externe :
- commons-imaging pour récupérer et modifier les différentes métadata des images
- commons-io pour gérer les fichiers

# Création d'un répertoire helper (contenant) :
- fileHelper : aide pour la manipulation des fichiers
- StringHelper : aide pour la conversion entre les chaines de caractère (ISO-8859-15 et UTF-8)
- WriteExifMetadata : aide à l'écriture et à la modification des mots clés des images



# Difficulté rencontrer :
- Temps d'adaptation et pris en main de java FX
- Complexité d'adaptabilité de l'architecture MVC - ( obligé de regrouper la partie modèle dans le Controller dans le délai imparti)
- La librairie externe "commons-imaging", malgré quelques exemples, il a fallu adapter en fonction de notre besoin sur les mots clés
# Bug potentiel
 S'il y a un espace dans le nom du chemin des images les mots clés ne sont pas pris en compte (non réglé)