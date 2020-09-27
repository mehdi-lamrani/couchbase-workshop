### Console Couchbase 

- Windows : 
```
cd C:\Program Files\Couchbase\Server\bin
```
- Mac OS : 
```
cd /Applications/Couchbase\ Server.app/Contents/Resources/couchbase-core/bin
```
- Linux : 
```
cd /opt/couchbase/bin
```

- Lancez la commande suivante :
<sub>*(./cbq au lieu de cbq si MacOS ou Linux)*</sub>
```
cbq -e=http://127.0.0.1:8091
```

```diff
- ERROR 100 : N1QL: Connection failure Requested resource not found.
```

Ce message d'erreur n'est pas adapté. En réalité, la connection a été refusée pour défaut de crédentiels.
```
./cbq -e=http://127.0.0.1:8091 -u=admin
Enter Password:
🗝
 ```
 
- Vous entrez dans la console cbq :
```
cbq>
```

- Lancez la commande suivante
```
cbq> select * from `hello-bucket`
```

Cette commande renvoie le contenu du bucket en question. 

- *A vous de jouer : *

Insérez des données à la volée dans le bucket 'cli-bucket' que vous avez précédemment créé avec l'outil ligne de commande<br>
Requêtez à nouveau pour vérifier la bonne insertion des données. 

- *Référence du shell CBQ :*
https://docs.couchbase.com/server/current/tools/cbq-shell.html

