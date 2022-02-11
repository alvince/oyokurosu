package cn.alvince.oyokurosu.core

import android.app.Activity
import android.content.Context
import androidx.collection.ArrayMap
import androidx.fragment.app.Fragment
import cn.alvince.zanpakuto.lifecycle.doOnDestroy

/**
 * Created by alvince on 2022/1/17
 *
 * @author alvince.zy@gmail.com
 */
class ComponentController private constructor(private val host: ComponentHostCallback<*>) {

    fun getComponentManager(): ComponentManager = host.componentManager

    companion object {
        fun createController(callbacks: ComponentHostCallback<*>): ComponentController {
            return ComponentController(callbacks)
        }
    }
}

private val LOCK = Any()
private val activityComponents = ArrayMap<Activity, ComponentController>()
private val fragmentComponents = ArrayMap<Fragment, ComponentController>()

private fun cacheActivityController(activity: Activity, controller: ComponentController) {
    synchronized(LOCK) { activityComponents[activity] = controller }
}

private fun cacheActivityController(fragment: Fragment, controller: ComponentController) {
    synchronized(LOCK) { fragmentComponents[fragment] = controller }
}

private fun clearController(activity: Activity) {
    synchronized(LOCK) { activityComponents.remove(activity) }
}

private fun clearController(fragment: Fragment) {
    synchronized(LOCK) { fragmentComponents.remove(fragment) }
}

internal fun Activity.getOrCreateController(): ComponentController {
    return activityComponents.getOrPut(this) {
        val components = ComponentController.createController(ActivityHostCallbacks(this, this))
        cacheActivityController(this, components)
        this.doOnDestroy {
            clearController(this)
        }
        components
    }
}

internal fun Fragment.getOrCreateController(): ComponentController {
    check(isAdded) { "Must call after fragment added." }
    return fragmentComponents.getOrPut(this) {
        val components = ComponentController.createController(FragmentHostCallbacks(requireContext(), this))
        cacheActivityController(this, components)
        this.doOnDestroy {
            clearController(it)
        }
        components
    }
}

private inline fun Fragment.doOnDestroy(crossinline action: (Fragment) -> Unit) {
    this.lifecycle.doOnDestroy { action(this) }
}

private class ActivityHostCallbacks(context: Context, activity: Activity) : ComponentHostCallback<Activity>(context) {

    private var hostActivity: Activity? = activity

    override fun onGetHost(): Activity? = hostActivity

    override fun getActivity(): Activity? = hostActivity
}

private class FragmentHostCallbacks(context: Context, fragment: Fragment) : ComponentHostCallback<Fragment>(context) {

    private var hostFragment: Fragment? = fragment

    override fun onGetHost(): Fragment? = hostFragment

    override fun getActivity(): Activity? = hostFragment?.activity
}
