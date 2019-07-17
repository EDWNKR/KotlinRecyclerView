package id.maemaem.aplikasifootballclub

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var name: String? = ""
    private var image: String? = ""
    private var desc: String? = ""
    private var imageInt: Int? = 0

    lateinit var imageClub: ImageView
    lateinit var nameTextView: TextView
    lateinit var descriptionClub: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //detailActivityUI().setContentView(this)
        //setContentView(R.layout.activity_detail)


        verticalLayout {
            padding = dip(16)

            imageClub = imageView {horizontalGravity = Gravity.CENTER}.lparams(width = dip(220), height = dip(220)) {  }

            nameTextView = textView{
                textSize = 22f
                textColor = Color.BLACK
                typeface = Typeface.DEFAULT_BOLD
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }.lparams(width = matchParent, height = wrapContent) {}

            descriptionClub = textView{
                textSize = 15f
                textColor = Color.BLACK
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }.lparams(width = matchParent, height = wrapContent) {  }
        }

        val intent = intent
        image = intent.getStringExtra("gambar")
        imageInt = intent.getStringExtra("gambar").toInt()
        name = intent.getStringExtra("nama")
        desc = intent.getStringExtra("deskripsi")

        Glide.with(this).load(imageInt).into(imageClub)
        nameTextView.text = name
        descriptionClub.text = desc
    }


}
