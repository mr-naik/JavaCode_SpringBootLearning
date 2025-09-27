/*  without mongodb



package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// controllers are special type of classes or components which handles HTTP requests

@RestController
@RequestMapping("/_journal")  // RequestMapping will add a mapping on the entire class
// so if we want to access an end point defined inside a class it will be localhost:8080/journal/...
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();  // as we don't have a table or db we can consider this as a table for now

    @GetMapping   // localhost:8080/journal  GET
    // METHODS INSIDE A CONTROLLER CLASS SHOULD BE PUBLIC SO THAT THEY CAN BE ACCESSED AND INVOKED AY THE SPRING FRAMEWORK OR EXTERNAL HTTP REQUESTS.
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping  // localhost:8080/journal POST
    public void createEntry(@RequestBody JournalEntry myEntry) { //It's like saying "Hey spring, please take the data from the request and turn it into a java object that i can use in my code".
        journalEntries.put(myEntry.getId(), myEntry);
    }

*/
/*
    this will not compile and give error because we have done @RequestMapping for the whole class and spring will not know which @GetMapping to use
    @GetMapping
    public List<JournalEntry> getAldeedl(){
        return new ArrayList<>(journalEntries.values());
    }
*//*


    // now we want to get a specific id by passing it a path variable in url
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId) {
        return journalEntries.get(myId);
    }

    // now we can add @DeleteMapping to delete an entry
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteEntryById(@PathVariable Long myId) {
        return journalEntries.remove(myId);
    }

    // now we want to update an existing so we will get the pathVariable and also the body as we are updating previously inputted values
    @PutMapping("id/{myId}")
    public JournalEntry updateJournalById(@PathVariable Long myId, @RequestBody JournalEntry myEntry) {
        return journalEntries.put(myId, myEntry);
    }


}
*/
