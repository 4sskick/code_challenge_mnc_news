package id.niteroomcreation.mncnews.data.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.niteroomcreation.mncnews.data.repository.NewsRepositoryImpl
import id.niteroomcreation.mncnews.domain.repository.NewsRepository

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsNewsRepository(
        repositoryImpl: NewsRepositoryImpl
    ): NewsRepository
}