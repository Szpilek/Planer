package app.planer.controller;

import app.planer.model.Note;
import app.planer.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public List<Note> getNotes(
            @RequestParam("dateFrom")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate dateFrom,
            @RequestParam("dateTo")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate dateTo
    ){
        return noteService.getNotes(dateFrom, dateTo);
    }

    @PostMapping
    public ResponseEntity addNote(@RequestBody Note note){
        noteService.addNote(note);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNote(@PathVariable int id){
        noteService.deleteNote(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
