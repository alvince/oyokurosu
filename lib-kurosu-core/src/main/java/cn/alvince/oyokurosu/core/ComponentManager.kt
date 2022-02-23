package cn.alvince.oyokurosu.core

import android.app.Activity
import androidx.annotation.RestrictTo
import androidx.fragment.app.Fragment

/**
 * Created by alvince on 2022/1/17
 *
 * @author alvince.zy@gmail.com
 */
abstract class ComponentManager {

    abstract fun registerComponentLifecycleCallbacks(callback: ComponentLifecycleCallbacks)

    abstract fun unregisterComponentLifecycleCallbacks(callback: ComponentLifecycleCallbacks)

    abstract fun findComponentByTag(tag: String): IComponent

    interface ComponentLifecycleCallbacks {
        fun onComponentAttached()
    }
}

@get:RestrictTo(RestrictTo.Scope.LIBRARY)
internal val Activity.components: ComponentController
    get() = getOrCreateController()

@get:RestrictTo(RestrictTo.Scope.LIBRARY)
internal val Fragment.components: ComponentController
    get() = getOrCreateController()
