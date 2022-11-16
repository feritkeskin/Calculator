package com.feritkeskin.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isNewOp = true
    var oldNumber = ""
    var op = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun oncBtn(view: View) {

        if (isNewOp)
            edit_text.setText("")
        isNewOp = false

        val btnSelect = view as Button
        var btnClicked: String = edit_text.text.toString()

        when (btnSelect.id) {

            button_0.id -> {
                btnClicked += "0"
            }

            button_1.id -> {
                btnClicked += "1"
            }

            button_2.id -> {
                btnClicked += "2"
            }

            button_3.id -> {
                btnClicked += "3"
            }

            button_4.id -> {
                btnClicked += "4"
            }

            button_5.id -> {
                btnClicked += "5"
            }

            button_6.id -> {
                btnClicked += "6"
            }

            button_7.id -> {
                btnClicked += "7"
            }

            button_8.id -> {
                btnClicked += "8"
            }

            button_9.id -> {
                btnClicked += "9"
            }

            button_nokta.id -> {
                btnClicked += "."
            }

            button_artiEksi.id -> {
                btnClicked = "-$btnClicked"
            }
        }
        edit_text.setText(btnClicked)

    }

    fun oncOp(view: View) {

        isNewOp = true
        oldNumber = edit_text.text.toString()
        var btnSelect: Button = view as Button

        when (btnSelect.id) {
            button_bol.id -> {
                op = "/"
            }
            button_carp.id -> {
                op = "*"
            }
            button_cikar.id -> {
                op = "-"
            }
            button_topla.id -> {
                op = "+"
            }
        }
    }

    fun buttonEsittir(view: View) {
        if (edit_text.text != null) {
            val newNumber = edit_text.text.toString()
            var result = 0

            when (op) {

                "/" -> {
                    result = oldNumber.toInt() / newNumber.toInt()
                }
                "*" -> {
                    result = oldNumber.toInt() * newNumber.toInt()
                }
                "-" -> {
                    result = oldNumber.toInt() - newNumber.toInt()
                }
                "+" -> {
                    result = oldNumber.toInt() + newNumber.toInt()
                }
            }
            edit_text.setText(result.toString())
        }
    }

    fun delete(view: View) {
        edit_text.setText("0")
        isNewOp = true
    }

    fun yuzde(view: View) {
        val no: Double = edit_text.text.toString().toDouble() / 100
        edit_text.setText(no.toString())
        isNewOp = true
    }
}