/*
package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


// controllers are special type of classes or components which handles HTTP requests

@RestController
@RequestMapping("/journal")  // RequestMapping will add a mapping on the entire class
// so if we want to access an end point defined inside a class it will be localhost:8080/journal/...
public class JournalEntryControllerV3_withResponseEntity {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping   // localhost:8080/journal  GET
    // METHODS INSIDE A CONTROLLER CLASS SHOULD BE PUBLIC SO THAT THEY CAN BE ACCESSED AND INVOKED AY THE SPRING FRAMEWORK OR EXTERNAL HTTP REQUESTS.
    public ResponseEntity<List<JournalEntry>> getAll() {
        List<JournalEntry> journalEntry = journalEntryService.getAll();
        if(journalEntry != null && !journalEntry.isEmpty()) {
            return new ResponseEntity<>(journalEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping  // localhost:8080/journal POST
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry) { //It's like saying "Hey spring, please take the data from the request and turn it into a java object that i can use in my code".
        try{
            myEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(myEntry);
            return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    // now we want to get a specific id by passing it a path variable in url
    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId) {
        //ResponseEntity is expecting a return of type class(T)
//        return journalEntryService.findById(myId).orElse(null);
        Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
        if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // now we can add @DeleteMapping to delete an entry
    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId myId) {
        Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
        if(journalEntry.isPresent()){
            journalEntryService.deleteById(myId);
            return new ResponseEntity<>(journalEntry.get(),HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // now we want to update an existing so we will get the pathVariable and also the body as we are updating previously inputted values
    @PutMapping("id/{myId}")
    public ResponseEntity<JournalEntry> updateJournalById(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry) {
        // with response entity
        JournalEntry old = journalEntryService.findById(myId).orElse(null);
        if(old !=null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle(): old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent(): old.getContent());
            journalEntryService.saveEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
*/
