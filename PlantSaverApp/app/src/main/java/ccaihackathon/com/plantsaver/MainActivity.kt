package ccaihackathon.com.plantsaver

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.graphics.Matrix
import android.os.Build
import android.provider.MediaStore
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {
    private lateinit var mClassifier: Classifier
    private lateinit var mBitmap: Bitmap

    private val mCameraRequestCode = 0
    private val mInputSize = 200 //224
    private val mModelPath = "model.tflite"
    private val mLabelPath = "labels.txt"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_main)
        mClassifier = Classifier(assets, mModelPath, mLabelPath, mInputSize)

        mCameraButton.setOnClickListener {
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(callCameraIntent, mCameraRequestCode)
        }
        mResultTextView.setOnClickListener{
            val callDetailsIntent = Intent(this, DetailsActivity::class.java)
            startActivity(callDetailsIntent)
        }
        val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(callCameraIntent, mCameraRequestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == mCameraRequestCode){
            if(resultCode == Activity.RESULT_OK && data != null) {
                mBitmap = data.extras!!.get("data") as Bitmap
                mBitmap = scaleImage(mBitmap)
                mPhotoImageView.setImageBitmap(mBitmap)
                val model_output = mClassifier.recognizeImage(scaleImage(mBitmap)).firstOrNull()
                mResultTextView.text = model_output?.title + "\n" + model_output?.confidence
            }
        }
    }

    fun scaleImage(bitmap: Bitmap?): Bitmap {
        val width = bitmap!!.width
        val height = bitmap.height
        val scaledWidth = mInputSize.toFloat() / width
        val scaledHeight = mInputSize.toFloat() / height
        val matrix = Matrix()
        matrix.postScale(scaledWidth, scaledHeight)
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true)
    }
}

