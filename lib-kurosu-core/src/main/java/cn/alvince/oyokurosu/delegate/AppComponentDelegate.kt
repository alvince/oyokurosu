package cn.alvince.oyokurosu.delegate

import android.app.Application
import cn.alvince.oyokurosu.core.IComponent
import cn.alvince.oyokurosu.impl.VirtualComponent

/**
 * Created by alvince on 2022/2/14
 *
 * @author alvince.zy@gmail.com
 */
class AppComponentDelegate(private val hostApp: Application) : VirtualComponent() {

    override fun addComponent(comp: IComponent, index: Int) {
        TODO("Not yet implemented")
    }
}
