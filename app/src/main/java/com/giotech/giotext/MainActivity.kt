package com.giotech.giotext

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.giotech.giotext.databinding.ActivityMainBinding
import com.giotech.giotext.view.RepeatorActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.repeatBTN.setOnClickListener {
            val inputText = binding.inputTextET.text.toString()
            val inputCount = binding.countNumberET.text.toString()
            var isChecked = binding.CB.isChecked

            if (inputText.isEmpty()){
                binding.inputTextET.error="Required"
            }else if (inputCount.isEmpty()){
                binding.countNumberET.error="Required"
            }else{
                val intent=Intent(this,RepeatorActivity::class.java).apply {
                    putExtra("inputText",inputText)
                    putExtra( "count",inputCount.toInt())
                    putExtra("isChecked",isChecked)
                }
                startActivity(intent)

                binding.inputTextET.text.toString()
                binding.countNumberET.text.toString()
                binding.CB.isChecked
            }

        }

    }
}