package com.giotech.giotext.view

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.giotech.giotext.databinding.ActivityRepeatorBinding

class RepeatorActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRepeatorBinding

    private var inputText:String? =null
    private var inputCount:Int? =null
    private var isChecked:Boolean =false

    var repeatText:String = ""

    lateinit var clipboardManager: ClipboardManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRepeatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repeatText()
        clickListener()
    }

    private fun clickListener() {
        binding.copyBTN.setOnClickListener {
            clipboardManager=getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val copyData= ClipData.newPlainText("text",repeatText)
            clipboardManager.setPrimaryClip(copyData)

            Toast.makeText(this, "Copied successful", Toast.LENGTH_SHORT).show()

        }
        binding.shareBTN.setOnClickListener {
            shareRepeatText(repeatText)

        }
    }

    private fun shareRepeatText(repeatText: String) {
        val intent=Intent(Intent.ACTION_SEND)
        intent.type="text/plain"
        intent.putExtra(Intent.EXTRA_TEXT,repeatText)
        startActivity(Intent.createChooser(intent,"share repeat text"))
    }

    private fun repeatText() {
        inputText=intent.getStringExtra("inputText")
        inputCount=intent.getIntExtra("count",0)
        isChecked= intent.getBooleanExtra("isChecked",false)

        var countNo = inputCount

        for (m in 0 until countNo!!){
            if (isChecked){
                repeatText= repeatText + inputText+"\n"
                binding.repeatText.text=repeatText
               // repeatText=binding.repeatText.append(inputText+"\n").toString()
            }
            else{

                repeatText= repeatText + inputText+" "
                binding.repeatText.text=repeatText
                //repeatText=binding.repeatText.append(inputText+" ").toString()
            }

        }

    }
}