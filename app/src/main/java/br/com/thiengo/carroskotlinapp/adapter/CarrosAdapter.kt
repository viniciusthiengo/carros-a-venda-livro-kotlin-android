package br.com.thiengo.carroskotlinapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.thiengo.carroskotlinapp.R
import br.com.thiengo.carroskotlinapp.bold
import br.com.thiengo.carroskotlinapp.domain.Carro
import br.com.thiengo.carroskotlinapp.getPrecoHuman


class CarrosAdapter(
        private val context: Context,
        private val carros: List<Carro>) :
        RecyclerView.Adapter<CarrosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int) : CarrosAdapter.ViewHolder {

        val v = LayoutInflater
                .from(context)
                .inflate(R.layout.item_carro, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(carros[position])
    }

    override fun getItemCount(): Int {
        return carros.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImagem: ImageView
        val ivLogo: ImageView
        val tvModelo: TextView
        val tvMarca: TextView
        val tvMotor: TextView
        val tvAcessorios: TextView
        val tvPreco: TextView

        init {
            ivImagem = itemView.findViewById(R.id.iv_imagem)
            ivLogo = itemView.findViewById(R.id.iv_logo)
            tvModelo = itemView.findViewById(R.id.tv_modelo)
            tvMarca = itemView.findViewById(R.id.tv_marca)
            tvMotor = itemView.findViewById(R.id.tv_motor)
            tvAcessorios = itemView.findViewById(R.id.tv_acessorios)
            tvPreco = itemView.findViewById(R.id.tv_preco)
        }

        fun setData(carro: Carro) {
            ivImagem.setImageBitmap(carro.imagem)
            tvModelo.text = carro.modelo
            ivLogo.setImageResource(carro.marca.logo)
            tvMarca.text = String.format("%s - %d", carro.marca.nome, carro.ano)
            tvMotor.text = "Motor: ".bold().append( "${carro.motor.modelo} (${carro.motor.cilindros}) - ${carro.motor.marca}" )
            tvAcessorios.text = "Acessórios: ".bold().append( carro.getAcessoriosFormatted() )
            tvPreco.text = carro.preco.getPrecoHuman()
        }
    }
}

