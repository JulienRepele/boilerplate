package com.repele.boilerplate.di

import com.repele.boilerplate.data.repository.RandomUserApiImpl
import com.repele.boilerplate.data.source.remote.RandomUserApi
import com.repele.boilerplate.domain.repository.UserRepository
import com.repele.boilerplate.domain.usecase.GetUserListUseCase
import com.repele.boilerplate.domain.usecase.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityRetainedComponent::class)
object AppModule {

    @ActivityRetainedScoped
    @Provides
    fun provideRandomUserApi(): RandomUserApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(RandomUserApi.BASE_URL)
        .build()
        .create(RandomUserApi::class.java)

    @ActivityRetainedScoped
    @Provides
    fun provideItemRepository(api: RandomUserApi): UserRepository = RandomUserApiImpl(api)

    @ActivityRetainedScoped
    @Provides
    fun provideGetItemUseCase(repo: UserRepository): GetUserUseCase = GetUserUseCase(repo)

    @ActivityRetainedScoped
    @Provides
    fun provideGetItemListUseCase(repo: UserRepository): GetUserListUseCase = GetUserListUseCase(repo)
}
