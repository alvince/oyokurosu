package cn.alvince.oyokurosu

import android.content.Intent
import cn.alvince.oyokurosu.core.IComponent

/**
 * Created by alvince on 2022/1/21
 *
 * @author alvince.zy@gmail.com
 */
interface ImplicitComponent : IComponent {

    fun getIntent(): Intent
}
