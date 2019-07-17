package id.maemaem.aplikasifootballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import id.maemaem.aplikasifootballclub.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*



class MainActivity : AppCompatActivity() {

    private var items_football: MutableList<ItemFootball> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        recycler_football.layoutManager = LinearLayoutManager(this)
        recycler_football.adapter = AdapterFootball(this, items_football){
            startActivity<DetailActivity>(
                    "nama" to it.name.toString(),
                    "gambar" to it.image.toString(),
                    "deskripsi" to it.desc.toString())

        }

        initData()

    }


    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val desc = resources.getStringArray(R.array.club_desc)
        val image = resources.obtainTypedArray(R.array.club_image)
        items_football.clear()
        for (i in name.indices) {
            items_football.add(ItemFootball(name[i], image.getResourceId(i, 0), desc[i] ))
        }
        image.recycle()
    }

}
