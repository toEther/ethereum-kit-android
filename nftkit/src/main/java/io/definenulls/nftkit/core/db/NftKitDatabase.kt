package io.definenulls.nftkit.core.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.definenulls.ethereumkit.api.storage.RoomTypeConverters
import io.definenulls.nftkit.models.Eip1155Event
import io.definenulls.nftkit.models.Eip721Event
import io.definenulls.nftkit.models.NftBalanceRecord

@Database(entities = [Eip721Event::class, Eip1155Event::class, NftBalanceRecord::class], version = 1, exportSchema = false)
@TypeConverters(NftTypeConverters::class, RoomTypeConverters::class)
abstract class NftKitDatabase : RoomDatabase() {

    abstract fun nftBalanceDao(): NftBalanceDao
    abstract fun eip721EventDao(): Eip721EventDao
    abstract fun eip1155EventDao(): Eip1155EventDao

    companion object {
        fun getInstance(context: Context, databaseName: String): NftKitDatabase {
            return Room.databaseBuilder(context, NftKitDatabase::class.java, databaseName)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }
}