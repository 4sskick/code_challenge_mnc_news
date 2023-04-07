package id.niteroomcreation.mncnews.data.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.niteroomcreation.mncnews.data.common.Dispatcher
import id.niteroomcreation.mncnews.data.common.NewsDispatcher
import javax.inject.Singleton

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDispatcher(): Dispatcher {
        return NewsDispatcher()
    }
}