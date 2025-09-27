package net.engineeringdigest.journalApp.repository;

// Controller will call service will call repository
// spring data mongodb(dependency added in pom.xml for mongodb) has provided an interface MongoRepository which provides standard CRUD(create read update and delete)
import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

//@Component  not required
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

        //spring will generate an implementation during run time

}
