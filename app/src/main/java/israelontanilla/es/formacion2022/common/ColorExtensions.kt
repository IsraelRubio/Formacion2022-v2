package israelontanilla.es.formacion2022.common

import android.content.Context

fun Int.getColor(context: Context): Int {
    return context.getColor(this)
}