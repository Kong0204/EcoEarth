package com.example.ecoearth.userprofile

import android.app.DatePickerDialog
import android.content.pm.PackageManager
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.andrinaecoearth.userprofile.UserProfileViewModel
import com.example.ecoearth.R
import com.example.ecoearth.databinding.LayoutUserProfileBinding
import androidx.annotation.RequiresApi
import com.google.firebase.auth.FirebaseAuth
import java.time.LocalDate
import java.time.format.DateTimeFormatter


abstract class UserProfile : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    //or use
    // lateinit var viewModel: UserProfileViewModel
    lateinit var binding: LayoutUserProfileBinding
    private lateinit var auth: FirebaseAuth
    val profileViewModel: UserProfileViewModel by viewModels()


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        //get the viewmodel
//        profileViewModel ViewModelProvider(this).get(UserProfileViewModel::class.java)

        //Auth
        auth = FirebaseAuth.getInstance()


        binding.profileGenderSpinner.setOnClickListener {
            genderSpinner(binding.profileGenderSpinner)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setBirthdayDate()
        }

        val profileEditImageButton = findViewById<Button>(R.id.profile_edit_image_button)
        profileEditImageButton.setOnClickListener {
            setProfilePic()
        }


        val profileBioText = findViewById<EditText>(R.id.profile_bio_text)
        //button to save user profile bio text description
        //val profileBioSaveButton = findViewById<Button>(R.id.profile_bio_save_button)
        binding.profileBioSaveButton.setOnClickListener {
            val stringProfileBioText = profileBioText.text.toString()

            saveBioText()

            binding.root
        }


    }

    //change user profile picture
    private fun setProfilePic() {
        val profileImage = findViewById<ImageView>(R.id.profileView)
        val profileEditImageButton = findViewById<Button>(R.id.profile_edit_image_button)

        profileEditImageButton.setOnClickListener {


            // Registers a photo picker activity launcher in single-select mode.
            val pickMedia =
                registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                    // Callback is invoked after the user selects a media item or closes the
                    // photo picker.
                    if (uri != null) {
                        Log.d("PhotoPicker", "Selected URI: $uri")
                    } else {
                        Log.d("PhotoPicker", "No media selected")
                    }
                }
            // Launch the photo picker and let the user choose only images.
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))


        }


        // Function to check and request permission to access pictures/media
        fun checkPermission(permission: String, requestCode: Int) {
            if (ContextCompat.checkSelfPermission(
                    this@UserProfile,
                    permission
                ) == PackageManager.PERMISSION_DENIED
            ) {
                // Requesting the permission
                ActivityCompat.requestPermissions(
                    this@UserProfile,
                    arrayOf(permission),
                    requestCode
                )
            } else {
                Toast.makeText(this@UserProfile, "Permission already granted", Toast.LENGTH_SHORT)
                    .show()
            }
        }


    }


    //save user profile description
    private fun saveBioText() {
        lateinit var binding: LayoutUserProfileBinding
        var profileBioText: String = ""


        val userText = binding.profileBioText.text.toString()
        profileBioText = userText


    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun setBirthdayDate() {
        lateinit var binding: LayoutUserProfileBinding

        val setBirthday = binding.profileBirthdayInput


        //set OnClickListener on the Birthday EditText to show DatePickerDialog
        setBirthday.setOnClickListener {
            //get current date from Calendar instance
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

            //create and show DatePickerDialog
            val datePickerDialog = DatePickerDialog(
                this@UserProfile,
                DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                    val date = LocalDate.of(selectedYear, selectedMonth + 1, selectedDayOfMonth)
                    val formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
                    setBirthday.setText(formattedDate)
                },
                year,
                month,
                dayOfMonth
            )
            datePickerDialog.show()

        }


    }


    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        lateinit var binding: LayoutUserProfileBinding
        val selectionTv = binding.selectedGenderTextView

        selectionTv.text = parent.getItemAtPosition(pos).toString()
    }


    //spinner for gender option
    private fun genderSpinner(profileGenderSpinner: Spinner) {
        lateinit var binding: LayoutUserProfileBinding

        //1. create object to hold spinner
        val spinnerGenderSelection = binding.profileGenderSpinner


        //2. create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter.createFromResource(
            this@UserProfile,
            R.array.profile_gender_selection,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            //specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            //apply the adapter to the spinner
            spinnerGenderSelection.adapter = adapter

        }
    }

}