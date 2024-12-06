package com.viniciuscoscia.memenexus.core.presentation


import com.plcoding.bookpedia.core.domain.DataError

fun DataError.toUiText(): UiText {
    val stringRes = when (this) {
        DataError.Local.DISK_FULL -> TODO()
        DataError.Local.UNKNOWN -> TODO()
        DataError.Remote.REQUEST_TIMEOUT -> TODO()
        DataError.Remote.TOO_MANY_REQUESTS -> TODO()
        DataError.Remote.NO_INTERNET -> TODO()
        DataError.Remote.SERVER -> TODO()
        DataError.Remote.SERIALIZATION -> TODO()
        DataError.Remote.UNKNOWN -> TODO()
    }

    return UiText.StringResourceId(stringRes)
}