package net.imt.fmsbookstore

import android.app.Application
import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.room.Room
import net.imt.fmsbookstore.data.book.BookDao
import net.imt.fmsbookstore.data.book.BookDatabase
import net.imt.fmsbookstore.data.book.BookRepository
import net.imt.fmsbookstore.data.book.BookService
import net.imt.fmsbookstore.ui.book.BookDetailsViewModel
import net.imt.fmsbookstore.ui.book.BookListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    fun provideRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        provideRetrofit( androidContext().getString(R.string.BASE_URL) )
    }
}

val serviceModule = module {

    fun provideBookService(retrofit: Retrofit): BookService {
        return retrofit.create(BookService::class.java)
    }
    single { provideBookService(get()) }
}

val databaseModule = module {

    fun provideDatabase(application: Application): BookDatabase {
        return Room.databaseBuilder(application, BookDatabase::class.java, "countries")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideBookDao(database: BookDatabase): BookDao {
        return  database.bookDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideBookDao(get()) }
}

val repositoryModule = module {

    fun provideBookRepository(service: BookService, dao : BookDao): BookRepository {
        return BookRepository(service, dao)
    }
    single { provideBookRepository(get(), get()) }
}

val viewModelModule = module {

    viewModel {
        BookListViewModel(get())
    }

    viewModel {
        BookDetailsViewModel(get(), get()) // this right here allows to use the saved state in the view model (ex: to get the isbn sent to BookDetailsFragment)
    }
}
