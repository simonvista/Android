package com.philipplackner.episode24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imgs= listOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4
        )
        val adapter=ViewPagerAdapter(imgs)
        viewPager.adapter=adapter
        viewPager.orientation= ViewPager2.ORIENTATION_VERTICAL
        viewPager.beginFakeDrag()
        viewPager.fakeDragBy(-10f)
        viewPager.endFakeDrag()
    }
}
