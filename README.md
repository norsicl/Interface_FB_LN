# Interface_FB_LN
###### Par Loris Norsic & Franck Boué

# Introduction
Nous avons voulu faire une interface se rapprochant le plus de notre prototypage qui nous semblait claire et compréhensible par des néophytes.
Le principe que nous avons voulu privilégier c'est l'interaction/action contextuelle en d'autre terme amener l'utilisateur à faire que ce qu'il peut faire et interdire les actions qui ne peut pas faire dans ce contexte d'utilisation.
Cela, simplifie grandement l'interface , évite les erreurs, augmente la lisibilité.
#### Exemple :
Tant que l'utilisateur n'a pas choisi son répertoire d'image. les différents onglets ne sont pas tous disponibles.


# Partie fonctionnel :
- le bouton parcourir permettant de visualiser tous les images de type jpeg d'un répertoire
- La listView permettant de filtrer les images en fonction du mot clé sélectionné
- Le TexteArea permmettant de modifier les mot clés de l'image lors de la sortie de la saisie du champs
- Les 3 langues sont disponible (français, américain, japon)

# Utilisation de librairie externe :
- commons-imaging pour récupérer et modifier les différentes méta-data des images
- commons-io pour gérer les fichiers

# Création d'un répertoire helper (contenant) :
- fileHelper : aide pour la manipulation des fichiers
- StringHelper : aide pour la conversion entre les chaines de caractère (ISO-8859-15 et UTF-8)
- WriteExifMetadata : aide à l'écriture et à la modification des mots clés des images



# Difficulté rencontrer :
- Temps d'adaptation et prise en main de java fx
- Complexité d'adaptabilité de l'architecture MVC - ( obligé de regrouper la partie modèle dans le Controller dans le délai impartie)
- La librairie externe "commons-imaging" malgré quelque que exemple il a fallu adapter en fonction de notre besoin sur les mots clés
