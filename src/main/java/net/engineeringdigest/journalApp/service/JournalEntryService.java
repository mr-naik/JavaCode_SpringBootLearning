package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//Controller will create an endpoint and the business logic is written in JournalEntryService
//Controller --> services --> repository
@Component
public class JournalEntryService {

    // To create an entry in database

    //dependency injection
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    public void saveEntry(JournalEntry journalEntry, String userName){
        User user = userService.findByUserName(userName);   // we will find the user form the userName
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved = journalEntryRepository.save(journalEntry);     // used to save the entry fetched from postman into mongoDB
        user.getJournalEntries().add(saved);    //we will add the above saved journalEntrie's reference in the respective user
        userService.saveUser(user);
    }

    // we will write an overloaded saveEntry method for PUT without the userName
    public void saveEntry(JournalEntry journalEntry){
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved = journalEntryRepository.save(journalEntry);     // used to save the entry fetched from postman into mongoDB

    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();    // used to find all the entries in the collection
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);     // will return the journal entry of id that is passed
                                                        // will return optional
    }

    public void deleteById(ObjectId id, String userName){
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));   // if we dont give this line and run the delete there will be inconsistency in user record as we have not removed from user
                                                                                    // but if we do a post again(or on the next save) spring will bring the consistency back and will add the new journalEntry in place of the inconsistent entries reference
        userService.saveUser(user);
        journalEntryRepository.deleteById(id);
    }

}
