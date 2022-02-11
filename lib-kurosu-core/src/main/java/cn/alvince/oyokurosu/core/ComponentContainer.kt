package cn.alvince.oyokurosu.core

/**
 * Created by alvince on 2022/1/17
 *
 * @author alvince.zy@gmail.com
 */
interface ComponentContainer {

    fun onFindComponentByTag(tag: String): IComponent?

    fun onHasComponent(): Boolean
}