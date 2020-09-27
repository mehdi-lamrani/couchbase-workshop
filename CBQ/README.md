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

*(./cbq au lieu de cbq si MacOS ou Linux)*
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
