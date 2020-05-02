package app.planer.service;

import app.planer.model.Note;
import app.planer.repository.NoteRepository;
import app.planer.repository.entity.NoteEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static app.planer.util.Util.transform;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    private final Mapper mapper;

    public List<Note> getNotes(LocalDate dateFrom, LocalDate dateTo){
        List<NoteEntity> noteEntities = noteRepository.getByCreatedDateBetween(dateFrom, dateTo);
        return transform(mapper::map, noteEntities);
    }

    public void addNote(Note note){
        note.setCreatedDate(LocalDate.now());
        NoteEntity noteEntity = mapper.map(note);
        noteRepository.save(noteEntity);
    }

    public void deleteNote(int id){
        noteRepository.deleteById(id);
    }
}
