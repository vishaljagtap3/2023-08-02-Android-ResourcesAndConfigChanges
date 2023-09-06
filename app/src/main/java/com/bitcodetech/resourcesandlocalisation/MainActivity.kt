package com.bitcodetech.resourcesandlocalisation

import android.content.res.Configuration
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bitcodetech.resourcesandlocalisation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mt("onCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(lastCustomNonConfigurationInstance != null) {
            mt("Got back the data...")
            binding.txtLabelInformation.text =
                (lastCustomNonConfigurationInstance as DataBackUp).text
        }

        /*mt(resources.getString(R.string.information_hint))
        mt("color : ${resources.getColor(R.color.txt_background_color)}")
        mt("dimen: ${resources.getDimension(R.dimen.txt_width)}")
        mt("bool: ${resources.getBoolean(R.bool.is_password)}")
        mt("integer : ${resources.getInteger(R.integer.company_code)}")*/

        /*val cities = resources.getStringArray(R.array.cities)
        mt("cities : ${cities[0]}")
        val cityCodes = resources.getIntArray(R.array.city_codes)
        mt("city codes: ${cityCodes[0]}")

        val drawable : Drawable = resources.getDrawable(R.drawable.ic_launcher_background)

        val bitmap = BitmapFactory.decodeResource(
            resources,
            R.drawable.flag
        )

        binding.imgFlag.setImageBitmap(bitmap)*/

        //mt("--------------------------------")
       /* val config = resources.configuration
        mt("${config.touchscreen} ${Configuration.TOUCHSCREEN_FINGER} ${Configuration.TOUCHSCREEN_STYLUS}")
*/
        /*when(config.touchscreen) {
            Configuration.TOUCHSCREEN_FINGER ->
                mt("Finger touch device")
            Configuration.TOUCHSCREEN_STYLUS ->
                mt("Stylus touch device")
        }
*/
       /* when(config.keyboard) {
            Configuration.KEYBOARD_NOKEYS ->
                mt("KB No Keys")
            Configuration.KEYBOARD_QWERTY ->
                mt("KB Qwerty Keys")
        }*/

       /* mt("font scale: ${config.fontScale}")
        mt("locale: ${config.locale.country}")
        mt("Density dpi: ${config.densityDpi}")*/

        binding.btnAction.setOnClickListener {
            binding.txtLabelInformation.text =
                binding.edtInfo.text.toString()
        }

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        mt("onConfigurationChanged")
    }





    override fun onRetainCustomNonConfigurationInstance(): Any? {
        mt("onRetainCustomNonConfigurationInstance");
        return DataBackUp(binding.txtLabelInformation.text.toString())
    }



    private fun mt(text : String) {
        Log.e("tag", text)
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        mt("onDestroy")
        super.onDestroy()
    }

    class DataBackUp(
        val text : String
    )
}