package com.ubaya.uts_160419108.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.ubaya.uts_160419108.R

fun ImageView.loadImage(url:String){
    Picasso.get()
        .load(url)
        .resize(800, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object: Callback {
            override fun onSuccess() {

            }
            override fun onError(e: Exception?) {
            }
        })
}