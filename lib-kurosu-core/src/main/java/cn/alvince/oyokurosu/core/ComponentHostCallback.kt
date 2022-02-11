package cn.alvince.oyokurosu.core

import android.app.Activity
import android.content.Context

/**
 * Created by alvince on 2022/1/17
 *
 * @author alvince.zy@gmail.com
 */
abstract class ComponentHostCallback<E>(val context: Context) {

    internal val componentManager: ComponentManager = ComponentManagerImpl()

    abstract fun onGetHost(): E?

    abstract fun getActivity(): Activity?
}
