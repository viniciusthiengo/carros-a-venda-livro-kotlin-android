package br.com.thiengo.carroskotlinapp.domain

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import br.com.thiengo.carroskotlinapp.getPrecoHumam


class Carro(
        val modelo: String,
        val ano: Int,
        val marca: Marca,
        val motor: Motor,
        val preco: Float,
        val acessorios: List<Acessorio>,
        val imagem: Bitmap ) : Parcelable {

    fun getAcessoriosFormatted(): String {
        val aux = StringBuilder()

        for (acessorio in acessorios)
            aux.append("${acessorio.nome} (${acessorio.preco.getPrecoHumam()}), ")

        return aux.trimEnd().trimEnd(',').toString()
    }

    companion object {
        val CARROS = "carros"

        @JvmField val CREATOR: Parcelable.Creator<Carro> = object : Parcelable.Creator<Carro> {
            override fun createFromParcel(source: Parcel): Carro = Carro(source)
            override fun newArray(size: Int): Array<Carro?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
        source.readString(),
        source.readInt(),
        source.readParcelable<Marca>(Marca::class.java.classLoader),
        source.readParcelable<Motor>(Motor::class.java.classLoader),
        source.readFloat(),
        source.createTypedArrayList(Acessorio.CREATOR),
        source.readParcelable<Bitmap>(Bitmap::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(modelo)
        dest.writeInt(ano)
        dest.writeParcelable(marca, 0)
        dest.writeParcelable(motor, 0)
        dest.writeFloat(preco)
        dest.writeTypedList(acessorios)
        dest.writeParcelable(imagem, 0)
    }
}