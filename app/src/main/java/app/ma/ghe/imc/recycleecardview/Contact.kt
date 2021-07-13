package app.ma.ghe.imc.recycleecardview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    var nome : String,
    var fone : String,
    var foto : String
) : Parcelable


