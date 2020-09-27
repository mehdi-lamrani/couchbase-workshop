Linux :
```
/opt/couchbase/bin, /opt/couchbase/bin/install, and /opt/couchbase/bin/tools
```

Windows :
```
C:\Program Files\couchbase\server\bin
```

Mac OS X :
```
/Applications/Couchbase\ Server.app/Contents/Resources/couchbase-core/bin
```

Lancer la commande suivante:
```
>couchbase-cli 

    analytics-link-setup      Manage Analytics Links
    bucket-compact            Compact database and view data
    bucket-create             Add a new bucket to the cluster
    bucket-delete             Delete an existing bucket
    bucket-edit               Modify settings for an existing bucket
    bucket-flush              Flush all data from disk for a given bucket
    bucket-list               List all buckets in a cluster
    cluster-init              Initialize a Couchbase cluster
    collect-logs-start        Start cluster log collection
    collect-logs-status       View the status of cluster log collection
    collect-logs-stop         Stop cluster log collection
    collection-manage         Manage collections in a bucket
    enable-developer-preview  Enable developer preview mode in target cluster
    eventing-function-setup   Manage Eventing Service Functions
    failover                  Failover one or more servers
    group-manage              Manage server groups
    host-list                 List all hosts in a cluster
    ip-family                 Change or get the address family
    master-password           Unlocking the master password
    node-init                 Set node specific settings
    node-to-node-encryption   Change or get the cluster encryption
                              configuration
    rebalance                 Start a cluster rebalancing
    rebalance-status          Show rebalance status
    rebalance-stop            Stop a rebalance
    recovery                  Recover one or more servers
    reset-admin-password      Resets the administrator password
    reset-cipher-suites       Rests cipher suites to the default
    server-add                Add servers to the cluster
    server-info               Show details of a node in the cluster
    server-list               List all nodes in a cluster
    setting-alert             Modify email alert settings
    setting-alternate-address
                              Configure alternate addresses
    setting-audit             Modify audit settings
    setting-autofailover      Modify auto failover settings
    setting-autoreprovision   Modify auto-reprovision settings
    setting-cluster           Modify cluster settings
    setting-compaction        Modify auto-compaction settings
    setting-index             Modify index settings
    setting-ldap              Modify LDAP settings
    setting-master-password   Changing the settings of the master password
    setting-notification      Modify software notification settings
    setting-password-policy   Modify the password policy
    setting-query             Manage query settings
    setting-rebalance         Configure automatic rebalance settings
    setting-saslauthd         Modify saslauthd settings
    setting-security          Modify security settings
    setting-xdcr              Modify XDCR related settings
    ssl-manage                Manage cluster certificates
    user-change-password      Change user password
    user-manage               Manage RBAC users
    xdcr-replicate            Manage XDCR cluster references
    xdcr-setup                Manage XDCR replications
```

Lancer la commande suivante:
```
>couchbase-cli bucket-list -c=127.0.0.1 -u=admin -p=couchbase

hello-bucket
 bucketType: membase
 numReplicas: 1
 ramQuota: 104857600
 ramUsed: 4457360
```