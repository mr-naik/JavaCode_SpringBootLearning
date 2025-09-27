/*  without response entity

package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;


// controllers are special type of classes or components which handles HTTP requests

@RestController
@RequestMapping("/journal")  // RequestMapping will add a mapping on the entire class
// so if we want to access an end point defined inside a class it will be localhost:8080/journal/...
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping   // localhost:8080/journal  GET
    // METHODS INSIDE A CONTROLLER CLASS SHOULD BE PUBLIC SO THAT THEY CAN BE ACCESSED AND INVOKED AY THE SPRING FRAMEWORK OR EXTERNAL HTTP REQUESTS.
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }

    @PostMapping  // localhost:8080/journal POST
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry) { //It's like saying "Hey spring, please take the data from the request and turn it into a java object that i can use in my code".
        myEntry.setDate(LocalDateTime.now());  // now the date will be set automatically
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }


    // now we want to get a specific id by passing it a path variable in url
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId) {
        return journalEntryService.findById(myId).orElse(null);
    }

    // now we can add @DeleteMapping to delete an entry
    @DeleteMapping("id/{myId}")
    public boolean deleteEntryById(@PathVariable ObjectId myId) {
        journalEntryService.deleteById(myId);
        return true;
    }

    // now we want to update an existing so we will get the pathVariable and also the body as we are updating previously inputted values
    @PutMapping("id/{myId}")
    public JournalEntry updateJournalById(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.findById(myId).orElse(null);
        if(old !=null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle(): old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent(): old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }
}*/
