package br.com.thiengo.carroskotlinapp.domain

import android.os.Parcel
import android.os.Parcelable

class Marca(
        val nome: String,
        val logo: Int) : Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Marca> = object : Parcelable.Creator<Marca> {
            override fun createFromParcel(source: Parcel): Marca = Marca(source)
            override fun newArray(size: Int): Array<Marca?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
    source.readString(),
    source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(nome)
        dest.writeInt(logo)
    }
}