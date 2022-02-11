package cn.alvince.oyokurosu.core

import android.view.View
import androidx.lifecycle.LifecycleOwner

/**
 * Created by alvince on 2022/1/17
 *
 * @author alvince.zy@gmail.com
 */
interface IComponent : LifecycleOwner {

    fun getView(): View?

    fun addComponent(comp: IComponent, index: Int)
}
