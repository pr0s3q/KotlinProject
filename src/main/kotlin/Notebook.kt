import java.time.LocalDate

class Notebook
{

    //region Variables

    private var notesList= mutableListOf<Note>()

    //endregion

    //region Methods

    fun addNote(note: Note)
    {
        notesList.add(note)
    }

    fun removeNote(note: Note)
    {
        notesList.remove(note)
    }

    fun searchNotes(text: String) : List<Note>
    {
        val list = mutableListOf<Note>()
        for(note in notesList)
        {
            if(note.search(text))
                list.add(note)
        }
        return list
    }

    fun getNotesByAuthor(author: String) : List<Note>
    {
        val list = mutableListOf<Note>()
        for(note in notesList)
        {
            if(note.author == author)
                list.add(note)
        }
        return list
    }

    fun removeNotesByAuthor(author: String)
    {
        val list = mutableListOf<Note>()
        for(note in notesList)
        {
            if(note.author == author)
                list.add(note)
        }
        notesList.removeAll(list)
    }

    fun getNotesByDate(begin: LocalDate, end: LocalDate) : List<Note>
    {
        val list = mutableListOf<Note>()
        for(note in notesList)
        {
            if(note.date in begin..end)
                list.add(note)
        }
        return list
    }

    fun sortNotes() : List<Note>
    {
        val list = notesList
        list.sortBy { it.date}
        return list
    }

    fun printNotes()
    {
        for(note in notesList)
            note.printNote()
    }

    //endregion

}