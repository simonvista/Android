package com.philipplackner.episode25

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
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
        TabLayoutMediator(tabLayout,viewPager){
//            position starts at 0
            tab,position->tab.text="Tab ${position+1}"
        }.attach()          // connect to view page
        tabLayout.addOnTabSelectedListener(
            object:TabLayout.OnTabSelectedListener{
                override fun onTabReselected(tab: TabLayout.Tab?) {
                    Toast.makeText(this@MainActivity,"You reselected ${tab?.text}",Toast.LENGTH_SHORT).show()
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    Toast.makeText(this@MainActivity,"You unselected ${tab?.text}",Toast.LENGTH_SHORT).show()
                }

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    Toast.makeText(this@MainActivity,"You selected ${tab?.text}",Toast.LENGTH_SHORT).show()
                }
            }
        )
//        Change swiping orientation
        /*viewPager.orientation=ViewPager2.ORIENTATION_VERTICAL
//        Swipe automatically
        viewPager.beginFakeDrag()
        viewPager.fakeDragBy(-10f)
        viewPager.endFakeDrag()*/
    }
}
