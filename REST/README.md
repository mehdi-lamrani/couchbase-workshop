### Utilisation de l'interface REST ###

Si Windows << Version 10 : <br>
téléchanrger l'outil suivant :
https://curl.haxx.se/windows/dl-7.72.0_3/curl-7.72.0_3-win64-mingw.zip

- Remarquez que le port a changé : On est sur le 8093 et non plus sur le 8091<br>
En effet, sur le port 8091, tourne le serveur **WEB** HTTP de couchbase<br>
Le port 8093, en revanche, est quant à lui dédié au serveur REST

- Lancer la commande suivante : 
````
curl -v http://127.0.0.1:8093/query/service -d 'statement=SELECT * FROM `hello-bucket`'
````

````diff
-  "User does not have credentials to run SELECT queries on the hello-bucket bucket. Add role query_select on hello-bucket to allow the query to run."
````
Encore une fois, il manque les crédentiels. Cette fois-ci, le message est plus explicite que dans le cas du shell CBQ.


- Lancer la commande suivante : 

````
curl -u admin:couchbase -v http://127.0.0.1:8093/query/service -d 'statement=SELECT * FROM `hello-bucket`'
````
- *A vous de jouer : *

En utilisant l'API REST, supprimez le bucket 'cli-bucket' que vous avez précédemment créé avec l'outil ligne de commande<br>
Tentez de le Requêter le pour vérifier la bonne insertion des données. 


- *Référence de l'API REST Bucket : *
https://docs.couchbase.com/server/current/rest-api/rest-bucket-intro.html