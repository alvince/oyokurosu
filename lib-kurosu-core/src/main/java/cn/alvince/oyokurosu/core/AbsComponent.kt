package cn.alvince.oyokurosu.core

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import cn.alvince.oyokurosu.core.IComponent

/**
 * Created by alvince on 2022/1/21
 *
 * @author alvince.zy@gmail.com
 */
abstract class AbsComponent : IComponent {

    private lateinit var _lifecycle: LifecycleRegistry

    init {
        initLifecycle()
    }

    override fun getLifecycle(): Lifecycle = _lifecycle

    internal fun performCreate() {
        onCreate()
        _lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
    }

    internal fun performStart() {
        onStart()
        _lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START)
    }

    internal fun performResume() {
        onResume()
        _lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    internal fun performPause() {
        _lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        onPause()
    }

    internal fun performStop() {
        _lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
        onStop()
    }

    internal fun performDestroy() {
        _lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        onDestroy()
    }

    open fun onCreate() {}
    open fun onStart() {}
    open fun onResume() {}
    open fun onPause() {}
    open fun onStop() {}
    open fun onDestroy() {}

    private fun initLifecycle() {
        _lifecycle = LifecycleRegistry(this)
    }
}
