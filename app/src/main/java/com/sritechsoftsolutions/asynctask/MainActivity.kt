package com.sritechsoftsolutions.asynctask

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btngetimage.setOnClickListener {
            var task=MyTask(imgView)
            task.execute()

            
        }


    }//oncreate

    class MyTask(var imgView:ImageView): AsyncTask<Unit, Unit, Unit>()
    {
        var bmp:Bitmap?=null
        override fun doInBackground(vararg params: Unit?) {

            var u=URL("https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?cs=srgb&dl=bench-carved-stones-cemetery-257360.jpg&fm=jpg")
            var ism =u.openStream()
             bmp=BitmapFactory.decodeStream(ism)


        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            imgView.setImageBitmap(bmp)
        }

    }


}
