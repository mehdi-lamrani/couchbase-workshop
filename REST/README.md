### Utilisation de l'interface REST ###

Si Windows << Version 10 : <br>
téléchanrger l'outil suivant :
https://curl.haxx.se/windows/dl-7.72.0_3/curl-7.72.0_3-win64-mingw.zip

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