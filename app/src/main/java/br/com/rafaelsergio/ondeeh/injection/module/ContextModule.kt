package br.com.rafaelsergio.ondeeh.injection.module

import android.app.Application
import android.content.Context
import br.com.rafaelsergio.ondeeh.base.BaseView
import dagger.Module
import dagger.Provides

@Module
object ContextModule {

    @Provides
    @JvmStatic
    internal fun provideContext(baseView: BaseView): Context {
        return baseView.getContext()
    }


    @Provides
    @JvmStatic
    internal fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }

}