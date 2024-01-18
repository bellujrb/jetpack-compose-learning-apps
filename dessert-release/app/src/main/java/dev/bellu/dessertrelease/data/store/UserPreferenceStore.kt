package dev.bellu.dessertrelease.data.store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

class UserPreferenceStore(private val context: Context){
    companion object{
        private val Context.datastore: DataStore<Preferences> by preferencesDataStore("isVertical")
        private val USER_PREFERENCE_KEY = stringPreferencesKey("user_preference")
    }

    val getPreference: kotlinx.coroutines.flow.Flow<String> = context.datastore.data.map { preferences ->
        preferences[USER_PREFERENCE_KEY] ?: ""
    }

    suspend fun savePreference(isVertical: String){
        context.datastore.edit {preference ->
            preference[USER_PREFERENCE_KEY] = isVertical
        }
    }
}