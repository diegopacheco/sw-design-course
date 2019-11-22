import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.google.common.base.Function;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public class Async{
    public static void main(String[] args) throws Exception {

        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        ListenableFuture<Session> session = cluster.connectAsync();
       
        ListenableFuture<ResultSet> resultSet = Futures.transformAsync(session,
        new AsyncFunction<Session, ResultSet>() {
            public ListenableFuture<ResultSet> apply(Session session) throws Exception {
                return session.executeAsync("select release_version from system.local");
            }
        });

        ListenableFuture<String> version = Futures.transform(resultSet,
        new Function<ResultSet, String>() {
            public String apply(ResultSet rs) {
                return rs.one().getString("release_version");
            }
        });

        Futures.addCallback(version, new FutureCallback<String>() {
            public void onSuccess(String version) {
                System.out.printf("Cassandra version: %s%n", version);
            }
            public void onFailure(Throwable t) {
                System.out.printf("Failed to retrieve the version: %s%n",
                    t.getMessage());
            }
        });

        Thread.sleep(3000L);
        if (cluster != null)
            cluster.close();
    }
}

