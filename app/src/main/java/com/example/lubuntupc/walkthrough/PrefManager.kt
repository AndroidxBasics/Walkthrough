package com.example.lubuntupc.walkthrough

import android.content.SharedPreferences
import android.content.Context


/**
 * Created by lubuntupc on 06.12.17.
 */
class PrefManager {
    var pref: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    var _context: Context? = null

    // shared pref mode
    val PRIVATE_MODE = 0

    private val PREF_NAME = "androidhive-welcome"
    private val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"

    constructor(context: Context) {
        this._context = context
        pref = _context?.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref?.edit()
    }

    fun setFirstTimeLaunch(isFirstTime: Boolean) {
        editor?.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime)
        editor?.commit()
    }

    fun isFirstTimeLaunch(): Boolean {
        return pref!!.getBoolean(IS_FIRST_TIME_LAUNCH, true)
    }
}