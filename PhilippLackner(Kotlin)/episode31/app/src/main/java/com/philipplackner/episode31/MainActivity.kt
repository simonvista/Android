package com.philipplackner.episode31

import android.content.ClipData
import android.content.ClipDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llTop.setOnDragListener(dragListener)
        llBottom.setOnDragListener(dragListener)

        dragView.setOnLongClickListener {
            val clipText="This is clipData text"
            val item=ClipData.Item(clipText)
            val mimeTypes= arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data=ClipData(clipText,mimeTypes,item)

            val dragShadowBuilder= View.DragShadowBuilder(it)
            it.startDragAndDrop(data,dragShadowBuilder,it,0)

            it.visibility=View.INVISIBLE
            true
        }
    }
//    Create drag listener
    val dragListener=View.OnDragListener { view, dragEvent ->
        when(dragEvent.action){
            DragEvent.ACTION_DRAG_STARTED->{
                dragEvent.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }
//            When drag enters layout boundary
            DragEvent.ACTION_DRAG_ENTERED->{
//                Update layout view -> Redraw on screen
                view.invalidate()
                true
            }
            DragEvent.ACTION_DRAG_LOCATION->true
            DragEvent.ACTION_DRAG_EXITED->{
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP->{
                val item=dragEvent.clipData.getItemAt(0)
                val dragData=item.text
                Toast.makeText(this,dragData,Toast.LENGTH_SHORT).show()
                view.invalidate()

//                Remove view from origin.
                val v=dragEvent.localState as View
                val owner=v.parent as ViewGroup
                owner.removeView(v)
//                Add view to destination
                val destination=view as LinearLayout
                destination.addView(v)
                v.visibility=View.VISIBLE
                true
            }
            DragEvent.ACTION_DRAG_ENDED->{
                view.invalidate()
                true
            }
            else->false
        }
    }
}
