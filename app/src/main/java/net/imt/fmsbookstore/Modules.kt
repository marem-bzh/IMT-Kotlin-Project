package net.imt.fmsbookstore

import androidx.room.Room
import net.imt.fmsbookstore.data.Database
import net.imt.fmsbookstore.data.book.BookRepository
import net.imt.fmsbookstore.data.book.BookService
import net.imt.fmsbookstore.data.cart.CartRepository
import net.imt.fmsbookstore.data.cart.CartService
import net.imt.fmsbookstore.ui.book.BookDetailsViewModel
import net.imt.fmsbookstore.ui.book.BookListViewModel
import net.imt.fmsbookstore.ui.cart.CartViewModel
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
    single {
        (get() as Retrofit).create(CartService::class.java)
    }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(androidApplication(), Database::class.java, "books")
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        (get() as Database).bookDao()
    }

    single {
        (get() as Database).cartDao()
    }
}

val repositoryModule = module {
    single {
        BookRepository(get(), get())
    }
    single {
        CartRepository(get(), get())
    }
}

val viewModelModule = module {
    viewModel {
        BookListViewModel(get(), get())
    }

    viewModel {
        BookDetailsViewModel(get(), get()) // this right here allows to use the saved state in the view model (ex: to get the isbn sent to BookDetailsFragment)
    }

    viewModel {
        CartViewModel(get(), get())
    }
}
