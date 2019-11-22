package mapper;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "cass_training", name = "user",
       readConsistency = "QUORUM",
       writeConsistency = "QUORUM",
       caseSensitiveKeyspace = false,
       caseSensitiveTable = false)
public class User{

    @PartitionKey
    @Column(name = "fullName")
    private String fullName;
    private String email;

    public User(){}

    public User(String name,String email){
        this.fullName = name;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Name: " + this.fullName + " Email: " + this.email;
    }
}