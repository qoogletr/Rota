package com.rota.barcodequarreader.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.rota.barcodequarreader.utils.Constants.DEFAULT_PORT
import com.rota.barcodequarreader.utils.Constants.DEFAULT_SERVER

object PreferencesManager {
    private const val PREFS_NAME = "rota_barcode_reader_prefs"
    private const val KEY_SERVER_ADDRESS = "server_address"
    private const val KEY_SERVER_PORT = "server_port"
    private const val KEY_SERVER_ENDPOINT = "server_endpoint"
    private const val KEY_AUTO_SEND = "auto_send"
    private const val KEY_VIBRATE = "vibrate"
    private const val KEY_PLAY_SOUND = "play_sound"
    private const val KEY_DARK_MODE = "dark_mode"
    private const val KEY_SEND_FORMAT = "send_format"

    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    var serverAddress: String
        get() = prefs.getString(KEY_SERVER_ADDRESS, DEFAULT_SERVER) ?: DEFAULT_SERVER
        set(value) = prefs.edit { putString(KEY_SERVER_ADDRESS, value) }

    var serverPort: Int
        get() = prefs.getInt(KEY_SERVER_PORT, DEFAULT_PORT)
        set(value) = prefs.edit { putInt(KEY_SERVER_PORT, value) }

    var serverEndpoint: String
        get() = prefs.getString(KEY_SERVER_ENDPOINT, "") ?: ""
        set(value) = prefs.edit { putString(KEY_SERVER_ENDPOINT, value) }

    var autoSendEnabled: Boolean
        get() = prefs.getBoolean(KEY_AUTO_SEND, false)
        set(value) = prefs.edit { putBoolean(KEY_AUTO_SEND, value) }

    var vibrateEnabled: Boolean
        get() = prefs.getBoolean(KEY_VIBRATE, true)
        set(value) = prefs.edit { putBoolean(KEY_VIBRATE, value) }

    var playSoundEnabled: Boolean
        get() = prefs.getBoolean(KEY_PLAY_SOUND, true)
        set(value) = prefs.edit { putBoolean(KEY_PLAY_SOUND, value) }

    var darkModeEnabled: Boolean
        get() = prefs.getBoolean(KEY_DARK_MODE, false)
        set(value) = prefs.edit { putBoolean(KEY_DARK_MODE, value) }

    var sendFormat: SendFormat
        get() = SendFormat.valueOf(prefs.getString(KEY_SEND_FORMAT, SendFormat.JSON_SIMPLE.name) ?: SendFormat.JSON_SIMPLE.name)
        set(value) = prefs.edit { putString(KEY_SEND_FORMAT, value.name) }
}