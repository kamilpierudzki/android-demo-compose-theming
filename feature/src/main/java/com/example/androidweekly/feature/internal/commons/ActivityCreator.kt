package com.example.androidweekly.feature.internal.commons

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.annotation.CheckResult
import kotlin.reflect.KClass

private const val ACTIVITY_CREATOR_ARGUMENT = "argument"
private const val ACTIVITY_CREATOR_BUNDLE = "argument_bundle"

/**
 * On some devices ClassNotFoundException is thrown when Unmarshalling an object that uses implicit
 * Bundle created during Intent creation. Creating the bundle explicitly and marshalling/unmarshalling
 * the object fixes this issue. See reference below
 * https://stackoverflow.com/questions/28589509/android-e-parcel-class-not-found-when-unmarshalling-only-on-samsung-tab3
 */
open class ActivityCreator<T : Any>(
    internal val activityClass: KClass<out Activity>
) {

    val Activity.argument: T
        get() = argument(this)

    fun argument(activity: Activity): T {
        val bundle = activity.intent.getBundleExtra(ACTIVITY_CREATOR_BUNDLE)!!
        @Suppress("UNCHECKED_CAST")
        return bundle.get(ACTIVITY_CREATOR_ARGUMENT) as T
    }
}

@CheckResult
fun <T : Parcelable> ActivityCreator<T>.createIntent(context: Context, argument: T): Intent {
    val bundle = Bundle().apply {
        putParcelable(ACTIVITY_CREATOR_ARGUMENT, argument)
    }
    return Intent(context, activityClass.java).putExtra(ACTIVITY_CREATOR_BUNDLE, bundle)
}

@CheckResult
fun ActivityCreator<Unit>.createIntent(context: Context): Intent =
    Intent(context, activityClass.java)
