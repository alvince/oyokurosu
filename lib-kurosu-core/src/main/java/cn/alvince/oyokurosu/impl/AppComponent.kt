package cn.alvince.oyokurosu.impl

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.lifecycle.Lifecycle
import cn.alvince.oyokurosu.AbsComponent
import cn.alvince.oyokurosu.ImplicitComponent
import cn.alvince.oyokurosu.core.IComponent

/**
 * Created by alvince on 2022/1/21
 *
 * @author alvince.zy@gmail.com
 */
abstract class AppComponent : AbsComponent(), ImplicitComponent {

    final override fun getView(): View? = null

    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }

    override fun getIntent(): Intent {
        TODO("Not yet implemented")
    }

    override fun addComponent(comp: IComponent, index: Int) {
        TODO("Not yet implemented")
    }
}
