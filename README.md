# Interface_FB_LN
###### Par Loris Norsic & Franck Boué

# Introduction
Nous avons voulu faire une interface se raprochant le plus de notre prototypage qui nous semblait claire et compréhensible par des néothites.
Le principe que nous avons voulu priviligier c'est l'interaction/action contextuelle en d'autre terme amener l'utilisateur à faire que ce qu'il peut faire et interdire les actions qui ne peut pas faire dans ce context d'utilisation.
Cela, simplifie grandement l'interface , évite les erreurs, augemente la lisibilité.
#### Exemple :
Tant que l'utilisateur n'a pas choisi sont répétoires d'image. les différents onglets ne sont pas tous disponilbles


# Partie fonctionnel :
- le bouton parccourir permettant de visualiser tout les images de type jpeg d'un répétoire 
- La listView permettant de filter les images en fonction du mot clé selectionné
- Le TexteArea permmettant de modifier les mot clés de l'image lors de la sortie de la saisie du champs


# Utilisation de librairie externe :
- commons-imaging pour récupérer les <> métadata des images
- commons-io pour gerer les fichiers

# Création d'un répétoire helper (contenant) :
- fileHelper : aide pour la manipulation des fichiers
- StringHelper : aide pour la conversion entre les chaines de caractère (ISO-XXX et UTF-8)
- WriteExifMetadata : aide la l'écriture et à la modification des mots clées des images




# Difficulter rencontrer :
- temps d'adaptation et prise en main de java fx
- complexité d'adapatabilité de l'architecture MVC - ( obligé de regrouper la partie modele dans le controller dans le délai impartie)
- la librairie externe "commons-imaging" malgré quelque que exemple il a fallu d'apater en fonction de notre besoin sur les mots clés