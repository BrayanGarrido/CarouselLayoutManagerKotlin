package com.bornidea.carrousel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bornidea.carrousel.databinding.ActivityMainBinding
import com.mig35.carousellayoutmanager.CarouselLayoutManager
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.mig35.carousellayoutmanager.CenterScrollListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val peliculas = ArrayList<Peliculas>()
        peliculas.add(Peliculas("Toy Story 4",R.drawable.pelicula1))
        peliculas.add(Peliculas("Avengers End Game",R.drawable.pelicula2))
        peliculas.add(Peliculas("Rey León",R.drawable.pelicula3))
        peliculas.add(Peliculas("Bob Esponja",R.drawable.pelicula4))

        binding.apply{
            RecyclerPeliculasVertical.setHasFixedSize(true)
            val carouselLayoutVertical = CarouselLayoutManager(CarouselLayoutManager.VERTICAL)
            carouselLayoutVertical.setPostLayoutListener(CarouselZoomPostLayoutListener())
            carouselLayoutVertical.setCircleLayout(true)
            RecyclerPeliculasVertical.layoutManager = carouselLayoutVertical
            RecyclerPeliculasVertical.addOnScrollListener(CenterScrollListener())
            RecyclerPeliculasVertical.adapter = AdaptadorPeliculas(peliculas, object: ClickListener{
                override fun onClick(vista: View, index: Int) {
                    Toast.makeText(this@MainActivity,
                        "Pelicula ${peliculas[index].nombre}",
                        Toast.LENGTH_SHORT).show()
                }
            })

            RecyclerPeliculasHorizontal.setHasFixedSize(true)
            val carouselLayoutHorizontal = CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL)
            carouselLayoutHorizontal.setPostLayoutListener(CarouselZoomPostLayoutListener())
            carouselLayoutHorizontal.setCircleLayout(true)
            RecyclerPeliculasHorizontal.layoutManager = carouselLayoutHorizontal
            RecyclerPeliculasHorizontal.addOnScrollListener(CenterScrollListener())
            RecyclerPeliculasHorizontal.adapter = AdaptadorPeliculas(peliculas, object: ClickListener{
                override fun onClick(vista: View, index: Int) {
                    Toast.makeText(this@MainActivity,
                        "Pelicula ${peliculas[index].nombre}",
                        Toast.LENGTH_SHORT).show()
                }
            })
        }

    }
}