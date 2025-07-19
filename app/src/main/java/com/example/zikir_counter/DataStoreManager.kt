package com.example.zikir_counter

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Membuat instance DataStore
val Context.dataStore by preferencesDataStore(name = "zikircounter")

class DataStoreManager(private val context: Context) {
    companion object {
        val COUNT_KEY = intPreferencesKey("count")
    }

    // Menyimpan count
    suspend fun saveCount(count: Int) {
        context.dataStore.edit { preferences ->
            preferences[COUNT_KEY] = count
        }
    }

    // Mengambil count
    val getCount: Flow<Int> = context.dataStore.data
        .map { preferences -> preferences[COUNT_KEY] ?: 0 }
}