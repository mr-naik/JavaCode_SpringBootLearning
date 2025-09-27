package net.engineeringdigest.journalApp.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
public class User {

    @Id
    private ObjectId id;

    //By default, spring boot won't do indexing we need to add = spring.data.mongodb.auto-index-creation=true in application.properties
    @Indexed(unique = true)     // @Indexed will create an index for the field(Like index page in a book)
                                // internally it may build a sorted list or a binary tree so it need not go through the entire list of users
                                // thus this makes queries faster as we need not search the entire database to locate data
                                // unique = true ensures no two users have same userName

    @NonNull                    // for userName with index we have also given NonNull, which will ensure the userName field is not NULL
    private String userName;

    @NonNull
    private String password;

    // so every user can have multiple JournalEntries so we want to link these journalEntries to the specific user.
    // so we will add a field called journalEntries
    @DBRef                      // we are creating references of journalEntries
                                // so the list of journalEntries below will keep a list of references of entries in journal_entries collection
                                // this has created a parent child relationship between two collections(mongodb collections)
    private List<JournalEntry> journalEntries = new ArrayList<>();
}
