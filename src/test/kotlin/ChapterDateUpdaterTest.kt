import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

class ChapterDateUpdaterTest {

    private val chapterDateUpdater = ChapterDateUpdater()

    @Test
    fun `test update chapter date`() {
        val chapter = Chapter(title = "Chapter 1", number = 1, publicationDate = LocalDate.of(2023, 1, 1))
        val newDate = LocalDate.of(2023, 2, 1)

        chapterDateUpdater.updateChapterDate(chapter, newDate)

        assertEquals(newDate, chapter.publicationDate)
    }

    @Test
    fun `test update multiple chapter dates`() {
        val chapters = listOf(
            Chapter(title = "Chapter 1", number = 1, publicationDate = LocalDate.of(2023, 1, 1)),
            Chapter(title = "Chapter 2", number = 2, publicationDate = LocalDate.of(2023, 1, 15))
        )
        val newDates = listOf(
            LocalDate.of(2023, 2, 1),
            LocalDate.of(2023, 2, 15)
        )

        chapterDateUpdater.updateMultipleChapterDates(chapters, newDates)

        assertEquals(newDates[0], chapters[0].publicationDate)
        assertEquals(newDates[1], chapters[1].publicationDate)
    }
}