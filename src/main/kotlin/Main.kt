import java.time.LocalDate
import java.time.format.DateTimeParseException

fun main() {
    var terminate = false
    var notebook = Notebook()
    while(!terminate)
    {
        println("-------------------------------------------------------")
        println("0 - Wyłącz program")
        println("1 - Dodaj notatkę")
        println("2 - Usuń notatkę")
        println("3 - Szukaj notatki")
        println("4 - Wypisz notatki autora")
        println("5 - Usuń notatki autora")
        println("6 - Wypisz notatki z zakresu dat")
        println("7 - Wypisz notatki od najstarszej do najmłodszej")
        println("8 - Wypisz notatki")
        println("-------------------------------------------------------")
        when(readln())
        {
            "0" -> terminate = true
            "1" -> notebook = addNote(notebook)
            "2" -> notebook = removeNote(notebook)
            "3" -> searchNotes(notebook)
            "4" -> printByAuthor(notebook)
            "5" -> removeAuthorNotes(notebook)
            "6" -> printByDate(notebook)
            "7" -> printByDateAsc(notebook)
            "8" -> printNotes(notebook)
            else -> println("Wprowadzono złą opcję")
        }
    }
}

fun addNote(notebook: Notebook) : Notebook
{
    println("Podaj autora notatki:")
    val author = readln()
    println("Podaj tekst notatki:")
    val text = readln()
    val note = Note(author, text)
    println("Podaj datę notatki: (format yyyy-MM-dd)")
    while(true)
    {
        try {
            val date = LocalDate.parse(readln())
            note.date = date
            break
        }
        catch (e: DateTimeParseException){
            println("Zły format daty!")
        }
    }
    notebook.addNote(note)
    return notebook
}

fun removeNote(notebook: Notebook) : Notebook
{
    println("Podaj autora notatki:")
    val author = readln()
    println("Podaj tekst notatki:")
    val text = readln()
    val note = Note(author, text)
    println("Podaj datę notatki: (format yyyy-MM-dd)")
    while(true)
    {
        try {
            val date = LocalDate.parse(readln())
            note.date = date
            break
        }
        catch (e: DateTimeParseException){
            println("Zły format daty!")
        }
    }
    notebook.removeNote(note)
    return notebook
}

fun searchNotes(notebook: Notebook)
{
    println("Podaj tekst, którego szukać w notatkach:")
    val text = readln()
    val notes = notebook.searchNotes(text)
    for(note in notes)
        note.printNote()
}

fun printByAuthor(notebook: Notebook)
{
    println("Podaj autora:")
    val author = readln()
    val notes = notebook.getNotesByAuthor(author)
    for(note in notes)
        note.printNote()
}

fun removeAuthorNotes(notebook: Notebook)
{
    println("Podaj autora:")
    val author = readln()
    notebook.removeNotesByAuthor(author)
}

fun printByDate(notebook: Notebook)
{
    while(true)
        try {
            println("Podaj datę początkową (format yyyy-MM-dd)")
            val begin = LocalDate.parse(readln())
            println("Podaj datę końcową (format yyyy-MM-dd)")
            val end = LocalDate.parse(readln())
            val notes = notebook.getNotesByDate(begin, end)
            for(note in notes)
                note.printNote()
            break
        }
        catch (e: DateTimeParseException){
            println("Zły format daty!")
        }
}

fun printByDateAsc(notebook: Notebook)
{
    val notes = notebook.sortNotes()
    for(note in notes)
        note.printNote()
}

fun printNotes(notebook: Notebook)
{
    notebook.printNotes()
}