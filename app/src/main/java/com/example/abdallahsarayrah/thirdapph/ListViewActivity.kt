package com.example.abdallahsarayrah.thirdapph

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        var committees = ArrayList<String>()

        committeeNameButton.setOnClickListener {
            committees.add(committeeNameEditText.text.toString())

            var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, committees)

            committeeNameListView.adapter = arrayAdapter

            committeeNameListView.setOnItemClickListener { adapterView, view, position, id -> Toast.makeText(this, committees[position], Toast.LENGTH_SHORT).show() }

            committeeNameListView.setOnItemLongClickListener { parent, view, position, id ->
                var alertDialog = AlertDialog.Builder(this).create()
                alertDialog.setTitle("حذف اللجنة")
                alertDialog.setMessage("هل أنت متأكد من حذف اللجنة؟")
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "نعم", { dialog: DialogInterface?, which: Int ->
                    arrayAdapter.remove(committees[position])
                })
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "لا", { dialog, which -> dialog.dismiss() })
                alertDialog.show()
                true
            }
        }
    }
}
