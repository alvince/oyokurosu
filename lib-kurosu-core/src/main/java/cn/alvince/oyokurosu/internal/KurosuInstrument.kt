package cn.alvince.oyokurosu.internal

import android.app.Application
import cn.alvince.oyokurosu.delegate.AppComponentDelegate

/**
 * Created by alvince on 2022/2/14
 *
 * @author alvince.zy@gmail.com
 */
internal class KurosuInstrument {

    val rootComponent: AppComponentDelegate get() = appComponent ?: error("Missing root app-component.")

    private var appComponent: AppComponentDelegate? = null

    fun installApp(application: Application) {
        appComponent = AppComponentDelegate(application)
    }
}
