package domain.manga

import java.time.LocalDate

data class Chapter(
    val title: String,
    val number: Int,
    val publicationDate: LocalDate
) {
    fun isUpdated(newDate: LocalDate): Boolean {
        return publicationDate.isBefore(newDate)
    }
}