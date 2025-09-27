package net.engineeringdigest.journalApp.entity;

// we need to map the objects of the class to the fields in mongodb

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;


//@Document will tell spring that JournalEntry is mongoDB Collection's mapped entity(meaning these entities are mapped to collection in mongoDB)
//in other words the instance(Object) of JournalEntry is same as collection or row in mongodb

@Document(collection = "journal_entries")
/*
// lombok annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
*/
//or we can use @Data
@Data
@NoArgsConstructor  // we need this during deserialization(conversion of json to POJO)
// Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.

//as we are using Project Lombok
//if the above is not given it will create or search for a collection with name JournalEntry in lower case
public class JournalEntry {

    //we will map this as primary key
    @Id
//  private String id;  as the mongoDb is saving it as ObjectId datatype we will change this here as well
    private ObjectId id;

    @NonNull
    private String title;

    private String content;

    private LocalDateTime date;

    //as we are using Project Lombok we don't need to write getters and setters
/*    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }*/

}




/*

// we will create a class with the required things for journal entry
// they can be id, title, content etc.


public class JournalEntry {

    private long id;

    private String title;

    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
*/
