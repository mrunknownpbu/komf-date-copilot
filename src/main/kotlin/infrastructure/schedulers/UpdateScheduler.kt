import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

class UpdateScheduler(private val chapterDateUpdater: ChapterDateUpdater) {

    private val scope = CoroutineScope(Dispatchers.IO + Job())

    fun startSchedulingUpdates(interval: Long, timeUnit: TimeUnit) {
        scope.launch {
            while (true) {
                chapterDateUpdater.updateChapterDates()
                delay(timeUnit.toMillis(interval))
            }
        }
    }

    fun stopSchedulingUpdates() {
        scope.cancel()
    }
}