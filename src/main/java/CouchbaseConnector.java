import com.couchbase.client.java.*;
import com.couchbase.client.java.kv.*;
import com.couchbase.client.java.json.*;
import com.couchbase.client.java.query.*;

public class CouchbaseConnector {

    static String bucketName = "hello-bucket";
    static String username = "admin";
    static String password = "couchbase";
    static Cluster cluster = null;
    static Collection collection = null;

    public static void main(String[] args) {
        print("Application Started.");

        initializeConnection();

        //insertUsers();

        //getUsersById();

        getAllUsers();

        //getUsersByEmail();

        //updateUser();

        //deleteUser();

        cleanDisconnect();

        print("Done !");

    }

    public static void initializeConnection()
    {
        try {

            // Initialize the Connection
            cluster = Cluster.connect("127.0.0.1", username, password);

            //Open the bucket
            Bucket bucket = cluster.bucket(bucketName);

            // get a collection reference
            collection = bucket.defaultCollection();


        } catch (Exception e ) {
            print("...something went wrong...");
            e.printStackTrace();
        } finally {

            // Disconnect and close all buckets

            if(cluster != null) {

                // Comment this section out to keep the connection alive
                // cluster.disconnect();
            }
        }
    }

    public static void insertUsers(){
        JsonObject user1 = JsonObject.create()
                .put("firstName", "Perry")
                .put("lastName", "Mason")
                .put("email", "perry.mason@acme.com")
                .put("type", "user")
                .put("tagLine", "Who can we get on the case?");

        MutationResult user1Result = collection.upsert("user::0001", user1);

        JsonObject user2 = JsonObject.create()
                .put("firstName", "Major")
                .put("lastName", "Tom")
                .put("email", "major.tom@acme.com")
                .put("type", "user")
                .put("tagLine", "Send me up a drink");

        MutationResult user2Result = collection.upsert("user::0002", user2);

        JsonObject user3 = JsonObject.create()
                .put("firstName", "Jerry")
                .put("lastName", "Wasaracecardriver")
                .put("email", "jerry.wasaracecardriver@acme.com")
                .put("type", "user")
                .put("tagLine", "el sob number one");

        MutationResult user3Result = collection.upsert("user::0003", user3);
    }

    public static void getUsersById(){

        GetResult getResult = collection.get("user::0001");
        print(getResult);

        getResult = collection.get("user::0002");
        print(getResult);

        getResult = collection.get("user::0003");
        print(getResult);
    }

    public static void updateUser(){

        GetResult getResult = collection.get("user::0001");
        JsonObject doc = getResult.contentAsObject();
        doc.put("newfield","THIS IS A NEW FIELD");
        collection.upsert("user::0003", doc);

    }

    public static void deleteUser(){
        print("before :");
        getAllUsers();

        print("removing user 3");
        collection.remove("user::0003");

        // check the removal :
        print("after :");
        getAllUsers();

    }

    public static void getUsersByEmail(){

        // We Build a query using N1QL & cluster.query
        QueryResult result = cluster.query(
                "SELECT * FROM `" + bucketName + "` WHERE email LIKE $email",
                QueryOptions.queryOptions().parameters(JsonObject.create().put("email", "%@acme.com"))
        );

        // Print each found Row
        for (JsonObject row : result.rowsAsObject()) {
            print("Found row: " + row);
        }

    }

    public static void getAllUsers(){

        // We Build a query using N1QL & cluster.query
        QueryResult result = cluster.query(
                "SELECT * FROM `" + bucketName +"`");

        // Print each found Row
        for (JsonObject row : result.rowsAsObject()) {
            print("Found row: " + row);
        }

        //Throws : "No index available on keyspace hello-bucket that matches your query.
        // Use CREATE INDEX or CREATE PRIMARY INDEX to create an index,
        // or check that your expected index is online."
        // Index needed :
        //CREATE PRIMARY INDEX `hello-index` ON `hello-bucket` USING GSI;
    }

    public static void print(Object msg){
        System.out.println(msg);
    }

    public static void cleanDisconnect() {
        if(cluster != null) {
            cluster.disconnect();
        }
    }
}