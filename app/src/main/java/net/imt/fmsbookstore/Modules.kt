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
    single {
        Retrofit.Builder()
            .baseUrl(androidContext().getString(R.string.BASE_URL))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

val serviceModule = module {
    single {
        (get() as Retrofit).create(BookService::class.java)
    }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(androidApplication(), BookDatabase::class.java, "books")
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        (get() as BookDatabase).bookDao()
    }
}

val repositoryModule = module {
    single {
        BookRepository(get(), get())
    }
}

val viewModelModule = module {
    viewModel {
        BookListViewModel(get())
    }

    viewModel {
        BookDetailsViewModel(get(), get()) // this right here allows to use the saved state in the view model (ex: to get the isbn sent to BookDetailsFragment)
    }
}
