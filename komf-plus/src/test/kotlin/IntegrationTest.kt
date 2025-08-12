import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class IntegrationTest {

    private val chapterDateUpdater = mock(ChapterDateUpdater::class.java)
    private val repository = mock(Repository::class.java)

    @Test
    fun `test chapter date update integration`() {
        val manga = Manga("Sample Manga", "Author", listOf())
        val chapter = Chapter("Chapter 1", 1, "2023-01-01")

        `when`(repository.getManga("Sample Manga")).thenReturn(manga)
        `when`(repository.getChapter("Sample Manga", 1)).thenReturn(chapter)

        chapterDateUpdater.updateChapterDate(chapter, "2023-02-01")

        verify(repository).saveChapter(chapter)
        assertEquals("2023-02-01", chapter.publicationDate)
    }
}