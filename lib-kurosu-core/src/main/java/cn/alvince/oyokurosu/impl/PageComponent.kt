package cn.alvince.oyokurosu.impl

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import cn.alvince.oyokurosu.AbsComponent
import cn.alvince.oyokurosu.core.IComponent

/**
 * Created by alvince on 2022/1/17
 *
 * @author alvince.zy@gmail.com
 */
open class PageComponent : AbsComponent() {

    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }

    override fun addComponent(comp: IComponent, index: Int) {
        TODO("Not yet implemented")
    }

    final override fun getView(): View? = null
}
