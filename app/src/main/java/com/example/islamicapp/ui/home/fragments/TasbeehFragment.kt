package com.example.islamicapp.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.islamicapp.R

class TasbeehFragment : Fragment() {

    lateinit var sebhaBodyImageView: ImageView
    lateinit var tsbeehCounter: TextView
    lateinit var tsbeehButtonCounter: Button

    val tsbeehList = mutableListOf("سبحان الله", "اللة اكبر", "الحمد للة", "لا اللة الا اللة")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasbeeh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSebhaImage()

        initCounter()
    }

    fun initCounter() {

        tsbeehButtonCounter = requireView().findViewById(R.id.tsbeeh_button)
        tsbeehCounter = requireView().findViewById(R.id.tsbeh_counter_textView)

        tsbeehButtonCounter.setOnClickListener(object : View.OnClickListener {

            override fun onClick(view: View?) {

                val tsbeehCounterNumber = ((tsbeehCounter.text.toString()).toInt())
                tsbeehCounter.text = (tsbeehCounterNumber + 1).toString()


                if ((tsbeehCounter.text.toString().toInt()) % 33 == 0) {

                    tsbeehList.shuffle()
                    tsbeehButtonCounter.text = tsbeehList.get(0)
                }
            }
        })
    }


    fun initSebhaImage() {

        sebhaBodyImageView = requireView().findViewById(R.id.sebha_body)

        sebhaBodyImageView.setOnClickListener(object : View.OnClickListener {

            override fun onClick(view: View?) {

                val rotateAnimation = RotateAnimation(
                    0f,
                    360f,
                    RotateAnimation.RELATIVE_TO_SELF,
                    0.5f,
                    RotateAnimation.RELATIVE_TO_SELF,
                    0.5f
                )
                rotateAnimation.duration = 5000L
                view?.startAnimation(rotateAnimation)
            }
        })
    }
}