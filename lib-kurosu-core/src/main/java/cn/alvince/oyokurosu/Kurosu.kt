package cn.alvince.oyokurosu

import android.app.Application
import cn.alvince.oyokurosu.internal.KurosuInstrument

/**
 * Created by alvince on 2022/2/14
 *
 * @author alvince.zy@gmail.com
 */
object Kurosu {

    internal var instrument: KurosuInstrument? = null

    fun init(application: Application) {
        instrument = KurosuInstrument().also {
            it.installApp(application)
        }
    }

    internal fun instrument(): KurosuInstrument {
        check(instrument != null) { "Must init after Application create" }
        return instrument!!
    }
}
