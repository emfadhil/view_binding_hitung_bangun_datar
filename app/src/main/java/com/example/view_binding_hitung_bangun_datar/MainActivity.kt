package com.example.view_binding_hitung_bangun_datar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.view_binding_hitung_bangun_datar.databinding.ActivityMainBinding
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    var binding : ActivityMainBinding? = null//buat variabel binding(1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // deklarasikan (2)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // jadi tinggal dipanggil aja elemen2 nya yang mau di setonclick dll
        binding?.button?.setOnClickListener {

            val input = binding?.editTextNumber?.text.toString()
            val input2 = binding?.editTextNumber2?.text.toString()

            if(input.isEmpty()){
//                show alert
                showAlert("number 1 masih koong")
            }else if(input2.isEmpty()){
//                show alert
                showAlert("number 2 masih kosong")
            }else{
//                calculate
                val x = input.toDouble()
                val y = input2.toDouble()

                val result = (x.div(2)).times(y)
                //show alert
                showAlert("${result}")
            }


        }
    }

    private fun showAlert(result : String){
        var alert = AlertDialog.Builder(this)
        alert.setTitle("Hasil")
        alert.setMessage(result)
        alert.setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which ->

        })
        alert.show()
    }
}