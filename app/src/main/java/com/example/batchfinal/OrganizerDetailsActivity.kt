package com.example.ajzoproject

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.ajzoproject.databinding.ActivityDateTime3Binding
import com.example.ajzoproject.databinding.ActivityLocationBinding
import com.example.ajzoproject.databinding.ActivityOrganigerDetailsBinding
import java.io.File


class OrganizerDetailsActivity : AppCompatActivity() {
    private val PROFILE_IMAGE_REQ_CODE = 101
    private val GALLERY_IMAGE_REQ_CODE = 102
    private val CAMERA_IMAGE_REQ_CODE = 103

    private lateinit var customSpinner: Spinner
    private lateinit var mBinding: ActivityOrganigerDetailsBinding


    private var mCameraUri: Uri? = null
    private var mGalleryUri: Uri? = null
    private var mProfileUri: Uri? = null

    @SuppressLint("CutPasteId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organiger_details)

        mBinding = ActivityOrganigerDetailsBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        var rl9: LinearLayout = findViewById(R.id.profileImage)


        rl9.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }

        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        detailsTextView.text = "Organizer Details"
        mBinding.profileImageTextView.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }
        val items =
            arrayOf("Marriage 1", "Party 2", "Birthday  3", "Anniversary 4", "Rewards Party 5")
        val adapter = ArrayAdapter(this, R.layout.custom_dropdown_item, items)
        mBinding.orgranizerSpinner.adapter = adapter
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        mBinding.saveAndContinueButtonOrganiger.setOnClickListener {
            startActivity(Intent(this, TicketingSeatDetailsActivity::class.java))
        }
//        if (allPermissionsGranted()) {
//            startCamera()
//        } else {
//            ActivityCompat.requestPermissions(
//                this,
//                REQUIRED_PERMISSIONS,
//                REQUEST_CODE_PERMISSIONS
//            )
//        }

        mBinding.profileImageRelativeLayout.setOnClickListener {
            takePhoto()
        }
    }


    private fun takePhoto() {

//        pickCameraImage()
    }


    fun showImageCode(view: View) {
//        var resource = 0
//        if (view === imgProfileCode) {
//            resource = R.drawable.img_profile_code
//        } else if (view === imgCameraCode) {
//            resource = R.drawable.img_camera_code
//        } else if (view === imgGalleryCode) {
//            resource = R.drawable.img_gallery_code
//        }
//        ImageViewerDialog
//            .newInstance(resource)
//            .show(supportFragmentManager, "")
    }

    fun showImage(view: View) {
//        val uri: Uri?
//        uri = if (view === imgProfile) {
//            mProfileUri
//        } else if (view === imgCamera) {
//            mCameraUri
//        } else if (view === imgGallery) {
//            mGalleryUri
//        } else {
//            null
//        }
//        if (uri != null) {
//            startActivity(IntentUtils.getUriViewIntent(this, uri))
//        }
    }

    fun showImageInfo(view: View) {
//        val uri: Uri?
//        uri = if (view === imgProfileInfo) {
//            mProfileUri
//        } else if (view === imgCameraInfo) {
//            mCameraUri
//        } else if (view === imgGalleryInfo) {
//            mGalleryUri
//        } else {
//            null
//        }
//        AlertDialog.Builder(this)
//            .setTitle("Image Info")
//            .setMessage(FileUtil.getFileInfo(this, uri))
//            .setPositiveButton("Ok", null)
//            .show()
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == RESULT_OK) {
//            // Uri object will not be null for RESULT_OK
//            val uri = data!!.data
//            when (requestCode) {
//               PROFILE_IMAGE_REQ_CODE -> {
//                    mProfileUri = uri
//                }
//
//              GALLERY_IMAGE_REQ_CODE -> {
//                    mGalleryUri = uri
//                }
//
//               CAMERA_IMAGE_REQ_CODE -> {
//                    mCameraUri = uri
//                }
//            }
//        } else if (resultCode == ImagePicker.RESULT_ERROR) {
//            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        private const val REQUEST_CODE_PERMISSIONS = 10
//        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }
}





