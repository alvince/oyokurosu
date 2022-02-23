package cn.alvince.oyokurosu.impl

import android.view.View
import cn.alvince.oyokurosu.core.AbsComponent

/**
 * Created by alvince on 2022/2/14
 *
 * @author alvince.zy@gmail.com
 */
abstract class VirtualComponent : AbsComponent() {

    final override fun getView(): View? = null
}
