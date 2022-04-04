package com.example.demo_saveimage

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.MediaColumns.IS_PENDING
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 分别绑定根布局和”保存图片”按钮
        val layout = findViewById<ConstraintLayout>(R.id.layout)
        val button = findViewById<Button>(R.id.save_button)

        // 设置“保存图片”按钮的点击
        button.setOnClickListener {
            saveImage(layout)
        }
    }

    /** 创建位图 */
    fun createViewBitmap(view: View): Bitmap? {
        val bitmap = Bitmap.createBitmap(
            view.width, view.height,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        view.draw(canvas)
        return bitmap
    }

    /** 保存为图片 */
    fun saveImage(view: View) {
        val imageBit = createViewBitmap(view)
        MediaStore.Images.Media.insertImage(contentResolver,imageBit, "picture_name", "demo_saveImage")
    }
}
