package cn.alvince.oyokurosu

import cn.alvince.oyokurosu.core.IComponent

/**
 * Created by alvince on 2022/1/21
 *
 * @author alvince.zy@gmail.com
 */
interface ExplicitComponent<E> : IComponent {

    fun getEntity(): E
}
