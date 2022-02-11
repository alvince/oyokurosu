package cn.alvince.oyokurosu.impl

import android.view.View
import androidx.lifecycle.Lifecycle
import cn.alvince.oyokurosu.AbsComponent
import cn.alvince.oyokurosu.ExplicitComponent
import cn.alvince.oyokurosu.core.IComponent

/**
 * Created by alvince on 2022/1/21
 *
 * @author alvince.zy@gmail.com
 */
open class ViewComponent : AbsComponent(), ExplicitComponent<View> {

    override fun getView(): View? {
        TODO("Not yet implemented")
    }

    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }

    override fun addComponent(comp: IComponent, index: Int) {
        TODO("Not yet implemented")
    }

    override fun getEntity(): View {
        TODO("Not yet implemented")
    }
}
