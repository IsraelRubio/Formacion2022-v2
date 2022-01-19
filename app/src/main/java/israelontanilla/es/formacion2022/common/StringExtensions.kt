package israelontanilla.es.formacion2022.common

import android.content.Context

fun Int.getString(context: Context, vararg arg: Any?): String =
    String.format(context.resources.getString(this), *arg)
