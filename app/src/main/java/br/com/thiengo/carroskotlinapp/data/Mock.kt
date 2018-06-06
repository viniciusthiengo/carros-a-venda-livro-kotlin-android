package br.com.thiengo.carroskotlinapp.data

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import br.com.thiengo.carroskotlinapp.R
import br.com.thiengo.carroskotlinapp.domain.Acessorio
import br.com.thiengo.carroskotlinapp.domain.Carro
import br.com.thiengo.carroskotlinapp.domain.Marca
import br.com.thiengo.carroskotlinapp.domain.Motor
import java.util.*


class Mock {
    private fun gerarMotor() : Motor {
        val modelos = arrayOf("V-Tec", "Rocan", "Zar-T")
        val cilindros = arrayOf(4, 4, 8)
        val marcas = arrayOf("Volkswagen", "Ford", "GM")
        val randIndex = Random().nextInt(3)

        return Motor( modelos[randIndex], cilindros[randIndex], marcas[randIndex])
    }

    private fun gerarAcessorio() : Acessorio {
        val nomes = arrayOf("Teto solar", "Multimídia", "Aro 21 (Sport)", "Bancos de couro")
        val precos = arrayOf(2500f, 5600f, 8000f, 980f)
        val randIndex = Random().nextInt(4)

        return Acessorio( nomes[randIndex], precos[randIndex] )
    }

    private fun gerarListaAcessorios() : List<Acessorio> {
        val acessorios = LinkedList<Acessorio>()
        val randIndex = Random().nextInt(3) + 1

        while( acessorios.size < randIndex ){
            val aux = gerarAcessorio()

            if( aux !in acessorios ){
                acessorios.add( aux )
            }
        }

        return acessorios
    }

    private fun gerarBitmap( resources: Resources, imagemRes: Int ) : Bitmap {
        return BitmapFactory.decodeResource( resources, imagemRes )
    }

    fun gerarCarro( resources: Resources ) : List<Carro> {

        val carros = listOf(
            Carro(
                "Impala",
                2014,
                Marca("Chevrolet", R.drawable.chevrolet_logo),
                gerarMotor(),
                89_997f,
                gerarListaAcessorios(),
                gerarBitmap(resources, R.drawable.chevrolet_impala) ),
            Carro(
                "Evoque",
                2017,
                Marca("Land Rover", R.drawable.land_rover_logo),
                gerarMotor(),
                228_500f,
                gerarListaAcessorios(),
                gerarBitmap(resources, R.drawable.land_rover_evoque) ),
            Carro(
                "Toureg",
                2017,
                Marca("Volkswagen", R.drawable.volkswagen_logo),
                gerarMotor(),
                327_793f,
                gerarListaAcessorios(),
                gerarBitmap(resources, R.drawable.volkswagen_toureg) ),
            Carro(
                "Fusion",
                2017,
                Marca("Ford", R.drawable.ford_logo),
                gerarMotor(),
                98_650f,
                gerarListaAcessorios(),
                gerarBitmap(resources, R.drawable.ford_fusion) ),
            Carro(
                "Taurus",
                2015,
                Marca("Ford", R.drawable.ford_logo),
                gerarMotor(),
                113_985f,
                gerarListaAcessorios(),
                gerarBitmap(resources, R.drawable.ford_taurus) )
        )

        return carros
    }
}