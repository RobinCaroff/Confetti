@file:OptIn(ExperimentalHorologistApi::class)

package dev.johnoreilly.confetti.wear.complication

import android.content.Context
import androidx.wear.watchface.complications.data.ComplicationType
import androidx.wear.watchface.complications.data.LongTextComplicationData
import androidx.wear.watchface.complications.data.ShortTextComplicationData
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.tiles.complication.DataTemplates.longText
import com.google.android.horologist.tiles.complication.DataTemplates.shortText
import com.google.android.horologist.tiles.complication.TypedComplicationTemplate
import dev.johnoreilly.confetti.R
import dev.johnoreilly.confetti.fragment.SessionDetails
import dev.johnoreilly.confetti.type.Session
import dev.johnoreilly.confetti.wear.preview.TestFixtures
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toKotlinInstant

@OptIn(ExperimentalHorologistApi::class)
class NextSessionTemplate(context: Context) :
    TypedComplicationTemplate<NextSessionComplicationData>(context) {
    override fun previewData(): NextSessionComplicationData {
        return NextSessionComplicationData(
            TestFixtures.sessionDetails,
            launchIntent = null
        )
    }

    override fun supportedTypes(): List<ComplicationType> =
        listOf(
            ComplicationType.SHORT_TEXT,
            ComplicationType.LONG_TEXT,
        )

    override fun renderShortText(data: NextSessionComplicationData): ShortTextComplicationData =
        shortText(
            title = data.sessionDetails?.title ?: "None",
            text = data.sessionDetails?.room?.name.orEmpty(),
            icon = R.drawable.ic_person_black_24dp,
            launchIntent = data.launchIntent
        )

    override fun renderLongText(data: NextSessionComplicationData): LongTextComplicationData? {
        return longText(
            title = data.sessionDetails?.title ?: "None",
            text = data.sessionDetails?.room?.name.orEmpty(),
            launchIntent = data.launchIntent,
            icon = null
        )
    }
}