package com.pf.login_senha

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pessoa(
    val nome: String,
    val login: String,
    val senha: String,
    val idade: Int
) : Parcelable